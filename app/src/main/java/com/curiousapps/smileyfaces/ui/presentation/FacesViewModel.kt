package com.curiousapps.smileyfaces.ui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curiousapps.smileyfaces.domain.FaceItems
import com.curiousapps.smileyfaces.domain.FaceRepository
import com.curiousapps.smileyfaces.util.IO_DISPATCHER
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FacesViewModel @Inject constructor(
    private val repository: FaceRepository
) : ViewModel() {

    private val _state = MutableStateFlow(FaceState())
    val state = _state
        .onStart { fetchAllFaces() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(4000L),
            FaceState()
        )

    private fun fetchAllFaces(){
        viewModelScope.launch(IO_DISPATCHER) {
            val result = repository.fetchAllFaces()
            when{
                result.isSuccess -> {
                    _state.update { it.copy(
                        faceList = result.getOrNull()!!,
                        isLoading = false
                    ) }
                }
                result.isFailure -> {
                    _state.update { it.copy(
                        faceList = emptyList(),
                        isLoading = false
                    ) }
                }
            }
        }
    }

    fun fetchOneFace(slug: String){
        viewModelScope.launch(IO_DISPATCHER) {
            val result = repository.fetchOneFace(slug = slug)
            when{
                result.isSuccess -> {
                    _state.update { it.copy(
                        selectedFace = result.getOrNull()!!
                    ) }
                }
                result.isFailure -> {
                    _state.update { it.copy(
                        selectedFace = emptyList()
                    ) }
                }
            }
        }
    }

    fun dismissDialog(){
        _state.update { it.copy(
            selectedFace = emptyList()
        ) }
    }


    data class FaceState(
        val faceList: List<FaceItems> = emptyList(),
        val isLoading: Boolean = true,
        val selectedFace: List<FaceItems> = emptyList()
    )
}