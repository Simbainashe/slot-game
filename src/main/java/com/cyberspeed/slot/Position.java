package com.cyberspeed.slot;

public class Position {
    private final int rowIndex;
    private final int columnIndex;

    private Position(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public static Position of(int rowIndex, int columnIndex) {
        return new Position(rowIndex, columnIndex);
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    @Override
    public String toString() {
        return "Position{" +
                "rowIndex=" + rowIndex +
                ", columnIndex=" + columnIndex +
                '}';
    }
}
