package ui;

import common.Cell;

import java.util.Arrays;

public class ConsoleView {
    private Log[] logs = new Log[100];
    private int size;

    public void add(String figureName, Cell from, Cell to, String captured) {
        logs[size++] = new Log(figureName, from, to, captured);
        if (size == logs.length) {
            logs = Arrays.copyOf(logs, logs.length + 100);
        }
    }

    public Cell getLastDestCell() {
        return size != 0 ? logs[size - 1].to : null;
    }

    public String[] getLastLogs(int deep) {
        String[] logs = new String[deep];
        for (int i = 0; i < deep; i++) {
            logs[deep - 1 - i] = i < size ? logs[deep - 1 - i] = this.logs[size - 1 - i].toString() : "";
        }
        return logs;
    }

    private static class Log {
        private final String figure;
        private final Cell from;
        private final Cell to;
        private final String captured;

        public Log(String figure, Cell from, Cell to, String captured) {
            this.figure = figure;
            this.from = from;
            this.to = to;
            this.captured = captured;
        }

        @Override
        public String toString() {
            return figure + " " + from + " -> " + to + (captured != null ? " x " + captured : "");
        }
    }
}
