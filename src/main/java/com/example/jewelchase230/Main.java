package com.example.jewelchase230;

import com.example.jewelchase230.vectors.IntVector2D;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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
public final class Main extends Application {

    // The dimensions of the canvas.
    /** Width of canvas. */
    private static final int CANVAS_WIDTH = 800;
    /** Height of canvas. */
    private static final int CANVAS_HEIGHT = 450;

    /** Number of times the game ticks per second. */
    private static final int FRAME_RATE = 10;

    /** The stage shown by the window. */
    private static Stage stage;

    /** Pane the hold the canvas as a child. */
    private static StackPane canvasPane;

    /** The canvas being used to render the grid/board. */
    private static Canvas canvas;

    /** Timeline which will cause tick method to be called periodically. */
    private static Timeline tickTimeline;

    /**
     * The level currently being played.
     * null if no level is being played.
     */
    private static Level currentLevel;

    @Override
    public void start(final Stage inStage) throws IOException {
        Menu.initMenus();

        // Register a tick method to be called periodically.
        // Make a new timeline with one keyframe that triggers
        // the tick method every half a second.
        final double millisecondsInASecond = 1000;
        Duration duration = Duration.millis(millisecondsInASecond / FRAME_RATE);
        KeyFrame keyFrame = new KeyFrame(duration, event -> tick());
        tickTimeline = new Timeline(keyFrame);
        // Loop the timeline forever
        tickTimeline.setCycleCount(Animation.INDEFINITE);

        // Setup canvas
        canvasPane = new StackPane();
        canvasPane.setStyle("-fx-background-color: #000000");
        canvas = new GameCanvas(canvasPane, CANVAS_WIDTH, CANVAS_HEIGHT);
        canvasPane.getChildren().add(canvas);

        stage = inStage;

        // Show main menu at first
        switchToScene(Menu.getMainMenu());

        stage.setTitle("Jewel Chase");
        stage.setResizable(true);
        //stage.setFullScreen(true); // Make this an optional setting
        stage.show();

        /* Test - Remove this */
        currentLevel = new Level(new IntVector2D(16, 1));
        /* Test - Remove this */
    }

    /**
     * Changes the level currently being played.
     * @param level The new level.
     */
    public void setLevel(final Level level) {
        currentLevel = level;
    }

    /**
     * Changes what is currently being rendered to the canvas.
     * Should be used when switching from a menu to a level.
     */
    public static void switchToCanvas() {
        tickTimeline.play();
        Scene scene = new Scene(canvasPane);
        stage.setScene(scene);
    }

    /**
     * Switches what is currently shown on the screen to a menu.
     * @param scene The scene to be shown.
     */
    public static void switchToScene(final Scene scene) {
        tickTimeline.stop();
        stage.setScene(scene);
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

    /**
     * Program entry point.
     * @param args Program arguments.
     */
    public static void main(final String[] args) {
        launch();
    }
}
