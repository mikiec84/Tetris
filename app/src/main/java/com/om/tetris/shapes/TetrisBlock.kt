package com.om.tetris.shapes

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import java.util.*

open class TetrisBlock {
  val cells = ArrayList<Rect>()
  val loweringSpeed = 10

  val painter = Paint(android.graphics.Paint.ANTI_ALIAS_FLAG).apply {
    style = android.graphics.Paint.Style.FILL
    color = Color.RED
  }

  fun getBlock(screenWidth: Int) =
      when (Random().nextInt(5) + 1) {
        1 -> Box(screenWidth)
        2 -> ZBlock(screenWidth)
        3 -> Stick(screenWidth)
        4 -> Glider(screenWidth)
        5 -> TBlock(screenWidth)
        else -> TODO()
      }

  fun draw(canvas: Canvas) {
    cells.forEach { canvas.drawRect(it, painter) }
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