package com.om.tetris.shapes

import android.graphics.Rect
import com.om.tetris.TetrisBlock

class Glider : TetrisBlock() {
  val cellHeight = 50
  val cellWidth = 50

  init {
    cells.add(Rect(cellWidth * 2, 0, cellWidth * 3, cellHeight))
    cells.add(Rect(0, cellHeight, cellWidth * 3, cellHeight * 2))
  }
}