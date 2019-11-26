
public class Dungeon {
	private Room[][] Dungeon;
	
	public Dungeon(int c, int r) {
		this.Dungeon = new Room[c][r];
		
		for(int i = 0; i < c; i++) {
			for(int j = 0; j < r; j++) {
				Dungeon[i][j] = new Room();
			}
		}
	}
	public Room getRoom(int i, int j) {
		return null;
	}
	
}
