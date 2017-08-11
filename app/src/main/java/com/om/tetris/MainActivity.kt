package com.om.tetris

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
  lateinit var tetris: Tetris

  var gameStarted = false

  var timer = Timer()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    mainContentLayout.post {
      tetris = Tetris(this, mainContentLayout)

      mainContentLayout.addView(tetris)

      mainContentLayout.setOnClickListener {
        if (gameStarted)
          stopGameLoop()
        else
          startGameLoop()
      }
    }
  }

  fun startGameLoop() {
    timer = Timer()
    val gameTimerTask = object : TimerTask() {
      override fun run() {
        runOnUiThread {
          tetris.loop()
        }
      }
    }

    timer.schedule(gameTimerTask, 0, 20)
    gameStarted = true
  }

  fun stopGameLoop() {
    timer.cancel()
    gameStarted = false
  }

  override fun onDestroy() {
    super.onDestroy()
    stopGameLoop()
  }
}
