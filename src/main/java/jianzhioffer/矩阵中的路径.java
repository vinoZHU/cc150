package jianzhioffer;

/**
 * Created by vino on 2017/8/8.
 *
 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class 矩阵中的路径 {

    public static void main(String[] args) {
        char[] matrix = "ABCESFCSADEE".toCharArray();
        int rows = 3;
        int cols = 4;
        char[] str = "ABCB".toCharArray();
        System.out.println(new 矩阵中的路径().hasPath(matrix, rows, cols, str));
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols && !visited[i][j]; j++) {
                if (bfs(matrix, rows, cols, i, j, str, 0, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean bfs(char[] matrix, int rows, int cols, int x, int y, char[] str, int index, boolean[][] visited) {
        int position = x * cols + y;
        if( x < 0 || x >= rows || y < 0 || y >= cols || matrix[position] != str[index] || visited[x][y])
            return false;
        if (index == str.length - 1)
            return true;
        visited[x][y] = true;
        if (bfs(matrix, rows, cols, x + 1, y, str, index + 1, visited)
                || bfs(matrix, rows, cols, x, y + 1, str, index + 1, visited)
                || bfs(matrix, rows, cols, x - 1, y, str, index + 1, visited)
                || bfs(matrix, rows, cols, x, y - 1, str, index + 1, visited)) {
            return true;
        }
        visited[x][y] = false;
        return false;


    }
}
