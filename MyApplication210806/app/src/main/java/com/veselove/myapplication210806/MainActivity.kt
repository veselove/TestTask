package com.veselove.myapplication210806

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.veselove.myapplication210806.databinding.ActivityMainBinding
import com.veselove.myapplication210806.viewmodels.MyViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var model = MyViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        val recyclerView = binding.rvNumbers
        val numberOfColumns = 10
        recyclerView.layoutManager =
                GridLayoutManager(this, numberOfColumns, GridLayoutManager.HORIZONTAL, false)
        val adapter = MyRecyclerViewAdapter(model.idImageList)
        recyclerView.adapter = adapter

        model = ViewModelProvider(this).get(MyViewModel::class.java)
        model.observableIdImageList.observe(this, Observer { adapter.updateList(it) })
        LinearSnapHelper().attachToRecyclerView(recyclerView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.add -> {
            model.addImage()
            true
        }
        R.id.removeAll -> {
            model.reloadAll()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

}