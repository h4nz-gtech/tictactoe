package com.handy.tictactoe.Services;

import com.handy.tictactoe.Common.Constants;
import com.handy.tictactoe.Entiry.Board;
import com.handy.tictactoe.Entiry.Dto.MoveRequestDto;
import com.handy.tictactoe.Entiry.Dto.StartRequestDto;
import com.handy.tictactoe.Entiry.Player;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class GameServicesTest {

    @Mock
    BoardServices boardServices;

    @InjectMocks
    GameServices services = new GameServiceImpl();

    @Mock
    private Player player;

    @Before
    void setUpMock(){
        player = mock(Player.class);
    }

    @Test
    void startGame_Success() throws Exception {
        StartRequestDto requestDto = new StartRequestDto();
        requestDto.setBoardSize(3);

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
        expectedResult.setCurrentPlayer(Constants.O_CURRENT_PLAYER);
        expectedResult.setBoardSize(requestDto.getBoardSize());

        Mockito.when(boardServices.configureBoardCells(requestDto.getBoardSize())).thenReturn(cells);
        Player result = services.startGame(requestDto);

        assertEquals(expectedResult,result);
    }

    @Test
    void moveGame_Success() throws Exception {

        MoveRequestDto moveRequestDto = MoveRequestDto.builder()
                .x(1)
                .y(1)
                .build();

        StartRequestDto requestDto = new StartRequestDto();
        requestDto.setBoardSize(3);

        List<List<String>> cells = new ArrayList<>();
        List<String> row = new ArrayList<>();
        List<String> row2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            row.add("");
        }

        for (int i = 0; i < 3; i++) {
            if (i == 1){
                row2.add(Constants.X_CURRENT_PLAYER);
            }else{
                row2.add("");
            }
        }

        for (int i = 0; i < 3; i++) {
            if (i == 1){
                cells.add(row2);
            }else{
                cells.add(row);
            }
        }
        Board board = Board.builder().cells(cells).build();
        Player expectedResult = new Player();
        expectedResult.setBoard(board);

        lenient().when(player.getCurrentPlayer()).thenReturn(Constants.X_CURRENT_PLAYER);
        Mockito.when(player.getBoard()).thenReturn(board);
        Player result = services.move(moveRequestDto);

        assertEquals(expectedResult.getBoard(),result.getBoard());
    }

    @Test
    void moveGame_HorizontalWinner_Success() throws Exception {

        MoveRequestDto moveRequestDto = MoveRequestDto.builder()
                .x(0)
                .y(0)
                .build();

        StartRequestDto requestDto = new StartRequestDto();
        requestDto.setBoardSize(3);

        List<List<String>> cells = new ArrayList<>();
        List<String> row = new ArrayList<>();
        List<String> row2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            row2.add("");
        }

        row.add(Constants.X_CURRENT_PLAYER);
        row.add("-");
        row.add("-");

        for (int i = 0; i < 3; i++) {
            if (i == 0){
                cells.add(row2);
            }else{
                cells.add(row);
            }
        }

        Board board = Board.builder().cells(cells).build();
        Player expectedResult = new Player();

        expectedResult.setBoard(board);
//
        lenient().when(player.getCurrentPlayer()).thenReturn(Constants.X_CURRENT_PLAYER);
        lenient().when(player.getBoardSize()).thenReturn(requestDto.getBoardSize());
        Mockito.when(boardServices.getHorizontalBoardValue(board,requestDto.getBoardSize(),moveRequestDto.getX(),moveRequestDto.getY())).thenReturn(board.getCells().get(1));
        Mockito.when(player.getBoard()).thenReturn(board);
        Player result = services.move(moveRequestDto);
    }
}
