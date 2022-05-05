package com.handy.tictactoe.Services;

import com.handy.tictactoe.Entiry.Dto.MoveRequestDto;
import com.handy.tictactoe.Entiry.Dto.StartRequestDto;
import com.handy.tictactoe.Entiry.Player;

public interface GameServices {

    Player startGame(StartRequestDto startRequestDto) throws Exception;
    Player move(MoveRequestDto moveRequestDto);
}
