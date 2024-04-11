package com.kpuig.flashycards.ui;

import java.util.ArrayList;

import com.kpuig.flashycards.cards.FlashCard;
import com.kpuig.flashycards.cards.storage.FlashCardSet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("views/editorlist.fxml"));
        primaryStage.setTitle("Editor");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    
}
