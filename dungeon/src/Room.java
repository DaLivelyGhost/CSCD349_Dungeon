import java.util.Random;

public class Room {
	Object[] content;
	int x;			//Coordinates
	int y;
	int objectNumber;	//number of objects, not in use yet, but will be later.
	String icon;
	
	public Room(int x, int y) {
		this.x = x;							//coordinates
		this.y = y;
		this.content = new Object[7];		//array to hold everything in the room
		this.objectNumber = 0;				//number of objects in the room
		icon = "E";							//contents of room (currently empty)
	}
	public void populateRoom(Object item) {	//IN PROGRESS
//		int i;
//		for(i = 0; i < content.length && content[i] != null; i++) {} //find the first null entry in the array
//		content[i] = item;
		if(item instanceof Pit) {	//0 for pits
			this.content[0] = item;
			this.setIcon("P");
		}
		if(item instanceof entrance) {	//1 for entrance
			this.content[1] = item;
			this.setIcon("I");
		}
		if(item instanceof exit) {	//2 for exit
			this.content[2] = item;
			this.setIcon("O");
		}
		if(item instanceof Pillar_of_OO) {	//3 for pillar
			this.content[3] = item;
			this.setIcon("$");
		}
		if(item instanceof Potion_healing) {	//4 for healing potion
			this.content[4] = item;
			this.setIcon("H");
		}
		if(item instanceof Potion_vision) {		//5 for vision potion
			this.content[5] = item;
			this.setIcon("V");
		}
		if(item instanceof DungeonCharacter) {	//6 for monster
			this.content[6] = item;
			this.setIcon("X");
		}
		this.objectNumber++;
	}
	public void setIcon(String icon) {
		if(this.objectNumber > 1) {
			this.icon = "M";
		}
		else {
			this.icon = icon;
		}
	}
	public void deleteContents() {
		for(Object item: this.content) {
			item = null;
		}
		this.objectNumber = 0;
	}
	@Override
	public String toString() {	//IN PROGRESS
		return this.icon;
	}
	public String roomEnter() {
		String output = "";
		Random rng = new Random();
		int r = rng.nextInt(4);
		
		if(this.content[6] != null) {
			output = output.concat("Monster attack!");
		}
		if(this.icon.compareTo("E") == 0) {
			output.concat("The room's empty!");
		}
		else {
			switch(r) {
			case 0: output = output.concat("A corpse is sticking out of rubble in the corner of the room. After searching the rubble, you find some items of use.\n");
				break;
			case 1: output = output.concat("It's hard to make out the contents of the dimly lit room, but upon investigation, you find some items worth keeping.\n");
				break;
			case 2: output = output.concat("The hole in the ceiling lets in just enough light to make out the contents of the room.\n");
				break;
			case 3: output = output.concat("Torches line the walls in this room illuminating a chest in the center.\n");
			}
			
		}
		return output;
	}
}
