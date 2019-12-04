
public class SaveList {
	  public static void main(String[] args)
	  {
		  List<Originator.SaveState> savedStates = new ArrayList<Originator.SaveState>();
      Originator ss = new Originator();
      ss.set("State1");
      ss.set("State2");
      savedStates.add(ss.saveToSS());
      ss.set("State3");
      // We can request multiple mementos, and choose which one to roll back to.
      savedStates.add(ss.saveToSS());
      ss.set("State4");
      ss.restoreFromSS(savedStates.get(1));       } 
}
