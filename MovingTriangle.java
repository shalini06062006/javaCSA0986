import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MovingTriangle extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        // Create a triangle (Polygon)
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(100.0, 50.0, 150.0, 150.0, 50.0, 150.0);
        triangle.setFill(Color.BLUE);
        triangle.setStroke(Color.BLACK);
        triangle.setStrokeWidth(3);

        // Moving animation
        TranslateTransition move = new TranslateTransition(Duration.seconds(3), triangle);
        move.setFromX(0);
        move.setToX(300);
        move.setCycleCount(2);
        move.setAutoReverse(true);

        // Rotation animation
        RotateTransition rotate = new RotateTransition(Duration.seconds(3), triangle);
        rotate.setByAngle(360);
        rotate.setCycleCount(2);
        rotate.setAutoReverse(true);

        // Revolve animation around a point (e.g., center of the scene)
        RotateTransition revolve = new RotateTransition(Duration.seconds(3), triangle);
        revolve.setByAngle(360);
        revolve.setCycleCount(2);
        revolve.setAutoReverse(true);
        revolve.setPivotX(200); // X coordinate of the pivot point
        revolve.setPivotY(200); // Y coordinate of the pivot point

        // Fade animation
        FadeTransition fade = new FadeTransition(Duration.seconds(3), triangle);
        fade.setFromValue(1.0);
        fade.setToValue(0.3);
        fade.setCycleCount(2);
        fade.setAutoReverse(true);

        // Color change animation
        FillTransition fill = new FillTransition(Duration.seconds(3), triangle);
        fill.setFromValue(Color.BLUE);
        fill.setToValue(Color.GREEN);
        fill.setCycleCount(2);
        fill.setAutoReverse(true);

        // Stroke color change animation
        StrokeTransition stroke = new StrokeTransition(Duration.seconds(3), triangle);
        stroke.setFromValue(Color.BLACK);
        stroke.setToValue(Color.RED);
        stroke.setCycleCount(2);
        stroke.setAutoReverse(true);

        // Sequential animation
        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(move, rotate, fade, fill, stroke, revolve);
        sequentialTransition.setCycleCount(1);
        sequentialTransition.play();

        pane.getChildren().add(triangle);

        Scene scene = new Scene(pane, 600, 400);
        primaryStage.setTitle("Moving Triangle with Effects");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
