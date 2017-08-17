package com.om.tetris

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import com.om.tetris.shapes.TetrisBlock

class TetrisView(context: Context) : View(context) {

  private val randomBlock = TetrisBlock().getBlock()

  private val painter = Paint(Paint.ANTI_ALIAS_FLAG).apply {
    style = android.graphics.Paint.Style.FILL
    color = Color.RED
  }

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)
    //Doesn't work now
    randomBlock.addToGrid(TetrisBlock.screenGrid)
    randomBlock.draw(canvas, painter)
  }

  fun loop() {
    render()
  }

  private fun render() {
//    randomBlock.move('D')
//    randomBlock.addToGrid(Pair(i, i))
//    i += 1
    invalidate()
  }
}