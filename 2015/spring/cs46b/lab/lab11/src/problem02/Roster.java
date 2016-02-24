package problem02;

import java.util.*;

public class Roster {

    private Map<String, List<Integer>> gradebook;

    public Roster () {
        gradebook = new HashMap<>();
    }
    /**
     * Adds a grade to the end of a list of grades for the named
     student.
     * Should work even if no student with this name has ever been seen
     before.
     * @param name Name of student who is getting the score added.
     * @param score Score being added to student's list of scores.
     */
    public void addGrade(String name, int score) {
        List<Integer> currentValue = gradebook.get(name);
        if (currentValue == null) {
            currentValue = new ArrayList<>();
            gradebook.put(name, currentValue);
        }

        currentValue.add(score);
    }

    /**
     * Gets the specified grade from the named student's scores.
     * @param name Name of student whose grade is requested.
     * @param index Index of the grade requested.
     * @return the score requested.
     */
    public int getGrade(String name, int index) {
        List<Integer> requestedScore = gradebook.get(name);
        return requestedScore.get(index);
    }

    /**
     * Gets the average for the named student.
     * @param name Name of student whose average is requested.
     * @return That students average grade.
     */
    public double getAverage(String name) {
        List<Integer> studentScores = gradebook.get(name);
        if (studentScores.size() == 0) { return 0.0; }

        double avg = 0.0;
        for (int score : studentScores) {
            avg += score;
        }

        return (studentScores.size() > 1) ? avg / gradebook.size() : avg;
    }
}