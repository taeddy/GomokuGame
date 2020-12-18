package gomoku.app;

public class Field {

	/** 1 = BLACK, -1 = WHITE, 0 = none */
	private int[][] field;
	
	private final int BLACK = 1;
	private final int WHITE = -1;
	
	/** true = BLACK, false = WHITE */
	private boolean checkTurn = true;

	public Field(FieldSize fs) {
		field = new int[fs.getSIZE()][fs.getSIZE()];
	}

	public int getBlack() {
		return BLACK;
	}

	public int getWhite() {
		return WHITE;
	}

	public int getXY(int x, int y) {
		return field[x][y];
	}

	public boolean getCheck() {
		return checkTurn;
	}

	public void changeCheck() {
		if (checkTurn) {
			checkTurn = false;
		} else {
			checkTurn = true;
		}
	}

	public void setField(int x, int y) {
		// following checkTurn, save stone
		if (checkTurn) {
			field[x][y] = BLACK;
		} else {
			field[x][y] = WHITE;
		}
	}

	public boolean checkFull(FieldSize fs) {
		for(int i = 0; i < fs.getSIZE(); i++) {
			for(int j = 0; j < fs.getSIZE(); j++) {
				if(field[i][j] == 0)
					return false;
			}
		}
		return true;
	}
	
	// FROM HERE
	// check finish rule
	// around latest cell

	public boolean checkWin(int x, int y) {
		if (checkWinLeft(x, y) || checkWinLeftDown(x, y) || checkWinLeftUp(x, y) || checkWinRight(x, y) || checkWinRightDown(x, y) || checkWinRightUp(x, y) || checkWinUp(x, y) || checkWinDown(x, y)
				|| checkWinOneDown(x, y) || checkWinOneLeft(x, y) || checkWinOneLeftDown(x, y) || checkWinOneLeftUp(x, y) || checkWinOneRight(x, y) || checkWinOneRightDown(x, y) || checkWinOneUp(x, y) || checkWinOneRightUp(x, y)
				|| checkWinCenterLeftUp(x, y) || checkWinCenterRightLeft(x, y) || checkWinCenterRightUp(x, y) 	|| checkWinCenterUpDown(x, y)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkWinUp(int x, int y) {
		try {
			for (int i = y; i < y + 5; i++) {
				if (field[y][x] != field[i][x])
					return false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	public boolean checkWinDown(int x, int y) {
		try {
			for (int i = y; i > y - 5; i--) {
				if (field[y][x] != field[i][x])
					return false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	public boolean checkWinRightUp(int x, int y) {
		try {
			for (int i = y, z = x; i > y - 5; i--, z++) {
				if (field[y][x] != field[i][z])
					return false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	public boolean checkWinLeftUp(int x, int y) {
		try {
			for (int i = y, z = x; i > y - 5; i--, z--) {
				if (field[y][x] != field[i][z])
					return false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	public boolean checkWinRight(int x, int y) {
		try {
			for (int z = x; z < x + 5; z++) {
				if (field[y][x] != field[y][z])
					return false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	public boolean checkWinLeft(int x, int y) {
		try {
			for (int i = y, z = x; z > x - 5; z--) {
				if (field[y][x] != field[i][z] || i > 19 || z > 19 || i < 0 || z < 0)
					return false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	public boolean checkWinRightDown(int x, int y) {
		try {
			for (int i = y, z = x; i < y + 5; i++, z++) {
				if (field[y][x] != field[i][z])
					return false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	public boolean checkWinLeftDown(int x, int y) {
		try {
			for (int i = y, z = x; i < y + 5; i++, z--) {
				if (field[y][x] != field[i][z])
					return false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	public boolean checkWinOneUp(int x, int y) {
		try {
			for (int i = y - 1; i < y + 4; i++) {
				if (field[y][x] != field[i][x])
					return false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	public boolean checkWinOneDown(int x, int y) {
		try {
			for (int i = y + 1; i > y - 4; i--) {
				if (field[y][x] != field[i][x])
					return false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	public boolean checkWinOneRightUp(int x, int y) {
		try {
			for (int i = y + 1, z = x - 1; i > y - 4; i--, z++) {
				if (field[y][x] != field[i][z])
					return false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	public boolean checkWinOneLeftUp(int x, int y) {
		try {
			for (int i = y + 1, z = x + 1; i > y - 4; i--, z--) {
				if (field[y][x] != field[i][z])
					return false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	public boolean checkWinOneRight(int x, int y) {
		try {
			for (int z = x - 1; z < x + 4; z++) {
				if (field[y][x] != field[y][z])
					return false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	public boolean checkWinOneLeft(int x, int y) {
		try {
			for (int z = x + 1; z > x - 4; z--) {
				if (field[y][x] != field[y][z])
					return false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	public boolean checkWinOneRightDown(int x, int y) {
		try {
			for (int i = y - 1, z = x - 1; i < y + 4; i++, z++) {
				if (field[y][x] != field[i][z] || i > 19 || z > 19 || i < 0 || z < 0)
					return false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	public boolean checkWinOneLeftDown(int x, int y) {
		try {
			for (int i = y - 1, z = x + 1; i < y + 4; i++, z--) {
				if (field[y][x] != field[i][z])
					return false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {

			return false;
		}
		return true;
	}

	public boolean checkWinCenterUpDown(int x, int y) {
		try {
			for (int i = y - 2; i < y + 3; i++) {
				if (field[y][x] != field[i][x])
					return false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	public boolean checkWinCenterRightLeft(int x, int y) {
		try {
			for (int z = x - 2; z < x + 3; z++) {
				if (field[y][x] != field[y][z])
					return false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	public boolean checkWinCenterRightUp(int x, int y) {
		try {
			for (int i = y + 2, z = x - 2; i > y - 3; i--, z++) {
				if (field[y][x] != field[i][z])
					return false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	public boolean checkWinCenterLeftUp(int x, int y) {
		try {
			for (int i = y + 2, z = x + 2; i > y - 4; i--, z--) {
				if (field[y][x] != field[i][z])

					return false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {

			return false;
		}
		return true;
	}

}
