package com.om.tetris

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
  var tetris: Tetris? = null

  var gameStarted = false

  var timer = Timer()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)


    mainContentLayout.post {

      addGameView()

      mainContentLayout.setOnClickListener {
        if (gameStarted) {
          stopGameLoop()
          removeGameView()
        } else {
          addGameView()
          startGameLoop()
        }
      }
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    stopGameLoop()
  }

  fun addGameView() {
    if (tetris == null) {
      tetris = Tetris(this, mainContentLayout)
      mainContentLayout.addView(tetris)
    }
  }

  fun removeGameView() {
    mainContentLayout.removeView(tetris)
    tetris = null
  }

  fun startGameLoop() {
    timer = Timer()
    val gameTimerTask = object : TimerTask() {
      override fun run() {
        runOnUiThread {
          tetris?.loop()
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
}
