package com.kpuig.flashycards.cards.storage;

import java.io.File;
import java.util.List;

import com.kpuig.flashycards.cards.FlashCard;

// This class may have limited functionality in prototyping stage
public class FlashCardSet {
    private List<FlashCard> cards;

    public FlashCardSet(List<FlashCard> cards) {
        this.cards = cards;
    }

    public FlashCardSet(File cardSetFile) {
        // TODO: Maybe implement
    }

    public void saveToFile(File file) {
        // TODO: Maybe implement
    }

    public List<FlashCard> getCards() {
        return this.cards;
    }
}
