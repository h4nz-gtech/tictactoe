package com.handy.tictactoe.Controller;

import com.handy.tictactoe.Entiry.Dto.MoveRequestDto;
import com.handy.tictactoe.Entiry.Dto.StartRequestDto;
import com.handy.tictactoe.Entiry.Player;
import com.handy.tictactoe.Services.GameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    GameServices services;


    @PostMapping(value = "/start")
    public Player startGame(@RequestBody StartRequestDto input) throws Exception {
        return services.startGame(input);
    }

    @PutMapping(value = "/move")
    public Player move(@RequestBody MoveRequestDto input) {
        return services.move(input);
    }

    @GetMapping
    public Player getGame() throws Exception {
        StartRequestDto startRequestDto = new StartRequestDto();
        startRequestDto.setBoardSize(3);
        return services.startGame(startRequestDto);
    }
}
