package capgemini.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingResultCalculator implements IBowlingResultCalculator {

	private int maxNumberOfFrames = 10;
	private List<Frame> frames = new ArrayList<Frame>();

	public BowlingResultCalculator() {
		Frame firstFrame = new Frame();
		frames.add(firstFrame);
	}

	/**
	 * Register a thrown a ball.
	 * 
	 * @param numberOfPins
	 *            number of knocked down pins
	 */
	public void roll(int numberOfPins) {
		if (isFinished() == true) {
			System.out.println(" Game Finished");
			return;
		}
		Roll roll = new Roll(numberOfPins);
		Frame currentFrame = this.frames.get(this.frames.size() - 1);
		currentFrame.getRollListInFrame().add(roll);
		boolean newFrame = false;
		boolean lastFrame = false;
		if (frames.size() == 10) {
			lastFrame = true;
		}

		if (numberOfPins == 10) { // Strike
			currentFrame.setStrike(true);
			newFrame = true;
		} else if (currentFrame.getFrameScore() == 10) { // Spare
			currentFrame.setSpare(true);
			newFrame = true;
		} else if (currentFrame.getRollListInFrame().size() == 2) {
			newFrame = true;
		}

		addBonus(roll);

		if (newFrame && lastFrame == false) {
			Frame nextFrame = new Frame();
			this.frames.add(nextFrame);
		}
	}

	private void addBonus(Roll roll) {
		if (frames.size() > 1) {
			Frame previous = frames.get(frames.size() - 2);
			addBonusToFrame(roll, previous);
		}

		if (frames.size() > 2) {
			Frame prePrevious = frames.get(frames.size() - 3);
			addBonusToFrame(roll, prePrevious);
		}
	}

	private void addBonusToFrame(Roll roll, Frame frame) {
		if ((frame.isStrike() || frame.isSpare()) && frame.getRollListInFrame().size() < 3) {
			frame.getRollListInFrame().add(roll);
		}

	}

	/**
	 * @return current game score
	 */
	public int score() {
		int score = 0;
		for (Frame frame : frames) {
			score += frame.getFrameScore();
		}
		return score;
	}

	/**
	 * @return true if a game is over, otherwise false
	 */
	public boolean isFinished() {
		boolean finished = false;
		if (frames.size() == maxNumberOfFrames) {
			Frame lastFrame = frames.get(frames.size() - 1);
			if (lastFrame.isStrike() || lastFrame.isSpare()) {
				if (lastFrame.getRollListInFrame().size() == 3) {
					finished = true;
				}
			} else if (lastFrame.getRollListInFrame().size() == 2) {
				finished = true;
			}
		}
		return finished;
	}
}
