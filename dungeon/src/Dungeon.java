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
		distributePillars(this.x_dimension, this.y_dimension);
		
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
			Room[i][j].setIcon("P");
		}
		if(vision > 8) {				//20% chance
			Room[i][j].populateRoom(new Potion_vision());		//vision potion item goes here
			Room[i][j].setIcon("V");
		}
		if(healing > 8) {				//20% chance
			Room[i][j].populateRoom(new Potion_healing());		//healing potion item goes here
			Room[i][j].setIcon("H");
		}
		//------------------------------------------------------		
			//Monster is stubbed out until the monster factory is complete
		//------------------------------------------------------		
//		if(monster > 8) {				//20% chance
//			Room[i][j].populateRoom();					//Monster goes here
//			Room[i][j].setIcon("X");
//		}
		
	}
	private void distributePillars(int x, int y) {
		Random r1 = new Random();
		Random r2 = new Random();
		int temp1;
		int temp2;
		
		for(int i = 0; i < 4; i++) {	//choose 4 random rooms to put a pillar into.
			temp1 = r1.nextInt(x - 1);
			temp2 = r2.nextInt(y - 1);
			Room[temp1][temp2].populateRoom(new Pillar_of_OO());
			Room[temp1][temp2].setIcon("I");
		}
	}

//------------------------------------------------------
	//TOSTRING
//------------------------------------------------------
	@Override
	public String toString() {
		
		String toReturn = "";
		
		//---------------------------------------------------
			//Top wall
		//---------------------------------------------------
		for(int m = 0; m < 2 * this.x_dimension + 1; m++) {
			toReturn = toReturn.concat("*");
			toReturn = toReturn.concat(" ");
		}
		toReturn = toReturn.concat("\n");
		//---------------------------------------------------
			//Dungeon contents
		//---------------------------------------------------
		
		for(int i = 0; i < x_dimension; i++) {		//walk through each room
			
			toReturn = toReturn.concat("*");		//Left wall
			
			for(int j = 0; j < y_dimension; j++) {
				
				toReturn = toReturn.concat(" ");
				toReturn = toReturn.concat(Room[i][j].toString());	//concat the room's toString to the dungeon string
				
				if(j != y_dimension - 1) {
					toReturn = toReturn.concat(" ");
					toReturn = toReturn.concat("|");
				}
				
				if(j == y_dimension - 1) {
					
					toReturn = toReturn.concat(" ");
					toReturn = toReturn.concat("*");  //Right wall
					toReturn = toReturn.concat("\n"); //new line
				}
			}
			//---------------------------------------------------
				//Horizontal Doors
			//---------------------------------------------------
			if(i != x_dimension - 1) {
				for(int m = 0; m < 2 * this.x_dimension + 1; m++) {
					if(m % 2 != 0) {
						toReturn = toReturn.concat("-");
					}
					else {	
						toReturn = toReturn.concat("*");
					}
					toReturn = toReturn.concat(" ");
				}
				toReturn = toReturn.concat("\n");
			}
		}
		//---------------------------------------------------
			//Bottom wall
		//---------------------------------------------------
		for(int m = 0; m < 2 * this.x_dimension + 1; m++) {
			toReturn = toReturn.concat("*");
			toReturn = toReturn.concat(" ");
		}
		return toReturn;
	}
}
