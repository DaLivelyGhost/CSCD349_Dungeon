import java.util.List;
import java.util.ArrayList; 
public class Originator
{
	private String state;
	
	public void set(String state)
	{
		 System.out.println("Creating save state:  " + state);
		 this.state = state;
	}
	
	 public SaveState saveToSS()
	 {
		 System.out.println("Originator: Saving to Memento.");
		 return new SaveState(state);
	 }
     public void restoreFromSS(SaveState ss)
     {
    	 state = ss.getSavedState();
    	 System.out.println("Loading save state: " + state);
    	 }
}
