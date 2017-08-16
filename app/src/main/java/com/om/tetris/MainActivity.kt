package com.om.tetris

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
  private var tetris: TetrisView? = null

  private var gameStarted = false

  private var timer = Timer()

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

  private fun addGameView() {
    if (tetris == null) {
      tetris = TetrisView(this)
      mainContentLayout.addView(tetris)
    }
  }

  private fun removeGameView() {
    mainContentLayout.removeView(tetris)
    tetris = null
  }

  private fun startGameLoop() {
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

  private fun stopGameLoop() {
    timer.cancel()
    gameStarted = false
  }
}
