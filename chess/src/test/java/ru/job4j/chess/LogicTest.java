package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

public class LogicTest {

    @Ignore
    @Test
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test
    public void whenValidMovingFromA7ToF2()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.A7));
        logic.move(Cell.A7, Cell.F2);
    }

    @Test (expected = OccupiedCellException.class)
    public void whenPositionIsOccupiedMovingFromH7ToF2()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.A7));
        logic.add(new PawnBlack(Cell.C5));
        logic.move(Cell.A7, Cell.F2);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenIncorrectPathMovingFromH7ToF2()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.G3));
        logic.move(Cell.G3, Cell.A5);
    }

    @Test (expected = FigureNotFoundException.class)
    public void whenFigureIsAbsentMovingFromH7ToF2()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.G3));
        logic.move(Cell.A2, Cell.A5);
    }
}