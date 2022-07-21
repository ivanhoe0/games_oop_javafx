package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;


import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void whenA1position() {
        BishopBlack bishop = new BishopBlack(Cell.A1);
        assertTrue(bishop.position().equals(Cell.A1)
        );
    }

    @Test
    public void whenD7position() {
        BishopBlack bishop = new BishopBlack(Cell.D7);
        assertTrue(bishop.position().equals(Cell.D7)
        );
    }

    @Test
    public void whenCopyToC3() {
        BishopBlack bishop = new BishopBlack(Cell.D8);
        BishopBlack copiedBishop = (BishopBlack) bishop.copy(Cell.C7);
        assertTrue(copiedBishop.position().equals(Cell.C7)
        );
    }

    @Test
    public void whenWayFromC1ToG5() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] returned = new Cell[bishop.way(Cell.G5).length];
        for (int i = 0; i < returned.length; i++) {
            returned[i] = bishop.way(Cell.G5)[i];
        }
        Cell[] expected = {
                Cell.D2, Cell.E3, Cell.F4, Cell.G5
        };
        assertArrayEquals(expected, returned);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenWayIsNotDiagonal() {
        new BishopBlack(Cell.B2).way(Cell.G5);
    }
}
