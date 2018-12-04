package proj.polypong;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Score {
	String name;
	Integer scoreVal;
	public Score(String name, Integer score) {
		this.name = name;
		this.scoreVal = score;
	}
	public String toString() {
		return name + " " + scoreVal.toString();
	}
	public static List<Score> getScores() {
		File file = new File("scores.txt");
		try {
			file.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Scanner sc;
		List<Score> scores = new ArrayList<>();
		try {
			sc = new Scanner(file);
		    while (sc.hasNextLine()) {
		    	String[] scoreArr= sc.nextLine().split("\\s+");
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
	public static void writeToFile(List<Score> scores) {
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
