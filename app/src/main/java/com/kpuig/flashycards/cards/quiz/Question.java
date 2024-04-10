package com.kpuig.flashycards.cards.quiz;

import java.util.ArrayList;

public class Question {
    private static final int UNANSWERED = -1;

    private String question;
    private ArrayList<String> answers;
    private int correctAnswerIndex;
    private int userAnswerIndex;

    public Question(String question, ArrayList<String> answers, int correctAnswerIndex) {
        this.question = question;
        this.answers = answers;
        this.correctAnswerIndex = correctAnswerIndex;
        this.userAnswerIndex = UNANSWERED;
    }

    public void answerQuestion(int userAnswer) {
        if (userAnswer < 0 || userAnswer >= answers.size())
            throw new ArrayIndexOutOfBoundsException("Invalid user answer index supplied: " + userAnswer);
        this.userAnswerIndex = userAnswer;
    }

    public boolean isCorrect() {
        return correctAnswerIndex == userAnswerIndex;
    }

    public String getUserAnswer() {
        return answers.get(userAnswerIndex);
    }

    public String getCorrectAnswer() {
        return answers.get(correctAnswerIndex);
    }

    @Override
    public int hashCode() {
        // this.userAnswerIndex omitted because the hashcode should not change depending on runtime conditions, especially user input
        return question.hashCode() ^ answers.hashCode() ^ correctAnswerIndex;
    }
}
