package capgemini.bowlingtest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import capgemini.bowling.BowlingResultCalculator;

public class BowlingResultCalculatorTest {
	BowlingResultCalculator game;

	@Before
	public void setUp() {
		game = new BowlingResultCalculator();
	}

	@Test
	public void shouldScoreBe0WhenNUmberOfPins0() {

		// given
		// when
		game.roll(0);
		game.roll(0);
		// Then
		assertEquals(0, game.score());
	}

	@Test
	public void shouldScoreBeNumberOfPins() {

		// given
		// when
		game.roll(5);
		game.roll(5);
		// Then
		assertEquals(10, game.score());
	}

	@Test
	public void shouldScoreBeWithStrikeAndSpareBonusAfterInFourRoll() {
		// when
		game.roll(10);
		game.roll(9);
		game.roll(1);
		game.roll(5);
		// then
		assertEquals(40, game.score());
	}

	@Test
	public void shouldScoreBeWithStrikeBonusAfterThreeRolls() {
		// when
		game.roll(10);
		game.roll(9);
		game.roll(1);
		// then
		assertEquals(30, game.score());
	}

	@Test
	public void shouldScoreBeWithSpareBonusAfterThreeRolls() {
		// when
		game.roll(9);
		game.roll(1);
		game.roll(1);
		// then
		assertEquals(12, game.score());
	}

	@Test
	public void shouldScoreBeWithSpareBonusAfterFourRolls() {
		// when
		game.roll(9);
		game.roll(1);
		game.roll(1);
		game.roll(5);
		// then
		assertEquals(17, game.score());
	}

	@Test
	public void shouldScoreBeWithStrikeWhenStrikeThreeTimes() {
		// when
		game.roll(10);
		game.roll(10);
		game.roll(10);
		game.roll(9);
		game.roll(0);
		// then
		System.out.println(game.score());
		assertEquals(87, game.score());
	}

	@Test
	public void isFinishedWithoutSpareBonusOrStrikeBonus() {
		// when
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		// then
		assertTrue(game.isFinished());
	}

	@Test
	public void isFinishedWithSpareBonus() {
		// when
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(5);
		game.roll(5); //ostatni frame spare
		game.roll(1);
		// then
		assertTrue(game.isFinished());
	}

	@Test
	public void isFinishedWithStrikeBonus() {
		// when
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(1);
		game.roll(10); //ostatni frame strike
		game.roll(5);
		game.roll(5);
		// then
		assertTrue(game.isFinished());
	}
}