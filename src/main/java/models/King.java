package models;

import common.Cell;

/**
 * Король
 */
public class King extends ChessFigure {
    public King(String color, Cell position) {
        super(color, position);
    }

    @Override
    protected boolean canMoveToPosition(int dX, int dY) {
        return Math.abs(dX) < 2 && Math.abs(dY) < 2;
    }
}