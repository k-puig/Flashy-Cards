package com.kpuig.flashycards.cards.quiz;

import java.util.ArrayList;
import java.util.List;

public class Question {
    public static final int UNANSWERED = -1;
    public static final String UNANSWERED_STRING = "UNANSWERED";

    private String question;
    private ArrayList<String> answers;
    private int correctAnswerIndex;
    private int userAnswerIndex;

    public Question(String question, ArrayList<String> answers, int correctAnswerIndex) {
        this.question = question;
        this.answers = answers;
        this.correctAnswerIndex = correctAnswerIndex;
        this.userAnswerIndex = UNANSWERED;

        while (answers.size() < FlashCardQuiz.ANSWERS_PER_QUESTION) {
            answers.add("");
        }
    }

    public void answerQuestion(int userAnswer) {
        this.userAnswerIndex = userAnswer;
    }

    public boolean isCorrect() {
        return correctAnswerIndex == userAnswerIndex;
    }

    public String getQuestion() {
        return this.question;
    }

    public int getUserAnswerIndex() {
        return this.userAnswerIndex;
    }

    public String getUserAnswer() {
        if (userAnswerIndex < 0 || userAnswerIndex >= answers.size())
            return UNANSWERED_STRING;
        return answers.get(userAnswerIndex);
    }

    public String getCorrectAnswer() {
        return answers.get(correctAnswerIndex);
    }

    public String getOrBlank(int index) {
        if (index >= answers.size() || index < 0)
            return "";
        return answers.get(index);
    }

    public List<String> getAnswers() {
        return this.answers;
    }

    @Override
    public int hashCode() {
        // this.userAnswerIndex omitted because the hashcode should not change depending on runtime conditions, especially user input
        return question.hashCode() ^ answers.hashCode() ^ correctAnswerIndex;
    }
}
