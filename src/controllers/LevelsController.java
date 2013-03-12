/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import bd.Levels;
import game.Direction;
import game.Main;
import game.State;
import models.Level;
import views.LevelView;

/**
 *
 * @author macbook
 */
public final class LevelsController {
    private Level currentLevel;
    private LevelView levelView;
    
    
    public LevelsController(){
        restart();
        this.levelView = new LevelView(currentLevel);
    }
    
    
    public void moveBlock(Direction direction){
        System.out.println("Двигаемся " + direction);
        currentLevel.move(direction);
        levelView.updateModel(currentLevel);
    }
    
    
    public String updateTime(){
        int time = currentLevel.getTimeLeft();
        
        if(time < 1){
            game.Main.state = State.GAME_IS_LOST;
            System.out.println("Вы проиграли!!");
        }
        
        return "Осталось: " + String.valueOf(time);
    }
    
    
    public void draw(){
        this.levelView.repaint();
    }
    
    
    public void tryToFinishLevel(){
        if(currentLevel.isFinished()){
            currentLevel = Levels.getLevel(currentLevel.getId() + 1);
            levelView.updateModel(currentLevel);
            
            if(currentLevel == null){
                Main.state = State.GAME_IS_WON;
            }
        }
    }
    
    
    public void restart(){
        this.currentLevel = Levels.getLevel(1);
    }
    

    /**
     * @return the levelView
     */
    public LevelView getLevelView() {
        return levelView;
    }
}
