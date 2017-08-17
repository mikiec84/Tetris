package com.om.tetris.shapes

class Stick(startingCoords: Pair<Int, Int>) : TetrisBlock() {
  init {
    placementCoords = arrayOf(
        Pair(startingCoords.first, startingCoords.second),
        Pair(startingCoords.first + 1, startingCoords.second),
        Pair(startingCoords.first + 2, startingCoords.second),
        Pair(startingCoords.first + 3, startingCoords.second))
  }
}