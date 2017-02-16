package capgemini.bowling;

public class Roll {

	private int numberOfPins;

	public Roll(int numberOfPins) {
		setNumberOfPins(numberOfPins);
	}

	public int getNumberOfPins() {
		return numberOfPins;
	}

	public void setNumberOfPins(int numberOfPins) {
		this.numberOfPins = numberOfPins;
	}

}
