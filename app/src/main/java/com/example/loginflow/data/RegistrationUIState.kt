package com.example.loginflow.data

import androidx.lifecycle.ViewModel

data class RegistrationUIState(
    var firstName: String = "",
    var lastName: String = "",
    var email: String = "",
    var password: String = "",
)