package com.example.purecleanat1.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.purecleanat1.Country
import com.example.purecleanat1.R

class CountryListAdapter(var countires: ArrayList<Country>) :
    RecyclerView.Adapter<CountryListAdapter.Viewholder>() {
    fun updateCunties(newCountires:List<Country>){
        countires.clear()
        countires.addAll(newCountires)
        notifyDataSetChanged()
    }


    class Viewholder(view: View) : RecyclerView.ViewHolder(view) {
   //  val countryName =view.name
        val countryName =view.findViewById<TextView>(R.id.name)
        fun bind(country: Country) {
       countryName.text=country.countryName

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