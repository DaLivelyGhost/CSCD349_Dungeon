
public class Hero extends DungeonCharacter{
	
	protected int totalHealthPots, totalVisionPots, totalPillars;
	protected double blockChance;
	
	public Hero() {
		this.totalHealthPots = totalHealthPots;
		this.totalVisionPots = totalVisionPots;
		this.totalPillars = totalPillars;
		this.blockChance = blockChance;
	}
	
	//Getters and Setters if you need them
	public int getTotalHealthPots() {
		return this.totalHealthPots;
	}
	
	public int getTotalVisionPots() {
		return this.totalVisionPots;
	}
	
	public int getTotalPillars() {
		return this.totalPillars;
	}
	 
	public void setTotalHealthPots(int totalHealthPots) {
		this.totalHealthPots = totalHealthPots;
	}
	
	public void setTotalVisionPots(int totalVisionPots) {
		this.totalVisionPots = totalVisionPots;
	}
	
	public void setTotalPillars(int totalPillars) {
		this.totalPillars = totalPillars;
	}
	
	public double getBlockChance() {
		return this.blockChance;
	}
	
	public void setBlockChance() {
		this.blockChance = blockChance;
	} //End of getters and setters
	
	public void useVisionPotion(Dungeon Dungeon) {
		Dungeon.vision = true;
	}

	//Create toString();
	@Override
	public String toString() {
		return (this.getName() + " has " + this.getHp() + " hp left.\n" + this.getName() + " also has: " + this.totalHealthPots + " Health pots, " + this.totalVisionPots + " Vision pots, and " + this.totalPillars + " Pillars of OO\n");
		
	}
}

