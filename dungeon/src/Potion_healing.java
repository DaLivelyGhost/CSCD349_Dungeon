import java.util.Random;

public class Potion_healing{
	
	int healpot;
	
	public void Potion_healing() {
		this.healpot = healpot;
	}
	
	public void addHealthPot(Hero player) {
		player.totalHealthPots++;
	}
	
	public static void useHealingPotion(Hero player) {
		
		Random r = new Random();
		
		if(player.getTotalHealthPots() > 0) {
		player.hp = player.getHp() + 15 - r.nextInt(10);
		player.totalHealthPots--;
		System.out.println(player.getName() + " used the healing potion and now has " + player.totalHealthPots + " left!");
		} else {
			System.out.println(player.getName() + " you don't have any health pots left!");
		}
	}
}
