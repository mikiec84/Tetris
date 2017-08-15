package com.om.tetris.shapes

class Stick(coords: Pair<Int, Int>) : TetrisBlock() {
  init {
    screenGrid[coords.first][coords.second] = 1
    screenGrid[coords.first + 1][coords.second] = 1
    screenGrid[coords.first + 2][coords.second] = 1
    screenGrid[coords.first + 3][coords.second] = 1
  }
}