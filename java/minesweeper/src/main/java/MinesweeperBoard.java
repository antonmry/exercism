import java.util.ArrayList;
import java.util.List;

public class MinesweeperBoard {
    char[][] board;

    public MinesweeperBoard(List<String> inputBoard) {
        if (inputBoard.size() > 0) {
            board = new char[inputBoard.size()][inputBoard.get(0).length()];
        } else {
            board = new char[inputBoard.size()][0];
        }
        for (int i = 0; i < inputBoard.size(); i++) {
            for (int j = 0; j < inputBoard.get(0).length(); j++) {
                board[i][j] = inputBoard.get(i).charAt(j);
            }
        }
    }

    boolean isBomb(int x, int y) {
        if (y > board.length - 1 || y < 0) return false;
        if (x > board[y].length - 1 || x < 0) return false;
        return board[y][x] == '*';
    }

    char calculateCell(int x, int y) {
        if (board[y][x] == '*') return board[y][x];

        int hint = 0;
        for (int a = -1; a < 2; a++) {
            for (int b = -1; b < 2; b++) {
                if (isBomb(x + b, y + a)) hint++;
            }
        }

        if (hint == 0) return board[y][x];
        return String.valueOf(hint).charAt(0);
    }

    public List<String> withNumbers() {

        List<String> result = new ArrayList<>();

        for (int y = 0; y < board.length; y++) {
            char[] line = new char[board[y].length];
            for (int x = 0; x < board[y].length; x++) {
                line[x] = calculateCell(x, y);
            }
            result.add(String.valueOf(line));
        }

        return result;
    }

}

