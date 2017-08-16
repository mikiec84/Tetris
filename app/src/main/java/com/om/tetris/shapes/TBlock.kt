package com.om.tetris.shapes

class TBlock : TetrisBlock() {
  override fun addToGrid(coords: Pair<Int, Int>, screenGrid: Array<IntArray>): Array<IntArray> {
    screenGrid[coords.first][coords.second] = 1
    screenGrid[coords.first][coords.second + 1] = 1
    screenGrid[coords.first][coords.second + 2] = 1
    screenGrid[coords.first + 1][coords.second + 1] = 1

    return screenGrid
  }
}