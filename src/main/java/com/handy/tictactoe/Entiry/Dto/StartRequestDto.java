package com.handy.tictactoe.Entiry.Dto;

import lombok.Builder;

@Builder
public class StartRequestDto {
    private int boardSize;


    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }
}
