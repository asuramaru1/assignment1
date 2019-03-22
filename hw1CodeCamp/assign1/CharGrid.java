// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

package assign1;

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {

		this.grid = grid;
	}


	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		int bot=0 , top=0 , left=0 , right=0 ;
		boolean virgin = true;
		for(int i = 0 ; i<grid.length ; i++){
			for(int j = 0 ; j<grid[0].length ; j++){
				if(grid[i][j]==ch){
					if(virgin){
						bot = i; top = i ;
						left = j   ; right = j ;
						virgin= false;
					}else{
						bot = Math.max(bot , i);
						top = Math.min(top , i);
						left = Math.min(left , j);
						right = Math.max(right , j);
					}
				}

			}
		}
		if(virgin)return 0 ;
		return (bot-top+1) * (right-left+1);

	}

	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	private boolean isCross(int x , int y){
		int up = 1  , down = 1 , left = 1 , right = 1;
		int x1=x-1 , x2=x+1 , y1=y-1 , y2 = y+1;

		char c = grid[x][y];
		while(x1>=0 &&grid[x1][y]==c) {
			up++;
			x1--;
		}
		while(x2<=grid.length-1 &&grid[x2][y]==c) {
			down++;
			x2++;
		}
		while(y1>=0 && grid[x][y1]==c){
			left++;
			y1--;
		}
		while(y2<=grid[0].length-1 && grid[x][y2]==c){
			right++;
			y2++;
		}
		return up==down && down==left &&left==right && right>1 ;


	}
	public int countPlus() {
		int count = 0 ;
		for(int i = 0 ; i<grid.length ; i++){
			for(int j = 0 ;   j< grid[0].length ;j++ ){
				count+= isCross(i,j)?1:0;
			}
		}
		return count;
	}

}