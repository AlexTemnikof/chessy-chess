package models;

import common.Cell;

/**
 * Ферзь
 */
public class Queen extends ChessFigure {
    public Queen(String color, Cell position) {
        super(color, position);
    }

    @Override
    public boolean canMoveToPosition(int dX, int dY) {
        return (dX == 0 || dY == 0) || Math.abs(dX) == Math.abs(dY);
    }
}