package com.game;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Class for a shield object
 * @author Kerem Tekik
 * @version 1.0
 */
public class Shield extends PowerUps {

    private final int BEGINNING_IMPACT_DURATION = 5;
    private final int AMOUNT_OF_INCREMENT = 2;
    private boolean isActive;
    private int numOfShieldsInGame = 3;

    /**
     * Initializes a shield object by setting its initial impact duration and
     * amount of increment in each upgrade.
     */
    public Shield() {
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
        if(numOfShieldsInGame > 0 && !isActive ) {
            isActive = true;
            Timer qwe = new Timer();
            Deactivator asd = new Deactivator();
            qwe.schedule(asd, 5000);
            numOfShieldsInGame--;
        }
    }

    //getter for isActive
    public boolean isActive(){
        return isActive;
    }
}
