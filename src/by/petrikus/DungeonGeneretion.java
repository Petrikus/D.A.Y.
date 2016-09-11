package by.petrikus;

import java.util.Random;

public class DungeonGeneretion {
	Random r = new Random();
	public boolean WEST, NORTH, SOUTH, EAST;
	boolean[] sides = new boolean[4];
	boolean or;
	int[][] dungeon;

	public void frame(int a, int b, int x, int y, boolean or){
			this.or = or;
			dungeon = new int[x][y];
			for (int i = 0; i < x; i++){
				for (int j = 0; j < y; j++){
					dungeon[i][j] = 1; 
				}
			}
			int koorX = 0;
			int koorY = 0;
			dungeon[0][0] = 0;
			int rr = 0;
			for (;;){
				if(rr == 18){
					break;
				}
				int e = r.nextInt(11);
				try{
				if (e == 0|| e == 4||e == 8){
					koorY++;
					if (koorY > y  || dungeon[koorX][koorY] == 0){
						koorY--;
					}
					else if (dungeon[koorX][koorY] == 0){
					}
					else{
						dungeon[koorX][koorY] = 0;
						rr++;
					}
				}
				else if(e == 1 || e == 5|| e == 9){
					koorX++;
					if (koorX > x || dungeon[koorX][koorY] == 0){
						koorX--;
					} 
					else if (dungeon[koorX][koorY] == 0){
					} 
					else{
						dungeon[koorX][koorY] = 0;
						rr++;
					}
				}
				else if (e == 2|| e == 6 || e == 10){
					koorY--;
					if (koorY < 0  || dungeon[koorX][koorY] == 0){
						koorY++;
					}
					else if (dungeon[koorX][koorY] == 0){
					}
					else{
						dungeon[koorX][koorY] = 0;
						rr++;
					}
				}
				else if (e == 3|| e == 7 || e == 11){
					koorX--;
					if (koorX < 0  ){
						koorX++;
					}
					else if (dungeon[koorX][koorY] == 0){
					} 
					else{
					}
					dungeon[koorX][koorY] = 0;
					rr++;}

				}
				catch(Exception zet){
				}
			}
			for (int i = 0; i < x; i++){
				for(int j = 0; j < y; j++){
					System.out.print(dungeon[i][j] + "\t");
				}
				System.out.println();
			}
			gener(a, b, 320, 240, or, dungeon);
		}

	public void gener(int a, int b, int x, int y, boolean or, int[][] dungeon) {
		try {
			if (dungeon[a + 1][b] == 0) {
				SOUTH = true;
			} else {
				SOUTH = false;
			}
		} catch (Exception e) {
			SOUTH = false;
		}
		sides[0] = SOUTH;
		try {
			if (dungeon[a - 1][b] == 0) {
				NORTH = true;
			} else {
				NORTH = false;
			}
		} catch (Exception e) {
			NORTH = false;
		}
		sides[1] = NORTH;
		try {
			if (dungeon[a][b + 1] == 0) {
				EAST = true;
			} else {
				EAST = false;
			}
		} catch (Exception e) {
			EAST = false;
		}
		sides[2] = EAST;
		try {
			if (dungeon[a][b - 1] == 0) {
				WEST = true;
			} else {
				WEST = false;
			}
		} catch (Exception e) {
			WEST = false;
		}
		sides[3] = WEST;
		GameStart game = new GameStart(or, sides, a, b, x, y, dungeon);
	}
}