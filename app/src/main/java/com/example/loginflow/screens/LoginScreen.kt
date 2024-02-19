package com.example.loginflow.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginflow.R
import com.example.loginflow.components.ButtonComponent
import com.example.loginflow.components.ClickableLoginTextComponent
import com.example.loginflow.components.DividerTextComponent
import com.example.loginflow.components.HeadingTextComponent
import com.example.loginflow.components.MyTextFieldComponent
import com.example.loginflow.components.NormalTextComponent
import com.example.loginflow.components.PasswordTextFieldComponent
import com.example.loginflow.components.SystemBackButtonHandler
import com.example.loginflow.components.UnderLinedNormalTextComponent
import com.example.loginflow.navigation.PostOfficeAppRouter
import com.example.loginflow.navigation.Screen

@Composable
fun LoginScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            NormalTextComponent(value = stringResource(id = R.string.login))
            HeadingTextComponent(value = stringResource(id = R.string.welcome))
            Spacer(modifier = Modifier.height(20.dp))

            MyTextFieldComponent(
                labelValue = stringResource(id = R.string.email),
                painterResource = painterResource(id = R.drawable.message)
            )

            PasswordTextFieldComponent(
                labelValue = stringResource(id = R.string.pass_word),
                painterResource = painterResource(id = R.drawable.profile)
            )

            Spacer(modifier = Modifier.height(40.dp))
            UnderLinedNormalTextComponent(value = stringResource(id = R.string.forgot_password))

            Spacer(modifier = Modifier.height(40.dp))
            ButtonComponent(value = stringResource(id = R.string.login))

            Spacer(modifier = Modifier.height(20.dp))
            DividerTextComponent()

            ClickableLoginTextComponent(
                tryingToLogin = false,
                onTextSelected = {
                    PostOfficeAppRouter.navigationTo(Screen.SignUpScreen)
                }
            )

        }

    }

    SystemBackButtonHandler {
        PostOfficeAppRouter.navigationTo(Screen.SignUpScreen)
    }

}

@Composable
@Preview
fun PreviewLoginScreen() {
    LoginScreen()
}
