package com.example.purecleanat1.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.purecleanat1.Country
import com.example.purecleanat1.R
import com.example.purecleanat1.util.*


class CountryListAdapter(var countires: ArrayList<Country>) :
    RecyclerView.Adapter<CountryListAdapter.Viewholder>() {
    fun updateCunties(newCountires:List<Country>){
        countires.clear()
        countires.addAll(newCountires)
        notifyDataSetChanged()
    }

    class Viewholder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView=view.findViewById<ImageView>(R.id.imageView)
        private val countryCapital=view.findViewById<TextView>(R.id.capital)
        private val progressDrawable=getProgressDrawable(view.context)
   //  val countryName =view.name
        val countryName =view.findViewById<TextView>(R.id.name)
        fun bind(country: Country) {
       countryName.text=country.countryName
            countryCapital.text=country.capital

            imageView.loadImage(country.flag,progressDrawable)

        }

        //val nameTextView = view.findViewById<TextView>(R.id.name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        Viewholder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_country, parent, false)
        )


    override fun getItemCount(): Int {
        Log.e("werdsfsdf","${countires.size}")
        return countires.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {

        holder.bind(countires.get(position))
    }

}

// fun ImageView.loadImage(uri: String?, progressDrawable: CircularProgressDrawable) {
//     val options= RequestOptions()
//         .placeholder(progressDrawable)
//         .error(R.mipmap.ic_launcher_round)
//
//     Glide.with(this.context)
//         .setDefaultRequestOptions(options)
//         .load(uri)
//         .into(this)
//
//
//}


