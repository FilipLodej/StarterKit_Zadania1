package capgemini.bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {

	private List<Roll> rollListInFrame;
	boolean strike = false;
	boolean spare = false;

	public Frame() {
		rollListInFrame = new ArrayList<Roll>();
	}

	public int getFrameScore() {
		int frameScore = 0;
		for (Roll roll : rollListInFrame) {
			frameScore += roll.getNumberOfPins();
		}
		return frameScore;
	}

	public List<Roll> getRollListInFrame() {
		return rollListInFrame;
	}

	public void setRollListInFrame(List<Roll> rollListInFrame) {
		this.rollListInFrame = rollListInFrame;
	}

	public boolean isStrike() {
		return strike;
	}

	public boolean isSpare() {
		return spare;
	}

	public void setSpare(boolean spare) {
		this.spare = spare;
	}

	public void setStrike(boolean strike) {
		this.strike = strike;
	}

}
