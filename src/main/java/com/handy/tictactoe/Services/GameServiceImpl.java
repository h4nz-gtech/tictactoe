package com.handy.tictactoe.Services;

import com.handy.tictactoe.Common.Constants;
import com.handy.tictactoe.Entiry.Board;
import com.handy.tictactoe.Entiry.Dto.MoveRequestDto;
import com.handy.tictactoe.Entiry.Dto.StartRequestDto;
import com.handy.tictactoe.Entiry.Player;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GameServiceImpl implements GameServices {

    private Player player;

    @Autowired
    BoardServices boardServices;

    @Override
    public Player startGame(StartRequestDto startRequestDto) throws Exception {
        this.player = new Player();
        this.player.setCurrentPlayer(Constants.O_CURRENT_PLAYER);

        try {
            player.setBoard(configureBoardStartGame(startRequestDto.getBoardSize()));
        }catch (Exception e){
            throw new Exception(Constants.GENERAL_ERROR_MESSAGE);
        }

        return player;
    }

    @Override
    public Player move(MoveRequestDto moveRequestDto) {
        changePlayer();
        player.setBoard(playerMove(moveRequestDto.getX(),moveRequestDto.getY()));
        return player;
    }


    private Board configureBoardStartGame(Integer boardSize){
        Board board =Board.builder()
                .cells(boardServices.configureBoardCells(boardSize))
                .build();
        return board;
    }

    private Board playerMove(int x, int y){

        Board board = player.getBoard();
        List<List<String>> cell = board.getCells();
        List<String> row = cell.get(x);
        if(row.get(y).toString().isEmpty() || row.get(y).toString().isBlank() ) {
            row.set(y,player.getCurrentPlayer());
        }
        return board;
    }

    private void changePlayer() {
        if (player.getCurrentPlayer().equals(Constants.O_CURRENT_PLAYER)) {
            player.setCurrentPlayer(Constants.X_CURRENT_PLAYER);
        } else {
            player.setCurrentPlayer(Constants.O_CURRENT_PLAYER);
        }

    }

    private Boolean checkWinner(){

        return false;
    }
}
