//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.
package assign1;

public class TetrisGrid {
	private boolean[][] grid;
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}

	private boolean isFullRow(int y){
		for(int x = 0 ; x<grid.length ; x++){
			if(!grid[x][y])
				return false;
		}
		return true;
	}
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		for(int i = grid[0].length-1 ; i>=0 ; i--){
			if(isFullRow(i))
				clearRow(i);
		}
	}

	private void clearRow(int y) {
		for(int i = y ; i<grid[0].length-1 ; i++){
			for(int j = 0 ; j<grid.length ; j++)
				grid[j][i]=grid[j][i+1];
		}
		for(int j = 0 ; j<grid.length ; j++)
			grid[j][grid[0].length-1]=false;


	}

	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return this.grid;
	}
}