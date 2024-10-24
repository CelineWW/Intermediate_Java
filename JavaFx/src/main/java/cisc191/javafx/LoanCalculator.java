/**
 * @Author: Celine Wang
 * classname: CISC 191
 * @Version: 3.0
 */

package cisc191.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.animation.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.util.Duration;
import javafx.scene.layout.BorderPane;
import javafx.animation.PathTransition;


public class LoanCalculator extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Loan Calculator");

        // Create UI elements
        TextField loanAmountField = new TextField();
        TextField interestRateField = new TextField();
        TextField loanTermField = new TextField();
        Button calculateButton = new Button("Calculate");
        Button clearButton = new Button("Clear");
        Label resultLabel = new Label();

        // Create a HBox to hold calculator and clear button
        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(10);
        calculateButton.setStyle("-fx-background-color: yellowgreen");
        clearButton.setStyle("-fx-background-color: orange");
        buttons.getChildren().addAll(calculateButton, clearButton);

        // Style text fields
        loanAmountField.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 12));
        interestRateField.setFont(Font.font("Times New Roman", FontWeight.BOLD,FontPosture.ITALIC, 12));
        loanTermField.setFont(Font.font("Times New Roman", FontWeight.BOLD,FontPosture.ITALIC, 12));

        // Layout using GridPane and set Font for labels
        GridPane layout = new GridPane();
        layout.setPrefSize(300, 300);
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(5);
        layout.setVgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.add(new Label("Loan Amount:") {{setFont(Font.font("Arial", FontWeight.BOLD, 12));}} ,0, 0);
        layout.add(loanAmountField, 1, 0);
        layout.add(new Label("Interest Rate:") {{setFont(Font.font("Arial", FontWeight.BOLD, 12));}}, 0, 1);
        layout.add(interestRateField, 1, 1);
        layout.add(new Label("Loan Term:") {{setFont(Font.font("Arial", FontWeight.BOLD, 12));}}, 0, 2);
        layout.add(loanTermField, 1, 2);
        layout.add(buttons,1, 3);
        layout.add(resultLabel,1,4);

        // Ensure the text fields regain focus on click
        loanAmountField.setOnMouseClicked(e -> loanAmountField.requestFocus());
        interestRateField.setOnMouseClicked(e -> interestRateField.requestFocus());
        loanTermField.setOnMouseClicked(e -> loanTermField.requestFocus());
        calculateButton.setOnAction(e -> calculateButton.requestFocus());
        clearButton.setOnAction(e -> clearButton.requestFocus());

        // Calculate Button Event Handling
        calculateButton.setOnAction(e -> {
            updateResult(loanAmountField, interestRateField, loanTermField, resultLabel);
        });

        // Clear button event handling
        clearButton.setOnAction(e -> {
            loanAmountField.clear();
            interestRateField.clear();
            loanTermField.clear();
            resultLabel.setText("");
        });

        // Create a ClockPane and set up clock animation
        BorderPane pane = getClockPane(layout);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Call animation method
        startBouncingBall(scene, layout);
    }

    private void updateResult(TextField loanAmountField, TextField interestRateField,
                              TextField loanTermField, Label resultLabel) {
        try {
            double loanAmount = Double.parseDouble(loanAmountField.getText());
            double interestRate = Double.parseDouble(interestRateField.getText()) / 100 / 12;
            int loanTerm = Integer.parseInt(loanTermField.getText()) * 12;
            double monthlyPayment = (loanAmount * interestRate) / (1 - Math.pow(1 + interestRate, -loanTerm));
            resultLabel.setText(String.format(" >>  Monthly Payment: %.2f", monthlyPayment));
            resultLabel.setTextFill(Color.ORANGE);
        }
        catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input.");
            resultLabel.setTextFill(Color.RED);
        }
    }

    private static BorderPane getClockPane(GridPane layout) {
        ClockPane clock = new ClockPane();
        // Create an animation for a running clock
        Timeline clockAnimation = new Timeline(
                new KeyFrame(Duration.millis(1000), e->clock.setCurrentTime()));
        clockAnimation.setCycleCount(Timeline.INDEFINITE);
        clockAnimation.play(); // Start animation

        // Use BorderPane to put loan calculator on the left and the clock animation on the right
        BorderPane pane = new BorderPane();
        pane.setLeft(layout);
        pane.setCenter(clock);
        return pane;
    }

    private void startBouncingBall(Scene scene, GridPane layout) {
        // Create a ballPane for animation
        Pane ballPane = new Pane();

        // Create a ball shape
        Circle ball = new Circle(15, Color.YELLOWGREEN);
        ball.setCenterX(15);
        ball.setCenterY(15);

        // Create a rectangle path
        Rectangle rectangle = new Rectangle(15, 15, 570, 270);
        rectangle.setStroke(Color.GREEN);
        rectangle.setFill(null);
        rectangle.setArcHeight(20);
        rectangle.setArcWidth(20);

        // Add the ball and the rectangle to the ballPane
        ballPane.getChildren().addAll(rectangle, ball);

        // Add bouncing ball in the background of scene
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(ballPane, scene.getRoot());
        scene.setRoot(stackPane);

        // Animation logic
        PathTransition transition = new
                PathTransition(Duration.seconds(10), ball);
        transition.setPath(rectangle);
        transition.setNode(ball);
        transition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transition.setCycleCount(Timeline.INDEFINITE);
        transition.play();

        // Pause ball animation event handling
        scene.setOnKeyPressed (e -> {
            ballPane.toFront();
            if (e.getCode() == KeyCode.SPACE) {
                if (transition.getStatus() == Animation.Status.RUNNING) {
                    transition.pause();
                } else {
                    transition.play();
                }
            }
            else {
                ballPane.requestFocus();
            }
        });

        // Change ball color event handling
        ball.setOnMouseClicked(e -> {
            ballPane.toFront();
            if (ball.getFill() == Color.YELLOWGREEN) {
                ball.setFill(Color.TEAL);
            } else if (ball.getFill() == Color.TEAL) {
                ball.setFill(Color.YELLOWGREEN);
            }
        });

        // Send ballPane back and set focus to loan calculator UI if clicked
        ballPane.setOnMouseClicked(e -> {
                ballPane.toBack();
                layout.requestFocus();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
