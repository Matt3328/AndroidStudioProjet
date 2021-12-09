package com.quantical.projetrayon

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import fr.epsi.epsig2.BaseActivity

class StudentActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        showBtnBack()
        setHeaderTitle("Student")

    }
}