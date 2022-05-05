package com.handy.tictactoe.Services;


import java.util.ArrayList;
import java.util.List;

public class BoardServicesImpl implements BoardServices {

    @Override
    public List<List<String>> configureBoardCells(Integer boardSize) {
        List<List<String>> cells;

        cells = new ArrayList<>();
        for (int i = 0; i < boardSize; i++) {
            List<String> row = new ArrayList<>();
            cells.add(row);

            for (int j = 0; j < boardSize; j++) {
                row.add("");
            }
        }
        return cells;
    }
}
