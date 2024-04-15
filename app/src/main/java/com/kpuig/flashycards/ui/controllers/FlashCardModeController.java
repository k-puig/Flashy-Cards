package com.kpuig.flashycards.ui.controllers;

import java.io.File;
import java.io.IOException;

import com.kpuig.flashycards.cards.quiz.FlashCardQuiz;
import com.kpuig.flashycards.cards.quiz.FlashCardQuizBuilder;
import com.kpuig.flashycards.cards.storage.FlashCardSet;
import com.kpuig.flashycards.ui.controllers.editor.FlashCardListController;
import com.kpuig.flashycards.ui.controllers.quiz.FlashCardQuizController;
import com.kpuig.flashycards.ui.controllers.quiz.FlashCardQuizResultsController;
import com.kpuig.flashycards.ui.controllers.viewer.FlashCardViewerController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FlashCardModeController {
    private FlashCardSet cards = null;
    
    @FXML
    private void handleOpen() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open FlashCard JSON File");

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json");
        chooser.getExtensionFilters().add(extFilter);

        File file = chooser.showOpenDialog(null);
        this.cards = new FlashCardSet(file);
    }

    @FXML
    private void handleSave() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open FlashCard JSON File");

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json");
        chooser.getExtensionFilters().add(extFilter);

        File file = chooser.showSaveDialog(null);
        cards.saveToFile(file);
    }

    @FXML
    private void handleView() {
        if (cards == null || cards.getCards().isEmpty()) {
            System.err.println("null cards in view method");
            return;
        }
        System.out.println("view");

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("views/viewer.fxml"));
            Parent root = loader.load();

            FlashCardViewerController viewerController = loader.getController();
            viewerController.setCards(cards);

            Stage stage = new Stage();
            stage.setTitle("View Flashcards");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleQuiz() {
        if (cards == null || cards.getCards().isEmpty()) {
            System.err.println("null cards in quiz method");
            return;
        }
        System.out.println("quiz");

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("views/quiz.fxml"));
            Parent root = loader.load();

            FlashCardQuizController quizController = loader.getController();
            quizController.setQuiz(FlashCardQuizBuilder.createNewRandomQuiz(cards.getCards()));

            Stage stage = new Stage();
            stage.setTitle("Quiz");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.showAndWait();
            FlashCardQuiz quiz = quizController.getQuiz();

            loader = new FXMLLoader(getClass().getClassLoader().getResource("views/quizresults.fxml"));
            root = loader.load();

            FlashCardQuizResultsController resultsController = loader.getController();
            resultsController.setQuiz(quiz);

            stage = new Stage();
            stage.setTitle("Quiz Results");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleEdit() {
        if (cards == null || cards.getCards().isEmpty()) {
            System.err.println("null cards in edit method");
        }
        System.out.println("edit");

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("views/editorlist.fxml"));
            Parent root = loader.load();

            FlashCardListController listController = loader.getController();
            listController.setCards(cards);

            Stage stage = new Stage();
            stage.setTitle("View Flashcards");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
