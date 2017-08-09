package com.om.tetris

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
  lateinit var tetris: Tetris

  var timer = Timer()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    mainContentLayout.post {
      tetris = Tetris(this, mainContentLayout)

      mainContentLayout.addView(tetris)

      Log.d("Coords", "Screen height for Hassan is : " + mainContentLayout.height)

      mainContentLayout.setOnClickListener {
        startGameLoop()
      }
    }
  }

  fun startGameLoop() {
    val runAsyncTask = object : TimerTask() {
      override fun run() {
        runOnUiThread {
          tetris.loop()
        }
      }
    }

    timer.schedule(runAsyncTask, 0, 20)
  }

  fun stopGameLoop() {
    timer.cancel()
  }

  override fun onDestroy() {
    super.onDestroy()
    stopGameLoop()
  }
}
