package loopTests;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import proj.polypong.Score;

public class ScoreboardLoops {
	
	@Test
	public void testScoreLoop1() {
		
		List<Score> scores = Score.getScores("test1.txt");
		// test to see if loop ran 3 times
		// because there are 3 scores in test file
		assertTrue(scores.size() == 3);
	}
	
	@Test
	public void testScoreLoopNoScores() {
		List<Score> scores = Score.getScores("test2.txt");
		// loop should not run here, so size 0
		assertTrue(scores.size() == 0);
		
	}

}
