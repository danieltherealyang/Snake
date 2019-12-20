package Snake;

import java.util.Random;

public class GridCoordinates {
	public int randCoord() {
		Random rand = new Random();
		int coord = rand.nextInt(15) * 40;
		return coord;
	}
	public int coord(int i) {
		int coord = i * 40;
		return coord;
	}
}
