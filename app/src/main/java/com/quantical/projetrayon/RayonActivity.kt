package com.quantical.projetrayon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class RayonActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rayon)
        showBtnBack()
        setHeaderTitle("Rayon")
        val Rayons = arrayListOf<Rayon>()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewStudents)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val RayonAdapter = RayonAdapter(Rayons)
        recyclerView.adapter = RayonAdapter


        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL = "https://djemam.com/epsi/categories.json"
        val request = Request.Builder()
            .url(mRequestURL)
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()
        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()
                if(data !=null){
                    val jsOb= JSONObject(data)
                    val jsArray =jsOb.getJSONArray("items")
                    for(i in 0 until jsArray.length()){
                        val jsStudent = jsArray.getJSONObject(i)
                        val title =jsStudent.optString("title","")
                        val category_id =jsStudent.optString("category_id","")
                        val products_url =jsStudent.optString("products_url","")
                        val rayon = Rayon(category_id, title, products_url)
                        Rayons.add(rayon)
                    }
                    runOnUiThread(Runnable {
                        RayonAdapter.notifyDataSetChanged()
                    })

//                    Handler(Looper.getMainLooper()).post(Runnable {
//                        studentAdapter.notifyDataSetChanged()
//                    })

                    Log.d("WS",data)
                    Log.d("Student","${Rayons.size}")
                }
            }
        })
    }
}