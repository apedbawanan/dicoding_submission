package com.example.mysubmission

import android.content.ClipData
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvwisata: RecyclerView
    private var list: ArrayList<Place> = arrayListOf()
    private var title: String = "List"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        rvwisata = findViewById(R.id.rv_wisata)
        rvwisata.setHasFixedSize(true)

        list.addAll(PlaceData.listData)
        showList()

    }

    private fun setActionBarTitle(title: String){
        supportActionBar?.title = title
    }

    private fun showList(){
        rvwisata.layoutManager = LinearLayoutManager(this)
        val listViewAdapter = ViewAdapter(list)
        rvwisata.adapter = listViewAdapter

        listViewAdapter.setOnItemClickCallback(object : ViewAdapter.ItemClicked{
            override fun onItemClicked(data: Place){
                showSelectedItem(data)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int){
        when (selectedMode){
            R.id.about ->{
                val aboutPage = Intent(this@MainActivity, About::class.java)
                startActivity(aboutPage)
            }
        }
    }

    private fun showSelectedItem(format: Place){
        val dataintent = Intent(this@MainActivity, DetailActivity::class.java)
        dataintent.putExtra(DetailActivity.ITEM_TITTLE, format.nama)
        dataintent.putExtra(DetailActivity.ITEM_LOCATION, format.lokasi)
        dataintent.putExtra(DetailActivity.ITEM_DESC, format.detail)
        dataintent.putExtra(DetailActivity.img, format.photo)
        startActivity(dataintent)
    }
}
