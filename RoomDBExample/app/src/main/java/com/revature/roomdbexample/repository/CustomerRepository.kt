package com.revature.roomdbexample.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.revature.roomdbexample.DAO.CustomerData
import com.revature.roomdbexample.datamodels.AppDatabase
import com.revature.roomdbexample.datamodels.Customer

class CustomerRepository (application: Application){

    private lateinit var customerDao: CustomerData

    init{

        var database = AppDatabase.getDatabase(application)

        customerDao = database.customerDao()

    }

    val readAllCustomers: LiveData<List<Customer>> = customerDao.fetchAllCustomer()

    suspend fun deleteCustomerById(id: Int)
    {
        customerDao.deleteCustomerById(id)
    }

    suspend fun insertCustomer(customer: Customer)
    {
        customerDao.insertCustomer(customer)
    }
}