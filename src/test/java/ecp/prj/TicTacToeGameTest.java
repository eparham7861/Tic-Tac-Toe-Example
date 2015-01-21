package ecp.prj;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class TicTacToeGameTest {
	
	private TicTacToeGame newGame;
	
	@Before
	public void StartUp() {
		newGame = new TicTacToeGame();
	}
	
	@Test
	public void testNewGame() {
		assertTrue(newGame.isNewGame());
	}
	
	@Test
	public void testMakeMove() {
		newGame.makeMove(0, 0);
		assertEquals(TicTacToeGame.gameLegend.X, newGame.getMarkAt(0, 0));
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testMakeMoveOutOfBounds() {
		newGame.makeMove(4, 5);
	}
	
	@Test
	public void testMakeSecondMoveO() {
		newGame.makeMove(0, 0);
		newGame.makeMove(0, 1);
		assertEquals(TicTacToeGame.gameLegend.X, newGame.getMarkAt(0, 0));
		assertEquals(TicTacToeGame.gameLegend.O, newGame.getMarkAt(0, 1));
	}
	
	@Test
	public void testNotNewGame() {
		newGame.makeMove(0, 0);
		assertFalse(newGame.isNewGame());
	}
	
	@Test
	public void testMakeMoveToTakenPosition() {
		newGame.makeMove(0, 0);
		newGame.makeMove(0, 0);
	}
	@Test
	public void testGetGameStatusWinX() {
		newGame.makeMove(0, 0);
		newGame.makeMove(1, 0);
		newGame.makeMove(0, 1);
		newGame.makeMove(2, 0);
		newGame.makeMove(0, 2);
		assertEquals(TicTacToeGame.gameLegend.XWIN, newGame.gameStatus());
	}
	
	@Test
	public void testGameStatusWinO() {
		newGame.makeMove(2, 2);
		newGame.makeMove(0, 0);
		newGame.makeMove(1, 0);
		newGame.makeMove(0, 1);
		newGame.makeMove(2, 0);
		newGame.makeMove(0, 2);
		assertEquals(TicTacToeGame.gameLegend.OWIN, newGame.gameStatus());
	}
	
	@Test
	public void testGameStatusDraw() {
		newGame.makeMove(0, 0);
		newGame.makeMove(0, 1);
		newGame.makeMove(0, 2);
		newGame.makeMove(1, 2);
		newGame.makeMove(1, 0);
		newGame.makeMove(1, 1);
		newGame.makeMove(2, 1);
		newGame.makeMove(2, 0);
		newGame.makeMove(2, 2);
		assertEquals(TicTacToeGame.gameLegend.DRAW, newGame.gameStatus());
	}
	
	@Test
	public void testGameStatusContinue() {
		newGame.makeMove(0, 0);
		assertEquals(TicTacToeGame.gameLegend.CONTINUE, newGame.gameStatus());
	}
	
	@Test
	public void testWinHoriztonalRowTwo() {
		newGame.makeMove(1, 0);
		newGame.makeMove(2, 0);
		newGame.makeMove(1, 1);
		newGame.makeMove(2, 1);
		newGame.makeMove(1, 2);
		assertEquals(TicTacToeGame.gameLegend.XWIN, newGame.gameStatus());
	}
	
	@Test
	public void testWinHoriztonalRowThree() {
		newGame.makeMove(2, 0);
		newGame.makeMove(0, 0);
		newGame.makeMove(2, 1);
		newGame.makeMove(0, 1);
		newGame.makeMove(2, 2);
		assertEquals(TicTacToeGame.gameLegend.XWIN, newGame.gameStatus());
	}
	
	@Test
	public void testWinVerticalColumnOne() {
		newGame.makeMove(0, 0);
		newGame.makeMove(2, 2);
		newGame.makeMove(1, 0);
		newGame.makeMove(2, 1);
		newGame.makeMove(2, 0);
		assertEquals(TicTacToeGame.gameLegend.XWIN, newGame.gameStatus());
	}
	
	@Test
	public void testWinVerticalColumnTwo() {
		newGame.makeMove(0, 1);
		newGame.makeMove(2, 2);
		newGame.makeMove(1, 1);
		newGame.makeMove(2, 0);
		newGame.makeMove(2, 1);
		assertEquals(TicTacToeGame.gameLegend.XWIN, newGame.gameStatus());
	}
	
	@Test
	public void testWinVerticalColumnThree() {
		newGame.makeMove(0, 2);
		newGame.makeMove(2, 0);
		newGame.makeMove(1, 2);
		newGame.makeMove(2, 1);
		newGame.makeMove(2, 2);
		assertEquals(TicTacToeGame.gameLegend.XWIN, newGame.gameStatus());
	}
	
	@Test
	public void testWinDiagonalOne() {
		newGame.makeMove(0, 0);
		newGame.makeMove(2, 0);
		newGame.makeMove(1, 1);
		newGame.makeMove(2, 1);
		newGame.makeMove(2, 2);
		assertEquals(TicTacToeGame.gameLegend.XWIN, newGame.gameStatus());
	}
	
	@Test
	public void testWindDiagonalTwo() {
		newGame.makeMove(0, 2);
		newGame.makeMove(2, 2);
		newGame.makeMove(1, 1);
		newGame.makeMove(2, 1);
		newGame.makeMove(2, 0);
		assertEquals(TicTacToeGame.gameLegend.XWIN, newGame.gameStatus());
	}
}