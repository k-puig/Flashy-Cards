package com.kpuig.flashycards.ui.controllers.viewer;

import java.util.List;

import com.kpuig.flashycards.cards.FlashCard;
import com.kpuig.flashycards.cards.storage.FlashCardSet;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FlashCardViewerController {
    @FXML
    private Label cardText;

    @FXML
    private Label cardIndex;

    @FXML
    private Label sideShown;

    private List<FlashCard> cards;
    private int currentIndex = 0;
    private boolean isFront = true;

    public void setCards(FlashCardSet set) {
        this.cards = set.getCards();
        updateCardDisplay();
    }

    @FXML
    private void handlePrev() {
        if (currentIndex > 0) {
            currentIndex--;
            isFront = true;
            updateCardDisplay();
        }
    }

    @FXML
    private void handleNext() {
        if (currentIndex < cards.size() - 1) {
            currentIndex++;
            isFront = true;
            updateCardDisplay();
        }
    }

    @FXML
    private void handleFlip() {
        isFront = !isFront;
        updateCardDisplay();
    }

    private void updateCardDisplay() {
        FlashCard currentCard = cards.get(currentIndex);
        cardText.setText(isFront ? currentCard.front : currentCard.back);
        cardIndex.setText("Card " + (currentIndex + 1) + " of " + cards.size());
        sideShown.setText(isFront ? "Front" : "Back");
    }

}
