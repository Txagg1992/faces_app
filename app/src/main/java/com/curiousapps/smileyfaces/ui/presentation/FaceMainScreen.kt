package com.curiousapps.smileyfaces.ui.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.curiousapps.smileyfaces.ui.presentation.component.FaceDialog
import com.curiousapps.smileyfaces.ui.presentation.component.FacesRow
import com.curiousapps.smileyfaces.ui.presentation.component.GradientBackground

@Composable
fun FaceMainScreen(
    viewModel: FacesViewModel = hiltViewModel(),
    onSelectFace: (slug: String) -> Unit
) {
    val state by viewModel.state.collectAsState(FacesViewModel.FaceState())
    val faceList = state.faceList
    val isLoading = state.isLoading
    val selectedFace = state.selectedFace

    GradientBackground()
    if (isLoading) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(120.dp),
                trackColor = Color.Red
            )
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(16.dp).padding(top = 32.dp)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(16.dp)
            ) {
                val count = faceList.size
                items(count){ index ->
                    val slug = faceList[index].slug
                    FacesRow(
                        faceItems = faceList[index],
                        modifier = Modifier.clickable {
                            onSelectFace(slug)
                        }
                    )
                    if (selectedFace.isNotEmpty()){
                        FaceDialog(
                            faceItem = selectedFace[0],
                            onDismiss = {viewModel.dismissDialog()}
                        )
                    }
                }
            }
        }
    }
}