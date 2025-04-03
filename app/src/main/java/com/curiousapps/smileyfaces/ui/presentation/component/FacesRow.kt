package com.curiousapps.smileyfaces.ui.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.curiousapps.smileyfaces.domain.FaceItems

@Composable
fun FacesRow(
    faceItems: FaceItems,
    modifier: Modifier = Modifier
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .wrapContentHeight()
    ) {
        Column(
            modifier = modifier.fillMaxWidth().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = faceItems.character,
                fontSize = 48.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Group: ${faceItems.group}",
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Unicode Name: ${faceItems.unicodeName}",
                fontStyle = FontStyle.Italic
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider(
                color = Color.Black,
                thickness = 3.dp
            )
        }
    }
}

@Preview
@Composable
fun FaceRowPreview(){
    val face = FaceItems(
        character = "\uD83D\uDC80",
        slug = "",
        codePoint = "",
        group = "smileys-emotion",
        subGroup = "",
        variants = emptyList(),
        unicodeName = "E0.6 skull"
    )
    FacesRow(
        faceItems = face,
    )
}