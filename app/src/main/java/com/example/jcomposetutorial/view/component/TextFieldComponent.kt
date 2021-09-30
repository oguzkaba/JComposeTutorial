package com.example.jcomposetutorial.view.component

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp
import com.example.jcomposetutorial.ui.theme.BabyPowder

@Composable
fun TextFieldCompanent(
    color:Color=BabyPowder,
    value: String,
    hint: String,
    onValueChange: (String) -> Unit,
    icon: ImageVector,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),

    ) {
    TextField(
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        singleLine = true,
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = hint,
                style = TextStyle(
                    color = color,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        },
        visualTransformation = visualTransformation,
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = color,
            focusedIndicatorColor = color,
            backgroundColor = Color.Transparent
        ),
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = null
            )
        },
        trailingIcon = trailingIcon

    )
}