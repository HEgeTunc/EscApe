package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Profile {

    private static Wing wing = new Wing();
    private static Shield shield = new Shield();
    private static ExtraLife extraLife = new ExtraLife();
    private static final Preferences preferences = Gdx.app.getPreferences("Data");

    public static void resetData() {
        preferences.putString("nickName", "");
        preferences.putInteger("coinCount", 0);
        preferences.putInteger("highestScore", 0);
        preferences.putInteger("wingLevel", 0);
        preferences.putInteger("shieldLevel", 0);
        preferences.putInteger("extraLifeCount", 0);
        preferences.flush();
    }

    public static void createData() {
        try {
            preferences.getString("nickName");
        }
        catch(NullPointerException e) {
            preferences.putString("nickName", "");
            preferences.flush();
        }

        try {
            preferences.getInteger("coinCount");
        }
        catch(NullPointerException e) {
            preferences.putInteger("coinCount", 0);
            preferences.flush();
        }

        try {
            preferences.getInteger("highestScore");
        }
        catch(NullPointerException e) {
            preferences.putInteger("highestScore", 0);
            preferences.flush();
        }

        try {
            preferences.getInteger("wingLevel");
        }
        catch(NullPointerException e) {
            preferences.putInteger("wingLevel", 0);
            preferences.flush();
        }

        try {
            preferences.getInteger("shieldLevel");
        }
        catch(NullPointerException e) {
            preferences.putInteger("shieldLevel", 0);
            preferences.flush();
        }

        try {
            preferences.getInteger("extraLifeCount");
        }
        catch(NullPointerException e) {
            preferences.putInteger("extraLifeCount", 0);
            preferences.flush();
        }
    }

    public static String getNickName() {
        return preferences.getString("nickName");
    }

    public static void setNickName(String nickName) {
        preferences.putString("nickName", nickName);
        preferences.flush();
    }

    public static int getCoinCount() {
        return preferences.getInteger("coinCount");
    }

    public static void setCoinCount(int coinCount) {
        preferences.putInteger("coinCount", coinCount);
        preferences.flush();
    }

    public static int getHighestScore() {
        return preferences.getInteger("highestScore");
    }

    public static void setHighestScore(int highestScore) {
        preferences.putInteger("highestScore", highestScore);
        preferences.flush();
    }

    public static void updateHighestScore(int newScore) {
        if (newScore > preferences.getInteger("highestScore")) setHighestScore(newScore);
    }

    public static Wing getWing() {
        return wing;
    }

    public static void setWing(Wing wing) {
        Profile.wing = wing;
    }

    public static int getWingLevel() {
        return preferences.getInteger("wingLevel");
    }

    public static void setWingLevel(int wingLevel) {
        preferences.putInteger("wingLevel", wingLevel);
        preferences.flush();
    }

    public static Shield getShield() {
        return shield;
    }

    public static void setShield(Shield shield) {
        Profile.shield = shield;
    }

    public static int getShieldLevel() {
        return preferences.getInteger("shieldLevel");
    }

    public static void setShieldLevel(int shieldLevel) {
        preferences.putInteger("shieldLevel", shieldLevel);
        preferences.flush();
    }

    public static ExtraLife getExtraLife() {
        return extraLife;
    }

    public static void setExtraLife(ExtraLife extraLife) {
        Profile.extraLife = extraLife;
    }

    public static int getExtraLifeCount() {
        return preferences.getInteger("extraLifeCount");
    }

    public static void setExtraLifeCount(int extraLifeCount) {
        preferences.putInteger("extraLifeCount", extraLifeCount);
        preferences.flush();
    }
}
