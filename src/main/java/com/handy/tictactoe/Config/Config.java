package com.handy.tictactoe.Config;

import com.handy.tictactoe.Services.BoardServices;
import com.handy.tictactoe.Services.BoardServicesImpl;
import com.handy.tictactoe.Services.GameServiceImpl;
import com.handy.tictactoe.Services.GameServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public BoardServices boardServices (){return new BoardServicesImpl();}

    @Bean
    public GameServices services(){return new GameServiceImpl();}


}
