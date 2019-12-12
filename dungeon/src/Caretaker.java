import java.util.List;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque; 

public class Caretaker {
	
	final static Deque<dungeonMemento> mementos =  new ArrayDeque();
	
	public dungeonMemento getMemento() {
		
		dungeonMemento gamesave = mementos.pop();
		return gamesave;
	}
	
	public static void addMemento(dungeonMemento memento) {
		
		mementos.push(memento);
	}
}
