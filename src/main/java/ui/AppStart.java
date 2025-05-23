package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppStart extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
    Scene s = new Scene(root);
    s.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
    stage.setScene(s);
    stage.setTitle("MMS-Übung Image Filters");
    stage.setMinHeight(400);
    stage.setMinWidth(800);
    stage.show();
  }

  public static void main(String[] args) {
    // check for command line argument
    if (args.length > 0) {
    }
    launch(args);
  }
}
