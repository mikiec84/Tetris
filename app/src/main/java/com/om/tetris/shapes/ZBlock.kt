package com.om.tetris.shapes

class ZBlock : TetrisBlock() {
  override fun addToGrid(coords: Pair<Int, Int>, screenGrid: Array<IntArray>): Array<IntArray> {
    screenGrid[coords.first][coords.second] = 1
    screenGrid[coords.first][coords.second + 1] = 1
    screenGrid[coords.first + 1][coords.second] = 1
    screenGrid[coords.first + 1][coords.second - 1] = 1

    return screenGrid
  }
}