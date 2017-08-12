package com.om.tetris.shapes

import android.graphics.Rect

class Stick(screenWidth: Int) : TetrisBlock() {
  val cellWidth = 50
  val cellHeight = 50

  val whole: Rect

  init {
    whole = Rect(0, 0, cellWidth, cellHeight * 4)
    cells.add(whole)
  }
}