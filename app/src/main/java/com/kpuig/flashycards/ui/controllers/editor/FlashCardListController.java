package com.kpuig.flashycards.ui.controllers.editor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import java.util.ArrayList;
import java.util.List;

import com.kpuig.flashycards.cards.FlashCard;

public class FlashCardListController {

    @FXML
    private ListView<String> flashcardListView;

    private List<FlashCard> cards = new ArrayList<>();

    @FXML
    public void initialize() {
        // Sample data
        cards.add(new FlashCard("The President of the United States", "George Washington"));
        cards.add(new FlashCard("The sum of 2 and 2", "4"));
        cards.add(new FlashCard("The powerhouse of the cell", "Mitochondria"));
        cards.add(new FlashCard("The derivative of e^x", "e^x"));
        cards.add(new FlashCard("A classic book called The Great _____", "Gatsby"));

        for (FlashCard flashcard : cards) {
            flashcardListView.getItems().add(flashcard.toString());
        }
    }

    public void handleEdit() {
        int selectedIndex = flashcardListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            FlashCard selectedCard = cards.get(selectedIndex);
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("views/editor.fxml"));
                Parent root = loader.load();
    
                FlashCardEditorController editorController = loader.getController();
                editorController.setFlashCard(selectedCard);
    
                Stage stage = new Stage();
                stage.setTitle("Edit Flashcard");
                stage.setScene(new Scene(root));
                stage.initModality(Modality.WINDOW_MODAL);  // Set the window to be modal
                stage.showAndWait();  // Show the window and wait until it is closed

                cards.set(selectedIndex, editorController.getFlashCard());
                flashcardListView.getItems().clear();
                for (FlashCard flashcard : cards) {
                    flashcardListView.getItems().add(flashcard.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Editing: " + selectedCard);
        } else {
            Alert alert = new Alert(AlertType.WARNING, "No flashcard selected", ButtonType.OK);
            alert.showAndWait();
        }
    }
}