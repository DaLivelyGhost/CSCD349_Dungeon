
public class Warrior extends Hero{
	
	//Safe damage class, but needs to watch health
	public Warrior() {
		this.characterType = "Warrior";
		this.hp = 300;
		this.attackSpeed = 1;
		this.hitChance = 0.5;
		this.minDamage = 10;
		this.maxDamage = 50;
		this.blockChance = 0.3;
		this.totalHealthPots = 0;
		this.totalVisionPots = 0;
		this.totalPillars = 0;
		Attack specialAttack = new CrushingBlow();
	}

}