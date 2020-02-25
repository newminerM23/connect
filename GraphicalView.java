package Connect4;
/** The graphic implementation of the Connect 4 game. */
import java.awt.Color;
import acm.graphics.*;

public class GraphicalView extends GCompound implements View{
	
	//The update method of this View.
	@Override
	public void update(Model model) {
		removeAll();
		drawBackground();
		drawView(model);
	}
	
	//The drawing methods.
	/** Draws the background of the game. */
	public void drawBackground() {
		GRect grid = new GRect(700, 600);
		grid.setFillColor(Color.BLUE);
		grid.setFilled(true);
		add(grid);
		
		for (int col = 0; col <= 6; col++) {
			for (int row = 0; row <= 5; row++) {
				GOval hole = new GOval( 100 * col, 100 * row, 100, 100);
				hole.setFillColor(Color.WHITE);
				hole.setFilled(true);
				add(hole);
			}
		}
	}
	
	/** Draw a view. */
	public void drawView(Model model) {
		int[][]grid = model.getGrid();
		for (int col = 0; col <= 6; col++) {
			for (int row = 5; row >= 0; row--) {
				if (grid[col][row] != 0) {
					GOval chip = new GOval(100 * col, 500 - row * 100, 100, 100);
					switch (grid[col][row]) {
						case 1: chip.setFillColor(Color.YELLOW);
						break;
						case 2: chip.setFillColor(Color.RED);
						break;
					}
					chip.setFilled(true);
					add(chip);
				}
			}
		}
	}
}