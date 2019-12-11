
public class Pit {
	
	public void Pit() {
		
	}
	
	public void damagePit(Hero you) {
		
		you.hp = you.hp - 20;
		System.out.println(you.getName() + " feel into a pit and now has " + you.hp + " left");
	}
}
