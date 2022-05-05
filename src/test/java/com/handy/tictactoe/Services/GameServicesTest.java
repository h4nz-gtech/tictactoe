package com.handy.tictactoe.Services;

import com.handy.tictactoe.Entiry.Board;
import com.handy.tictactoe.Entiry.Dto.StartRequestDto;
import com.handy.tictactoe.Entiry.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class GameServicesTest {

    @Mock
    BoardServices boardServices;

    @InjectMocks
    GameServices services = new GameServiceImpl();


    @Test
    void startGame_Success() throws Exception {
        StartRequestDto requestDto = StartRequestDto.builder()
                .boardSize(3)
                .build();
        List<List<String>> cells = new ArrayList<>();
        List<String> row = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            row.add("");
        }
        for (int i = 0; i < 3; i++) {
            cells.add(row);
        }
        Board board = Board.builder().cells(cells).build();
        Player expectedResult = new Player();
        expectedResult.setBoard(board);

        Mockito.when(boardServices.configureBoardCells(requestDto.getBoardSize())).thenReturn(cells);
        Player result = services.startGame(requestDto);

        assertEquals(expectedResult,result);
    }
}
