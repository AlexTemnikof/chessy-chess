import common.Cell;
import common.ChessBoard;

import java.util.Scanner;

import static models.ChessFigure.WHITE_COLOR;

public class ChessyChessApp {

    public static void main(String[] args) {
        String help = """
                'help' - список команд
                'exit' - завершить игру
                'restart' - перезапустить игру
                'castling H1' - рокировка с ладьей на H1
                'A1 B2' - передвижение фигуры с позиции A1 на B2
                """;
        System.out.println(help);

        ChessBoard board = new ChessBoard(WHITE_COLOR);
        Scanner scanner = new Scanner(System.in);
        boolean isRun = true;
        boolean isCheck;
        while (isRun) {
            isCheck = false;
            board.printBoard();
            System.out.print("Ход " + (board.nowPlayerColor().equals(WHITE_COLOR) ? "белых" : "черных") + ": ");
            String command = scanner.nextLine();
            try {
                String[] commands = command.split(" ");
                switch (commands[0]) {
                    case "help" -> System.out.println(help);
                    case "exit" -> isRun = false;
                    case "restart" -> board = new ChessBoard(WHITE_COLOR);
                    case "castling" -> isCheck = board.castling(Cell.of(commands[1].toUpperCase()));
                    default -> {
                        if (commands.length == 2) {
                            isCheck = board.moveToPosition(Cell.of(commands[0].toUpperCase()), Cell.of(commands[1].toUpperCase()));
                        } else {
                            throw new IllegalArgumentException("Неверная команда");
                        }
                    }
                }
                if (isCheck) {
                    System.out.println("Шах!");
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}