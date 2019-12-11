
public class Potion_healing extends Hero{
	
	int healpot;
	
	public void Potion_healing() {
		this.healpot = healpot;
	}
	
	public void addHealthPot() {
		setTotalHealthPots(this.healpot + 1);
	}
	
	public void useHealingPotion() {
		
		if(this.totalHealthPots > 0) {
		this.hp = this.getHp() + 10;
		System.out.println(this.getName() + " used the healing potion and healed for 10 hp! You have " + this.totalHealthPots + " left!");
		} else {
			System.out.println(this.getName() + " ypu don't have any health pots left!");
		}
	}
}
