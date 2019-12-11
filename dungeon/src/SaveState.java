public class SaveState{
	private String state = null;
	
	private SaveState(String stateToSave) {
		state = stateToSave;
	}
	
	private String getSave() {
		return state;
	}
}
