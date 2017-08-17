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

  private val startingCoords = Pair(1, 8)

  companion object {
    fun Array<IntArray>.copy() = map { it.clone() }.toTypedArray()

    private fun array2dOfInt(sizeOuter: Int, sizeInner: Int): Array<IntArray>
        = Array(sizeOuter) { IntArray(sizeInner) }

    fun clearGrid(screenGrid: Array<IntArray>): Array<IntArray> {
      screenGrid.forEachIndexed { rowIndex, ints ->
        ints.forEachIndexed { columnIndex, integer ->
          screenGrid[rowIndex][columnIndex] = 0
        }
      }

      return screenGrid
    }

    fun addShapeToGrid(source: Array<IntArray>,
        screenGrid: Array<IntArray>, point: Pair<Int, Int>): Array<IntArray> {
      val newGrid = source.copy()

      source.forEachIndexed { rowIndex, ints ->
        ints.forEachIndexed inner@ { columnIndex, num ->
          val target_row_idx = point.first + rowIndex
          val target_col_idx = point.second + columnIndex

          println("Target row idx $target_row_idx")
          println("Target col idx $target_col_idx")

          if (target_row_idx >= source.size
              || target_col_idx >= source[0].size) {
            return@inner
          } else {
            newGrid[target_row_idx][target_col_idx] = screenGrid[rowIndex][columnIndex]
          }
        }
      }

      return newGrid
    }

    //The Grid
    val screenGrid = array2dOfInt(20, 40)
  }

  fun getBlock() =
      when (Random().nextInt(5) + 1) {
        1 -> Box()
        2 -> ZBlock(startingCoords)
        3 -> Stick(startingCoords)
        4 -> Glider(startingCoords)
        5 -> TBlock(startingCoords)
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

  fun moveBlock(direction: Char) = when (direction) {
    'L' -> {
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
      screenGrid.forEachIndexed { rowIndex, ints ->
        ints.forEachIndexed { columnIndex, integer ->
          if (integer == 1) {
            val rowIndexIncrement = rowIndex + 1

            if (rowIndexIncrement < screenGrid.size) {
              screenGrid[rowIndex][columnIndex] = 0
              screenGrid[rowIndexIncrement][columnIndex] = 1
            }
          }
        }
      }
    }
    else -> throw Exception("Invalid move, choose from 'L', 'R', 'U', 'D'")
  }
}