package com.quantical.projetrayon

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    fun showBtnBack(){
        val imageViewBack=findViewById<ImageView>(R.id.imageViewBack)
        imageViewBack.visibility=View.VISIBLE
        imageViewBack.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

    fun setHeaderTitle(txt : String){
        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        textViewTitle.text = txt
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Epsi","################ onCreate ##############"+javaClass.simpleName)
    }

    override fun onResume() {
        super.onResume()
        Log.d("Epsi","################ onResume ##############"+javaClass.simpleName)
    }

    override fun onPause() {
        super.onPause()
        Log.d("Epsi","################ onPause ##############"+javaClass.simpleName)
    }

}