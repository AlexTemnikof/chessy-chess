package models;

import common.Cell;

import static java.util.Objects.isNull;

/**
 * Лошадь
 */
public class Horse extends ChessFigure {
    public Horse(String color, Cell position) {
        super(color, position);
    }

    @Override
    public Cell[] steps(Cell dest) {
        if (isNull(dest) || dest.equals(getPos())) {
            return null;
        }
        int dX = Math.abs(dest.getX() - getPos().getX());
        int dY = Math.abs(dest.getY() - getPos().getY());
        return canMoveToPosition(dX, dY) ? new Cell[]{dest} : null;
    }

    @Override
    protected boolean canMoveToPosition(int dX, int dY) {
        return (dX == 2 && dY == 1) || (dX == 1 && dY == 2);
    }
}