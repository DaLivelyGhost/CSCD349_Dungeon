
public  class Thief extends Hero{
	
	//Chance based class
	public Thief() {
		this.characterType = "Thief";
		this.hp = 100;
		this.attackSpeed = 1;
		this.hitChance = 0.5;
		this.minDamage = 10;
		this.maxDamage = 30;
		this.blockChance = 0.3;
		this.totalHealthPots = 0;
		this.totalVisionPots = 0;
		this.totalPillars = 0;
		
		Attack specialAttack = new SupriseAttack();
	}
}
