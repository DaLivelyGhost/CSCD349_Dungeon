
public class Potion_healing{
	
	int healpot;
	
	public void Potion_healing() {
		this.healpot = healpot;
	}
	
	public void addHealthPot(Hero player) {
		player.totalHealthPots++;
	}
	
	public static void useHealingPotion(Hero player) {
		
		if(player.getTotalHealthPots() > 0) {
		player.hp = player.getHp() + 10;
		System.out.println(player.getName() + " used the healing potion and healed for 10 hp! You have " + player.totalHealthPots + " left!");
		} else {
			System.out.println(player.getName() + " ypu don't have any health pots left!");
		}
	}
}
