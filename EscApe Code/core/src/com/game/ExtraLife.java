package com.game;

/**
 * Class for extra life power-up
 * @author Kerem Tekik
 * @date 24/12/2021
 */
public class ExtraLife extends PowerUps {

    public final int EXTRA_LIFE_PRICE = 3000;
    private int extraLifeCount;

    /**
     * Constructs an extra lif power-up
     */
    public ExtraLife() {
        extraLifeCount = 10000;
        setLocked(false);
    }

    /**
     * Purchases extra life if profile has sufficient coins
     *
     */
    public void purchase() {
        if(Profile.getCoinCount() > EXTRA_LIFE_PRICE) {
            extraLifeCount++;
            Profile.setCoinCount(Profile.getCoinCount() - EXTRA_LIFE_PRICE);
        }
    }

    /**
     * Activates extra life if the count of extra lives is more than zero
     */
    public void activate(){
        if(extraLifeCount > 0){
            extraLifeCount--;
        }
    }

    /**
     * Returns extra life count
     * @return is extra life count.
     */
    public int getExtraLifeCount(){
        return extraLifeCount;
    }
}
