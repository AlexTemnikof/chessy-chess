package models;

import common.Cell;

import java.util.Objects;

import static java.util.Objects.isNull;

/**
 * Фигура
 */
public abstract class ChessFigure {
    public static final String PAWN_FIGURE = "P";
    public static final String WHITE_COLOR = "White";
    public static final String BLACK_COLOR = "Black";
    private final String color;
    private Cell pos;
    private boolean isFirstPos = true;

    protected ChessFigure(String color, Cell pos) {
        this.color = color;
        this.pos = pos;
    }

    public String getSymbol() {
        return this.getClass().getSimpleName().substring(0, 1);
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return getSymbol() + getColor().charAt(0);
    }

    public void setPos(Cell pos) {
        isFirstPos = false;
        this.pos = pos;
    }

    public Cell getPos() {
        return pos;
    }

    public boolean isFirstPos() {
        return isFirstPos;
    }

    /**
     * Возвращает массив клеток на пути движения фигуры
     *
     * @param dest конечная клетка
     * @return null, при неверном движении фигуры
     */
    public Cell[] steps(Cell dest) {
        if (isNull(dest) || dest.equals(getPos())) {
            return null;
        }

        int dX = getPos().getX() - dest.getX();
        int dY = getPos().getY() - dest.getY();

        if (!canMoveToPosition(dX, dY)) {
            return null;
        }

        int directionX = dX != 0 ? (dX > 0 ? 1 : -1) : 0;
        int directionY = dY != 0 ? (dY > 0 ? 1 : -1) : 0;
        int size = Math.max(Math.abs(dX), Math.abs(dY));
        Cell[] steps = new Cell[size];
        for (int i = 1; i <= steps.length; i++) {
            steps[i - 1] = new Cell(getPos().getX() - i * directionX, getPos().getY() - i * directionY);
        }
        return steps;
    }

    protected abstract boolean canMoveToPosition(int dX, int dY);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessFigure that = (ChessFigure) o;
        return Objects.equals(color, that.color) && Objects.equals(pos, that.pos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, pos);
    }

    @Override
    public String toString() {
        return getName();
    }
}