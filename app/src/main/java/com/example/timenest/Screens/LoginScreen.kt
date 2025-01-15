package com.example.timenest.Screens

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicSecureTextField
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timenest.R

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
){
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.SpaceAround
    ){
        Column {
//            Image(
//                painter = painterResource(R.drawable.login),
//                contentDescription = null,
//                contentScale = ContentScale.FillHeight,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .fillMaxWidth(0.25f)
//            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Login",
                fontWeight = FontWeight.SemiBold,
                fontSize = 30.sp
            )
        }

        MyTextFeild(
            modifier = Modifier.fillMaxWidth(),
            textFeildState = TextFieldState(),
            leadingIcon = Icons.Outlined.Email,
            hint = "Email",
            trailingIcon = Icons.Outlined.Check,
        )
        MyTextFeild(
            modifier = Modifier.fillMaxWidth(),
            textFeildState = TextFieldState(),
            hint = "Password",
            leadingIcon = Icons.Outlined.Lock,
            trailingText = "Forgot?",
            isPassword = true,
        )

        OutlinedButton(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Login",
                fontSize = 17.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
        Text(
            text = "or, login with...",
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
                text = "Don't have an account?",
                fontSize = 16.sp,
            )
            Text(
                text = "Register",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .clickable {  }
            )

        }
            Spacer(modifier = Modifier.height(1.dp))

    }
}

@Composable
fun MyTextFeild(
    modifier: Modifier = Modifier,
    trailingText: String? = null,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    textFeildState: TextFieldState,
    hint: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPassword: Boolean = false,
    onleadingClick: () -> Unit = {},
    onTrailingClick: () -> Unit = {},
){

    if (isPassword){
            PasswordTextFeild(
                modifier = modifier,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                textFeildState = textFeildState,
                hint = hint,
                trailingText = trailingText,
                onTrailingClick = onTrailingClick,
                onleadingClick = onleadingClick,

            )
    }else{
        TextTextFeild(
            modifier = modifier,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            textFeildState = textFeildState,
            hint = hint,
            keyboardType = keyboardType,
            trailingText = trailingText,
            onTrailingClick = onTrailingClick,
            onleadingClick = onleadingClick,

        )
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TextTextFeild(
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    trailingText: String? = null,
    textFeildState: TextFieldState,
    hint: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPassword: Boolean = false,
    onleadingClick: () -> Unit = {},
    onTrailingClick: () -> Unit = {},
){
    BasicTextField(
        state = textFeildState,
        textStyle = LocalTextStyle.current.copy(
            color = MaterialTheme.colorScheme.onBackground,
        ),
        keyboardOptions = KeyboardOptions(keyboardType=keyboardType),
        lineLimits = TextFieldLineLimits.SingleLine,
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        modifier = modifier,
        decorator = { innerTextField ->
            Column{
                Row(
                    modifier = Modifier.height(56.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    if(leadingIcon != null){
                        Icon(
                            imageVector = leadingIcon,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
                            modifier = Modifier
                                .padding(end = 4.dp)
                                .clickable { onleadingClick() }
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                    Box(
                        modifier = Modifier.weight(1f)
                    ){
                        if(textFeildState.text.isEmpty()) {
                            Text(
                                text = hint,
                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f),
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                        innerTextField()
                    }
                    if(trailingIcon != null){
                        Icon(
                            imageVector = trailingIcon,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
                            modifier = Modifier
                                .padding(start = 4.dp)
                                .clickable { onTrailingClick() }
                        )
                    }else if(trailingText != null){
                        Text(
                            text = trailingText,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                                .padding(end = 4.dp)
                                .clickable { onTrailingClick() }
                        )
                    }

                }
                Spacer(modifier = Modifier.height(10.dp))

                HorizontalDivider(modifier= Modifier.alpha(0.7f))
            }

        }
    )
}

@Composable
fun PasswordTextFeild(
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    trailingText: String? = null,
    textFeildState: TextFieldState,
    hint: String,
    onleadingClick: () -> Unit = {},
    onTrailingClick: () -> Unit = {},
){
    BasicSecureTextField(
        state = textFeildState,
        textObfuscationMode = TextObfuscationMode.Hidden,
        textStyle = LocalTextStyle.current.copy(
            color = MaterialTheme.colorScheme.onBackground,
        ),
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        modifier = modifier,
        decorator = { innerTextField ->
            Column{
                Row(
                    modifier = Modifier.height(56.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    if(leadingIcon != null){
                        Icon(
                            imageVector = leadingIcon,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
                            modifier = Modifier
                                .padding(end = 4.dp)
                                .clickable { onleadingClick() }
                        )
                    }
                    else if (trailingText != null){
                        Text(
                            text = trailingText,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(end = 4.dp)
                                .clickable { onleadingClick() }
                        )
                    }
                    Box(
                        modifier = Modifier.weight(1f)
                    ){
                        if(textFeildState.text.isEmpty()){
                            Text(
                                text = hint,
                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f),
                                modifier = Modifier.fillMaxWidth()
                            )

                        }
                        innerTextField()
                    }
                    if(trailingIcon != null) {
                        Icon(
                            imageVector = trailingIcon,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
                            modifier = Modifier
                                .padding(end = 4.dp)
                                .clickable { onTrailingClick() }

                        )
                    }else if (trailingText != null){
                        Text(
                            text = trailingText,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                                .padding(end = 4.dp)
                                .clickable { onTrailingClick() }
                        )
                    }

                }
                Spacer(modifier = Modifier.height(10.dp))

                HorizontalDivider(modifier= Modifier.alpha(0.7f))
            }

        }
    )
}

@Composable
fun AuthOption(
    modifier: Modifier = Modifier,
    image: Int,
    tint: Color? = null,
    contentDescription: String? = null,
    ){
    Box(
        modifier = modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.2f),
                shape = RoundedCornerShape(14.dp)
            )
            .clip(RoundedCornerShape(14.dp))
            .clickable {  }
            .padding(horizontal = 35.dp, vertical = 12.dp),
        contentAlignment = Alignment.Center
    ){
        if (tint != null){
            Icon(
                painter = painterResource(id = image),
                contentDescription = contentDescription,
                modifier =Modifier.size(30.dp)
            )
        }else{
            Image(
                painter = painterResource(id = image),
                contentDescription = contentDescription,
                modifier =Modifier.size(30.dp)
            )
        }
    }
}