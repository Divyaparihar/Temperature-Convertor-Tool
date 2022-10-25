package com.Temperature.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;


public class MyMain extends Application {
	public static void main(String[] args)
	{
    launch(args);
	}

	@Override
	public void init() throws Exception {
		System.out.println("intit");           //initialize an  Application
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		System.out.println("Start");          //Start an Application

		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar =  createMenu();
		rootNode.getChildren().add(0, menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
				primaryStage.setTitle("Temperature Convertor Tool");
				//	primaryStage.setResizable(false);
				primaryStage.show();
				}

	private MenuBar createMenu(){
		//File Menu
	  Menu fileMenu = new Menu("File");
	  MenuItem newMenuItem = new MenuItem("New");

	  newMenuItem.setOnAction(event -> System.out.println("New Menu Item Clicked"));      //Lambda Feature
	  SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
	  MenuItem quitMenuItem = new MenuItem("Quit");

	  quitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
		  @Override
		  public void handle(ActionEvent event) {
			  Platform.exit();
			  System.exit(0);
		  }
	  });

	  //Or
	 //quitMenuItem.setOnAction(event -> {
		//   Platform.exit();
		//   System.exit(0);

	// });
	  fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);

	  //Help Menu
	  Menu helpMenu = new Menu("Help");
	  MenuItem aboutApp = new MenuItem("About");

	  aboutApp.setOnAction(new EventHandler<ActionEvent>() {
		  @Override
		  public void handle(ActionEvent event) {
			  aboutApp();

			  //Or
	//aboutApp.setOnAction(event1 -> aboutApp());


		  }
	  });
	  helpMenu.getItems().addAll(aboutApp);

	  //Menu Bar
	  MenuBar menuBar = new MenuBar();
	 menuBar.getMenus().addAll(fileMenu, helpMenu);

	return menuBar;
	}

	private void aboutApp(){
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My First Desktop App");
		alertDialog.setHeaderText("Learning JavaFX");
        alertDialog.setContentText("It is a simple temperature convert tool !!");

        ButtonType okBtn = new ButtonType("OK");      // ButtonType yesBtn = new ButtonType("Yes");
		                                                  //ButtonType noBtn = new ButtonType("No");

		                                                  //alertDialog.getButtonTypes().setAll(yesBtn, noBtn);


		Optional<ButtonType> clickedBtn = alertDialog.showAndWait();
		//	if (clickedBtn.isPresent() && clickedBtn.get() == noBtn){
	    //		System.out.println("Yes Button Clicked !!");
	   //	}else {
	   //		System.out.println("No Button Clicked !!");
	   //	}

        alertDialog.show();
	}

@Override
public void stop() throws Exception {
		System.out.println("Stop");              //called when app is stoped and is about to shut down
		super.stop();
		}
}
