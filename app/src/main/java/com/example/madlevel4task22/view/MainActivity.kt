package com.example.madlevel4task22.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.madlevel4task22.R
import com.example.madlevel4task22.data.GameRepository
import com.example.madlevel4task22.model.Game
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    private val scope = CoroutineScope(Dispatchers.Default)
    private lateinit var repository: GameRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        repository = GameRepository(context = this)
        initView()
    }

    private fun beginSpel(spelerKeuze: Int) {
        val computerKeuze =
            intArrayOf(R.drawable.paper, R.drawable.rock, R.drawable.scissors).random()
        KeuzeSpeler.setImageResource(spelerKeuze)
        Keuzecomputer.setImageResource(computerKeuze)
        tvResults.text = checkWinner(pcChoice = computerKeuze, playerChoice = spelerKeuze)
        scope.launch {
            repository.insertGame(Game(Calendar.getInstance().time, computerKeuze, spelerKeuze, tvResults.text.toString()))
        }
    }

    private fun initView() {
        Rock.setOnClickListener {
            beginSpel(R.drawable.rock)
        }
        Paper.setOnClickListener {
            beginSpel(R.drawable.paper)
        }
        Scissors.setOnClickListener {
            beginSpel(R.drawable.scissors)
        }
    }
    private fun checkWinner(pcChoice: Int, playerChoice: Int): String {
        pcChoice.run {
            if ((this == R.drawable.paper && playerChoice == R.drawable.rock)||
                    (this == R.drawable.scissors && playerChoice == R.drawable.paper)||
                    (this == R.drawable.rock && playerChoice == R.drawable.scissors)) {
                return "Computer wins!"
            } else if ((playerChoice == R.drawable.paper && this == R.drawable.rock)||
                    (playerChoice == R.drawable.scissors && this == R.drawable.paper)||
                    (playerChoice == R.drawable.rock && this == R.drawable.scissors)) {
                return "You win!"
            } else {
                return "Draw!"
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_history -> {
                startActivity(Intent(this,SecondActivity::class.java))
                true}
            else -> super.onOptionsItemSelected(item)
        }

          }
}