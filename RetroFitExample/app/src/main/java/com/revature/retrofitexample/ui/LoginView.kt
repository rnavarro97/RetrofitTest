package com.revature.retrofitexamlelogin.ui

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.revature.retrofitexample.viewmodel.LoginViewModel


@Composable
fun LoginView(
    modifier: Modifier = Modifier,
    viewModel:LoginViewModel,

    ) {
    var email by rememberSaveable { mutableStateOf(value = "") }
    var password by rememberSaveable { mutableStateOf(value = "") }
    val isValidate by derivedStateOf { email.isNotBlank() && password.isNotBlank() }
    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //

        //  TextLogin()

        Spacer(modifier = modifier.height(15.dp))
        TextField(
            value = email,
            onValueChange = { email = it },)

        Spacer(modifier = modifier.height(15.dp))

        TextField(
            value = password,
            onValueChange = { password = it },

            )

        Spacer(modifier = modifier.height(35.dp))

        Button(onClick = { viewModel.login(email,password)}) {


            Text(text = "Call API")
        }

//        val status_msg = viewModel.
//
//        Text(text = "API Response")




    }
}