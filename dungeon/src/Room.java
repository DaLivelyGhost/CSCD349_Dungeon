
public class Room {
	Object[] content;
	int x;			//Coordinates
	int y;
	int objectNumber;	//number of objects, not in use yet, but will be later.
	String icon;
	
	public Room(int x, int y) {
		this.x = x;							//coordinates
		this.y = y;
		this.content = new Object[10];		//array to hold everything in the room
		this.objectNumber = 0;				//number of objects in the room
		icon = "E";							//contents of room (currently empty)
	}
	public void populateRoom(Object item) {	//IN PROGRESS
		int i;
		for(i = 0; i < content.length && content[i] != null; i++) {} //find the first null entry in the array
		content[i] = item;
		this.objectNumber++;	//this literally doesn't do anything yet
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
}
