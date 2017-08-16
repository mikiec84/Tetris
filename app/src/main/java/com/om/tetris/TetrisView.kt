package com.om.tetris

import android.content.Context
import android.graphics.Canvas
import android.view.View
import com.om.tetris.shapes.TetrisBlock

class TetrisView(context: Context) : View(context) {

  private val randomBlock = TetrisBlock().getBlock()
  private val coordsPair = Pair(1, 1)

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)
    //Doesn't work now
    randomBlock.addToGrid(coordsPair, TetrisBlock.screenGrid)
    randomBlock.draw(canvas)
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