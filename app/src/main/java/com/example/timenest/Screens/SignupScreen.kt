package com.example.timenest.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.timenest.ui.theme.TimeNestTheme

@Composable
fun SignupScreen() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            DataTextFeild(
                value = name,
                onValueChange = { name = it },
                label = "Name",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            DataTextFeild(
                value = email,
                onValueChange = { email = it },
                label = "Email",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            DataTextFeild(
                value = password,
                onValueChange = { password = it },
                label = "Password",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun DataTextFeild(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, color = Color.LightGray) },
        shape = RoundedCornerShape(25.dp),
//        colors = TextFieldDefaults.outlinedTextFieldColors(
//            containerColor = Color(0xFFFFE4E6),
//            unfocusedBorderColor = Color.LightGray,
//            focusedBorderColor = Color.Gray
//        ),
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun SignupScreenPreview() {
    TimeNestTheme {
        SignupScreen()
    }
}
