package gol;

public class MCP { //Master Controller Program

	/**
	 * The main method.
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		GameOfLifeGUI gui = new GameOfLifeGUI();
		gui.init();
		gui.run();
	}
}
