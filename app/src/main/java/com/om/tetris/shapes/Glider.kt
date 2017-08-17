package com.om.tetris.shapes

class Glider(startingCoords: Pair<Int, Int>) : TetrisBlock() {
  init {
    placementCoords = arrayOf(
        Pair(startingCoords.first, startingCoords.second),
        Pair(startingCoords.first + 1, startingCoords.second),
        Pair(startingCoords.first + 1, startingCoords.second - 1),
        Pair(startingCoords.first + 1, startingCoords.second - 2))
  }
}