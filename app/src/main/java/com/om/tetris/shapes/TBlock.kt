package com.om.tetris.shapes

import android.graphics.Rect

class TBlock : TetrisBlock() {
  val cellWidth = 50
  val cellHeight = 50

  val upper: Rect
  val lower: Rect

  init {
    upper = Rect(0, 0, cellWidth * 3, cellHeight)
    cells.add(upper)

    lower = Rect(cellWidth, cellHeight, cellWidth * 2, cellHeight * 2)
    cells.add(lower)
  }
}