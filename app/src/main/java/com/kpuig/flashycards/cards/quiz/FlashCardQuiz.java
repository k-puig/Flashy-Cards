package com.kpuig.flashycards.cards.quiz;

import java.util.ArrayList;

public class FlashCardQuiz {
    // Make use of this constant when building quizzes
    public static final int ANSWERS_PER_QUESTION = 4;

    private ArrayList<Question> questions;

    public FlashCardQuiz(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public ArrayList<Question> getQuestions() {
        return this.questions;
    }

    // Inclusive Range [0.0, 1.0]
    public double getScore() {
        int totalQuestions = questions.size();
        if (totalQuestions == 0 ) {
            return 0.0;
        }

        int correctAnswers = 0;
        for (Question question : questions) {
            if (question.isCorrect()) {
                correctAnswers++;
            }
        }

        return (double) correctAnswers / totalQuestions;
       
    }

    public void answerQuestion(int questionIndex, int answer) {
        if (questionIndex >= 0 && questionIndex < questions.size()) {
            questions.get(questionIndex).answerQuestion(answer);
        }
    } 

}
