package com.om.tetris.shapes

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import java.util.*

open class TetrisBlock {
  private val cells = ArrayList<Rect>()
  private val loweringSpeed = 10

  lateinit var placementCoords: Array<Pair<Int, Int>>

  private val cellWidth = 60
  private val cellHeight = 60

  open fun addToGrid(screenGrid: Array<IntArray>): Array<IntArray> {
    placementCoords.forEachIndexed { index, pair ->
      screenGrid[pair.first][pair.second] = 1
    }

    return screenGrid
  }

  companion object {
    private fun array2dOfInt(sizeOuter: Int, sizeInner: Int): Array<IntArray>
        = Array(sizeOuter) { IntArray(sizeInner) }

    val screenGrid = array2dOfInt(20, 40)
  }

  fun getBlock() =
      when (Random().nextInt(5) + 1) {
        1 -> Box(Pair(0, 4))
        2 -> ZBlock(Pair(0, 4))
        3 -> Stick(Pair(0, 4))
        4 -> Glider(Pair(0, 4))
        5 -> TBlock(Pair(0, 4))
        else -> TODO()
      }

  fun draw(canvas: Canvas, painter: Paint) {
    screenGrid.forEachIndexed { rowIndex, ints ->
      ints.forEachIndexed { columnIndex, integer ->
        if (integer == 1) {
          canvas.drawRect(
              Rect(columnIndex * cellWidth, rowIndex * cellHeight,
                  (columnIndex * cellWidth) + cellWidth, (rowIndex * cellHeight) + cellHeight),
              painter)
        }
      }
    }
  }

  fun move(direction: Char) = when (direction) {
    'L' -> {
      cells.forEach {
        it.right -= loweringSpeed
        it.left -= loweringSpeed
      }
    }
    'R' -> {
      cells.forEach {
        it.right += loweringSpeed
        it.left += loweringSpeed
      }
    }
    'U' -> {
      cells.forEach {
        it.top -= loweringSpeed
        it.bottom -= loweringSpeed
      }
    }
    'D' -> {
      cells.forEach {
        it.top += loweringSpeed
        it.bottom += loweringSpeed
      }
    }
    else -> throw Exception("Invalid move, choose from 'L', 'R', 'U', 'D'")
  }
}