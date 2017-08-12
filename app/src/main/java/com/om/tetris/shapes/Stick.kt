package com.om.tetris.shapes

import android.graphics.Rect
import com.om.tetris.TetrisBlock

class Stick : TetrisBlock() {
  val cellHeight = 50
  val cellWidth = 50

  init {
    cells.add(Rect(0, 0, cellWidth, cellHeight * 4))
  }
}