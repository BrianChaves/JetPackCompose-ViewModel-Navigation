package com.example.jetpackcompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.R
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import com.example.jetpackcompose.Utils
import com.example.jetpackcompose.data.UserDataUiEvents


@Composable
fun TopBar(value: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {

        Text(
            text = value, color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.Medium

        )
        Spacer(modifier = Modifier.size(80.dp))
        Image(
            modifier = Modifier.size(60.dp),
            painter = painterResource(id = R.drawable.jetpac), contentDescription = "Aplicacion Movil"
        )

    }
}


@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar("")
}


@Composable
fun TextComponent(textValue: String, textSize: TextUnit, colorValue: Color = Color.Black) {
    Text(
        text = textValue,
        fontSize = textSize,
        color = colorValue,
        fontWeight = FontWeight.Light
    )
}

@Preview(showBackground = true)
@Composable
fun TextComponentPreview() {
    TextComponent(textValue = "Aplicacion nativa", textSize = 24.sp)
}


@Composable
fun TextFieldComponent(
    onTextChanged: (name: String) -> Unit
) {
    var currentValue by remember {
        mutableStateOf("")
    }
    val localFocusManager = LocalFocusManager.current
    OutlinedTextField(modifier = Modifier.fillMaxWidth(), value = currentValue,
        onValueChange = {
            currentValue = it
            onTextChanged(it)
        },
        placeholder = {
            Text(text = "Enter your name", fontSize = 18.sp)
        },
        textStyle = TextStyle.Default.copy(fontSize = 24.sp),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        }
    )
}

@Composable
fun LanguajeCard(
    image: Painter,
    languageName: String,
    selected: Boolean = false, // Default value for selected state
    onCardClick: (String) -> Unit // Callback for card click
) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .size(90.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .clickable { // Handle click for any language
                        onCardClick(languageName)
                    },
                painter = image,
                contentDescription = "Image of $languageName" // Update contentDescription
            )
            if (selected) { // Apply border only when selected
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .border(
                            width = 1.dp,
                            color = Color.Green,
                            shape = RoundedCornerShape(8.dp)
                        )
                )
            }
        }
    }
}

@Composable
fun ButtonComponent(
    goToDetailScreen: () -> Unit
) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            goToDetailScreen()
        }) {
        TextComponent(
            textValue = "Datos Interesantes",
            textSize = 18.sp,
            colorValue = Color.White
        )
    }
}


@Composable
fun TextWithShadow(value: String) {
    val shadowOffset = Offset(x = 1f, y = 2f)
    Text(
        text = value,
        fontSize = 24.sp,
        fontWeight = FontWeight.Light,
        style = TextStyle(
            shadow = Shadow(Utils.generateRandomCor(), shadowOffset, 2f)
        )

    )
}


@Composable
fun FactComposable(value: String) {
    Card(
        modifier = Modifier
            .padding(32.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp), elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(18.dp, 24.dp)

        ) {
            Spacer(modifier = Modifier.size(24.dp))
            TextWithShadow(value = value)
            Spacer(modifier = Modifier.size(24.dp))

        }
    }
}

@Preview()
@Composable
fun FactComposablePreview() {
    TextComponent(textValue = "Aplicacion nativa", textSize = 24.sp)
}
