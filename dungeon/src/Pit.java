import java.util.Random;

public class Pit {
	
	public void Pit() {
		
	}
	
	public void damagePit(Hero player) {
		
		Random r = new Random();
		
		player.hp = player.hp - (20 - r.nextInt(19));
		System.out.println(player.getName() + " feel into a pit and now has " + player.hp + " left");
	}
}
