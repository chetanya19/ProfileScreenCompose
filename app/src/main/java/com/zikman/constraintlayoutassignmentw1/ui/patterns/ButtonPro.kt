package com.zikman.constraintlayoutassignmentw1.ui.patterns

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ButtonPro(buttonType: Int, buttonText: String, onClick: () -> Unit, modifier: Modifier) {
    Button(
        onClick = {
            onClick()
        },
        modifier = modifier,
        shape = ShapeDefaults.Small,
        border = getButtonBorderStyle(buttonType),
        colors = ButtonDefaults.buttonColors(
            containerColor = getButtonBgColour(buttonType),
        )
    ) {
        Text(
            text = buttonText,
            style = MaterialTheme.typography.bodyLarge,
            color = getButtonTextColour(buttonType)
        )
    }
}

fun getButtonBgColour(buttonType: Int): Color =
    if (buttonType == ButtonType.Solid.ordinal) {
        Color.Black
    } else {
        Color.White
    }

fun getButtonTextColour(buttonType: Int): Color =
    if (buttonType == ButtonType.Solid.ordinal) {
        Color.White
    } else {
        Color.Black
    }

fun getButtonBorderStyle(buttonType: Int): BorderStroke? =
    if (buttonType == ButtonType.Solid.ordinal) {
        null
    } else {
        BorderStroke(width = 2.dp, Color.Black)
    }

enum class ButtonType {
    Solid,
    Border
}

@Preview
@Composable
fun ButtonSolidPreview() {
    ButtonPro(ButtonType.Solid.ordinal, buttonText = "Follow",
        onClick = {
        },
        modifier = Modifier.fillMaxWidth().height(55.dp)
    )
}

@Preview
@Composable
fun ButtonBorderPreview() {
    ButtonPro(ButtonType.Border.ordinal, buttonText = "Message",
        onClick = {
        },
        modifier = Modifier.fillMaxWidth().height(55.dp)
    )
}