package com.handy.tictactoe.Entiry.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MoveRequestDto {
    int x;
    int y;
}
