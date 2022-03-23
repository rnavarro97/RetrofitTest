package com.revature.roomdbexample.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.revature.roomdbexample.datamodels.Customer
import com.revature.roomdbexample.repository.CustomerRepository
import kotlinx.coroutines.launch

class CustomerViewModel(appObj: Application): AndroidViewModel(appObj)  {

    private val customerRepository: CustomerRepository = CustomerRepository(appObj)

    fun fetchAllCustomers(): LiveData<List<Customer>>
    {
        return customerRepository.readAllCustomers
    }

    fun insertCustomer(customer:Customer)
    {
        viewModelScope.launch{
            customerRepository.insertCustomer(customer)
        }
    }

    fun deleteCustomerById(id:Int)
    {
        viewModelScope.launch{
            customerRepository.deleteCustomerById(id)
        }
    }
}