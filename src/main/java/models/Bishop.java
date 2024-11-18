package models;

import common.Cell;

/**
 * Слон
 */
public class Bishop extends ChessFigure {
    public Bishop(String color, Cell position) {
        super(color, position);
    }

    @Override
    protected boolean canMoveToPosition(int dX, int dY) {
        return Math.abs(dX) == Math.abs(dY);
    }
}