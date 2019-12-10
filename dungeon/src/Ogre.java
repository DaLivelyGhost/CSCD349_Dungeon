public  class Ogre extends Monster {
   public Ogre()
	{
      this.name = "Ogre";
      this.hp = 200;
      this.attackSpeed = 2;
      this.hitChance = .6;
      this.healChance = .1;
      this.minDamage = 30;
      this.maxDamage = 50;
      this.minHeal = 30;
      this.maxHeal = 50;
    }
}