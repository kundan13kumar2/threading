public class PlayGame implements IGame {

    @Override
    public char[][] init(int n) {
        return new char[n][n];
    }

    @Override
    public Status move(int x, int y, Player p, char[][] board, int[] RS, int[] CS) {

        //if (isValidMove(x - 1, y - 1, board.length, board)) {
        board[x - 1][y - 1] = p.getSign();
        RS[x - 1] += p.getSign() == 'X' ? 1 : -1;
        CS[y - 1] += p.getSign() == 'X' ? 1 : -1;

        if (Math.abs(RS[x - 1]) == board.length || Math.abs(CS[y - 1]) == board.length) {
            System.out.println(p.getPlayerId() + " is Winner");
            return Status.WIN;
        }
//        } else {
//            return Status.INVALID;
//        }
        return Status.DRAW;
    }

    @Override
    public boolean isValidMove(int x, int y, int n, char[][] board) {
        if (x >= 0 && x < n && y >= 0 && y < n && board[x][y] == ' ')
            return true;
        return false;
    }

    @Override
    public void print(char[][] board, int[] RS, int[] CS) {

        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(board[i][j]);
            System.out.println();
        }
        for (int i = 0; i < 3; i++)
            System.out.print(RS[i]);
        System.out.println();

        for (int i = 0; i < 3; i++)
            System.out.print(CS[i]);
        System.out.println();
    }

    @Override
    public Status checkWining(char[][] board, Player lastPlayer, int n) {
        /**
         * check ALL Columns O(n2)
         * Check ALL Rows O(n2)
         * Check both diagonal O(n)
         *
         * O(n2)
         */
        return null;
    }
}
/**
 * X X X   RS[3,0,1]  :n+n
 * 0   0   CS[2,1,1]
 * X   0
 * <p>
 * P1 > 1,2 X
 * P2 > 2,2 0
 * P1 > 2,3 X
 * <p>
 * X ->  1
 * 0 -> -1
 * 1,2
 * <p>
 * _ X _   RS:[1,0,0] CS:[0,1,0]
 * <p>
 * _ 0 _   CS[0,1,0]
 * <p>
 * _ _ _
 */
