package com.glacier.main;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import com.glacier.handlers.*;
import com.glacier.util.Utility;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public class Dice extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox radioButtons = new VBox();
        HBox wrapThings = new HBox();
        ToggleGroup toggleGroup = new ToggleGroup();
        Button btChoose = new Button("Choose the selected input method");
        RadioButton oneLine = new RadioButton("Input on one line (a-la 1d20+1)");
        RadioButton multiLine = new RadioButton("Input sides and number of dice separately");
        oneLine.setToggleGroup(toggleGroup);
        multiLine.setToggleGroup(toggleGroup);
        radioButtons.getChildren().add(oneLine);
        radioButtons.getChildren().add(multiLine);
        wrapThings.getChildren().add(radioButtons);
        wrapThings.getChildren().add(btChoose);
        btChoose.setOnAction(new showCorrectInputHandler(oneLine.isSelected(),multiLine.isSelected()));
        Scene primaryScene = new Scene(wrapThings,Utility.MENU_SIZE,Utility.MENU_SIZE_TWO);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
