package com.om.tetris.shapes

open class Box : TetrisBlock() {
//  init {
//    placementCoords = arrayOf(
//        Pair(startingCoords.first, startingCoords.second),
//        Pair(startingCoords.first, startingCoords.second + 1),
//        Pair(startingCoords.first + 1, startingCoords.second),
//        Pair(startingCoords.first + 1, startingCoords.second + 1))
//  }

  val grid = arrayOf(
      intArrayOf(1, 1),
      intArrayOf(1, 1)
  )
}