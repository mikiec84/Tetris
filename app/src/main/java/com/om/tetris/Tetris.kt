package com.om.tetris

import android.content.Context
import android.graphics.Canvas
import android.view.View
import android.widget.RelativeLayout
import com.om.tetris.shapes.TetrisBlock

class Tetris(context: Context, mainContentLayout: RelativeLayout) : View(context) {

  var randomBlock = TetrisBlock().getBlock(mainContentLayout.width)

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