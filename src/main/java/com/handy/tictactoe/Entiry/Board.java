package com.handy.tictactoe.Entiry;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Board {
    private List<List<String>> cells;
}
