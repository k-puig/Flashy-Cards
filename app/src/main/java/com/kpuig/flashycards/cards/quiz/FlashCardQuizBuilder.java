package com.kpuig.flashycards.cards.quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.kpuig.flashycards.cards.FlashCard;

public final class FlashCardQuizBuilder {
    private static Random random = new Random();

    private FlashCardQuizBuilder() {
        // No body here
    }

    public static FlashCardQuiz createNewRandomQuiz(ArrayList<FlashCard> cards) {
        // List that stores selected flashcards
        ArrayList<Question> questions = new ArrayList<>();
        // For each loop that goes through the cards on the list
        for (FlashCard card : cards) {
            ArrayList<String> answers = new ArrayList<>();
            answers.add(card.back); //Correct answer
            //Shuffled distractors
            int answersLeft = cards.size();
            for (int k = 0; k < Math.min(FlashCardQuiz.ANSWERS_PER_QUESTION, cards.size()); k++) {
                int randomIndex = random.nextInt(cards.size());
                answersLeft--;
                while (answers.contains(cards.get(randomIndex).back) && answersLeft > 0) {
                    randomIndex = random.nextInt(cards.size());
                }
                answers.add(cards.get(randomIndex).back);
            }
            //Shuffled answers
            for (int j = answers.size() - 1; j > 0; j--) {
                int k = random.nextInt(j + 1);
                String tempAnswer = answers.get(j);
                answers.set(j, answers.get(k));
                answers.set(k, tempAnswer);
            }
            //Find index of correct answer
            int correctAnswerIndex = answers.indexOf(card.back);
            //Creates question with correct answer shuffled
            questions.add(new Question(card.front, answers, correctAnswerIndex));
        }

        return new FlashCardQuiz(questions);
        
    }

    public static FlashCardQuiz createNewRandomQuiz(List<FlashCard> cards) {
        ArrayList<FlashCard> cardsArr = new ArrayList<>();
        for (FlashCard fc : cards) {
            cardsArr.add(fc);
        }
        return createNewRandomQuiz(cardsArr);
    }

}
