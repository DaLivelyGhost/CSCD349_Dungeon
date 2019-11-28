
public class Room {
	Object[] content;
	int x;			//Coordinates
	int y;
	int objectNumber;	//number of objects, not in use yet, but will be later.
	
	public Room(int x, int y) {
		this.x = x;
		this.y = y;
		this.content = new Object[10];
	}
	public void populateRoom(Object item) {	//IN PROGRESS
		int i;
		for(i = 0; i < content.length && content[i] != null; i++) {} //find the first null entry in the array
		content[i] = item;
		this.objectNumber++;	//this literally doesn't do anything yet
	}
	@Override
	public String toString() {	//IN PROGRESS
		return "[" + this.x + "," + this.y + "]";
	}
}
