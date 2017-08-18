import com.om.tetris.shapes.TetrisBlock
import org.junit.Test
import kotlin.test.assertTrue

class TetrisTest {
  @Test
  fun testCreateBoxShape() {
    val boxGrid = arrayOf(
        intArrayOf(1, 1),
        intArrayOf(1, 1)
    )

    val emptyGrid = arrayOf(
        intArrayOf(0, 0),
        intArrayOf(0, 0)
    )

    val expectedGrid = arrayOf(
        intArrayOf(1, 1),
        intArrayOf(1, 1)
    )

    assertTrue(
        twoDimenArrayEquals(expectedGrid,
            TetrisBlock.addShapeToGrid(emptyGrid, boxGrid, Pair(0, 0))))
  }

  @Test
  fun testCreateGliderShape() {
    val gliderGrid = arrayOf(
        intArrayOf(0, 0, 1),
        intArrayOf(1, 1, 1)
    )

    val emptyGrid = arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 0)
    )

    val expectedGrid = arrayOf(
        intArrayOf(0, 0, 1),
        intArrayOf(1, 1, 1)
    )

    assertTrue(
        twoDimenArrayEquals(expectedGrid,
            TetrisBlock.addShapeToGrid(emptyGrid, gliderGrid, Pair(0, 0))))
  }

  @Test
  fun testCreateTShape() {
    val tBlockGrid = arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(0, 1, 0)
    )

    val emptyGrid = arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 0)
    )

    val expectedGrid = arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(0, 1, 0)
    )

    assertTrue(
        twoDimenArrayEquals(expectedGrid,
            TetrisBlock.addShapeToGrid(emptyGrid, tBlockGrid, Pair(0, 0))))
  }

  @Test
  fun testCreateZShape() {
    val zBlockGrid = arrayOf(
        intArrayOf(0, 1, 1),
        intArrayOf(1, 1, 0)
    )

    val emptyGrid = arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 0)
    )

    val expectedGrid = arrayOf(
        intArrayOf(0, 1, 1),
        intArrayOf(1, 1, 0)
    )

    assertTrue(
        twoDimenArrayEquals(expectedGrid,
            TetrisBlock.addShapeToGrid(emptyGrid, zBlockGrid, Pair(0, 0))))
  }

  @Test
  fun testCreateStickShape() {
    val stickGrid = arrayOf(
        intArrayOf(1),
        intArrayOf(1),
        intArrayOf(1),
        intArrayOf(1)
    )

    val emptyGrid = arrayOf(
        intArrayOf(0),
        intArrayOf(0),
        intArrayOf(0),
        intArrayOf(0)
    )

    val expectedGrid = arrayOf(
        intArrayOf(1),
        intArrayOf(1),
        intArrayOf(1),
        intArrayOf(1)
    )

    assertTrue(
        twoDimenArrayEquals(expectedGrid,
            TetrisBlock.addShapeToGrid(emptyGrid, stickGrid, Pair(0, 0))))
  }

  @Test
  fun testClearGrid() {
    val grid = arrayOf(
        intArrayOf(0, 1, 1, 0),
        intArrayOf(0, 1, 1, 0),
        intArrayOf(1, 1, 1, 0),
        intArrayOf(0, 1, 0, 1)
    )

    val expectedGrid = arrayOf(
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0)
    )

    assertTrue(twoDimenArrayEquals(expectedGrid, TetrisBlock.clearGrid(grid)))
  }

  private fun twoDimenArrayEquals(first: Array<IntArray>, second: Array<IntArray>): Boolean {
    first.forEachIndexed { rowIndex, ints ->
      ints.forEachIndexed { columnIndex, _ ->
        if (first[rowIndex][columnIndex] != second[rowIndex][columnIndex])
          return false
      }
    }

    return true
  }
}