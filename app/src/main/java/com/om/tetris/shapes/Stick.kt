package com.om.tetris.shapes

class Stick : TetrisBlock() {
  fun addToGrid(coords: Pair<Int, Int>, screenGrid: Array<IntArray>): Array<IntArray> {
    screenGrid[coords.first][coords.second] = 1
    screenGrid[coords.first + 1][coords.second] = 1
    screenGrid[coords.first + 2][coords.second] = 1
    screenGrid[coords.first + 3][coords.second] = 1

    return screenGrid
  }
}