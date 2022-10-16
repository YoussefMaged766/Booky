package com.example.books.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.books.utils.Status
import com.example.books.adapter.Adapter
import com.example.books.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import io.karn.notify.Notify


class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    val viewModel: MainViewModel by viewModels()
    lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        lifecycleScope.launch {
           viewModel.getData().collect {
                it.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
                            resource.data .let { response->
                                adapter = Adapter(response?.data?.categories as ArrayList<String>)
                               binding.recycler.adapter=adapter
                                binding.recycler.visibility = View.VISIBLE
                                binding.progress1.visibility=View.INVISIBLE
                            }
                        }
                        Status.LOADING -> {
                            binding.recycler.visibility = View.INVISIBLE
                            binding.progress1.visibility=View.VISIBLE
                        }
                        Status.ERROR -> {
                            binding.recycler.visibility = View.VISIBLE
                            binding.progress1.visibility=View.INVISIBLE
                           Toast.makeText(this@MainActivity,it.message.toString(),Toast.LENGTH_SHORT).show()
                            Log.e( "onCreate: ", it.message.toString())
                        }
                    }
                    Log.e("onCreate: ",it.data?.data?.categories.toString() )
                }
            }
        }

    }




}