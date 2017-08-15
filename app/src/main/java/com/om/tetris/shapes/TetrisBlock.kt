package com.om.tetris.shapes

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import java.util.*

open class TetrisBlock {
  val cells = ArrayList<Rect>()
  val loweringSpeed = 10
  val screenGrid = array2dOfInt(20, 40)

  val cellWidth = 60
  val cellHeight = 60

  lateinit var currentBlock: TetrisBlock

  val painter = Paint(android.graphics.Paint.ANTI_ALIAS_FLAG).apply {
    style = android.graphics.Paint.Style.FILL
    color = Color.RED
  }

  fun getBlock() =
      when (Random().nextInt(5) + 1) {
        1 -> Box(Pair(0, 8))
        2 -> ZBlock(Pair(0, 8))
        3 -> Stick(Pair(0, 8))
        4 -> Glider(Pair(0, 8))
        5 -> TBlock(Pair(0, 8))
        else -> TODO()
      }

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
//      cells.forEach {
//        it.top += loweringSpeed
//        it.bottom += loweringSpeed
//      }
//      clearGrid(screenGrid)
      incrementCoords(screenGrid)
    }
    else -> throw Exception("Invalid move, choose from 'L', 'R', 'U', 'D'")
  }

  fun array2dOfInt(sizeOuter: Int, sizeInner: Int): Array<IntArray>
      = Array(sizeOuter) { IntArray(sizeInner) }

  fun incrementCoords(screenGrid: Array<IntArray>) {
    screenGrid.forEachIndexed { rowIndex, ints ->
      ints.forEachIndexed { columnIndex, number ->
        if (number == 1) {
          ints[columnIndex] = 0
          screenGrid[rowIndex][columnIndex] = 1
        }
      }
    }
  }
}