
public  class Arcanist extends Hero{
	
	public Arcanist() {
		this.characterType = "Arcanist";
		this.hp = 100;
		this.attackSpeed = 1;
		this.hitChance = 0.5;
		this.minDamage = 10;
		this.maxDamage = 30;
		this.blockChance = 0.3;
		
		Attack specialAttack = new FireBomb();
	}
}
