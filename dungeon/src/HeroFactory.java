
public class HeroFactory {
   
   public DungeonCharacter createHero(int role)
   {
      DungeonCharacter hero = null;
      
      if(role == 1)
      {
         hero = new Warrior();
      }
      else if(role == 2)
      {
         hero = new Sorceress();
      }
      else if(role == 3)
      {
         hero = new Thief();
      }
      return hero;
   }
}
