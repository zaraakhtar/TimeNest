package com.example.timenest.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timenest.R

@Composable
fun SignupScreen(
    modifier: Modifier = Modifier,
){
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 35.dp),
        verticalArrangement = Arrangement.SpaceAround
    ){
        Column {

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Signup",
                fontWeight = FontWeight.SemiBold,
                fontSize = 30.sp
            )
        }

        MyTextFeild(
            modifier = Modifier.fillMaxWidth(),
            textFeildState = TextFieldState(),
            leadingIcon = Icons.Outlined.Person,
            hint = "Name",
            trailingIcon = Icons.Outlined.Check,
        )
        MyTextFeild(
            modifier = Modifier.fillMaxWidth(),
            textFeildState = TextFieldState(),
            leadingIcon = Icons.Outlined.Email,
            hint = "Email",
            keyboardType = KeyboardType.Email,
            trailingIcon = Icons.Outlined.Check,
        )

        MyTextFeild(
            modifier = Modifier.fillMaxWidth(),
            textFeildState = TextFieldState(),
            hint = "Password",
            leadingIcon = Icons.Outlined.Lock,
            isPassword = true,
        )
MyTextFeild(
            modifier = Modifier.fillMaxWidth(),
            textFeildState = TextFieldState(),
            hint = "Confirm Password",
            leadingIcon = Icons.Outlined.Lock,
            isPassword = true,
        )

        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Sign Up",
                fontSize = 17.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
        Spacer(modifier = Modifier.height(30.dp))


        Text(
            text = "or, Register with...",
            fontSize = 15.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .alpha(0.5f)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            AuthOption(image = R.drawable.google)
            AuthOption(image = R.drawable.facebook)
            AuthOption(
                image = R.drawable.apple,
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
        Row (
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Already have an account?",
                fontSize = 16.sp,
            )
            Text(
                text = "Login Here",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .clickable {  }
            )

        }
        Spacer(modifier = Modifier.height(14.dp))

    }
}

