package Connect4;
/** A general controller class, that other controller classes can inherit from */
public class GeneralController {

	// The instance variables.
	/** The model of the controller. */
	private Model model;

	// The constructor.
	/** Creates a controller. */
	public GeneralController(Model model) {
		this.model = model;
	}

	// The controller methods.
	/** Puts a chip in the grid. */
	public void putChip(int col) {

		//We check if the input is valid.
		if (col < 0 || col > 6) {
			return;
		} else {

			//We create a new grid.
			int[][] grid = this.model.getGrid();

			//We check if the spot is free.
			for (int row = 0; row <= 5; row++) {
				if (grid[col][row] == 0) {

					//We change the spot.
					grid[col][row] = this.model.turn();
					this.model.setGrid(grid);
					return;
				}
			}
		}
	}
}