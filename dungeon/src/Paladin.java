
public  class Paladin extends Hero{
	
	//Safe class that is good at everything
	public Paladin() {
		this.characterType = "Paladin";
		this.hp = 200;
		this.attackSpeed = 1;
		this.hitChance = 0.5;
		this.minDamage = 20;
		this.maxDamage = 340;
		this.blockChance = 0.5;
		this.totalHealthPots = 0;
		this.totalVisionPots = 0;
		this.totalPillars = 0;
		
		Attack specialAttack = new HolyBash();
	}
}
