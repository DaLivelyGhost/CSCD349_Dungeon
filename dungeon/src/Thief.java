
public class Thief extends Hero{
	
	public Thief() {
		this.characterType = "Thief";
		this.hp = 100;
		this.attackSpeed = 1;
		this.hitChance = 0.5;
		this.minDamage = 10;
		this.maxDamage = 30;
		this.blockChance = 0.3;
		
		Attack specialAttack = new SupriseAttack();
	}
}
