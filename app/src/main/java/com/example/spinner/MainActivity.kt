package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import java.time.DayOfWeek

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // introduce the widgets
        val spMonths = findViewById<Spinner>(R.id.spinner1)
        val Months = findViewById<TextView>(R.id.textView1)
        val spDayOfWeek = findViewById<Spinner>(R.id.spinner2)
        val DayOfWeek = findViewById<TextView>(R.id.textView2)

        //start with example one

        //we already have the least and every thing the only thing we need is when item selected
        /*note : if you write ( spMonths.onItemSelectedListener= object :{} ) then clicked on alt+enter
        you can implement the function automatic
         */

        spMonths.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
            //the action to do when item selected function we need it to change the textView text
            //note: p0-> for AdapterView p1-> for view  p2->position
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Months.text= p0?.getItemAtPosition(p2).toString()
            }
            //what if the user did not choose any thing but we don't need it here
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }

        // example two

        // create your list
        var Days = mutableListOf<String>("sun","mon","tus","wed","thur","fri","sat")
        // now we need to populate the spinner with the data
        //create adapter
        // note: ArrayAdapter<String> (context,layout style ,array of data)
         val DayOfWeekAdaptor = ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,Days)
        //connect adaptor
        spDayOfWeek.adapter=DayOfWeekAdaptor
        //and again what if item selected
        spDayOfWeek.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                DayOfWeek.text= p0?.getItemAtPosition(p2).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        //thank you

    }
}