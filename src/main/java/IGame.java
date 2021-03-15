public interface IGame {

    char[][] init(int n);

    Status move(int x, int y, Player p, char[][] board, int[] RS, int CS[]);

    boolean isValidMove(int x, int y, int n, char[][] board);

    Status checkWining(char[][] board, Player lastPlayer, int n);

    public void print(char[][] board, int[] RS, int[] CS);
}
