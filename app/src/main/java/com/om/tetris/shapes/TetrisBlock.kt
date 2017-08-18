package com.om.tetris.shapes

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import timber.log.Timber
import java.util.*

object TetrisBlock {
  var screenGrid = array2dOfInt(20, 40)

  private val cellWidth = 60
  private val cellHeight = 60

  private fun array2dOfInt(sizeOuter: Int, sizeInner: Int): Array<IntArray>
      = Array(sizeOuter) { IntArray(sizeInner) }

  fun getShapeGrid() =
      when (Random().nextInt(5) + 1) {
      //Box
        1 -> arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
      //Z Shape
        2 -> arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 1, 0)
        )
      //Stick
        3 -> arrayOf(
            intArrayOf(1),
            intArrayOf(1),
            intArrayOf(1),
            intArrayOf(1)
        )
      //Glider
        4 -> arrayOf(
            intArrayOf(0, 0, 1),
            intArrayOf(1, 1, 1)
        )
      //T Shape
        5 -> arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(0, 1, 0)
        )
        else -> TODO()
      }

  fun addShapeToGrid(source: Array<IntArray>,
      screenGrid: Array<IntArray>, point: Pair<Int, Int>): Array<IntArray> {
    val newGrid = source.clone()

    screenGrid.forEachIndexed { rowIndex, ints ->
      ints.forEachIndexed inner@ { columnIndex, _ ->
        val target_row_idx = point.first + rowIndex
        val target_col_idx = point.second + columnIndex

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

  fun draw(screenGrid: Array<IntArray>, canvas: Canvas, painter: Paint) {
    screenGrid.forEachIndexed { rowIndex, ints ->
      ints.forEachIndexed { columnIndex, integer ->
        Timber.d("Reaching here?")
        if (integer == 1) {
          canvas.drawRect(
              Rect(columnIndex * cellWidth, rowIndex * cellHeight,
                  (columnIndex * cellWidth) + cellWidth, (rowIndex * cellHeight) + cellHeight),
              painter)
        }
      }
    }
  }

  fun clearGrid(screenGrid: Array<IntArray>): Array<IntArray> {
    screenGrid.forEachIndexed { rowIndex, ints ->
      ints.forEachIndexed { columnIndex, _ ->
        screenGrid[rowIndex][columnIndex] = 0
      }
    }

    return screenGrid
  }
}