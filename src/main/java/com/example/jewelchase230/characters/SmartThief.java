package com.example.jewelchase230.characters;

import com.example.jewelchase230.Direction;
import com.example.jewelchase230.Level;
import com.example.jewelchase230.items.Door;
import com.example.jewelchase230.items.Item;
import com.example.jewelchase230.items.Lever;
import com.example.jewelchase230.items.Loot;
import com.example.jewelchase230.vectors.IntVector2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * The SmartThief, this is the smartest thief in the game.
 * It tries to collect all the closest loot until all collected
 * then tries to get to the door before the player reaches it.
 *
 * @author Will Kaye
 */
public final class SmartThief extends AICharacter {
    /**
     * The amount of time between moves.
     * The smart thief is the slowest character.
     */
    private static final int MOVE_SPEED = 1350;

    /**
     * Left facing image.
     */
    private static final String FACING_LEFT_IMAGE =
            "images/SMART_THIEF_LEFT.png";
    /**
     * Right facing image.
     */
    private static final String FACING_RIGHT_IMAGE =
            "images/SMART_THIEF_RIGHT.png";

    /**
     * The item the thief is heading towards.
     */
    private Item targetItem;

    /**
     * Position of random tile if no loot is left.
     */
    private IntVector2D randomTarget;

    /**
     * The number of moves towards the current target item.
     */
    private int distanceMoved;

    /**
     * Parent nodes from BFS traversal.
     */
    private int[] parent;

    /**
     * The distance from the position the thief began to head
     * towards the target item.
     */
    private int[] distance;

    /**
     * Constructs a renderable component.
     */
    public SmartThief() {
        super();
        setFacingLeftImage(FACING_LEFT_IMAGE);
        setFacingRightImage(FACING_RIGHT_IMAGE);
        setDirection(Direction.NONE);
        setMoveSpeed(MOVE_SPEED);
        randomTarget = null;
    }

    @Override
    protected void makeNextMove() {
        Level level = getLevel();

        // Check if there is currently a target item.
        boolean invalidTargetItem = targetItem == null
                || targetItem.hasExploded()
                || level.getItem(targetItem.getGridPosition()) != targetItem;
        boolean invalidRandomTarget = randomTarget == null
                || randomTarget.equals(getGridPosition());
        if (invalidTargetItem && invalidRandomTarget) {
            findNextTargetItem();
        }

        IntVector2D nextPos = null;
        if (targetItem != null || randomTarget != null) {
            IntVector2D targetPos;

            if (randomTarget != null) {
                targetPos = randomTarget;
            } else {
                targetPos = targetItem.getGridPosition();
            }

            /* Find the next position to move to which eventually leads
            to the target position. */
            int currentParent = getTileIdx(targetPos);
            distanceMoved++;
            /* Goes up the path from the target pos to the move after
            reaching the current position. */
            while (distance[currentParent] != distanceMoved) {
                currentParent = parent[currentParent];

                if (currentParent == -1) {
                    targetItem = null;
                    return;
                }
            }
            nextPos = getTilePos(currentParent);
        }

        // If the next position has been found move.
        // Check that square can still be moved into.
        if (nextPos != null && canCharactersCollide(nextPos)) {
            //Only for image changes, direction is not relevent.
            int xDiff = nextPos.getX() - getGridPosition().getX();
            if (xDiff > 0) {
                setDirection(Direction.RIGHT);
            } else if (xDiff < 0) {
                setDirection(Direction.LEFT);
            }
            setGridPosition(nextPos);
        } else {
            distanceMoved--; // Undo move
        }
    }

    /**
     * Selects the next closest item to where the thief is.
     */
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
                if (!loot.hasExploded()) {
                    potentialTiles.add(loot.getGridPosition());
                }
            }

            for (Lever lever : targetLevers) {
                if (!lever.hasExploded()) {
                    potentialTiles.add(lever.getGridPosition());
                }
            }
        } else {
            // Look for doors if there is no more loot or levers
            ArrayList<Door> doors = level.getAllItemsOfType(Door.class);
            for (Door door : doors) {
                potentialTiles.add(door.getGridPosition());
            }
        }

        if (potentialTiles.size() < 1) {
            // Head towards random tile as there is no objectives
            Random random = new Random();
            while (potentialTiles.size() < 1) {
                int randomX = random.nextInt(levelSize.getX() - 1);
                int randomY = random.nextInt(levelSize.getY() - 1);
                IntVector2D pos = new IntVector2D(randomX, randomY);

                // Ensure tile is reachable
                if (distance[getTileIdx(pos)] != -1) {
                    potentialTiles.add(pos);
                    randomTarget = pos;
                }
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

        IntVector2D upPos = canMoveIgnoreCharacters(tilePos, Direction.UP);
        if (!upPos.equals(tilePos)) {
            adjacentTiles.add(upPos);
        }

        IntVector2D downPos = canMoveIgnoreCharacters(tilePos, Direction.DOWN);
        if (!downPos.equals(tilePos)) {
            adjacentTiles.add(downPos);
        }

        IntVector2D leftPos = canMoveIgnoreCharacters(tilePos, Direction.LEFT);
        if (!leftPos.equals(tilePos)) {
            adjacentTiles.add(leftPos);
        }

        IntVector2D rightPos = canMoveIgnoreCharacters(tilePos,
                Direction.RIGHT);
        if (!rightPos.equals(tilePos)) {
            adjacentTiles.add(rightPos);
        }

        return adjacentTiles;
    }
}
