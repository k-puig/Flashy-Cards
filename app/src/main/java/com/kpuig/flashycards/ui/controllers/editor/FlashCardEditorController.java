package com.kpuig.flashycards.ui.controllers.editor;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import com.kpuig.flashycards.cards.FlashCard;

import javafx.event.ActionEvent;

public class FlashCardEditorController {
    @FXML
    private TextArea frontText;
    @FXML
    private TextArea backText;

    public void setFlashCard(FlashCard card) {
        this.frontText.setText(card.front);
        this.backText.setText(card.back);
    }

    // Handler for save button
    public void handleSave(ActionEvent event) {
        String front = frontText.getText();
        String back = backText.getText();
        System.out.println("Front: " + front + " Back: " + back);
    }

    // Handler for cancel button
    public void handleCancel(ActionEvent event) {
        frontText.clear();
        backText.clear();
    }

    public FlashCard getFlashCard() {
        return new FlashCard(frontText.getText(), backText.getText());
    }
}
