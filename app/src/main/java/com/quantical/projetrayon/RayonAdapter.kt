package com.quantical.projetrayon

import android.content.Intent
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RayonAdapter (private val Rayons: ArrayList<Rayon>): RecyclerView.Adapter<RayonAdapter.ViewHolder>(){

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val buttonProduit = view.findViewById<TextView>(R.id.buttonProduit)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.cell_rayon, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rayon = Rayons.get(position)
        holder.buttonProduit.text=rayon.title

        holder.buttonProduit.setOnClickListener(View.OnClickListener {
            val context= holder.buttonProduit.context
            val newIntent= Intent(context,ProduitActivity::class.java)
            newIntent.putExtra("id", rayon.category_id)
            newIntent.putExtra("product_irl", rayon.product_url)
            context.startActivity(newIntent)
        })
    }

    override fun getItemCount(): Int {
        return Rayons.size
    }
}