package com.example.jewelchase230;
import java.util.ArrayList;
import com.example.jewelchase230.vectors.IntVector2D;

public class Bomb extends Item{

private int time;

    public Bomb(int x, int y, String name, String fileName, int time) {
        super(x, y, name, fileName);
        this.time = time;
    }

    public void setTime(int newTime) {
        this.time = newTime;
    }

    public int getTime() {
        return this.time;
    }

    //psueod code for explode. waiting for getObjectArray and setObjectArray in level class (or similar)

    public void explode() {
        /*level currentLevel = main.getCurrentLevel();
        ArrayList<Object> objectArray = currentLevel.getObjectArray();
        for (int i=0; i < objectArray.size(); i++) {
            if (i.getX == this.getX) {
                i.remove()
            }
            if (i.getY == this.getY) {
                i.remove()
            }
        }
        main.currentLevel.setObjectArray(objectArray);  */
    }

    public void doOnCollision() {
        explode();
        remove();
    }
}
