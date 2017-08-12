package com.om.tetris.shapes

import android.graphics.Rect
import com.om.tetris.TetrisBlock

class TBlock : TetrisBlock() {
  val cellHeight = 50
  val cellWidth = 50

  init {
    cells.add(Rect(0, 0, cellWidth * 3, cellHeight))
    cells.add(Rect(cellWidth, cellHeight, cellWidth * 2, cellHeight * 2))
  }
}