package com.Temperature.javafxapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	@FXML
	public Label welcomeLabel;

	@FXML
	public ChoiceBox<String> choiceBox;

	@FXML
	public TextField userInputField;

	@FXML
	public Button convertButton;

	private boolean isCelsiustoFahrenheit = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		choiceBox.getItems().add("Celsius to Fahrenheit");
		choiceBox.getItems().add("Fahrenheit to Celsius");

		choiceBox.setValue("Celsius to Fahrenheit");          //set default value in choice box

		choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.equals("Celsius to Fahrenheit")){
				isCelsiustoFahrenheit = true;
			}else{
				isCelsiustoFahrenheit = false;
			}
		});
		convertButton.setOnAction(event ->{
				convert();
		});

	}

	private void convert() {
		String input = userInputField.getText();

		float enteredTemperature = 0.0f;
		try{
			 enteredTemperature = Float.parseFloat(input);
		}catch (Exception exception){
			warnUser();
			return;
		}

		float newTemperature = 0.0f;
		if(isCelsiustoFahrenheit){
			newTemperature = (enteredTemperature * 9 / 5) + 32;
		}else {
			newTemperature = (enteredTemperature - 32) * 5 / 9;
		}
		
		display(newTemperature);
	}

	private void warnUser() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occured");
		alert.setHeaderText("Invalid Temperature Entered");
		alert.setContentText("Please enter the valid temperature");
		alert.show();
	}

	private void display(float newTemperature) {

		String unit = isCelsiustoFahrenheit? "F" : "C";

		System.out.println("The new temperature is : " + newTemperature + unit);

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    alert.setTitle("Result");
	    alert.setContentText("The new temperature is : " + newTemperature + unit);
	    alert.show();
	}
}

