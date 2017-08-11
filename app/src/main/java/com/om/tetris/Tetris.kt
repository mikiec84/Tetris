package com.om.tetris

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import android.widget.RelativeLayout
import com.om.tetris.shapes.Box
import com.om.tetris.shapes.Glider
import com.om.tetris.shapes.Stick
import com.om.tetris.shapes.ZBlock
import java.util.*

class Tetris(context: Context, mainContentLayout: RelativeLayout) : View(context) {

  val box = Box()
  val glider = Glider()
  val zBlock = ZBlock()
  val stick = Stick()

  val randomBlock: Int
  val painter: Paint

  val screenWidth: Int
  val screenHeight: Int

  val loweringSpeed = 10

  init {
    painter = Paint(android.graphics.Paint.ANTI_ALIAS_FLAG).apply {
      strokeWidth = 10f
      style = android.graphics.Paint.Style.FILL
    }

    screenWidth = mainContentLayout.width
    screenHeight = mainContentLayout.height

    randomBlock = Random().nextInt(4 - 1) + 1
  }

  override fun onDraw(canvas: Canvas?) {
    super.onDraw(canvas)

    painter.color = Color.RED

    when (randomBlock) {
      1 -> glider.cells.forEach { canvas?.drawRect(it, painter) }
      2 -> box.cells.forEach { canvas?.drawRect(it, painter) }
      3 -> zBlock.cells.forEach { canvas?.drawRect(it, painter) }
      4 -> stick.cells.forEach { canvas?.drawRect(it, painter) }
    }
  }

  fun loop() {
    render()
  }

  fun render() {
    when (randomBlock) {
      1 -> moveBlock(glider.cells, 'D')
      2 -> moveBlock(box.cells, 'D')
      3 -> moveBlock(zBlock.cells, 'D')
      4 -> moveBlock(stick.cells, 'D')
    }

    invalidate()
  }

  fun moveBlock(cells: ArrayList<Rect>, direction: Char) = when (direction) {
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