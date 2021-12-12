package com.quantical.projetrayon

import android.os.Bundle
import android.widget.TextView

class ProduitActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produit)
        showBtnBack()
        setHeaderTitle("Produit")
        val text = intent.getStringExtra("id")
        val textTest: TextView = findViewById(com.quantical.projetrayon.R.id.textTest)
        textTest.text = text
    }
}