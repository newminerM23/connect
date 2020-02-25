package Connect4;
/** Main method of the connect 4 program. */
import java.awt.Color;
import acm.program.*;

public class Connect4 extends GraphicsProgram {

	/** The initiation method */
	public void init() {
		//Sets the GraphicsProgramm background.
		this.setBackground(Color.WHITE);
		
		//Creates a model.
		Model model = new Model();
				
		//Creates a view.
		GraphicalView view = new GraphicalView();
		model.addView(view);
		add(view);
				
		//Creates a controller.
		KeyboardController controller = new KeyboardController(model);
		getGCanvas().addKeyListener(controller);
	}
	
	public static void main(String[] args) {
		new Connect4().start();
	}
}