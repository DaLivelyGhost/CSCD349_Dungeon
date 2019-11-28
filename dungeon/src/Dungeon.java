import java.util.Random;

public class Dungeon {
	private Room[][] Room;
	int x_dimension;
	int y_dimension;
	
	public Dungeon(int c, int r) {
		this.Room = new Room[c][r];
		this.x_dimension = c;
		this.y_dimension = r;
		
		for(int i = 0; i < c; i++) {
			for(int j = 0; j < r; j++) {
				Room[i][j] = new Room(i, j);
				populateRooms(Room, i, j);
			}
		}
		
	}

	public Room getRoom(int i, int j) {
		return Room[i][j];
	}
//------------------------------------------------------
	//Randomly populating each room as we build them.
	private void populateRooms(Room[][] Room, int i, int j) {
		Random r = new Random();
		int pit = r.nextInt(11);;
		int vision = r.nextInt(11);
		int healing = r.nextInt(11);
		int monster = r.nextInt(11);
		//------------------------------------------------------	
			//TO DO: build items to put into these rooms
		//------------------------------------------------------		
		if(pit > 8) {					//20% chance
			Room[i][j].populateRoom(new Pit());					//pit item goes here
		}
		if(vision > 8) {				//20% chance
			Room[i][j].populateRoom(new Potion_vision());		//vision potion item goes here
		}
		if(healing > 8) {				//20% chance
			Room[i][j].populateRoom(new Potion_healing());		//healing potion item goes here
		}
		//------------------------------------------------------		
			//Monster is stubbed out until the monster factory is complete
		//------------------------------------------------------		
//		if(monster > 8) {				//20% chance
//			Room[i][j].populateRoom();					//Monster goes here
//		}
		
	}

//------------------------------------------------------
	//TOSTRING IN PROGRESS; it works, but doesn't account for doors n shit. Will continue to work on this.
//------------------------------------------------------
	@Override
	public String toString() {
		String toReturn = "";
		
		for(int i = 0; i < x_dimension; i++) {		//walk through each room
			for(int j = 0; j < y_dimension; j++) {
				
				toReturn = toReturn.concat(Room[i][j].toString());	//concat the room's toString to the dungeon string
				
				if(j == y_dimension - 1) {
					toReturn = toReturn.concat("\n"); //new line
				}
			}
		}
		return toReturn;
	}
}
