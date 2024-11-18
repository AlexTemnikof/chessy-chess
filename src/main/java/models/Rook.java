package models;

import common.Cell;

/**
 * Ладья
 */
public class Rook extends ChessFigure {
    public Rook(String color, Cell position) {
        super(color, position);
    }

    @Override
    protected boolean canMoveToPosition(int dX, int dY) {
        return dX == 0 || dY == 0;
    }
}