package com.kpuig.flashycards.ui;

import com.kpuig.flashycards.ui.controllers.FlashCardModeController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("views/modeselector.fxml"));
        Parent root = loader.load();
        
        FlashCardModeController modeController = loader.getController();
        modeController.createNewFlashCardSet();

        primaryStage.setTitle("Flash-E");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    
}
