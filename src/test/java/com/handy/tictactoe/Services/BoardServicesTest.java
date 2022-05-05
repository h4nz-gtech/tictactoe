package com.handy.tictactoe.Services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BoardServicesTest {

    @InjectMocks
    BoardServices services = new BoardServicesImpl();


    @Test
    void configureBoardCells_Success() {
        Integer boardSize = 3;
        List<List<String>> expectedResult = new ArrayList<>();
        List<String> row = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            row.add("");
        }
        for (int i = 0; i < 3; i++) {
            expectedResult.add(row);
        }

        List<List<String>> result = services.configureBoardCells(boardSize);

        assertEquals(expectedResult,result);
    }

}
