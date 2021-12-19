package com.quantical.projetrayon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetailsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        showBtnBack()
        intent.getStringExtra("name")?.let { setHeaderTitle(it) }
        val imageViewDetail = findViewById<ImageView>(R.id.imageViewDetail)
        val picture_url= intent.getStringExtra("picture_url")
        Picasso.get().load(picture_url).into(imageViewDetail)
        val textViewDescriptionAll = findViewById<TextView>(R.id.textViewDescriptionAll)
        val description= intent.getStringExtra("description")
        textViewDescriptionAll.text = description
    }
}