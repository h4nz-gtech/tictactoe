package com.handy.tictactoe.Entiry;

import lombok.Data;

@Data
public class Player {
    private Board board;
    private Integer boardSize;
    private String currentPlayer;
    private String winner;
    private boolean finish = false;
}
