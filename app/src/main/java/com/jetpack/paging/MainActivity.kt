package com.jetpack.paging

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import com.jetpack.paging.databinding.ActivityMainBinding
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.lifecycle.viewModelScope
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil
            .setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        //ViewModelProviders.of(this).get(ListViewModel::class.java)
        val viewModel: ListViewModel = ViewModelProvider(this, AndroidViewModelFactory(application))
            .get(ListViewModel::class.java)

        val adapter = ListAdapter()
        viewModel.dataList.observe(this,{list ->
            adapter.submitList(list)
            Log.d("log_debug","data is updated size is ${list.size}")
        })

        binding.list.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.list.layoutManager = layoutManager
        binding.list.addItemDecoration(MyDecoration(this,MyDecoration.VERTICAL_LIST))

    }

    fun toJava(view: View) {
        startActivity(Intent(this,MainActivityJava::class.java))
    }
}