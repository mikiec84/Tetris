import com.nhaarman.mockito_kotlin.mock
import com.om.tetris.shapes.Box
import org.junit.Test
import kotlin.test.assertTrue

class TetrisTest {
  @Test
  fun addToGridTest() {
    val box = mock<Box>()

    val grid: Array<IntArray> = arrayOf(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0))

    val expectedGrid: Array<IntArray> = arrayOf(intArrayOf(0, 0, 0, 0, 0, 1, 1, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 1, 1, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0))

    assertTrue(twoDimenArrayEquals(expectedGrid, box.addToGrid(Pair(0, 5), grid)))
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