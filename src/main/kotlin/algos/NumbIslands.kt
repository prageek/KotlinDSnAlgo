package algos

class NumbIslands {
}

//Time = o(m*n)
//Space = o(m*n)
fun numIslands(grid: Array<CharArray>): Int {
    if (grid.isEmpty()) return 0
    var result =0

    grid.forEachIndexed { i, c ->
        c.forEachIndexed { j, value ->
            if(grid[i][j] == '1'){
                result+= dfs(grid, i, j)
            }
        }
    }
    return result
}
fun dfs(grid:Array<CharArray> ,i:Int,j:Int): Int{
    if(i < 0 || j <0 || i>= grid.size || j>= grid[0].size || grid[i][j] =='0'){
        return 0
    }
    grid[i][j] = '0'
    dfs(grid, i -1, j)
    dfs(grid, i + 1, j)
    dfs(grid, i, j-1)
    dfs(grid, i, j+1)
    return 1
}
//
//fun numIslands1(grid: Array<CharArray>): Int {
//    if (grid.isEmpty() || grid[0].isEmpty()) return 0
//
//    val m = grid.size; val n = grid[0].size
//    val dx = intArrayOf(1, -1, 0, 0)
//    val dy = intArrayOf(0, 0, 1, -1)
//
//    fun bfs(x: Int, y: Int) {
//        val q = ArrayDeque<IntArray>()
//
//        q.offer(intArrayOf(x, y))
//        grid[x][y] = '0'
//
//        while (!q.isEmpty()) {
//            val p = q.poll()
//
//            for (k in 0..3) {
//                val i = p[0] + dx[k]
//                val j = p[1] + dy[k]
//
//                if (i >= 0 && i < m && j >= 0 && j < n &&
//                    grid[i][j] == '1') {
//                    q.offer(intArrayOf(i, j))
//                    grid[i][j] = '0'
//                }
//            }
//        }
//    }
//
//    var cnt = 0
//
//    for (i in 0..m - 1) {
//        for (j in 0..n - 1) {
//            if (grid[i][j] == '1') {
//                bfs(i, j)
//                cnt++
//            }
//        }
//    }
//
//    return cnt
//}