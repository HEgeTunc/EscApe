package com.game;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Class for wing power-up
 * @author Kerem Tekik
 * @date 24/12/2021
 */
public class Wing extends PowerUps {

    private final int BEGINNING_IMPACT_DURATION = 3;
    private final int AMOUNT_OF_INCREMENT = 1;
    private boolean isActive;
    private int numOfWingsInGame = 3;

    /**
     * Initializes a shield object by setting its initial impact duration and
     * amount of increment in each upgrade.
     */
    public Wing() {
        setLevel1ImpactDuration(BEGINNING_IMPACT_DURATION);
        setAmountOfIncrementDuration(AMOUNT_OF_INCREMENT);
    }

    /**
     * Deactivates the power-up when impact duration ends
     */
    private class Deactivator extends TimerTask {
        public void run(){
            isActive = false;
        }
    }

    /**
     * Activates the power-ups if number of shields is greater than three and
     * current activation status of shield is false.
     */
    public void activate() {
        if(numOfWingsInGame > 0 && !isActive) {
            isActive = true;
            Timer tyu = new Timer();
            Deactivator ghj = new Deactivator();
            tyu.schedule(ghj,3000);
            numOfWingsInGame--;
        }
    }

    /**
     * Returns the activation status of the wing
     * @return isActive
     */
    public boolean isActive(){
        return isActive;
    }
}
