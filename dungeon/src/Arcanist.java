
public  class Arcanist extends Hero{
	
	//Chance based class, but starts with 3 health pots
	public Arcanist() {
		this.characterType = "Arcanist";
		this.hp = 100;
		this.attackSpeed = 2;
		this.hitChance = 0.8;
		this.minDamage = 5;
		this.maxDamage = 30;
		this.blockChance = 0.25;
		this.totalHealthPots = 3;
		this.totalVisionPots = 0;
		this.totalPillars = 0;
		
		Attack specialAttack = new FireBomb();
	}
}
