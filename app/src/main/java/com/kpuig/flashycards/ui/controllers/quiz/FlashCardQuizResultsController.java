package com.kpuig.flashycards.ui.controllers.quiz;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.ListCell;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

import com.kpuig.flashycards.cards.quiz.FlashCardQuiz;
import com.kpuig.flashycards.cards.quiz.Question;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FlashCardQuizResultsController {

    @FXML private Text scoreText;
    @FXML private ListView<ResultItem> resultsList;

    private FlashCardQuiz questions;
    private List<Boolean> answersCorrect;

    public void setQuiz(FlashCardQuiz questions) {
        this.questions = questions;
        this.answersCorrect = new ArrayList<>();
        for (Question q : questions.getQuestions()) {
            answersCorrect.add(q.isCorrect());
        }
        updateResults();
    }

    private void updateResults() {
        ObservableList<ResultItem> items = FXCollections.observableArrayList();
        int score = 0;
        for (int i = 0; i < questions.getQuestions().size(); i++) {
            Question q = questions.getQuestions().get(i);
            boolean correct = answersCorrect.get(i);
            if (correct) {
                score++;
            }
            items.add(new ResultItem(q.getQuestion(), q.getCorrectAnswer(), q.getUserAnswer(), correct));
        }
        resultsList.setItems(items);
        resultsList.setCellFactory(param -> new ListCell<ResultItem>() {
            @Override
            protected void updateItem(ResultItem item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.question + "\nCorrect Answer: " + item.correctAnswer + " | " + "Your Answer: " + item.userAnswer + ", " + (item.wasCorrect ? "Correct" : "Incorrect"));
                }
            }
        });
        scoreText.setText("Your score: " + score + "/" + questions.getQuestions().size() + " (" + toPercentage(questions.getScore()) + ")");
    }

    private static String toPercentage(double score) {
        StringBuilder scoreStr = new StringBuilder();
        score *= 100;
        scoreStr.append((int) score);
        scoreStr.append(".");

        score -= (int) (score);
        score *= 100;
        scoreStr.append((int) score);
        scoreStr.append("%");

        return scoreStr.toString();
    }

    public static class ResultItem {
        String question;
        String correctAnswer;
        String userAnswer;
        boolean wasCorrect;

        ResultItem(String question, String correctAnswer, String userAnswer, boolean wasCorrect) {
            this.question = question;
            this.correctAnswer = correctAnswer;
            this.userAnswer = userAnswer;
            this.wasCorrect = wasCorrect;
        }
    }
}
