package com.example.jcomposetutorial.view.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jcomposetutorial.ui.theme.MariGold
import com.example.jcomposetutorial.ui.theme.MiddleBlue

@Composable
fun OutTextFieldCompanent(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    maxLines: Int,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = hint,
                style = TextStyle(
                    color = MiddleBlue,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MariGold,
            unfocusedBorderColor = MiddleBlue
        ),
        modifier = Modifier
            .padding(vertical = 15.dp)
            .height(55.dp)
            .fillMaxWidth(),
        maxLines = maxLines,
        shape = RoundedCornerShape(30.dp)
    )

}