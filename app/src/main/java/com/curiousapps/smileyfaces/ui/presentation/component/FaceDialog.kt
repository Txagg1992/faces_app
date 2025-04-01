package com.curiousapps.smileyfaces.ui.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.curiousapps.smileyfaces.domain.FaceItems

@Composable
fun FaceDialog(
    faceItem: FaceItems,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
){
    Dialog(
        onDismissRequest = { onDismiss() }
    ){
        Card(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth(),
            elevation = 6.dp,
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(Color.LightGray)
                    .padding(16.dp)
            ) {
                Text(
                    modifier = modifier.align(Alignment.CenterHorizontally),
                    text = faceItem.character,
                    fontSize = 100.sp
                )
                Spacer(modifier = modifier.height(8.dp))
                Text(
                    modifier = modifier.padding(start = 8.dp),
                    text = "Unicode Name: ${faceItem.unicodeName}",
                    fontSize = 20.sp
                )
                Spacer(modifier = modifier.height(4.dp))
                Text(
                    modifier = modifier.padding(start = 8.dp),
                    text = "Emoji Group: ${faceItem.group}",
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun FaceDialogPreview(){
    val face = FaceItems(
        character = "\uD83D\uDC80",
        slug = "",
        codePoint = "",
        group = "smileys-emotion",
        subGroup = "",
        variants = emptyList(),
        unicodeName = "E0.6 skull"
    )
    FaceDialog(
        faceItem = face,
        onDismiss = {}
    )
}