package com.kpuig.flashycards.ui.controllers.quiz;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import com.kpuig.flashycards.cards.quiz.FlashCardQuiz;
import com.kpuig.flashycards.cards.quiz.Question;

public class FlashCardQuizController {

    @FXML private Label questionLabel;
    @FXML private RadioButton optionNone;
    @FXML private RadioButton option1;
    @FXML private RadioButton option2;
    @FXML private RadioButton option3;
    @FXML private RadioButton option4;
    @FXML private ToggleGroup optionsGroup;
    @FXML private TextField questionIndexField;
    @FXML private Label totalQuestionsLabel;

    private FlashCardQuiz quiz;
    private int currentIndex = 0;

    @FXML private Button finishButton;

    @FXML
    private void handlePrevious() {
        answerQuestion();
        if (currentIndex > 0) {
            currentIndex--;
            updateQuestionDisplay();
        }
    }

    @FXML
    private void handleNext() {
        answerQuestion();
        if (currentIndex < quiz.getQuestions().size() - 1) {
            currentIndex++;
            updateQuestionDisplay();
        }
    }

    @FXML
    private void handleJump() {
        answerQuestion();
        try {
            int index = Integer.parseInt(questionIndexField.getText()) - 1;
            if (index >= 0 && index < quiz.getQuestions().size()) {
                currentIndex = index;
                updateQuestionDisplay();
            }
        } catch (NumberFormatException e) {
            // Handle error or ignore
            e.printStackTrace();
        }
    }

    @FXML
    private void handleFinish() {
        answerQuestion();
        Stage stage = (Stage) finishButton.getScene().getWindow();
        stage.close();
    }

    private void updateQuestionDisplay() {
        Toggle[] toggles = new Toggle[]{
            option1,
            option2,
            option3,
            option4,
        };

        Question currentQuestion = quiz.getQuestions().get(currentIndex);
        questionLabel.setText(currentQuestion.getQuestion());
        option1.setText(currentQuestion.getOrBlank(0));
        option2.setText(currentQuestion.getOrBlank(1));
        option3.setText(currentQuestion.getOrBlank(2));
        option4.setText(currentQuestion.getOrBlank(3));
        questionIndexField.setText(String.valueOf(currentIndex + 1));
        totalQuestionsLabel.setText(String.valueOf(quiz.getQuestions().size()));
        if (currentQuestion.getUserAnswerIndex() != Question.UNANSWERED)
            optionsGroup.selectToggle(toggles[currentQuestion.getUserAnswerIndex()]);
        else
            optionsGroup.selectToggle(optionNone);
    }

    private void answerQuestion() {
        Question currentQuestion = quiz.getQuestions().get(currentIndex);
        Toggle[] toggles = new Toggle[]{
            option1,
            option2,
            option3,
            option4,
        };

        boolean answered = false;
        int i = 0;
        for (Toggle t : toggles) {
            if (t.isSelected()) {
                currentQuestion.answerQuestion(i);
                answered = true;
                break;
            }
            i++;
        }
        if (!answered) {
            currentQuestion.answerQuestion(Question.UNANSWERED);
        }
    }

    public void setQuiz(FlashCardQuiz quiz) {
        this.quiz = quiz;
        updateQuestionDisplay();
    }

    public FlashCardQuiz getQuiz() {
        return quiz;
    }
}
