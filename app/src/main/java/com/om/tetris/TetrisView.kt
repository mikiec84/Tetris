package com.om.tetris

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import com.om.tetris.shapes.TetrisBlock

class TetrisView(context: Context) : View(context) {

  private val randomShape = TetrisBlock.getShapeGrid()

  private val startingCoords = Pair(2,4)

  private val painter = Paint(Paint.ANTI_ALIAS_FLAG).apply {
    style = Paint.Style.FILL
    color = Color.RED
  }

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    with(TetrisBlock){
    addShapeToGrid(randomShape, screenGrid, startingCoords)
    draw(screenGrid, canvas, painter)
    }
  }

  fun loop() {
    render()
  }

  private fun render() {
//    randomShape.moveBlock('D')
    invalidate()
  }
}