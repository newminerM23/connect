package Connect4;

/** The data of the Connect 4 game.*/
import java.util.*;

public class Model {

	// The instance variables.
	/** The status of the holes of the connect 4 game. **/
	private int[][] grid;

	/** The number of chips left in the game. **/
	private int chips;

	/** A list of the views the model has. */
	private final Set<View> views = new HashSet<>();

	// The constructor.
	/** Creates a model. */
	public Model() {
		this.grid = new int[7][6];
		this.chips = 42;
	}

	// The setter.
	/** Sets the grid. */
	public void setGrid(int[][] grid) {
		// We check if the given grid is a valid state of the game.
		int yellow = 0;
		int red = 0;
		for (int col = 0; col <= 6; col++) {
			for (int row = 0; row <= 5; row++) {
				if (grid[col][row] == 1) {
					yellow++;
				} else if (grid[col][row] == 2) {
					red++;
				}
			}
		}
		if (yellow > red + 1 || red > yellow || this.chips == 0) {
			return;
		} else {
			// We check if the grid has 4 in a Row.*/
			this.grid = grid;
			if (FourinARow()) {
				this.chips = 0;
			} else {
				this.chips = 42 - (yellow + red);
			}
			notifyViews();
		}
	}

	// The getter.
	/** Gets the grid. */
	public int[][] getGrid() {
		return this.grid;
	}

	// The view methods.
	/** Adds a view to the list of views for this model. */
	public void addView(View view) {
		views.add(view);
		view.update(this);
	}

	/** Calls update(this) on every view to reconstruct their displays. */
	private void notifyViews() {
		for (View view : views) {
			view.update(this);
		}
	}

	// The helper methods.
	/** Checks if there are four chips of one kind in a row. */
	public boolean FourinARow() {
		int inARow;
		int turn = turn();

		if (turn == 0) {
			return false;
		}

		// We check horizontally.
		for (int col = 0; col <= 6; col++) {
			inARow = 0;
			for (int row = 0; row <= 5; row++) {
				if (grid[col][row] == turn) {
					inARow++;
				} else {
					inARow = 0;
				}
				if (inARow == 4) {
					return true;
				}
			}
		}

		// We check vertically.
		for (int row = 0; row <= 5; row++) {
			inARow = 0;
			for (int col = 0; col <= 6; col++) {
				if (grid[col][row] == turn) {
					inARow++;
				} else {
					inARow = 0;
				}
				if (inARow == 4) {
					return true;
				}
			}
		}

		// We check diagonally.
		for (int row = 0; row <= 3; row++) {
			inARow = 0;
			for (int i = 0; i <= 6; i++) {
				if (row + i >= 0 && row + i <= 5) {
					if (grid[i][row + i] == turn) {
						inARow++;
					} else {
						inARow = 0;
					}
					if (inARow == 4) {
						return true;
					}
				}
			}
		}

		for (int col = 1; col <= 4; col++) {
			inARow = 0;
			for (int i = 0; i <= 6; i++) {
				if (col + i >= 0 && col + i <= 6) {
					if (grid[col + i][i] == turn) {
						inARow++;
					} else {
						inARow = 0;
					}
					if (inARow == 4) {
						return true;
					}
				}
			}
		}

		for (int row = 4; row <= 6; row++) {
			inARow = 0;
			for (int i = 0; i <= 6; i++) {
				if (row - i >= 0 && row - i <= 5) {
					if (grid[i][row - i] == turn) {
						inARow++;
					} else {
						inARow = 0;
					}
					if (inARow == 4) {
						return true;
					}
				}
			}
		}

		for (int col = 1; col <= 4; col++) {
			inARow = 0;
			for (int i = 0; i <= 6; i++) {
				if (col - i >= 0 && col - i <= 6) {
					if (grid[col - i][i] == turn) {
						inARow++;
					} else {
						inARow = 0;
					}
					if (inARow == 4) {
						return true;
					}
				}
			}
		}

		return false;
	}

	/** Returns whose turn it is. */
	public int turn() {
		// If it's yellow's turn.
		if (this.chips > 0 && this.chips % 2 == 0) {
			return 1;
		} else if (this.chips > 0 && this.chips % 2 == 1) {
			// If it's reds turn.
			return 2;
		} else {
			// If it's nobody's turn.
			return 0;
		}
	}
}