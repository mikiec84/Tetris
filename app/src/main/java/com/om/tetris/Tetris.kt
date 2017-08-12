package com.om.tetris

import android.content.Context
import android.graphics.Canvas
import android.view.View

class Tetris(context: Context) : View(context) {
  val randomBlock = TetrisBlock().getBlock()

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)
    randomBlock.draw(canvas)
  }

  fun loop() {
    render()
  }

  fun render() {
    randomBlock.move('D')
    invalidate()
  }
}