package com.om.tetris.shapes

import android.graphics.Rect

class Box {
  val cells = ArrayList<Rect>()

  val cellWidth = 50
  val cellHeight = 50

  val upper: Rect
  val lower: Rect

  init {
    upper = Rect(0, 0, cellWidth * 2, cellHeight)
    cells.add(upper)

    lower = Rect(0, cellHeight, cellWidth * 2, cellHeight * 2)
    cells.add(lower)
  }
}