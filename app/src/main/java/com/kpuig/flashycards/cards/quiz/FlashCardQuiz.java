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
        
        int totalQuestions = questions.size();
        if(totalQuestions == 0 ){
            return 0.0;
        }

        int correctAnswers = 0;// counts the correct answers
        for(Question question : questions){// iterate through question for correct answers
            if(question.isCorrect()){
                correctAnswers++;
            }//end if
        }// end for

        return (double) correctAnswers /totalQuestions;// return score

       // throw new UnsupportedOperationException("Unimplemented method");
       
    }//end of get score

    public void answerQuestion(int questionIndex, int answer) {
        if(questionIndex >= 0 && questionIndex < questions.size()){
            questions.get(questionIndex).answerQuestion(answer);
        } else{
            throw new IllegalArgumentException("Invalid question Index");
        }


        // TODO: Implement this method
        //throw new UnsupportedOperationException("Unimplemented method");
    } 

}
