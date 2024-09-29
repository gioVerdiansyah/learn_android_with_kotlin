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
import com.verdixi.basickotlin.R
import com.verdixi.basickotlin.databinding.ActivityPracticeViewBindingBinding
import com.verdixi.basickotlin.models.adapters.HeroAdapterWithViewBinding
import com.verdixi.basickotlin.models.data.HeroWithLibrary

class PracticeViewBinding : AppCompatActivity() {
    private lateinit var binding: ActivityPracticeViewBindingBinding
    private val list = ArrayList<HeroWithLibrary>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPracticeViewBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupWindowInsets()
        setupRecycleView()
        list.addAll(getListHeroes())
        showRecyclerList()
    }

    private fun setupWindowInsets(){
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
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

    private fun setupRecycleView(){
        with(binding.rvHeroes){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@PracticeViewBinding)
        }
    }

    private fun showRecyclerList() {
        val adapter = HeroAdapterWithViewBinding(list)
        binding.rvHeroes.adapter = adapter

        adapter.setOnItemClickCallback(object : HeroAdapterWithViewBinding.OnItemClickCallback {
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
            R.id.action_list -> binding.rvHeroes.layoutManager = LinearLayoutManager(this)

            R.id.action_grid -> binding.rvHeroes.layoutManager = GridLayoutManager(this, 2)
        }
        return super.onOptionsItemSelected(item)
    }
}