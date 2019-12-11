
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
	
	public void useVisionPotion() {
		
	}
	//Methods to add items
	public void addHealingPotion() {
		totalHealthPots++;
	}
	
	public void addVisionPoiton() {
		totalHealthPots++;
	}
	
	public void addPillar() {
		totalPillars++;
	}
	//Create toString();
}

