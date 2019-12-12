import java.io.Serializable;

public  class Ogre extends Monster implements Serializable{
   public Ogre()
	{
      this.name = "Ogre";
      this.hp = 200;
      this.attackSpeed = 2;
      this.hitChance = .6;
      this.healChance = .1;
      this.minDamage = 10;
      this.maxDamage = 50;
      this.minHeal = 30;
      this.maxHeal = 50;
    }
}