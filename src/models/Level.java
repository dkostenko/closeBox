/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import game.BlockType;
import game.Direction;
import game.Settings;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author macbook
 */
public class Level {
    private ArrayList<Block> blocks;
    private int id;
    private int timeLeft;
    private int currentRow;
    private int currentCol;
    private int width;
    private int height;
    private Point offset;
    private Block inBig;
    private Block inSmall;
    
    
    public Level(int id, int width, int height, int timeLeft, ArrayList<Block> blocks, int currentRow, int currentCol){
        this.id = id;
        this.width = width;
        this.height = height;
        this.timeLeft = timeLeft;
        this.blocks = blocks;
        this.currentCol = currentCol;
        this.currentRow = currentRow;
        this.offset = new Point((Settings.getGAME_WIDTH() - 200) / 2 - width * Settings.getBLOCK_SIZE() / 2,
                                Settings.getGAME_HEIGHT() / 2 - height * Settings.getBLOCK_SIZE() / 2);
    }
    
    
    public void move(Direction direction){
        currentSituation();
        
        switch(direction){
            case TOP:
                if(isMovementToTopPossible()){
                    moveToTop();
                }
                break;
            case RIGHT:
                if(isMovementToRightPossible()){
                    moveToRight();
                }
                break;
            case BOTTOM:
                if(isMovementToBottomPossible()){
                    moveToBottom();
                }
                break;
            case LEFT:
                if(isMovementToLeftPossible()){
                    moveToLeft();
                }
                break;
        }
    }

    
    public boolean isFinished(){
        if(blocks.get(0).getRow() == blocks.get(1).getRow() 
                && blocks.get(0).getCol() == blocks.get(1).getCol()){
            return true;
        }
        return false;
    }
    
    
    private void currentSituation(){
        inBig = null;
        inSmall = null;
        
        Block block;
        
        for (int i = 0; i < blocks.size(); ++i) {
            block = blocks.get(i);
            
            if(block.getCol() == currentCol 
                    && block.getRow() == currentRow){
                if(block.isBig()){
                    inBig = block;
                } else {
                    inSmall = block;
                }
            }
        }
    }
    
    
    private void moveToTop(){
        if(inBig != null){
            if(inBig.getType() != BlockType.OPEN_ON_THE_TOP){
                inBig.moveToTop();
                if(inSmall != null){
                    inSmall.moveToTop();
                }
            } else {
                if(inSmall != null && inSmall.getType() != BlockType.OPEN_ON_THE_TOP){
                    inSmall.moveToTop();
                }
            }
        } else {
            if(inSmall != null && inSmall.getType() != BlockType.OPEN_ON_THE_TOP){
                inSmall.moveToTop();
            }
        }
        
        currentRow--;
    }
    
    
    private void moveToLeft(){
        if(inBig != null){
            if(inBig.getType() != BlockType.OPEN_ON_THE_LEFT){
                inBig.moveToLeft();
                if(inSmall != null){
                    inSmall.moveToLeft();
                }
            } else {
                if(inSmall != null && inSmall.getType() != BlockType.OPEN_ON_THE_LEFT){
                    inSmall.moveToLeft();
                }
            }
        } else {
            if(inSmall != null && inSmall.getType() != BlockType.OPEN_ON_THE_LEFT){
                inSmall.moveToLeft();
            }
        }
        
        currentCol--;
    }
    
    
    private void moveToBottom(){
        if(inBig != null){
            if(inBig.getType() != BlockType.OPEN_ON_THE_BOTTOM){
                inBig.moveToBottom();
                if(inSmall != null){
                    inSmall.moveToBottom();
                }
            } else {
                if(inSmall != null && inSmall.getType() != BlockType.OPEN_ON_THE_BOTTOM){
                    inSmall.moveToBottom();
                }
            }
        } else {
            if(inSmall != null && inSmall.getType() != BlockType.OPEN_ON_THE_BOTTOM){
                inSmall.moveToBottom();
            }
        }
        
        currentRow++; 
    }
    
    
    private void moveToRight(){
        if(inBig != null){
            if(inBig.getType() != BlockType.OPEN_ON_THE_RIGHT){
                inBig.moveToRight();
                if(inSmall != null){
                    inSmall.moveToRight();
                }
            } else {
                if(inSmall != null && inSmall.getType() != BlockType.OPEN_ON_THE_RIGHT){
                    inSmall.moveToRight();
                }
            }
        } else {
            if(inSmall != null && inSmall.getType() != BlockType.OPEN_ON_THE_RIGHT){
                inSmall.moveToRight();
            }
        }
        
        currentCol++;
    }
    
    
    private boolean isMovementToTopPossible(){
        if(currentRow - 1 < 0){
            return false;
        }
        
        Block block;
        
        for (int i = 0; i < blocks.size(); ++i) {
            block = blocks.get(i);
            
            if(block.getCol() == currentCol 
                    && block.getRow() == currentRow - 1){
                
                if(block.getType() != BlockType.OPEN_ON_THE_BOTTOM){
                    return false;
                }
                
                if(inSmall != null && !block.isBig()
                        || inBig != null && block.isBig()
                        || inBig != null && !block.isBig()){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    
    private boolean isMovementToRightPossible(){
        if(currentCol + 1 >= width){
            return false;
        }
        
        Block block;
        
        for (int i = 0; i < blocks.size(); ++i) {
            block = blocks.get(i);
            
            if(block.getCol() == currentCol + 1
                    && block.getRow() == currentRow){
                
                if(block.getType() != BlockType.OPEN_ON_THE_LEFT){
                    return false;
                }
                
                if(inSmall != null && !block.isBig()
                        || inBig != null && block.isBig()
                        || inBig != null && !block.isBig()){
                    return false;
                }
            }
        }
        
        return true;
    }
    
   
    private boolean isMovementToBottomPossible(){
        if(currentRow + 1 >= height){
            return false;
        }
        
        Block futureBlock;
        
        for (int i = 0; i < blocks.size(); ++i) {
            futureBlock = blocks.get(i);
            
            if(futureBlock.getCol() == currentCol 
                    && futureBlock.getRow() == currentRow + 1){
                
                if(futureBlock.getType() != BlockType.OPEN_ON_THE_TOP){
                    return false;
                }
                
                if(inSmall != null && !futureBlock.isBig()
                        || inBig != null && futureBlock.isBig()
                        || inBig != null && !futureBlock.isBig() && futureBlock.getType() != BlockType.OPEN_ON_THE_TOP){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    
    private boolean isMovementToLeftPossible(){
        if(currentCol - 1 < 0){
            return false;
        }
        
        Block block;
        
        for (int i = 0; i < blocks.size(); ++i) {
            block = blocks.get(i);
            
            if(block.getCol() == currentCol - 1
                    && block.getRow() == currentRow){
                
                if(block.getType() != BlockType.OPEN_ON_THE_RIGHT){
                    return false;
                }
                
                if(inSmall != null && !block.isBig()
                        || inBig != null && block.isBig()
                        || inBig != null && !block.isBig()){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the timeLeft
     */
    public int getTimeLeft() {
        return timeLeft--;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return the blocks
     */
    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    /**
     * @return the currentRow
     */
    public int getCurrentRow() {
        return currentRow;
    }

    /**
     * @return the currentCol
     */
    public int getCurrentCol() {
        return currentCol;
    }

    /**
     * @return the offset
     */
    public Point getOffset() {
        return offset;
    }
}
