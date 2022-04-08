package com.revature.isuckatretrofit.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.revature.isuckatretrofit.mainviewmodel.MainViewModel

@Composable
fun PrintItem() {
    val mainViewModel = MainViewModel()
    val data = mainViewModel.donationList[1]
    Column{
        LazyColumn {
            items(data.images.size){index ->
                Text(text = data.images[index])}
        }
        Text(text= data.description)
        Text(text= data.donationName)
        //Text(text= data.id.toString())

    }
    
    
}