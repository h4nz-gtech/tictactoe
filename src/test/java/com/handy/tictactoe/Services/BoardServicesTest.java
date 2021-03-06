package com.handy.tictactoe.Services;

import com.handy.tictactoe.Common.Constants;
import com.handy.tictactoe.Entiry.Board;
import com.handy.tictactoe.Entiry.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BoardServicesTest {

    @InjectMocks
    BoardServices services = new BoardServicesImpl();


    @Test
    void configureBoardCells_Success() {
        Integer boardSize = 3;
        List<List<String>> expectedResult = new ArrayList<>();
        List<String> row = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            row.add("");
        }
        for (int i = 0; i < 3; i++) {
            expectedResult.add(row);
        }

        List<List<String>> result = services.configureBoardCells(boardSize);

        assertEquals(expectedResult,result);
    }

    @Test
    void getHorizontalBoardValue_Success() {
        int boardSize = 3;
        int x = 2;
        int y=1;
        List<List<String>> cells = new ArrayList<>();
        List<String> row = new ArrayList<>();
        List<String> row2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            row.add("");
        }

        for (int i = 0; i < 3; i++) {
            row2.add(Constants.X_CURRENT_PLAYER);
        }

        for (int i = 0; i < 3; i++) {
            if (i == x){
                cells.add(row2);
            }else{
                cells.add(row);
            }
        }
        Board board = Board.builder().cells(cells).build();
        List<String> expectedResult = board.getCells().get(x);

        List<String> result = services.getHorizontalBoardValue(board,boardSize,x,y);

        assertEquals(expectedResult,result);
    }

    @Test
    void getVerticalBoardValue_Success() {
        int boardSize = 3;
        int x = 2;
        int y=2;
        List<List<String>> cells = new ArrayList<>();
        List<String> row = new ArrayList<>();
        List<String> row2 = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            row.add("");
        }

        row2.add(Constants.X_CURRENT_PLAYER);
        row2.add("");
        row2.add("");

        for (int i = 0; i < 2; i++) {
            cells.add(row);
        }
        cells.add(row2);

        Board board = Board.builder().cells(cells).build();
        List<String> expectedResult = new ArrayList<>();
        for (int i = 0;i<3;i++){
            expectedResult.add(Constants.X_CURRENT_PLAYER);
        }

        System.out.println(board);
        List<String> result = services.getVerticalBoardValue(board,boardSize,x,y);
    }


    @Test
    void getDiagonalBoardValue_Success() {
        int boardSize = 3;
        int x = 2;
        int y=1;
        List<List<String>> cells = new ArrayList<>();
        List<String> row = new ArrayList<>();
        List<String> row2 = new ArrayList<>();
        List<String> row3 = new ArrayList<>();

        row.add(Constants.X_CURRENT_PLAYER);
        row.add("");
        row.add("");
        cells.add(row);

        row2.add("");
        row2.add(Constants.X_CURRENT_PLAYER);
        row2.add("");
        cells.add(row2);

        row3.add("");
        row3.add("");
        row3.add(Constants.X_CURRENT_PLAYER);
        cells.add(row3);

        Board board = Board.builder().cells(cells).build();
        List<String> expectedResult = new ArrayList<>();
        for (int i = 0;i<3;i++){
            expectedResult.add(Constants.X_CURRENT_PLAYER);
        }

        List<String> result = services.getDiagonalBoardValue(board,boardSize);

        assertEquals(expectedResult,result);
    }

}
