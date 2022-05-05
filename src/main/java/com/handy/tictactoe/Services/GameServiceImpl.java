package com.handy.tictactoe.Services;

import com.handy.tictactoe.Common.Constants;
import com.handy.tictactoe.Entiry.Board;
import com.handy.tictactoe.Entiry.Dto.StartRequestDto;
import com.handy.tictactoe.Entiry.Player;
import org.springframework.beans.factory.annotation.Autowired;

public class GameServiceImpl implements GameServices {

    private Player player;

    @Autowired
    BoardServices boardServices;

    @Override
    public Player startGame(StartRequestDto startRequestDto) throws Exception {
        this.player = new Player();
        try {
            player.setBoard(configureBoardStartGame(startRequestDto.getBoardSize()));
        }catch (Exception e){
            throw new Exception(Constants.GENERAL_ERROR_MESSAGE);
        }

        return player;
    }


    private Board configureBoardStartGame(Integer boardSize){
        Board board =Board.builder()
                .cells(boardServices.configureBoardCells(boardSize))
                .build();
        return board;
    }
}
