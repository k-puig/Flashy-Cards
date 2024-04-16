package com.kpuig.flashycards.cards.storage;

import java.io.File;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.io.FileWriter;


import com.google.gson.Gson;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.kpuig.flashycards.cards.FlashCard;

// This class may have limited functionality in prototyping stage
public class FlashCardSet {
    private List<FlashCard> cards;

    public FlashCardSet(List<FlashCard> cards) {
        this.cards = cards;
    }

    public FlashCardSet(File cardSetFile) throws IOException {
        // Handle potential IOException when reading from file
        try {
            Gson gson = new Gson();
            try (FileReader reader = new FileReader(cardSetFile)) {
                FlashCard[] flashCards = gson.fromJson(reader, FlashCard[].class);
                this.cards = Arrays.asList(flashCards);
            }
        } catch (IOException e) {
            // Propagate the exception or handle it accordingly
            throw e;
        }
    }
    public FlashCardSet(String jsonString) {
        Gson gson = new Gson();
        FlashCard[] flashCards = gson.fromJson(jsonString, FlashCard[].class);
        this.cards = Arrays.asList(flashCards);
    }

    public void saveToFile(File file) throws IOException {
        Gson gson = new Gson();
        try(FileWriter writer = new FileWriter(file)){
            gson.toJson(this.cards, writer);
        }
        // TODO: Maybe implement
        // Gson gson = new Gson();
        // System.out.println(gson.toJson(gson));
        // Implement a method to save the json as a string to the file.
    }

    public List<FlashCard> getCards() {
        return this.cards;
    }
}

