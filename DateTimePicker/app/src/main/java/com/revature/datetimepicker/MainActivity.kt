package com.revature.datetimepicker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import com.revature.datetimepicker.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(R.layout.activity_main),
    DatePickerDialog.OnDateSetListener,
     TimePickerDialog.OnTimeSetListener {

    var month = 0
    var day = 0
    var year = 0
    var hour = 0
    var minute = 0

    //I kind of wonder why these shouldn't be remembered by mutableStateOf("")
    var savedMonth = 0
    var savedDay = 0
    var savedYear = 0
    var savedHour = 0
    var savedMinute = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pickDate()
    }

    private fun getDateTimeCalendar(){
        val cal = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
        hour = cal.get(Calendar.HOUR)
        minute = cal.get(Calendar.MINUTE)
    }

    private fun pickDate(){

        /*Working around deprecated methods to call views we declared in layout
        and setting an On Click Listener for that button*/
        /*lateinit*/var binding: ActivityMainBinding
        = ActivityMainBinding.inflate(layoutInflater)
        binding.btnTimePicker
            .setOnClickListener{
                //fetches the method we declared earlier...
                getDateTimeCalendar()

                //...and feeds them to the Date Picker Dialog
                DatePickerDialog(this,
                this,
                        year,
                        month,
                        day).show()
            }
    }


    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        savedDay = dayOfMonth
        savedMonth = month
        savedYear = year

        getDateTimeCalendar()
        TimePickerDialog(this,
            this,
            hour,
            minute,
            true).show()
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        savedHour = hourOfDay
        savedMinute = minute

        var binding: ActivityMainBinding
                = ActivityMainBinding.inflate(layoutInflater)
        binding.tvTextTime.text = "$savedMonth-$savedDay-$savedYear\n"+
                "$savedHour:$savedMinute"
    }


}