package com.example.jewelchase230;

import com.example.jewelchase230.vectors.IntVector2D;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

/**
 * Jewel Chase application. This class manages the initial startup,
 * what gets rendered and the ticking of the game.
 *
 * @author Will Kaye
 */
public class Main extends Application {

    // The dimensions of the canvas
    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGHT = 450;

    // Number of times the game ticks per second
    private static final int FRAME_RATE = 2;

    // The first component in the scene
    private Pane root;

    // The canvas being used to render the grid/board
    private Canvas canvas;

    // Timeline which will cause tick method to be called periodically.
    private Timeline tickTimeline;

    // The level currently being played.
    // null if no level is being played.
    private static Level currentLevel;

    @Override
    public void start(Stage stage) throws IOException {
        root = new StackPane();
        root.setStyle("-fx-background-color: #000000");
        canvas = new GameCanvas(root, CANVAS_WIDTH, CANVAS_HEIGHT);
        switchToCanvas(); // TODO: Change this to show a menu

        Scene scene = new Scene(root);
        stage.setTitle("Jewel Chase");
        stage.setScene(scene);
        stage.setResizable(true);
        //stage.setFullScreen(true); // TODO: Make this an optional setting
        stage.show();

        // Register a tick method to be called periodically.
        // Make a new timeline with one keyframe that triggers the tick method every half a second.
        tickTimeline = new Timeline(new KeyFrame(Duration.millis((double) 1000/FRAME_RATE), event -> tick()));
        // Loop the timeline forever
        tickTimeline.setCycleCount(Animation.INDEFINITE);

        /* Test - Remove this */
        currentLevel = new Level();
        tickTimeline.play();
        /* Test - Remove this */
    }

    /**
     * Changes the level currently being played.
     * @param level The new level.
     */
    public void setLevel(Level level) {
        currentLevel = level;
    }

    /**
     * Changes what is currently being rendered to the canvas.
     * Should be used when switching from a menu to a level.
     */
    private void switchToCanvas() {
        ObservableList<Node> children = root.getChildren();
        children.removeAll();
        children.add(canvas);
    }

    /**
     * Clears the canvas so that it's empty with a white
     * background.
     */
    private void resetCanvas() {
       GraphicsContext gc = canvas.getGraphicsContext2D();
       gc.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);

       gc.setFill(Color.WHITE);
       gc.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
    }

    /**
     * @return The level currently being played.
     */
    public static Level getCurrentLevel() {
        return currentLevel;
    }

    /**
     * @return The pixel dimensions of the canvas.
     */
    public static IntVector2D getCanvasSize() {
        return new IntVector2D(CANVAS_WIDTH, CANVAS_HEIGHT);
    }

    /**
     * Re-renders the grid and calls a tick function on
     * any items before being rendered.
     */
    private void tick() {
        if (currentLevel != null) {
            resetCanvas();

            GraphicsContext gc = canvas.getGraphicsContext2D();

            Renderable[] renderables = currentLevel.getRenderables();
            for (Renderable renderable : renderables) {
                renderable.tick(0);
                renderable.draw(gc);
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}