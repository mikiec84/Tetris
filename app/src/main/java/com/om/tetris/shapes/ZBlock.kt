package com.om.tetris.shapes

import android.graphics.Rect

class ZBlock {
  val cells = ArrayList<Rect>()

  val cellWidth = 50
  val cellHeight = 50

  val upper: Rect
  val lower: Rect

  init {
    upper = Rect(cellWidth, 0, cellWidth * 3, cellHeight)
    cells.add(upper)

    lower = Rect(0, cellHeight, cellWidth * 2, cellHeight * 2)
    cells.add(lower)
  }
}