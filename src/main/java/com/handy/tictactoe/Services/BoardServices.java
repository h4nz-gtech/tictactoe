package com.handy.tictactoe.Services;

import com.handy.tictactoe.Entiry.Board;

import java.util.List;

public interface BoardServices {
    List<List<String>> configureBoardCells(Integer boardSize);
    List<String> getHorizontalBoardValue(Board board,int boardSize,int x,int y);
    List<String> getVerticalBoardValue(Board board,int boardSize,int x,int y);
}
