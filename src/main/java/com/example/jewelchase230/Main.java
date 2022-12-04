package com.example.jewelchase230;

import com.example.jewelchase230.profiles.ProfileManager;
import com.example.jewelchase230.vectors.IntVector2D;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

/**
 * Jewel Chase application. This class manages the initial startup,
 * what gets rendered and the ticking of the game.
 *
 * @author Will Kaye, Daniel Clark
 */
public final class Main extends Application {
    /** Default window width. */
    private static final int DEFAULT_WINDOW_WIDTH = 800;

    /** Default window height. */
    private static final int DEFAULT_WINDOW_HEIGHT = 450;

    /** Number of times the game ticks per second. */
    private static final int FRAME_RATE = 10;

    /** The number of milliseconds in a second. */
    private static final int MILLISECONDS_IN_A_SECOND = 1000;

    /** Size of the window. */
    private static IntVector2D windowSize;

    /** The canvas being used to render the grid/board. */
    private static Canvas canvas;

    /** The scene shown by the window. */
    private static ScalingScene mainScene;

    /** Pane the hold the canvas as a child. */
    private static StackPane canvasPane;

    /** Timeline which will cause tick method to be called periodically. */
    private static Timeline tickTimeline;

    /**
     * The level currently being played.
     * null if no level is being played.
     */
    private static Level currentLevel;

    @Override
    public void start(final Stage inStage) throws IOException {
    	
        ProfileManager.readLines();
    	
        windowSize =
                new IntVector2D(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);

        Menu.initMenus();

        // Register a tick method to be called periodically.
        // Make a new timeline with one keyframe that triggers
        // the tick method every half a second.
        Duration duration =
                Duration.millis((double) MILLISECONDS_IN_A_SECOND / FRAME_RATE);
        KeyFrame keyFrame = new KeyFrame(duration, event -> tick());
        tickTimeline = new Timeline(keyFrame);
        // Loop the timeline forever
        tickTimeline.setCycleCount(Animation.INDEFINITE);

        // Setup canvas
        canvasPane = new StackPane();
        canvas = new GameCanvas(windowSize.getX(), windowSize.getY());
        canvasPane.getChildren().add(canvas);

        // Show main menu at first
        mainScene = new ScalingScene(Menu.getMainMenu());
        mainScene.widthProperty().addListener(e -> updateWindowSize());
        mainScene.heightProperty().addListener(e -> updateWindowSize());
        mainScene.addEventFilter(KeyEvent.KEY_PRESSED, Main::processKeyEvent);

        inStage.setScene(mainScene);
        inStage.setTitle("Jewel Chase");
        inStage.setResizable(true);
        //stage.setFullScreen(true); // Make this an optional setting
        inStage.show();
        
    

        /* Test - Remove this */
        currentLevel = LevelFileReader.readInFile("Level_Files/level1.txt");
        /* Test - Remove this */
    }

    /**
     * Closes the FXML window.
     */
    public static void close() {
        System.exit(0);
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
        mainScene.setScaleRoot(false);
        mainScene.setRoot(canvasPane);
    }

    /**
     * Switches what is currently shown on the screen to a menu.
     * @param root The root node to be shown.
     */
    public static void switchRoot(final Parent root) {
        tickTimeline.stop();
        mainScene.setRoot(root);
        mainScene.setScaleRoot(true);
    }

    /**
     * Clears the canvas so that it's empty with a white
     * background.
     */
    private void resetCanvas() {
       GraphicsContext gc = canvas.getGraphicsContext2D();
       gc.clearRect(0, 0, windowSize.getX(), windowSize.getY());

       gc.setFill(Color.WHITE);
       gc.fillRect(0, 0, windowSize.getX(), windowSize.getY());
    }

    private static void processKeyEvent(final KeyEvent event) {
        boolean bGameRunning =
                tickTimeline.getStatus() == Animation.Status.RUNNING;

        if (currentLevel != null && bGameRunning) {
            currentLevel.getPlayer().processKeyEvent(event);
        }

        if (event.getCode() == KeyCode.ESCAPE) {
            switchRoot(Menu.getMainMenu());
        }
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
        return windowSize;
    }

    /**
     * Changes the window size used by the canvas.
     */
    private void updateWindowSize() {
        int width = (int) Math.round(mainScene.getWidth());
        int height = (int) Math.round(mainScene.getHeight());

        windowSize = new IntVector2D(width, height);
    }

    /**
     * Re-renders the grid and calls a tick function on
     * any items before being rendered.
     */
    private void tick() {
        double timeSinceLastFrame =
                (double) MILLISECONDS_IN_A_SECOND / FRAME_RATE;
        int timeSinceLastFrameInt = (int) Math.round(timeSinceLastFrame);
        if (currentLevel != null) {
            resetCanvas();

            GraphicsContext gc = canvas.getGraphicsContext2D();

            Renderable[] renderables = currentLevel.getRenderables();
            for (Renderable renderable : renderables) {
                renderable.tick(timeSinceLastFrameInt);
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
