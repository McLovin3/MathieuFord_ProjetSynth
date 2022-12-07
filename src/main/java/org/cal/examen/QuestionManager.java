package org.cal.examen;

import java.util.LinkedList;

public class QuestionManager {
    LinkedList<String> popQuestions = new LinkedList<>();
    LinkedList<String> scienceQuestions = new LinkedList<>();
    LinkedList<String> sportsQuestions = new LinkedList<>();
    LinkedList<String> rockQuestions = new LinkedList<>();

    public QuestionManager(int nbCards) {
        for (int i = 0; i < nbCards; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast("Science Question " + i);
            sportsQuestions.addLast("Sports Question " + i);
            rockQuestions.addLast("Rock Question " + i);
        }
    }

    public void askQuestion(Category category) {
        switch (category) {
            case POP -> System.out.println(popQuestions.removeFirst());
            case SCIENCE -> System.out.println(scienceQuestions.removeFirst());
            case SPORTS -> System.out.println(sportsQuestions.removeFirst());
            case ROCK -> System.out.println(rockQuestions.removeFirst());
        }
    }
}
