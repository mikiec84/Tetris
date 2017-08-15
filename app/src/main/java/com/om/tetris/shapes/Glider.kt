package com.om.tetris.shapes

class Glider(coords: Pair<Int, Int>) : TetrisBlock() {
  init {
    screenGrid[coords.first][coords.second] = 1
    screenGrid[coords.first + 1][coords.second] = 1
    screenGrid[coords.first + 1][coords.second - 1] = 1
    screenGrid[coords.first + 1][coords.second - 2] = 1
  }
}