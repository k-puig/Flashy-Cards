/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.kpuig.flashycards;

import com.kpuig.flashycards.cards.FlashCard;
import com.kpuig.flashycards.cards.storage.FlashCardSet;
import com.kpuig.flashycards.ui.MainApplication;

import javafx.application.Application;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        File jsonFile = new File("flashcards.json");
        String sampleJson = "[{\"front\":\"Question 1\",\"back\":\"Answer 1\"},{\"front\":\"Question 2\",\"back\":\"Answer 2\"}]";

       
        FlashCardSet flashCardSet = new FlashCardSet(sampleJson);

        
        List<FlashCard> cards = flashCardSet.getCards();

        
        for (int i = 0; i < cards.size(); i++) {
            FlashCard card = cards.get(i);
            System.out.println("Flashcard " + (i + 1) + ":");
            System.out.println(card); // This calls the overridden toString() method
            System.out.println();
        }
        
        Application.launch(MainApplication.class, args);
        
    }
}
