import java.io.Serializable;

public  class Gremlin extends Monster implements Serializable{
   public Gremlin()
   {
      this.name = "Gremlin";
      this.hp = 70;
      this.attackSpeed = 5;
      this.hitChance = .8;
      this.healChance = .4;
      this.minDamage = 15;
      this.maxDamage = 30;
      this.minHeal = 20;
      this.maxHeal = 40;

   }

}