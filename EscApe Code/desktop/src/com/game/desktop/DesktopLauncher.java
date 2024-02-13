package com.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.game.GameMain;
import com.game.GameScreen;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = GameScreen.HEIGHT;
		config.width = GameScreen.WIDTH;
		config.title = "EscApe";
		//config.backgroundFPS = 60;
		config.resizable = true;
		new LwjglApplication(new GameMain(), config);
	}
}
