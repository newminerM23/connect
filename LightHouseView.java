package Connect4;
import java.io.IOException;
/** The view for the lighthouse. */
public class LightHouseView implements View {

	@Override
	public void update(Model world) {
		LighthouseDisplay display = null;

		// Try connecting to the display
		try {
			display = LighthouseDisplay.getDisplay();
		    display.setUsername("Michel");
		    display.setToken("API-TOK_vx/r-JV8D-N3A4-xkgv-d4Vm");
		} catch (Exception e) {
			System.out.println("Connection failed: " + e.getMessage());
			e.printStackTrace();
		}

		// Send data to the display
		try {
			// This array contains for every window (14 rows, 28 columns) three
			// bytes that define the red, green, and blue component of the color
			// to be shown in that window. See documentation of LighthouseDisplay's
			// send(...) method.
			byte[] data = new byte[14 * 28 * 3];
			
			// Fill array
			
			display.sendImage(data);
		} catch (IOException e) {
			System.out.println("Connection failed: " + e.getMessage());
			e.printStackTrace();
		}
		display.close();
	}
}