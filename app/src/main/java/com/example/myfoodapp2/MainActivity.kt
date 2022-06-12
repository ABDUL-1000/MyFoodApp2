package com.example.myfoodapp2

import ListAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.myfoodapp2.data.SourceOfData
import com.example.myfoodapp2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private val myDataset = SourceOfData().displayDeclaration()
    private var isGridLayoutManager = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = binding.recreateItem

        recyclerView.setHasFixedSize(true)
        layoutChoice()

    }
    private fun layoutChoice(){
        if(isGridLayoutManager){
            recyclerView.layoutManager = GridLayoutManager(this, 2)
        }else {
            recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        }
        recyclerView.adapter = ListAdapter(myDataset)

    }
    private fun setIcon(menuItem: MenuItem?){
        if(menuItem == null) return
        menuItem.icon =
            if (isGridLayoutManager)
                ContextCompat.getDrawable(this, R.drawable.ic_grid_icon)
            else ContextCompat.getDrawable(this, R.drawable.ic_list_icon)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        val layoutButton = menu?.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){R.id.action_switch_layout -> {
            isGridLayoutManager = !isGridLayoutManager
            layoutChoice()
            setIcon(item)

            return true
        }
            else -> super.onOptionsItemSelected(item)
        }
    }

}