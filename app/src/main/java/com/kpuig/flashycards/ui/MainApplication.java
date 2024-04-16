package com.kpuig.flashycards.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("views/modeselector.fxml"));
        primaryStage.setTitle("Editor");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    
}
