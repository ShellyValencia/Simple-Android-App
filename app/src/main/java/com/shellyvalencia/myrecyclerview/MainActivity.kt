package com.shellyvalencia.myrecyclerview

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var rvHarbingers: RecyclerView
    private val list = ArrayList<Harbinger>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHarbingers = findViewById(R.id.rv_harbingers)
        rvHarbingers.setHasFixedSize(true)

        list.addAll(getListHarbingers())
        showRecyclerList()

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("Recycle")
    private fun getListHarbingers(): ArrayList<Harbinger> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataCodename = resources.getStringArray(R.array.data_codename)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listHarbinger = ArrayList<Harbinger>()
        for (i in dataName.indices) {
            val harbinger = Harbinger(dataName[i], dataCodename[i], dataPhoto.getResourceId(i, -1), dataDescription[i])
            listHarbinger.add(harbinger)
        }
        return listHarbinger
    }

    private fun showRecyclerList() {
        rvHarbingers.layoutManager = LinearLayoutManager(this)
        val listHarbingerAdapter = ListHarbingerAdapter(list)
        rvHarbingers.adapter = listHarbingerAdapter
        listHarbingerAdapter.setOnItemClickCallback(object : ListHarbingerAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Harbinger) {
                showSelectedHarbinger(data)
            }
        })
    }

    private fun showSelectedHarbinger(harbinger: Harbinger) {
        Toast.makeText(this, "Kamu memilih " + harbinger.name, Toast.LENGTH_SHORT).show()
    }


}