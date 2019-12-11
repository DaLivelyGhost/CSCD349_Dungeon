import java.util.List;
import java.util.ArrayList; 

public class Caretaker {
	  public void Saves()
	  {
         List<Originator.SaveState> savedStates = new ArrayList<Originator.SaveState>();
         Originator ss = new Originator();
         ss.set("State1");
         ss.set("State2");
         savedStates.add(ss.saveToMomento());
         ss.set("State3");
         savedStates.add(ss.saveToMomento());
         ss.set("State4");
         ss.restoreFromSS(savedStates.get(1));       } 
}
