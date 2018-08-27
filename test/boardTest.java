import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class boardTest {

    private board Board;

    @Before
    public void setUp() throws Exception {
        Board = new board(100,100);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testInitGame() {
//        Board = new board(10,10);
        Board.setCell(true,3,1);
        Board.setCell(true,1,2);
        Board.setCell(true,3,2);
        Board.setCell(true,3,3);
        Board.setCell(true,2,3);
        for(int i = 0; i < 30; i++){
            Board.changeGen();
        }
        Board.printBoard();
//        Board.printBoard();
//        Board.printN();
//        System.out.println();
//        Board.changeGen();
//        Board.printBoard();
//        Board.printN();
//        System.out.println();
//        Board.changeGen();
//        Board.printBoard();
//        Board.printN();
    }
}