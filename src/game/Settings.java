/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author macbook
 */
public class Settings {
    private static final int GAME_WIDTH = 780;
    private static final int GAME_HEIGHT = 600;
    private static final int BLOCK_SPEED = 2;
    private static final int BLOCK_SIZE = 80;
    private static Controller AVAILABLE_CONTROL = Controller.NONE;
    private static final int FRAMES_PER_SECOND = 25;
    private static final int SKIP_TICKS = 1000 / FRAMES_PER_SECOND;
    private static final int TIME_BETWEEN_LEVELS = 2000;

    /**
     * @return the GAME_WIDTH
     */
    public static int getGAME_WIDTH() {
        return GAME_WIDTH;
    }

    /**
     * @return the GAME_HEIGHT
     */
    public static int getGAME_HEIGHT() {
        return GAME_HEIGHT;
    }

    /**
     * @return the BLOCK_SPEED
     */
    public static int getBLOCK_SPEED() {
        return BLOCK_SPEED;
    }

    /**
     * @return the BLOCK_SIZE
     */
    public static int getBLOCK_SIZE() {
        return BLOCK_SIZE;
    }

    /**
     * @return the AVAILABLE_CONTROL
     */
    public static Controller getAVAILABLE_CONTROL() {
        return AVAILABLE_CONTROL;
    }

    /**
     * @param aAVAILABLE_CONTROL the AVAILABLE_CONTROL to set
     */
    public static void setAVAILABLE_CONTROL(Controller aAVAILABLE_CONTROL) {
        AVAILABLE_CONTROL = aAVAILABLE_CONTROL;
    }

    /**
     * @return the FRAMES_PER_SECOND
     */
    public static int getFRAMES_PER_SECOND() {
        return FRAMES_PER_SECOND;
    }

    /**
     * @return the SKIP_TICKS
     */
    public static int getSKIP_TICKS() {
        return SKIP_TICKS;
    }

    /**
     * @return the TIME_BETWEEN_LEVELS
     */
    public static int getTIME_BETWEEN_LEVELS() {
        return TIME_BETWEEN_LEVELS;
    }
}
