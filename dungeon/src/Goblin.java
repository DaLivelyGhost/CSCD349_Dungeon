public class Goblin extends Monster{
   public Goblin()
	{
      this.name = "Goblin";
      this.hp = 50;
      this.attackSpeed = 10;
      this.hitChance = .9;
      this.healChance = .1;
      this.minDamage = 10;
      this.maxDamage = 20;
      this.minHeal = 40;
      this.maxHeal = 60;
    }
}