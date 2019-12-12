import java.util.Random;

public class Potion_healing{
	
	int healpot;
	
	public Potion_healing() {
		this.healpot = healpot;
	}
	
	public void addHealthPot(Hero player) {
		player.totalHealthPots++;
	}
	
	public static void useHealingPotion(Hero player) {
		
		Random r = new Random();
		
		player.hp = player.getHp() + 15 - r.nextInt(10);
		player.totalHealthPots--;
		GameView.drinkHealthPotion(player);
	}
}
