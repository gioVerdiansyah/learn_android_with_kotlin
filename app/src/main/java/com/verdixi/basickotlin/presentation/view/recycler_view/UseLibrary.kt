package com.verdixi.basickotlin.presentation.view.recycler_view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.verdixi.basickotlin.R
import com.verdixi.basickotlin.models.adapters.HeroAdapterWithLibrary
import com.verdixi.basickotlin.models.data.HeroWithLibrary

// Add implementation 'com.github.bumptech.glide:glide:4.16.0' in build.gradle.kts or implementation(libs.glide)
// And give permission internet <uses-permission android:name="android.permission.INTERNET" />
// Change data type from HeroAdapter to HeroAdapterWithLibrary and data class Hero to HeroWithLibrary

class UseLibrary : AppCompatActivity() {
    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<HeroWithLibrary>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_use_library)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()
    }

    @SuppressLint("Recycle")
    private fun getListHeroes(): ArrayList<HeroWithLibrary> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.url_data_photo)
        val listHero = ArrayList<HeroWithLibrary>()
        for (i in dataName.indices) {
            val hero = HeroWithLibrary(dataName[i], dataDescription[i], dataPhoto[i])
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapterWithLibrary = HeroAdapterWithLibrary(list)
        rvHeroes.adapter = listHeroAdapterWithLibrary

//        Onclick per list
        listHeroAdapterWithLibrary.setOnItemClickCallback(object : HeroAdapterWithLibrary.OnItemClickCallback {
            override fun onItemClicked(data: HeroWithLibrary) {
                showOnItemClicked(data)
            }
        })
    }

    private fun showOnItemClicked(hero: HeroWithLibrary) {
        Toast.makeText(this, "You click " + hero.name, Toast.LENGTH_SHORT).show()
    }

    //    Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvHeroes.layoutManager = LinearLayoutManager(this)
            }

            R.id.action_grid -> {
                rvHeroes.layoutManager = GridLayoutManager(this, 2)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}