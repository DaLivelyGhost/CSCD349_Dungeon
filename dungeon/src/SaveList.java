import java.util.List;
import java.util.ArrayList;
public class SaveList 
{
   public static void main(String[] args)
   {
      List<Originator.SaveState> savedStates = new ArrayList<Originator.SaveState>();
      Originator o = new Originator();
      o.set("State1");
      o.set("State2");
      savedStates.add(o.saveToSS());
      o.set("State3");
      
      savedStates.add(o.saveToSS());
      o.set("State4");
      o.restoreFromSS(savedStates.get(1));
   } 
}
