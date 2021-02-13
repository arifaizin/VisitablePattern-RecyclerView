package com.dicoding.picodiploma.myrecyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.picodiploma.myrecyclerview.base.BaseHeroAdapter
import com.dicoding.picodiploma.myrecyclerview.visitors.VisitorElementFactory
import com.dicoding.picodiploma.myrecyclerview.databinding.ActivityMainBinding
import com.dicoding.picodiploma.myrecyclerview.model.CardHero
import com.dicoding.picodiploma.myrecyclerview.model.GridHero
import com.dicoding.picodiploma.myrecyclerview.model.Hero
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var title = "Visitable Pattern RecyclerView"
    private val list = ArrayList<Hero>()

    companion object {
        private const val STATE_TITLE = "state_string"
        private const val STATE_LIST = "state_list"
        private const val STATE_MODE = "state_mode"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvHeroes.setHasFixedSize(true)
        /*
        Gunakanlah savedinstancestate untuk menjaga data ketika terjadi config changes
         */
        when (savedInstanceState) {
            null -> {
                /*
            Pada saat pertama kali activity dijalankan,
            Ambil data dari method getListHeroes, kemudian tampilkan recyclerviewlist
             */
                setActionBarTitle(title)

                val dataName = resources.getStringArray(R.array.data_name)
                val dataDescription = resources.getStringArray(R.array.data_description)
                val dataPhoto = resources.getStringArray(R.array.data_photo)

                val listHero = ArrayList<Hero>()
                val gridsHero = ArrayList<GridHero>()
                val cardsHero = ArrayList<CardHero>()
                for (position in dataName.indices) {
                    val hero = Hero(
                            dataName[position],
                            dataDescription[position],
                            dataPhoto[position]
                    )
                    listHero.add(hero)

                    val gridHero = GridHero(
                            dataName[position],
                            dataDescription[position],
                            dataPhoto[position]
                    )
                    gridsHero.add(gridHero)

                    val cardHero = CardHero(
                            dataName[position],
                            dataDescription[position],
                            dataPhoto[position]
                    )
                    cardsHero.add(cardHero)
                }

                binding.rvHeroes.layoutManager = LinearLayoutManager(this)
                val listHeroAdapter = BaseHeroAdapter(VisitorElementFactory(::showSelectedHero))
                binding.rvHeroes.adapter = listHeroAdapter

                listHeroAdapter.addItem(listHero)
                listHeroAdapter.addItem(gridsHero)
                listHeroAdapter.addItem(cardsHero)

            }
            else -> {
                /*
            Jika terjadi config changes maka ambil data yang dikirimkan dari saveinstancestate
             */
                title = savedInstanceState.getString(STATE_TITLE).toString()
                val stateList = savedInstanceState.getParcelableArrayList<Hero>(STATE_LIST)

                /*
            Set data untuk title, list, dan mode yang dipilih
             */
                setActionBarTitle(title)
                if (stateList != null) {
                    list.addAll(stateList)
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_TITLE, title)
        outState.putParcelableArrayList(STATE_LIST, list)
    }

    private fun setActionBarTitle(title: String?) {
            supportActionBar?.title = title
    }

    private fun showSelectedHero(hero: Hero) {
        Toast.makeText(this, "Kamu memilih ${hero.name}", Toast.LENGTH_SHORT).show()
    }
}
