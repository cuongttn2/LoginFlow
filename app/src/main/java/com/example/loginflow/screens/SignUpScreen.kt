package com.example.loginflow.screens

import android.util.Log
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginflow.R
import com.example.loginflow.components.ButtonComponent
import com.example.loginflow.components.CheckboxComponent
import com.example.loginflow.components.ClickableLoginTextComponent
import com.example.loginflow.components.DividerTextComponent
import com.example.loginflow.components.HeadingTextComponent
import com.example.loginflow.components.MyTextFieldComponent
import com.example.loginflow.components.NormalTextComponent
import com.example.loginflow.components.PasswordTextFieldComponent
import com.example.loginflow.data.LoginViewModel
import com.example.loginflow.data.UIEvent
import com.example.loginflow.navigation.PostOfficeAppRouter
import com.example.loginflow.navigation.Screen

@Composable
fun SignUpScreen(loginViewModel: LoginViewModel = viewModel()) {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(28.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            NormalTextComponent(value = stringResource(id = R.string.hello))

            HeadingTextComponent(value = stringResource(id = R.string.create_an_account))

            Spacer(modifier = Modifier.height(20.dp))

            MyTextFieldComponent(
                labelValue = stringResource(id = R.string.first_name),
                painterResource = painterResource(R.drawable.profile),
                onTextSelected = {
                    loginViewModel.onEvent(UIEvent.FirstNameChanged(it))
                }
            )

            MyTextFieldComponent(
                labelValue = stringResource(id = R.string.last_name),
                painterResource = painterResource(R.drawable.profile),
                onTextSelected = {
                    loginViewModel.onEvent(UIEvent.LastNameChanged(it))
                }
            )

            MyTextFieldComponent(
                labelValue = stringResource(id = R.string.email),
                painterResource = painterResource(R.drawable.message),
                onTextSelected = {
                    loginViewModel.onEvent(UIEvent.EmailChanged(it))
                }
            )

            PasswordTextFieldComponent(
                labelValue = stringResource(id = R.string.pass_word),
                painterResource = painterResource(R.drawable.profile),
                onTextSelected = {
                    loginViewModel.onEvent(UIEvent.PasswordChanged(it))
                }
            )

            CheckboxComponent(
                value = stringResource(id = R.string.terms_and_conditions),
                onTextSelected = {
                    Log.d("ClickableTextComponent", "SignUpScreen: $it")
                    PostOfficeAppRouter.navigationTo(Screen.TermsAndConditionsScreen)
                })

            Spacer(modifier = Modifier.height(80.dp))

            ButtonComponent(
                value = stringResource(id = R.string.register),
                onButtonClicked = {
                    loginViewModel.onEvent(UIEvent.RegisterButtonClicked)
                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            DividerTextComponent()

            ClickableLoginTextComponent(
                tryingToLogin = true,
                onTextSelected = {
                    PostOfficeAppRouter.navigationTo(Screen.LoginScreen)
                }
            )

        }

    }
}

@Composable
@Preview
fun DefaultPreviewSignUpScreen() {
    SignUpScreen()
}
