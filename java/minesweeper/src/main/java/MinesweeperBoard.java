import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinesweeperBoard {
    char[][] board;

    public MinesweeperBoard(List<String> inputBoard) {
        this.board = inputBoard.stream()
                .map(s -> s.toCharArray())
                .toArray(char[][]::new);
    }

    public List<String> withNumbers() {

        return IntStream.range(0, board.length)
                .mapToObj(y -> IntStream.range(0, board[y].length)
                        .mapToObj(x -> calculateCell(x, y))
                        .collect(StringBuilder::new,
                                StringBuilder::append,
                                StringBuilder::append)
                        .toString())
                .collect(Collectors.toList());
    }

    char calculateCell(int x, int y) {
        if (board[y][x] == '*') return board[y][x];

        int hint = 0;
        for (int i = -1; i < 2; i++)
            for (int j = -1; j < 2; j++)
                if (isBomb(x + j, y + i)) hint++;

        if (hint == 0) return board[y][x];
        return String.valueOf(hint).charAt(0);
    }

    boolean isBomb(int x, int y) {
        if (y > board.length - 1 || y < 0) return false;
        if (x > board[y].length - 1 || x < 0) return false;
        return board[y][x] == '*';
    }

}

