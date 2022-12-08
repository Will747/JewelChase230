package com.example.jewelchase230.characters;

import com.example.jewelchase230.Direction;
import com.example.jewelchase230.Level;
import com.example.jewelchase230.items.Item;
import com.example.jewelchase230.items.Lever;
import com.example.jewelchase230.items.Loot;
import com.example.jewelchase230.vectors.IntVector2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * The SmartThief, this is the smartest thief in the game.
 * It tries to collect all the closest loot until all collected
 * then tries to get to the door before the player reaches it.
 *
 * @author Will Kaye
 */
public final class SmartThief extends AICharacter {
    /** Image used by the smart thief. */
    private static final String SMART_THIEF_IMAGE = "images/CAT_WHITE_SIT.png";

    /** The item the thief is heading towards. */
    private Item targetItem;

    /** The number of moves towards the current target item. */
    private int distanceMoved;

    /** Parent nodes from BFS traversal. */
    private int[] parent;

    /**
     * The distance from the position the thief began to head
     * towards the target item.
     */
    private int[] distance;

    /**
     * Constructs a renderable component.
     * @param direction The initial direction.
     */
    public SmartThief(final Direction direction) {
        super();
        setDirection(direction);
        setImageFromFile(SMART_THIEF_IMAGE);
    }

    @Override
    protected void makeNextMove() {
        Level level = getLevel();

        // Check if there is currently a target item.
        if (targetItem == null
                || level.getItem(targetItem.getGridPosition()) != targetItem) {
            findNextTargetItem();
        }

        IntVector2D nextPos = null;
        if (targetItem != null) {
            /* Find the next position to move to which eventually leads
            to the target position. */
            IntVector2D targetPos = targetItem.getGridPosition();
            int currentParent = getTileIdx(targetPos);
            distanceMoved++;
            /* Goes up the path from the target pos to the move after
            reaching the current position. */
            while (distance[currentParent] != distanceMoved) {
                currentParent = parent[currentParent];
            }
            nextPos = getTilePos(currentParent);
        }

        // If the next position has been found move.
        if (nextPos != null) {
            setGridPosition(nextPos);
        }
    }

    /** Selects the next closest item to where the thief is. */
    private void findNextTargetItem() {
        IntVector2D startPos = getGridPosition();

        Level level = getLevel();
        IntVector2D levelSize = level.getLevelSize();

        // Tiles the smart thief may head towards
        ArrayList<IntVector2D> potentialTiles = new ArrayList<>();

        // Run a Breadth-first-search
        int numOfTiles = levelSize.getX() * levelSize.getY();
        distance = new int[numOfTiles];
        parent = new int[numOfTiles];

        // Set all distances to max (infinity)
        Arrays.fill(distance, Integer.MAX_VALUE);

        // Set all parents to initially be -1
        Arrays.fill(parent, -1);

        distance[getTileIdx(startPos)] = 0;
        IntVector2D currentTile = startPos;

        // Queue of tiles to be checked
        Stack<IntVector2D> queue = new Stack<>();
        queue.add(currentTile);

        while (queue.size() > 0) {
            // Get and remove last element in queue.
            currentTile = queue.pop();
            int currentTileDistance = distance[getTileIdx(currentTile)];
            int nextTileDistance = currentTileDistance + 1;

            ArrayList<IntVector2D> adjacentTiles =
                    getAdjacentTiles(currentTile);

            for (IntVector2D tile : adjacentTiles) {
                // If a tile hasn't been added, add it to the queue
                int idx = getTileIdx(tile);

                /* If the tile has a higher distance this must be
                 the shortest path so set its distance and parent tile. */
                if (distance[idx] > nextTileDistance) {
                    distance[idx] = nextTileDistance;
                    parent[idx] = getTileIdx(currentTile);

                    /* Add this tile to the queue to check for any
                    adjacent tiles. */
                    queue.add(tile);
                }
            }
        }

        // Adds all loot and levers as potential tiles.
        ArrayList<Loot> targetLoot = level.getAllItemsOfType(Loot.class);
        ArrayList<Lever> targetLevers =
                level.getAllItemsOfType(Lever.class);

        if (targetLoot.size() > 0 || targetLevers.size() > 0) {
            for (Loot loot : targetLoot) {
                potentialTiles.add(loot.getGridPosition());
            }

            for (Lever lever : targetLevers) {
                potentialTiles.add(lever.getGridPosition());
            }
        }

        IntVector2D bestTilePos = null;
        // Find the closest tile that holds a wanted item.
        int smallestDistance = Integer.MAX_VALUE;
        for (IntVector2D tilePos : potentialTiles) {
            if (smallestDistance > distance[getTileIdx(tilePos)]) {
                smallestDistance = distance[getTileIdx(tilePos)];
                bestTilePos = tilePos;
            }
        }

        if (bestTilePos != null) {
            distanceMoved = 0;
            targetItem = level.getItem(bestTilePos);
        } else {
            distanceMoved = -1;
            targetItem = null;
        }
    }

    private int getTileIdx(final IntVector2D tilePos) {
        Level level = getLevel();
        return tilePos.getX() + tilePos.getY() * level.getLevelSize().getX();
    }

    private IntVector2D getTilePos(final int tileIdx) {
        IntVector2D levelSize = getLevel().getLevelSize();
        return new IntVector2D(tileIdx % levelSize.getX(),
                Math.floorDiv(tileIdx, levelSize.getX()));
    }

    private ArrayList<IntVector2D> getAdjacentTiles(final IntVector2D tilePos) {
        ArrayList<IntVector2D> adjacentTiles = new ArrayList<>();

        IntVector2D upPos = canMove(tilePos, Direction.UP, false);
        if (!upPos.equals(tilePos)) {
            adjacentTiles.add(upPos);
        }

        IntVector2D downPos = canMove(tilePos, Direction.DOWN, false);
        if (!downPos.equals(tilePos)) {
            adjacentTiles.add(downPos);
        }

        IntVector2D leftPos = canMove(tilePos, Direction.LEFT, false);
        if (!leftPos.equals(tilePos)) {
            adjacentTiles.add(leftPos);
        }

        IntVector2D rightPos = canMove(tilePos, Direction.RIGHT, false);
        if (!rightPos.equals(tilePos)) {
            adjacentTiles.add(rightPos);
        }

        return adjacentTiles;
    }
}
