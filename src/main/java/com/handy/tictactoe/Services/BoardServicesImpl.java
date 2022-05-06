package com.handy.tictactoe.Services;


import com.handy.tictactoe.Entiry.Board;

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

    @Override
    public List<String> getHorizontalBoardValue(Board board, int boardSize, int x, int y) {
        List<String> result = new ArrayList<>();

        List<List<String>> cell = board.getCells();
        List<String> row = cell.get(x);

        for (String val : row){
            result.add((val.isBlank() || val.isEmpty() ? "-" :val ));
        }

        return result;
    }

    @Override
    public List<String> getVerticalBoardValue(Board board,int boardSize, int x, int y) {
        List<String> result = new ArrayList<>();
        List<String> row = new ArrayList<>();
        String val ;

        List<List<String>> cell = board.getCells();

        for (int i=0; i<boardSize; i++){
            row = cell.get(x);
            for (int j = 0 ; j<row.size();j++){
                if(j==y){
                    val=row.get(y);
                    result.add((val.isBlank() || val.isEmpty() ? "-" :val));
                }
            }
        }
        return result;
    }
}
