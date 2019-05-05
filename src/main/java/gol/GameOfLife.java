package gol;

/**
 * The Class GameOfLife.
 */
public class GameOfLife {
	
	/** The gol grid. */
	CellGrid golGrid;
	private static GameOfLife ref = null;

	private GameOfLife(){

	}

	public static GameOfLife getReference(){
		if(ref == null){
			ref = new GameOfLife();
		}
		return ref;
	}

	/**
	 * Inits the gol grid.
	 *
	 * @param cols the cols
	 * @param rows the rows
	 */
	private void initGOLGrid(int cols, int rows) {
		this.golGrid = new CellGrid(cols, rows);
		this.golGrid.randomize();
	}

	/**
	 * Start gol.
	 */
	private void startGOL() {
		this.golGrid.nextGeneration();
	}
	
	/**
	 * Prints the.
	 */
	private void print(){
		System.out.println(golGrid);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		GameOfLife gol = GameOfLife.getReference(); //angepasst
		gol.initGOLGrid(5, 5);
		for(int i= 0; i<= 10; i++){
			gol.startGOL();
			gol.print();
		}
	}
}
