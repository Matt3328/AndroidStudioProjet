package com.quantical.projetrayon

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProduitAdapter (private val produits: ArrayList<Produit>): RecyclerView.Adapter<ProduitAdapter.ViewHolder>(){

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val textViewName = view.findViewById<TextView>(R.id.textViewName)
        val textViewDescription = view.findViewById<TextView>(R.id.textViewDescription)
        val imageViewProduit = view.findViewById<ImageView>(R.id.imageViewProduit)
        val contentLayout = view.findViewById<LinearLayout>(R.id.contentLayout)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.cell_produit, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produit = produits.get(position)
        holder.textViewName.text=produit.name
        holder.textViewDescription.text=produit.description

        Picasso.get().load(produit.picture_url).into(holder.imageViewProduit)

        holder.contentLayout.setOnClickListener(View.OnClickListener {
            val context= holder.contentLayout.context
            val newIntent= Intent(context,DetailsActivity::class.java)
            newIntent.putExtra("name", produit.name)
            newIntent.putExtra("description", produit.description)
            newIntent.putExtra("picture_url", produit.picture_url)
            context.startActivity(newIntent)
        })
    }

    override fun getItemCount(): Int {
        return produits.size
    }
}