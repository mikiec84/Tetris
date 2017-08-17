package com.om.tetris.shapes

open class Box(startingCoords: Pair<Int, Int>) : TetrisBlock() {
  init {
    placementCoords = arrayOf(
        Pair(startingCoords.first, startingCoords.second),
        Pair(startingCoords.first, startingCoords.second + 1),
        Pair(startingCoords.first + 1, startingCoords.second),
        Pair(startingCoords.first + 1, startingCoords.second + 1))
  }
}