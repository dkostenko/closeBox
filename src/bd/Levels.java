/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import game.BlockType;
import java.util.ArrayList;
import models.Block;
import models.Level;

/**
 *
 * @author macbook
 */
public class Levels {
    public static Level getLevel(int id){
        switch(id){
            case 1:
                return getLevel1();
            case 2:
                return getLevel2();
        }
        
        return null;
    }
    
    private static Level getLevel1(){
        ArrayList<Block> blocks = new ArrayList<>();
//        new Block(row, col, BlockType.OPEN_ON_THE_TOP, true)
        blocks.add(new Block(4, 4, BlockType.OPEN_ON_THE_LEFT, false)); // small
        blocks.add(new Block(3, 4, BlockType.OPEN_ON_THE_BOTTOM, true)); // big
//        new Level(id, width, height, timeLeft, blocks, currentRow, currentCol)
        return new Level(1, 5, 6, 20, blocks, 3, 4);
    }
    
    private static Level getLevel2(){
         ArrayList<Block> blocks = new ArrayList<>();
//        new Block(row, col, BlockType.OPEN_ON_THE_TOP, true)
        blocks.add(new Block(1, 1, BlockType.OPEN_ON_THE_LEFT, false)); // small
        blocks.add(new Block(3, 4, BlockType.OPEN_ON_THE_BOTTOM, true)); // big
//        new Level(id, width, height, timeLeft, blocks, currentRow, currentCol)
        return new Level(2, 5, 6, 20, blocks, 2, 2);
    }
}
