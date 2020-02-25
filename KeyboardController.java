package Connect4;
/**
 * The Controller of the the Connect 4 game.
 * @author Michel, Hamza
 */
import java.awt.event.*;

public class KeyboardController extends GeneralController implements KeyListener {
	
	public KeyboardController(Model model) {
		super(model);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		putChip(e.getKeyCode() - 49);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}