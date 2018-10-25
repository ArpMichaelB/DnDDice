package com.glacier.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.glacier.handlers.showCorrectInputHandler;
import com.glacier.util.Utility;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public class Dice extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox radioButtons = new VBox();
		HBox wrapThings = new HBox();

		ToggleGroup toggleGroup = new ToggleGroup();
		Button btChoose = new Button("Choose the selected input method");
		RadioButton oneLine = new RadioButton("Input on one line (a-la 1d20+1)");
		RadioButton multiLine = new RadioButton("Input sides and number of dice separately");
		oneLine.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected,
					Boolean isNowSelected) {
				btChoose.setOnAction(
						new showCorrectInputHandler(oneLine.isSelected(), multiLine.isSelected(), primaryStage));
			}
		});
		multiLine.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected,
					Boolean isNowSelected) {
				btChoose.setOnAction(
						new showCorrectInputHandler(oneLine.isSelected(), multiLine.isSelected(), primaryStage));
			}
		});
		// any time we change the selected type, update the action for the choose button
		// to reflect that change
		oneLine.setToggleGroup(toggleGroup);
		multiLine.setToggleGroup(toggleGroup);
		radioButtons.getChildren().add(oneLine);
		radioButtons.getChildren().add(multiLine);
		wrapThings.getChildren().add(radioButtons);
		wrapThings.getChildren().add(btChoose);
		btChoose.setOnAction(new showCorrectInputHandler(oneLine.isSelected(), multiLine.isSelected(), primaryStage));
		Scene primaryScene = new Scene(wrapThings, Utility.MENU_SIZE, Utility.MENU_SIZE_TWO);
		primaryStage.setScene(primaryScene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Utility.setupFileError();
		Utility.setupFileOut();
		//TODO: make sure to use system.out for action logs
		launch(args);
	}
}
