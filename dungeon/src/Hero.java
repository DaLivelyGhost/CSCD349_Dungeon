
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
	
	public void useHealingPotion() {
		
		if(this.totalHealthPots > 0) {
		this.hp = this.getHp() + 10;
		System.out.println(this.getName() + " used the healing potion and healed for 10 hp! You have " + this.totalHealthPots + " left!");
		} else {
			System.out.println(this.getName() + " ypu don't have any health pots left!");
		}
	}
	
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

