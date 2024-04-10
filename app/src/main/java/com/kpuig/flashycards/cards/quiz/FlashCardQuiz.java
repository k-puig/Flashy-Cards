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
        // TODO: Implement this method such that the highest score is 1.0 (100%) and lowest is 0.0 (0%)
        throw new UnsupportedOperationException("Unimplemented method");
    }

    public void answerQuestion(int questionIndex, int answer) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Unimplemented method");
    } 

}
