package gol;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellGridTest {

    @Test
    void testGetAliveNeighboursCount_case1() {
        CellGrid grid = new CellGrid(3,3);
        grid.setCellState(1,1,true);
        int actual = grid.getAliveNeighboursCount(1,1);
        int expected = 0;
        assertEquals(expected, actual);
    }
    @Test
    void testGetAliveNeighboursCount_case2() {
        CellGrid grid = new CellGrid(3,3);
        grid.setCellState(1,1,false);
        int actual = grid.getAliveNeighboursCount(1,1);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void testGetAliveNeighboursCount_case3() {
        CellGrid grid = new CellGrid(3,3);
        grid.setCellState(1,1,true);
        grid.setCellState(0,0,true);
        grid.setCellState(0,2,true);
        grid.setCellState(2,1,true);
        int actual = grid.getAliveNeighboursCount(1,1);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    void testGetAliveNeighboursCount_case4() {
        CellGrid grid = new CellGrid(3,3);
        int actual = grid.getAliveNeighboursCount(0,0);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void testGetAliveNeighboursCount_case5() {
        CellGrid grid = new CellGrid(3,3);
        grid.setCellState(0,1,true);
        grid.setCellState(1,0,true);
        grid.setCellState(1,1,true);
        int actual = grid.getAliveNeighboursCount(0,0);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    void testGetAliveNeighboursCount_case6() {
        CellGrid grid = new CellGrid(3,3);
        grid.setCellState(1,1,true);
        int actual = grid.getAliveNeighboursCount(0,2);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void testGetAliveNeighboursCount_case7() {
        CellGrid grid = new CellGrid(3,3);
        grid.setCellState(1,1,true);
        int actual = grid.getAliveNeighboursCount(2,2);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void testGetAliveNeighboursCount_case8() {
        CellGrid grid = new CellGrid(3,3);
        grid.setCellState(1,1,true);
        int actual = grid.getAliveNeighboursCount(2,0);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void testGetAliveNeighboursCount_case9() {
        CellGrid grid = new CellGrid(3,3);
        grid.setCellState(0,0,true);
        grid.setCellState(0,1,true);
        grid.setCellState(0,2,true);
        grid.setCellState(1,1,true);
        grid.setCellState(1,2,true);
        grid.setCellState(2,0,true);
        grid.setCellState(2,1,true);
        grid.setCellState(2,2,true);
        int actual = grid.getAliveNeighboursCount(1,0);
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void testGetAliveNeighboursCount_case10() {
        CellGrid grid = new CellGrid(3,3);
        grid.setCellState(0,0,true);
        grid.setCellState(0,1,true);
        grid.setCellState(0,2,true);
        grid.setCellState(1,0,true);
        grid.setCellState(1,2,true);
        grid.setCellState(2,0,true);
        grid.setCellState(2,1,true);
        grid.setCellState(2,2,true);
        int actual = grid.getAliveNeighboursCount(1,1);
        int expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    void testGetAliveNeighboursCount_case11() {
        CellGrid grid = new CellGrid(3,3);
        grid.setCellState(0,0,true);
        grid.setCellState(0,1,true);
        grid.setCellState(0,2,true);
        grid.setCellState(1,0,true);
        grid.setCellState(1,1,true);
        grid.setCellState(2,0,true);
        grid.setCellState(2,1,true);
        grid.setCellState(2,2,true);
        int actual = grid.getAliveNeighboursCount(1,2);
        int expected = 5;
        assertEquals(expected, actual);
    }
}