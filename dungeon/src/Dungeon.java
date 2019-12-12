import java.io.Serializable;
import java.util.Random;

public class Dungeon implements Serializable{
	private Room[][] Room;
	final int x_dimension;
	final int y_dimension;
	int player_x;
	int player_y;
	boolean vision;	//checks if a vision potion has been used (purely for toString);
	
	public Dungeon(int c, int r) {
		this.Room = new Room[c][r];
		this.x_dimension = c;
		this.y_dimension = r;
		vision = false;
		
		for(int i = 0; i < c; i++) {
			for(int j = 0; j < r; j++) {
				Room[i][j] = new Room(i, j);
				populateRooms(Room, i, j);
			}
		}
		distributeExits(this.x_dimension, this.y_dimension);		//Player default location is distributed here. (cuz of the entrance)
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
		if(Room[i][j].icon.compareTo("O") != 0 && Room[i][j].icon.compareTo("I") != 0) {
			if(pit > 8) {					//20% chance
				Room[i][j].populateRoom(new Pit());					//pit item goes here
			}
			if(vision > 8) {				//20% chance
				Room[i][j].populateRoom(new Potion_vision());		//vision potion item goes here
			}
			if(healing > 7) {				//40% chance
				Room[i][j].populateRoom(new Potion_healing());		//healing potion item goes here
			}		
			if(monster > 8) {//20% chance
				int monsterType = r.nextInt(5);
				if(monsterType == 0) {
					Room[i][j].populateRoom(MonsterFactory.makeMonster("Ogre"));
				} //Monster goes here
				if(monsterType == 1) {
					Room[i][j].populateRoom(MonsterFactory.makeMonster("Goblin"));
				}
				if(monsterType == 2) {
					Room[i][j].populateRoom(MonsterFactory.makeMonster("Gremlin"));
				}
				if(monsterType == 3) {
					Room[i][j].populateRoom(MonsterFactory.makeMonster("Skeleton"));
				}
				if(monsterType == 4) {
					Room[i][j].populateRoom(MonsterFactory.makeMonster("Zombie"));
				}	
			}
		}
	}
	private void distributeExits(int x, int y) {
		Random r = new Random();
		int exit_x;
		int exit_y;
		int entrance_x;
		int entrance_y;
		
		do {
			exit_x = r.nextInt(x);
			exit_y = r.nextInt(y);
			entrance_x = r.nextInt(x);
			entrance_y = r.nextInt(y);
		}while((exit_y == entrance_y) && (exit_x == entrance_x));
		
		Room[exit_x][exit_y].deleteContents();
		Room[exit_x][exit_y].populateRoom(new exit());
		Room[exit_x][exit_y].setIcon("O");
		
		Room[entrance_x][entrance_y].deleteContents();
		Room[entrance_x][entrance_y].populateRoom(new entrance());
		Room[entrance_x][entrance_y].setIcon("I");
		
		this.player_x = entrance_x;
		this.player_y = entrance_y;
	}
	private void distributePillars(int x, int y) {
		Random r = new Random();
		int temp1;
		int temp2 ;
		
		for(int i = 0; i < 4; i++) {	//choose 4 random rooms to put a pillar into.
			do {
			temp1 = r.nextInt(x);
			temp2 = r.nextInt(y);
			} while(Room[temp1][temp2].content[1] != null || Room[temp1][temp2].content[2] != null
					|| Room[temp1][temp2].content[3] != null);
			
			Room[temp1][temp2].populateRoom(new Pillar_of_OO());
			Room[temp1][temp2].setIcon("$");
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
		for(int m = 0; m < 2 * this.y_dimension + 1; m++) {
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
				
				if(i == this.player_x && j == this.player_y) {
					toReturn = toReturn.concat("[");
				}
				else {
					toReturn = toReturn.concat(" ");
				}
				if(vision) {
					if(i - player_x <= 1 && i - player_x >= -1) {
						if(j - player_y <= 1 && j - player_y >= -1) {
							toReturn = toReturn.concat(Room[i][j].toString());
						}
						else {
							if(i == this.player_x && j == this.player_y) {
								toReturn = toReturn.concat("]");
							}
							else {
								toReturn = toReturn.concat(" ");
							}
						}
					}
					else {
						if(Room[i][j].visited == true) {
							toReturn = toReturn.concat(Room[i][j].toString());
						}
						else {
							toReturn = toReturn.concat(" ");
						}
					}
				}
				else {
					if((i == player_x && j == player_y) || Room[i][j].visited == true) {
						toReturn = toReturn.concat(Room[i][j].toString());
					}
					else {
						toReturn = toReturn.concat(" ");
					}
				}
				if(j != y_dimension - 1) {
					if(i == this.player_x && j == this.player_y) {
						toReturn = toReturn.concat("]");
					}
					else {
						toReturn = toReturn.concat(" ");
					}
					toReturn = toReturn.concat("|");
				}
				
				if(j == y_dimension - 1) {	
					if(i == player_x && j == player_y) {
						toReturn = toReturn.concat("]");
					}
					else {
						toReturn = toReturn.concat(" ");
					}
					toReturn = toReturn.concat("*");  //Right wall
					toReturn = toReturn.concat("\n"); //new line
				}
			}
			//---------------------------------------------------
				//Horizontal Doors
			//---------------------------------------------------
			if(i != x_dimension - 1) {
				for(int m = 0; m < 2 * this.y_dimension + 1; m++) {
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
		for(int m = 0; m < 2 * this.y_dimension + 1; m++) {
			toReturn = toReturn.concat("*");
			toReturn = toReturn.concat(" ");
		}
		return toReturn;
	}
}

