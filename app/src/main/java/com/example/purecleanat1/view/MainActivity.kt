package com.example.purecleanat1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isEmpty
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.purecleanat1.R
import com.example.purecleanat1.databinding.ActivityMainBinding
import com.example.purecleanat1.viewmodel.ListViewModel


class MainActivity : AppCompatActivity() {
    //i promise i give this before i use it
    lateinit var viewModel:ListViewModel
    private val countriesAdapter=CountryListAdapter(arrayListOf())
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // take care to update viewmodel and destory it when we dont need it
        viewModel=ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()
        binding.countiresList.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=countriesAdapter
        }

        observeViewModel()
        Log.e("viiiidnfk","xxxx ${binding.countiresList.adapter?.itemCount}")



    }
    fun observeViewModel(){
        viewModel.countries.observe(this, Observer {  countries->
            countries?.let{countriesAdapter.updateCunties(it)
                Log.e("viiiidnfk","1")
                Log.e("viiiidnfk","sdfasdfasfd"+countries.toString())
            }
        })
    viewModel.countryLoadError.observe(this, Observer { isError->
        isError?.let {
            Log.e("viiiidnfk","2")
            Log.e("viiiidnfk","2"+it)
            binding.listError.visibility=if (it) View.VISIBLE else View.GONE }
    })
        viewModel.loading.observe(this, Observer { isLoading->
            isLoading?.let {
                Log.e("viiiidnfk","3"+it)
binding.loadingView.visibility=View.GONE
                binding.loadingView.visibility=if (it) View.VISIBLE else View.GONE
                if (it){
                    binding.listError.visibility=View.GONE
                    binding.listError.visibility=View.GONE
                }



            }
        })
    }
}