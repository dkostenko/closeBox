/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import game.Settings;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import models.Block;
import models.Level;

/**
 *
 * @author macbook
 */
public class LevelView extends javax.swing.JPanel {

    private Level level;
    /**
     * Creates new form LevelView
     */
    public LevelView(Level level) {
        initComponents();
        this.level = level;
    }
    
    
    public void updateModel(Level level){
        this.level = level;
    }
    

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(2));
        
        drawGameField(g2d);
        drawCurrentPosition(g2d);
        drawBlocks(g2d);
    }
    
    
    private void drawGameField(Graphics2D g2d){
        // Периметр игрового поля
        g2d.drawRect(level.getOffset().x, 
                     level.getOffset().y, 
                     level.getWidth() * Settings.getBLOCK_SIZE(),
                     level.getHeight() * Settings.getBLOCK_SIZE());
        
        
        
        for(int i = 1; i < level.getHeight(); ++i){
            for (int j = 1; j < level.getWidth(); ++j) {
                // Вертикальные полосы
                g2d.drawLine(level.getOffset().x + j * Settings.getBLOCK_SIZE(), 
                             level.getOffset().y, 
                             level.getOffset().x + j * Settings.getBLOCK_SIZE(), 
                             level.getOffset().y + Settings.getBLOCK_SIZE() * level.getHeight());
                
                // Горизонтальные полосы
                g2d.drawLine(level.getOffset().x, 
                             level.getOffset().y + i * Settings.getBLOCK_SIZE(), 
                             level.getOffset().x + Settings.getBLOCK_SIZE() * level.getWidth(), 
                             level.getOffset().y + i * Settings.getBLOCK_SIZE());
            }
        }
    }
    
    
    private void drawBlocks(Graphics2D g2d){
        Block block;
        for (int i = 0; i < level.getBlocks().size(); ++i) {
            block = level.getBlocks().get(i);
            
            if(block.isBig()){
                drawBigBlock(g2d, block);
            } else {
                drawSmallBlock(g2d, block);
            }
        }
    }
    
    
    private void drawBigBlock(Graphics2D g2d, Block block){
        Point topLeft = new Point(level.getOffset().x + Settings.getBLOCK_SIZE() * block.getCol() + 10 ,
                                  level.getOffset().y + Settings.getBLOCK_SIZE() * block.getRow() + 10);
        
        Point topRight = new Point(level.getOffset().x + Settings.getBLOCK_SIZE() * block.getCol() + Settings.getBLOCK_SIZE() - 10,
                                   level.getOffset().y + Settings.getBLOCK_SIZE() * block.getRow() + 10);
        
        Point bottomLeft = new Point(level.getOffset().x + Settings.getBLOCK_SIZE() * block.getCol() + 10,
                                     level.getOffset().y + Settings.getBLOCK_SIZE() * block.getRow() + Settings.getBLOCK_SIZE() - 10);
        
        Point bottomRight = new Point(level.getOffset().x + Settings.getBLOCK_SIZE() * block.getCol() + Settings.getBLOCK_SIZE() - 10,
                                      level.getOffset().y + Settings.getBLOCK_SIZE() * block.getRow() + Settings.getBLOCK_SIZE() - 10);
        
        switch(block.getType()){
            case OPEN_ON_THE_TOP:
                // левая палка
                g2d.drawLine(topLeft.x, 
                             topLeft.y, 
                             bottomLeft.x, 
                             bottomLeft.y);
                
                // правая палка
                g2d.drawLine(topRight.x, 
                             topRight.y, 
                             bottomRight.x, 
                             bottomRight.y);
                
                // нижняя палка
                g2d.drawLine(bottomLeft.x, 
                             bottomLeft.y, 
                             bottomRight.x, 
                             bottomRight.y);
                break;
                
            case OPEN_ON_THE_RIGHT:
                // верхняя палка
                g2d.drawLine(topLeft.x, 
                             topLeft.y, 
                             topRight.x, 
                             topRight.y);
                // левая палка
                g2d.drawLine(topLeft.x, 
                             topLeft.y, 
                             bottomLeft.x, 
                             bottomLeft.y);
                
                // нижняя палка
                g2d.drawLine(bottomLeft.x, 
                             bottomLeft.y, 
                             bottomRight.x, 
                             bottomRight.y);
                break;
                
            case OPEN_ON_THE_BOTTOM:
                // левая палка
                g2d.drawLine(topLeft.x, 
                             topLeft.y, 
                             bottomLeft.x, 
                             bottomLeft.y);
                
                // правая палка
                g2d.drawLine(topRight.x, 
                             topRight.y, 
                             bottomRight.x, 
                             bottomRight.y);
                
                // верхняя палка
                g2d.drawLine(topLeft.x, 
                             topLeft.y, 
                             topRight.x, 
                             topRight.y);
                break;
                
            case OPEN_ON_THE_LEFT:
                // верхняя палка
                g2d.drawLine(topLeft.x, 
                             topLeft.y, 
                             topRight.x, 
                             topRight.y);
                // правая палка
                g2d.drawLine(topRight.x, 
                             topRight.y, 
                             bottomRight.x, 
                             bottomRight.y);
                
                // нижняя палка
                g2d.drawLine(bottomLeft.x, 
                             bottomLeft.y, 
                             bottomRight.x, 
                             bottomRight.y);
                break;
        }
    }
    
    
    private void drawSmallBlock(Graphics2D g2d, Block block){
        Point topLeft = new Point(level.getOffset().x + Settings.getBLOCK_SIZE() * block.getCol() + 15 ,
                                  level.getOffset().y + Settings.getBLOCK_SIZE() * block.getRow() + 15);
        
        Point topRight = new Point(level.getOffset().x + Settings.getBLOCK_SIZE() * block.getCol() + Settings.getBLOCK_SIZE() - 15,
                                   level.getOffset().y + Settings.getBLOCK_SIZE() * block.getRow() + 15);
        
        Point bottomLeft = new Point(level.getOffset().x + Settings.getBLOCK_SIZE() * block.getCol() + 15,
                                     level.getOffset().y + Settings.getBLOCK_SIZE() * block.getRow() + Settings.getBLOCK_SIZE() - 15);
        
        Point bottomRight = new Point(level.getOffset().x + Settings.getBLOCK_SIZE() * block.getCol() + Settings.getBLOCK_SIZE() - 15,
                                      level.getOffset().y + Settings.getBLOCK_SIZE() * block.getRow() + Settings.getBLOCK_SIZE() - 15);
        
        switch(block.getType()){
            case OPEN_ON_THE_TOP:
                // левая палка
                g2d.drawLine(topLeft.x, 
                             topLeft.y, 
                             bottomLeft.x, 
                             bottomLeft.y);
                
                // правая палка
                g2d.drawLine(topRight.x, 
                             topRight.y, 
                             bottomRight.x, 
                             bottomRight.y);
                
                // нижняя палка
                g2d.drawLine(bottomLeft.x, 
                             bottomLeft.y, 
                             bottomRight.x, 
                             bottomRight.y);
                break;
                
            case OPEN_ON_THE_RIGHT:
                // верхняя палка
                g2d.drawLine(topLeft.x, 
                             topLeft.y, 
                             topRight.x, 
                             topRight.y);
                // левая палка
                g2d.drawLine(topLeft.x, 
                             topLeft.y, 
                             bottomLeft.x, 
                             bottomLeft.y);
                
                // нижняя палка
                g2d.drawLine(bottomLeft.x, 
                             bottomLeft.y, 
                             bottomRight.x, 
                             bottomRight.y);
                break;
                
            case OPEN_ON_THE_BOTTOM:
                // левая палка
                g2d.drawLine(topLeft.x, 
                             topLeft.y, 
                             bottomLeft.x, 
                             bottomLeft.y);
                
                // правая палка
                g2d.drawLine(topRight.x, 
                             topRight.y, 
                             bottomRight.x, 
                             bottomRight.y);
                
                // верхняя палка
                g2d.drawLine(topLeft.x, 
                             topLeft.y, 
                             topRight.x, 
                             topRight.y);
                break;
                
            case OPEN_ON_THE_LEFT:
                // верхняя палка
                g2d.drawLine(topLeft.x, 
                             topLeft.y, 
                             topRight.x, 
                             topRight.y);
                // правая палка
                g2d.drawLine(topRight.x, 
                             topRight.y, 
                             bottomRight.x, 
                             bottomRight.y);
                
                // нижняя палка
                g2d.drawLine(bottomLeft.x, 
                             bottomLeft.y, 
                             bottomRight.x, 
                             bottomRight.y);
                break;
        }
    }

    
    private void drawCurrentPosition(Graphics2D g2d){
        g2d.fillRect(level.getOffset().x + Settings.getBLOCK_SIZE() * level.getCurrentCol() + Settings.getBLOCK_SIZE() / 4, 
                     level.getOffset().y + Settings.getBLOCK_SIZE() * level.getCurrentRow() + Settings.getBLOCK_SIZE() / 4, 
                     Settings.getBLOCK_SIZE() / 2, 
                     Settings.getBLOCK_SIZE() / 2);
    }
    

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
