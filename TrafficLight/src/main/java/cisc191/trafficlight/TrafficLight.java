/**
 * A class of traffic light that allow user to select one of the three lights,
 * the circle will light up depends on the user's selection. One light on at maximum.
 * @Author: Celine Wang
 * classname: CISC 191
 * @Version: 1.0
 */

package cisc191.trafficlight;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TrafficLight extends Application {

    protected BorderPane getPane() {
        HBox paneForButtons = new HBox();
        // Create buttons
        RadioButton redButton = new RadioButton("Red");
        redButton.setTextFill(Color.RED);
        redButton.setStyle("-fx-font-size: 16;");
        RadioButton yellowButton = new RadioButton("Yellow");
        yellowButton.setTextFill(Color.ORANGE);
        yellowButton.setStyle("-fx-font-size: 16;");
        RadioButton greenButton = new RadioButton("Green");
        greenButton.setTextFill(Color.GREEN);
        greenButton.setStyle("-fx-font-size: 16;");

        // Add buttons to pane for buttons
        paneForButtons.getChildren().addAll(redButton, yellowButton, greenButton);
        paneForButtons.setAlignment(Pos.CENTER);

        // Group radio buttons
        ToggleGroup toggleGroup = new ToggleGroup();
        redButton.setToggleGroup(toggleGroup);
        yellowButton.setToggleGroup(toggleGroup);
        greenButton.setToggleGroup(toggleGroup);

        // Create a borderPane and put the pane for buttons to the bottom
        BorderPane pane = new BorderPane();
        pane.setBottom(paneForButtons);
        // Add padding at the top and bottom of the  rectangle
        paneForButtons.setPadding(new Insets(5, 20, 5, 20));

        // Create a pane to display lights
        StackPane paneForLightGroup = new StackPane();
        VBox paneForLights = new VBox(5);  // Specify the spacing between lights
        // Add padding at the top and bottom of the  rectangle
        paneForLights.setPadding(new Insets(10, 0, 10, 0));

        // Create lights
        Circle redLight = new Circle(30, 30, 15, Color.WHITE);
        redLight.setStroke(Color.BLACK);
        redLight.setFill(Color.WHITE);
        Circle yellowLight = new Circle(30, 30, 15, Color.WHITE);
        yellowLight.setStroke(Color.BLACK);
        yellowLight.setFill(Color.WHITE);
        Circle greenLight = new Circle(30, 30, 15, Color.WHITE);
        greenLight.setStroke(Color.BLACK);
        greenLight.setFill(Color.WHITE);

        // Add lights to pane for Lights
        paneForLights.getChildren().addAll(redLight, yellowLight, greenLight);
        paneForLights.setAlignment(Pos.CENTER);

        // Create a background for lights
        Rectangle lightBackground = new Rectangle(40, 110);
        lightBackground.setStroke(Color.BLACK);
        lightBackground.setFill(Color.WHITE);

        // Stack light background and pane for lights together
        paneForLightGroup.getChildren().addAll(lightBackground, paneForLights);
        // Put the pane for light group to the center
        pane.setCenter(paneForLightGroup);

        // Event handling
        redButton.setOnAction(e -> {
            redLight.setFill(Color.RED);
            yellowLight.setFill(Color.WHITE);
            greenLight.setFill(Color.WHITE);
        });
        yellowButton.setOnAction(e -> {
            yellowLight.setFill(Color.YELLOW);
            greenLight.setFill(Color.WHITE);
            redLight.setFill(Color.WHITE);
        });
        greenButton.setOnAction(e -> {
            greenLight.setFill(Color.GREEN);
            yellowLight.setFill(Color.WHITE);
            redLight.setFill(Color.WHITE);
        });

        return pane;

    }
    @Override // Override the stare method in the Application class
    public void start(Stage primaryStage) {
        // Create a scene and place it in the stage
        Scene scene = new Scene(getPane());
        primaryStage.setTitle("Traffic Light");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

