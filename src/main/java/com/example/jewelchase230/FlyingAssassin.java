package com.example.jewelchase230;
import com.example.jewelchase230.vectors.IntVector2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Implements the Flying Assassin. A class to implement the move patterns and events of the AICharater
 * Flying Assassin.
 *
 * @author Caroline Segestaal.
 */
public class FlyingAssassin extends AICharacter {

    /**
     * Constructs a renderable component.
     *  @param x X position on the grid.
     * @param y Y position on the grid.
     * @param d
     */
    public FlyingAssassin(int x, int y, Direction d) {
        super(x, y);
    }

    /**
     * Controls the next move of the Flying Assassin.
     *
     * @param d Direction the Flying assassin is facing.
     */
    protected void getNextMove(Direction d) {
        switch (d) {
            case UP: if (getGridPosition().getY() < getLevel().getLevelSize().getY()) {
                setGridPosition(new IntVector2D(getGridPosition().getX(), getGridPosition().getY() + 1));
            } else {
                getNextMove(d.getOppositeDirection(d));
            }
            case DOWN: if (getGridPosition().getY() > getLevel().getLevelSize().getY()) {
                setGridPosition(new IntVector2D(getGridPosition().getX(), getGridPosition().getY() - 1));
            } else {
                getNextMove(d.getOppositeDirection(d));
            }
            case LEFT: if (getGridPosition().getX() > getLevel().getLevelSize().getX()) {
                setGridPosition(new IntVector2D(getGridPosition().getX() - 1, getGridPosition().getY()));
            } else {
                getNextMove(d.getOppositeDirection(d));
            }
            case RIGHT: if (getGridPosition().getX() < getLevel().getLevelSize().getX()) {
                setGridPosition(new IntVector2D(getGridPosition().getX() + 1, getGridPosition().getY()));
            } else {
                getNextMove(d.getOppositeDirection(d));
            }
        }
    }

    /**
     * Draws this item to the canvas.
     *
     * @param gc GraphicsContext for creating draw class.
     */
    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(new Image("src/main/java/com/example/jewelchase230/images/CAT_BLACK_SIT.png"), 1, 1);
        //setGridPosition(new IntVector2D(1,1));
    }
}


//    public void inputImage() throws FileNotFoundException {
//        InputStream imageStream = new FileInputStream("src/main/java/com/example/jewelchase230/images/CAT_BLACK_SIT.png");
//        Image image = new Image(imageStream);
//        ImageView view = new ImageView();
//        view.setImage(image);
//        view.setX(1);
//        view.setY(1);
//
//    }

//        It moves in a straight line in
//        the direction it is facing until it reaches the edge
//        of the level. On reaching the edge, it rotates 180
//        degrees and continues moving forward. As this
//        NPC is flying, it does not respect the floor move-
//        ment rules and simply always travels straight. The
//        movement is either vertical or horizontal.
//        If the Flying Assassin connects with (i.e. occupies
//        the same tile) the player, the player loses. If they
//        connect with another NPC, that NPC is removed
//        from the game.