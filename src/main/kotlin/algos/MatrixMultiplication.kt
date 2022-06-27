package algos

class MatrixMultiplication {

    fun multiply(a: Array<IntArray>, b: Array<IntArray>): Array<IntArray> {
        val aRows = a.size
        val bColumns = b.first().size
        val ab = Array<IntArray>(aRows) { IntArray(bColumns) }
        val aNonZeroColumnIndicesByRow = nonZeroColumnIndicesByRow(a)
        val bNonZeroRowIndicesByColumn = nonZeroRowIndicesByColumn(b)
        for (aRowIndex in 0 until aRows) {
            for (abColumnIndex in 0 until bColumns) {
                var sum = 0
                for (aNonZeroColumnIndex in aNonZeroColumnIndicesByRow.getOrDefault(aRowIndex, HashSet<Int>())) {
                    if (bNonZeroRowIndicesByColumn.getOrDefault(abColumnIndex, HashSet<Int>()).contains(aNonZeroColumnIndex)) {
                        sum += a.get(aRowIndex).get(aNonZeroColumnIndex) * b.get(aNonZeroColumnIndex).get(abColumnIndex)
                    }
                }
                ab.get(aRowIndex).set(abColumnIndex, sum)
            }
        }
        return ab
    }

    private fun nonZeroRowIndicesByColumn(a: Array<IntArray>): HashMap<Int, HashSet<Int>> {
        val aRows = a.size
        val aColumns = a.get(0).size
        val nonZeroRowIndicesByColumn = HashMap<Int, HashSet<Int>>()
        for (aColumnIndex in 0 until aColumns) {
            val nonZeroRowIndices = HashSet<Int>()
            for (aRowIndex in 0 until aRows) {
                if (a.get(aRowIndex).get(aColumnIndex) != 0) {
                    nonZeroRowIndices.add(aRowIndex)
                }
            }
            nonZeroRowIndicesByColumn.put(aColumnIndex, nonZeroRowIndices)
        }
        return nonZeroRowIndicesByColumn
    }

    private fun nonZeroColumnIndicesByRow(a: Array<IntArray>): HashMap<Int, HashSet<Int>> {
        val nonZeroColumnIndicesByRow = HashMap<Int, HashSet<Int>>()
        for ((aRowIndex, aRow) in a.withIndex()) {
            val nonZeroColumnIndices = HashSet<Int>()
            for ((aColumnIndex, aColumn) in aRow.withIndex()) {
                if (aColumn != 0) {
                    nonZeroColumnIndices.add(aColumnIndex)
                }
            }
            nonZeroColumnIndicesByRow.put(aRowIndex, nonZeroColumnIndices)
        }
        return nonZeroColumnIndicesByRow
    }

}