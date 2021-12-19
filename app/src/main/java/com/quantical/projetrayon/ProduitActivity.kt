package com.quantical.projetrayon

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ProduitActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produit)
        showBtnBack()
        intent.getStringExtra("title")?.let { setHeaderTitle(it) }
        val products_url = intent.getStringExtra("products_url")
        val produits = arrayListOf<Produit>()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewProduit)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val produitAdapter = ProduitAdapter(produits)
        recyclerView.adapter = produitAdapter


        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL =products_url
        val request = Request.Builder()
            .url(mRequestURL.toString())
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
                        val jsProduit = jsArray.getJSONObject(i)
                        val name =jsProduit.optString("name","")
                        val description =jsProduit.optString("description","")
                        val picture_url =jsProduit.optString("picture_url","")
                        val produit = Produit(name, description, picture_url)
                        produits.add(produit)
                        Log.d("Produit",produit.name)
                    }
                    runOnUiThread(Runnable {
                        produitAdapter.notifyDataSetChanged()
                    })

//                    Handler(Looper.getMainLooper()).post(Runnable {
//                        studentAdapter.notifyDataSetChanged()
//                    })

                    Log.d("WS",data)
                    Log.d("Produit","${produits.size}")
                }
            }
        })
    }
}