package common;

import java.util.Objects;

import static java.util.Objects.nonNull;

public class Cell {
    private static final String HORIZONTAL_SYMBOLS = "ABCDEFGH";
    private static final String VERTICAL_SYMBOLS = "12345678";
    private static final int X_SHIFT = 65;
    private static final int Y_SHIFT = 8;
    private final int x;
    private final int y;

    public Cell(int x, int y) {
        if (!isCell(x, y)) {
            throw new RuntimeException("Некорректные координаты клетки " + x + " " + y);
        }
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Cell of(String cell) {
        if (!isCell(cell)) {
            throw new RuntimeException("Некорректная клетка " + cell);
        }
        return new Cell(cell.charAt(0) - X_SHIFT, Y_SHIFT - Integer.parseInt(cell.substring(1)));
    }

    public static boolean isCell(String cell) {
        return nonNull(cell)
                && cell.length() == 2
                && HORIZONTAL_SYMBOLS.contains(cell.substring(0, 1))
                && VERTICAL_SYMBOLS.contains(cell.substring(1));
    }

    public static boolean isCell(int x, int y) {
        return x >= 0 && x <= 7 && y >= 0 && y <= 7;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x && y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return String.valueOf((char) (x + X_SHIFT)) + (Y_SHIFT - y);
    }
}
