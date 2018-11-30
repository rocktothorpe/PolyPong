package proj.polypong;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Score {
	String name;
	Integer score;
	Score(String name, Integer score) {
		this.name = name;
		this.score = score;
	}
	public String toString() {
		return name + " " + score.toString();
	}
	public static Vector<Score> getScores() {
		File file = new File("scores.txt");
		try {
			file.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Scanner sc;
		Vector<Score> scores = new Vector<Score>();
		try {
			sc = new Scanner(file);
		    while (sc.hasNextLine()) {
		    	String scoreArr[] = sc.nextLine().split("\\s+");
		    	String name = scoreArr[0];
		    	int score = Integer.parseInt(scoreArr[1]);
		    	Score tempScore = new Score(name, score);
		    	scores.add(tempScore);
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return scores;
	}
	public static void writeToFile(Vector<Score> scores) {
	    BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("scores.txt"));
		    for (int i = 0; i < scores.size(); i++) {
		    	writer.write(scores.get(i).toString() + "\n");
	    	}
		    writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
