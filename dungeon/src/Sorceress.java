
public  class Sorceress extends Hero{
	
	//Another safe class which is easy to use
	public Sorceress() {
		this.characterType = "Sorceress";
		this.hp = 150;
		this.attackSpeed = 2;
		this.hitChance = 0.6;
		this.minDamage = 20;
		this.maxDamage = 30;
		this.blockChance = 0.1;
		this.totalHealthPots = 0;
		this.totalVisionPots = 0;
		this.totalPillars = 0;
		
		Attack specialAttack = new SpecialHeal();
	}
}
