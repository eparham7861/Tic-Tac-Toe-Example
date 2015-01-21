package ecp.prj;

public class TicTacToeGame {

	public enum gameLegend{X, O, XWIN, OWIN, DRAW, EMPTY, CONTINUE};
	private gameLegend[][] gameBoard;
	private int rows, columns;
	private boolean xTurn;
	
	public TicTacToeGame() {
		rows = 3;
		columns = 3;
		gameBoard = new gameLegend[rows][columns];
		startNewGame();
		xTurn = true;
	}
	
	private void startNewGame() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				gameBoard[i][j] = gameLegend.EMPTY;
			}
		}
	}
	
	public boolean isNewGame() {
		boolean newGame = true;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (gameBoard[i][j] != gameLegend.EMPTY) {
					newGame = false;
				}
			}
		}
		return newGame;
	}
	
	public void makeMove(int row, int column) {
		if(row < 3 && column < 3) {
			if (positionIsEmpty(row, column)) {
				setMark(row, column);
				changeTurn();
			}
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	private boolean positionIsEmpty(int row, int column) {
		if (gameBoard[row][column] == gameLegend.EMPTY) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private void setMark(int row, int column) {
		if (xTurn) {
			gameBoard[row][column] = gameLegend.X;
		}
		else {
			gameBoard[row][column] = gameLegend.O;
		}
	}
	private void changeTurn() {
		xTurn = !xTurn;
	}
	public gameLegend getMarkAt(int row, int column) {
		return gameBoard[row][column];
	}
	
	public gameLegend gameStatus() {
		if (checkXWin()) {
			return gameLegend.XWIN;
		}
		else if (checkOWin()) {
			return gameLegend.OWIN;
		}
		else {
			if (checkDraw()) {
				return gameLegend.DRAW;
			}
			else {
				return gameLegend.CONTINUE;
			}
			
		}
	}
	
	private boolean checkXWin() {
		gameLegend piece = gameLegend.X;
		
		if (checkHorizontalWin(piece) || checkVerticalWin(piece) || checkDiagonalWin(piece)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean checkOWin() {
		gameLegend piece = gameLegend.O;
		
		if (checkHorizontalWin(piece) || checkVerticalWin(piece) || checkDiagonalWin(piece)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean checkHorizontalWin(gameLegend piece) {
		if (gameBoard[0][0] == piece && gameBoard[0][1] == piece && gameBoard[0][2] == piece) {
			return true;
		}
		else if (gameBoard[1][0] == piece && gameBoard[1][1] == piece && gameBoard[1][2] == piece) {
			return true;
		}
		else if (gameBoard[2][0] == piece && gameBoard[2][1] == piece && gameBoard[2][2] == piece) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean checkVerticalWin(gameLegend piece) {
		if (gameBoard[0][0] == piece && gameBoard[1][0] == piece && gameBoard[2][0] == piece) {
			return true;
		}
		else if (gameBoard[0][1] == piece && gameBoard[1][1] == piece && gameBoard[2][1] == piece) {
			return true;
		}
		else if (gameBoard[0][2] == piece && gameBoard[1][2] == piece && gameBoard[2][2] == piece) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean checkDiagonalWin(gameLegend piece) {
		if (gameBoard[0][0] == piece && gameBoard[1][1] == piece && gameBoard[2][2] == piece) {
			return true;
		}
		else if (gameBoard[0][2] == piece && gameBoard[1][1] == piece && gameBoard[2][0] == piece) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean checkDraw() {
		boolean isDraw = true;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (gameBoard[i][j] == gameLegend.EMPTY) {
					isDraw = false;
				}
			}
		}
		return isDraw;
	}
}