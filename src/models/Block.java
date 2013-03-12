/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import game.BlockType;
/**
 *
 * @author macbook
 */
public class Block {
    private int row;
    private int col;
    private BlockType type;
    private boolean big;
    
    public Block(int row, int col, BlockType type, boolean big){
        this.row = row;
        this.col = col;
        this.type = type;
        this.big = big;
    }
    
    public void moveToTop(){
        row--;
    }
    
    public void moveToRight(){
        col++;
    }
    
    public void moveToBottom(){
        row++;
    }
    
    public void moveToLeft(){
        col--;
    }
    
    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @return the col
     */
    public int getCol() {
        return col;
    }

    /**
     * @return the type
     */
    public BlockType getType() {
        return type;
    }

    /**
     * @return the big
     */
    public boolean isBig() {
        return big;
    }
    
}
