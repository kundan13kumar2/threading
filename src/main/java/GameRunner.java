import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
        Player p1 = new Player("P1", 'X');
        Player p2 = new Player("P2", '0');

        IGame game = new PlayGame();
        System.out.println("Enter board Size: ");
        Scanner scanner = new Scanner(System.in);
        int counter = 0;

        char[][] board = game.init(3);
        int[] RS = new int[3];
        int[] CS = new int[3];

        Status status = game.move(1, 1, p1, board, RS, CS);
        if (status.equals(Status.WIN)) {
            System.out.println(p1 + " wins");
        }
        game.print(board, RS, CS);

        status = game.move(1, 2, p1, board, RS, CS);
        if (status.equals(Status.WIN)) {
            System.out.println(p2 + " wins");
        }
        game.print(board, RS, CS);

        status = game.move(1, 3, p1, board, RS, CS);
        if (status.equals(Status.WIN)) {
            System.out.println(p1 + " wins");
            return;
        }
        game.print(board, RS, CS);


        status = game.move(2, 1, p2, board, RS, CS);
        if (status.equals(Status.WIN)) {
            System.out.println(p2 + " wins");
        }
        game.print(board, RS, CS);

        status = game.move(2, 2, p1, board, RS, CS);
        if (status.equals(Status.WIN)) {
            System.out.println(p1 + " wins");
        }
        game.print(board, RS, CS);
        // status = game.move(1, 2, p1, board, RS, CS);


    }
}
