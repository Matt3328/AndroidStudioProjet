package com.quantical.projetrayon

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonStudents: Button = findViewById(R.id.buttonStudents)
        val buttonRayon: Button = findViewById(R.id.buttonRayon)

        buttonStudents.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,StudentActivity::class.java)
            startActivity(newIntent)
        })
        buttonRayon.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,StudentActivity::class.java)
            startActivity(newIntent)
        })

    }
}