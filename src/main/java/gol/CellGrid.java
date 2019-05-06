package gol;

import java.util.*;
import java.io.*;

/**
 * The Class CellGrid.
 */
public class CellGrid {
	
	/** The grid. */
	private Cell[][] grid;
	
	/** The cols. */
	private int cols;
	
	/** The rows. */
	private int rows;
	
	/** The generation. */
	private int generation;

	/** The generation history. */
	//TODO save history
	private Originator originator = new Originator();
	private CareTaker careTaker = new CareTaker();

	//method to call that adds a grid as a String .. blablabla müde
	public void saveHistory(){
		String gridString = Arrays.deepToString(grid); //TODO .deepTostring müsste getestet werden ob es gewollte funktion durchführt
		originator.setState(gridString);
		careTaker.add(originator.saveStateToMemento(originator.getState()));
	}

	
	/**
	 * Instantiates a new cell grid.
	 */
	public CellGrid() {
	}

	/**
	 * Instantiates a new cell grid.
	 *
	 * @param cols the cols
	 * @param rows the rows
	 */
	public CellGrid(int cols, int rows) {
		this.initGrid(cols, rows);
	}

	/**
	 * Sets the cell state.
	 *
	 * @param col the col
	 * @param row the row
	 * @param cellValue the cell value
	 */
	//specific cell wird belegt
	public void setCellState(int col, int row, boolean cellValue) {
		this.grid[col][row].setState(cellValue);
	}

	/**
	 * Gets the cell state.
	 *
	 * @param col the col
	 * @param row the row
	 * @return the cell state
	 */
	public boolean getCellState(int col, int row) {
		return this.grid[col][row].getState();
	}

	/**
	 * Sets the cols.
	 *
	 * @param cols the new cols
	 */
	private void setCols(int cols) {
		this.cols = cols;
	}

	/**
	 * Gets the cols.
	 *
	 * @return the cols
	 */
	public int getCols() {
		return this.cols;
	}

	/**
	 * Sets the rows.
	 *
	 * @param rows the new rows
	 */
	private void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 * Gets the rows.
	 *
	 * @return the rows
	 */
	public int getRows() {
		return this.rows;
	}

	/**
	 * Sets the generation.
	 *
	 * @param generation the new generation
	 */
	public void setGeneration(int generation) {
		this.generation = generation;
	}

	/**
	 * Gets the generation.
	 *
	 * @return the generation
	 */
	public int getGeneration() {
		return this.generation;
	}

	/**
	 * Next generation.
	 */
	public void nextGeneration() {
		Cell[][] tempGrid = new Cell[this.getCols()][this.getRows()];

		for (int i = 0; i < this.getCols(); i++) {
			for (int j = 0; j < this.getRows(); j++) {
				tempGrid[i][j] = new Cell(this.calculateNewCellState(i, j, this.getAliveNeighboursCount(i, j)));
			}
		}
		for (int i = 0; i < this.getCols(); i++) {
			for (int j = 0; j < this.getRows(); j++) {
				grid[i][j].setState(tempGrid[i][j].getState()); 
			}
		}
		this.setGeneration(this.getGeneration() + 1);
	}

	/**
	 * Gets the alive neighbours count.
	 *
	 * @param col the col
	 * @param row the row
	 * @return the alive neighbours count
	 */
	public int getAliveNeighboursCount(int col, int row) {
		int aliveNeighboursCount = 0;
		if(row == 0){
			if (col == 0){
				if(getCell(row,col+1).getState()){
					aliveNeighboursCount++;
				}
				if(getCell(row+1,col).getState()){
					aliveNeighboursCount++;
				}
				if(getCell(row+1,col+1).getState()){
					aliveNeighboursCount++;
				}
			} else if (col == this.cols-1){
				if(getCell(row,col-1).getState()){
					aliveNeighboursCount++;
				} else if(getCell(row+1,col-1).getState()){
					aliveNeighboursCount++;
				} else if(getCell(row+1,col).getState()){
					aliveNeighboursCount++;
				}
			} else {
				if(getCell(row,col-1).getState()){
					aliveNeighboursCount++;
				}
				if(getCell(row,col+1).getState()){
					aliveNeighboursCount++;
				}
				if(getCell(row+1,col-1).getState()){
					aliveNeighboursCount++;
				}
				if(getCell(row+1,col).getState()){
					aliveNeighboursCount++;
				}
				if(getCell(row+1,col+1).getState()){
					aliveNeighboursCount++;
				}
			}
		} else if(row == this.rows-1){
			if (col == 0){
				if(getCell(row-1,col).getState()){
					aliveNeighboursCount++;
				}
				if(getCell(row-1,col+1).getState()){
					aliveNeighboursCount++;
				}
				if(getCell(row,col+1).getState()){
					aliveNeighboursCount++;
				}
			} else if(col == this.cols-1){
				if(getCell(row-1,col-1).getState()){
					aliveNeighboursCount++;
				}
				if(getCell(row-1,col).getState()){
					aliveNeighboursCount++;
				}
				if(getCell(row,col-1).getState()){
					aliveNeighboursCount++;
				}
			} else {
				if(getCell(row-1,col-1).getState()){
					aliveNeighboursCount++;
				}
				if(getCell(row-1,col).getState()){
					aliveNeighboursCount++;
				}
				if(getCell(row-1,col+1).getState()){
					aliveNeighboursCount++;
				}
				if(getCell(row,col-1).getState()){
					aliveNeighboursCount++;
				}
				if(getCell(row,col+1).getState()){
					aliveNeighboursCount++;
				}
			}
		}	else if(col == 0){
			if(getCell(row-1,col).getState()){
				aliveNeighboursCount++;
			}
			if(getCell(row-1,col+1).getState()){
				aliveNeighboursCount++;
			}
			if(getCell(row,col+1).getState()){
				aliveNeighboursCount++;
			}
			if(getCell(row+1,col).getState()){
				aliveNeighboursCount++;
			}
			if(getCell(row+1,col+1).getState()){
				aliveNeighboursCount++;
			}
		}	else if(col == this.cols-1){
			if(getCell(row-1,col).getState()){
				aliveNeighboursCount++;
			}
			if(getCell(row+1,col).getState()){
				aliveNeighboursCount++;
			}
			if(getCell(row-1,col-1).getState()){
				aliveNeighboursCount++;
			}
			if(getCell(row+1,col-1).getState()){
				aliveNeighboursCount++;
			}
			if(getCell(row,col-1).getState()){
				aliveNeighboursCount++;
			}
		} else {
			if(getCell(row-1,col-1).getState()){
				aliveNeighboursCount++;
			}
			if(getCell(row-1,col).getState()){
				aliveNeighboursCount++;
			}
			//DONE (row-1,col) auf (row-1,col+1) geändert
			/*if(getCell(row-1,col).getState()){ //DONE duplicate code
				aliveNeighboursCount++;
			}*///DONE (row-1,col) auf (row-1,col+1) geändert
			if(getCell(row-1,col+1).getState()){ //DONE duplicate code
				aliveNeighboursCount++;
			}

			if(getCell(row,col-1).getState()){
				aliveNeighboursCount++;
			}
			if(getCell(row,col+1).getState()){
				aliveNeighboursCount++;
			}
			if(getCell(row+1,col-1).getState()){
				aliveNeighboursCount++;
			}
			if(getCell(row+1,col).getState()){
				aliveNeighboursCount++;
			}
			if(getCell(row+1,col+1).getState()){
				aliveNeighboursCount++;
			}
		}
		return aliveNeighboursCount;
	}

	/**
	 * Calculate new cell state.
	 *
	 * @param col the col
	 * @param row the row
	 * @param aliveNeighboursCount the alive neighbours count
	 * @return true, if successful
	 */
	private boolean calculateNewCellState(int col, int row, int aliveNeighboursCount) {
		Cell cell = getCell(row,col);
		if(cell.getState()){
			if (!(aliveNeighboursCount == 2 || aliveNeighboursCount == 3)){
				return false;
			}
		} else {
			if (aliveNeighboursCount == 3){
				return true;
			}
		}
		return cell.getState();
	}

	/**
	 * Reset.
	 */
	public void reset() {
		this.initGrid(this.getCols(), this.getRows());
	}

	/**
	 * Randomize.
	 */
	public void randomize() {
		Random generator = new Random();
		for (int i = 0; i < this.getCols(); i++) {
			for (int j = 0; j < this.getRows(); j++) {
				this.grid[i][j].setState(generator.nextBoolean());
			}
		}
		this.setGeneration(0);
	}

	/**
	 * Inits the grid.
	 *
	 * @param cols the cols
	 * @param rows the rows
	 */
	private void initGrid(int cols, int rows) {
		this.setCols(cols);
		this.setRows(rows);
		this.setGeneration(0);

		this.grid = new Cell[this.getCols()][this.getRows()];

		for (int i = 0; i < this.getCols(); i++) {
			for (int j = 0; j < this.getRows(); j++) {
				this.grid[i][j] = new Cell(false);
			}
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String matrix = "";
		for (int i = 0; i < this.getRows(); i++) {
			for (int j = 0; j < this.getCols(); j++) {
				matrix = matrix+(this.grid[j][i].getState() ? Cell.ALIVE : Cell.DEAD);
			}
			matrix = matrix+"\n";
		}
		return matrix;
	}

	/**
	 * Checks if is alive.
	 *
	 * @param row the row
	 * @param col the col
	 * @return true, if is alive
	 */
	public boolean isAlive(int row, int col) {
		return this.grid[col][row].getState();
	}
	
	/**
	 * Gets the cell.
	 *
	 * @param row the row
	 * @param col the col
	 * @return the cell
	 */
	public Cell getCell(int row, int col){
		return this.grid[col][row];
	}
	
	/**
	 * Load grid.
	 *
	 * @param file the file
	 */
	/*TODO
	Die Methode loadGrid der Klasse CellGrid ist nicht optimal nach den Prinzipen von
	TTD umgesetzt.
	Versuchen sie die Methoden aufzuteilen und beim Testen mit dem Mockito Framework zu testen
	 */
	public void loadGrid(File file) {
		String line;
		Vector<String> fileGrid = new Vector<String>();
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(file));
			while ((line = fileReader.readLine()) != null)
				fileGrid.add(line);
			fileReader.close();
		} catch (Exception e) {

		}
		//anzahl der cols wird anhand länge der strings gesetzt
		this.setCols(fileGrid.get(0).length());
		//länge der rows wird anhand der anzahl an strings von fileGrid gesetzt
		this.setRows(fileGrid.size());
		this.setGeneration(0);

		this.grid = new Cell[this.getCols()][this.getRows()];

		for (int i = 0; i < this.getCols(); i++) {
			for (int j = 0; j < this.getRows(); j++) {
				String fieldValue = fileGrid.elementAt(j).substring(i, i + 1);
				boolean state = (fieldValue.equals(Cell.ALIVE) ? true : false);
				this.grid[i][j] = new Cell(state);
			}
		}
	}
	
	/**
	 * Save grid.
	 *
	 * @param file the file
	 */
	public void saveGrid(File file) {
		try {
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i < this.getRows(); i++) {
				for (int j = 0; j < this.getCols(); j++) {
					fileWriter.write((this.grid[j][i].getState()) ? Cell.ALIVE : Cell.DEAD);
				}
				fileWriter.newLine();
			}
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception e) {
		}
	}

	public boolean checkStable() {
		boolean same = false;
		
		//TODO use the history to check stable
		
		return same;
	}
	
}
