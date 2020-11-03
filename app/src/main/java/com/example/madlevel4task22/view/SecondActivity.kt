package com.example.madlevel4task22.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.madlevel4task22.R
import com.example.madlevel4task22.data.GameRepository
import com.example.madlevel4task22.model.Game
import com.example.madlevel4task22.utils.Adapter
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SecondActivity : AppCompatActivity() {
    private val scope = CoroutineScope(Dispatchers.Main)
    private lateinit var repository: GameRepository
    private var listofGames = arrayListOf<Game>()
    private val adapter = Adapter(listofGames)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        repository = GameRepository(this)
        initView()
        getData()
    }

    private fun initView() {
        rv_history.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_history.adapter = adapter
    }

    private fun getData() {
        scope.launch {
            listofGames.clear()
            repository.getAllGames()?.let { listofGames.addAll(it) }
            adapter.notifyDataSetChanged()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_history, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.Delete ->{
              scope.launch {
                  repository.deleteAllGames()
                  getData()
              }
             true}
            else -> super.onOptionsItemSelected(item)
        }
    }
}