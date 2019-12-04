import java.util.List;
import java.util.ArrayList; 
public class Originator
{
	private String state;
	
	public void set(String state)
	{
       this.state = state;
		 System.out.println("Creating save state:  " + state);
	}
	
	 public SaveState saveToSS()
	 {
      
		 System.out.println("Originator: Saving to List.");
		 return new SaveState(this.state);
	 }
    public void restoreFromSS(SaveState ss)
    {
    	 this.state = ss.getSavedState();
    	 System.out.println("Loading save state: " + state);
    }
    
    public static class SaveState {
         private final String state;
   
         public SaveState(String stateToSave) {
 	         state = stateToSave;
         }
   
         private String getSavedState() 
         {
            return state;
         }
   }

}
