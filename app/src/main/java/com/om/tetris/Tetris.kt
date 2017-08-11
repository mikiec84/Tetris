package com.om.tetris

import android.content.Context
import android.graphics.Canvas
import android.view.View
import com.om.tetris.shapes.TetrisBlock

class Tetris(context: Context) : View(context) {

  var randomBlock = TetrisBlock().getBlock()

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