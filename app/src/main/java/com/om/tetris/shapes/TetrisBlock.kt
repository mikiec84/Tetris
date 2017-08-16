package com.om.tetris.shapes

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import java.util.*

open class TetrisBlock {
  private val cells = ArrayList<Rect>()
  private val loweringSpeed = 10

  private val cellWidth = 60
  private val cellHeight = 60

  private val painter = Paint(Paint.ANTI_ALIAS_FLAG).apply {
    style = android.graphics.Paint.Style.FILL
    color = Color.RED
  }

  companion object {
    private fun array2dOfInt(sizeOuter: Int, sizeInner: Int): Array<IntArray>
        = Array(sizeOuter) { IntArray(sizeInner) }

    val screenGrid = array2dOfInt(20, 40)
  }

  fun getBlock() =
      when (Random().nextInt(5) + 1) {
        1 -> Box()
        2 -> ZBlock()
        3 -> Stick()
        4 -> Glider()
        5 -> TBlock()
        else -> TODO()
      }

  fun addToGrid(coords: Pair<Int, Int>, screenGrid: Array<IntArray>): Array<IntArray> = screenGrid

  fun draw(canvas: Canvas) {
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