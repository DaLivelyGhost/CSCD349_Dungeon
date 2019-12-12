import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
public class DungeonSerialization implements Serializable{
	
	static String filename = "gamesaves.txt";
	
	public static void Serialization(dungeonMemento gamesave) throws IOException {
		
		if(filename .equals(null)) {
			throw new IOException("No file with that name please create gamesaves.txt in the source file");
		}
		
        FileOutputStream file = new FileOutputStream(filename); 
        ObjectOutputStream out = new ObjectOutputStream(file); 
        
        out.writeObject(gamesave);
        
        out.close();
        file.close();
        
        System.out.println("Game has been saved to gamesaves.txt\n");
	}
	
	public dungeonMemento Deserialization() throws IOException, ClassNotFoundException {
		
		if(DungeonSerialization.filename .equals(null)) {
			throw new IOException("No file with that name");
		}
		
		dungeonMemento gamesave = new dungeonMemento(null, null);

		
        FileInputStream file = new FileInputStream(DungeonSerialization.filename); 
        ObjectInputStream in = new ObjectInputStream(file); 
        
        gamesave =  (dungeonMemento) in.readObject();
        return gamesave;
	}
}
