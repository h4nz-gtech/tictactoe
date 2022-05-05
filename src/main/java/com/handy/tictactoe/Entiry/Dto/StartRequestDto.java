package com.handy.tictactoe.Entiry.Dto;

import lombok.Data;

public class StartRequestDto {
    private int boardSize;

    public StartRequestDto() {

    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    @Override
    public String toString() {
        return "StartDTO [boardSize=" + boardSize + "]";
    }
}
