import java.io.Serializable;
import java.util.Random;

public class Pit implements Serializable{
	
	public Pit() {
		
	}
	
	public void damagePit(Hero player) {
		
		Random r = new Random();
		
		player.hp = player.hp - (20 - r.nextInt(19));
		CombatView.pitFall(player);
	}
}
