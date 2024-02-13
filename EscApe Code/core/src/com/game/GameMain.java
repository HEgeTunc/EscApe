package com.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameMain extends Game {

	private SpriteBatch batch;
	
	private MainMenu mainMenu;
	//inside the main
	private SinglePlayerMenu singlePlayerMenu;
	//inside the singleplayer
	private ShopMenu shopMenu;
	private ScoresMenu scoresMenu;
	//inside the main
	private MultiplayerMenu multiplayerMenu;
	//inside the multiplayer
	private CreateServerMenu createServerMenu;
	private JoinServerMenu joinServerMenu;
	//inside the main
	private ProfilesMenu profilesMenu;
	//inside the main
	private SettingsMenu settingsMenu;
	//inside the settings
	private ControlsMenu controlsMenu;
	
	private GameScreen gameScreen;
	
	private GameOverScreen gameOverScreen;
	
	public final static int MAIN_MENU = 0; 
	public final static int SINGLE_PLAYER_MENU = 1;
	public final static int SHOP_MENU = 2;
	public final static int SCORES_MENU = 3;
	public final static int MULTIPLAYER_MENU = 4;
	public final static int CREATE_SERVER_MENU = 5;
	public final static int JOIN_SERVER_MENU = 6;
	public final static int PROFILES_MENU = 7;
	public final static int SETTINGS_MENU = 8;
	public final static int GAME_SCREEN = 9;
	public final static int GAME_OVER_SCREEN = 10;
	public final static int CONTROLS_MENU = 11;

	
	
	//swapping screens
	public void changeScreen(int screen) {
		switch(screen){
		case MAIN_MENU:	
			mainMenu = new MainMenu(this);
			this.setScreen(mainMenu);
			break;
		case SINGLE_PLAYER_MENU:	
			singlePlayerMenu = new SinglePlayerMenu(this);
			this.setScreen(singlePlayerMenu);
			break;
		case SHOP_MENU:	
			shopMenu = new ShopMenu(this);
			this.setScreen(shopMenu);
			break;
		case SCORES_MENU:	
			scoresMenu = new ScoresMenu(this);
			this.setScreen(scoresMenu);
			break;
		case MULTIPLAYER_MENU:	
			multiplayerMenu = new MultiplayerMenu(this);
			this.setScreen(multiplayerMenu);
			break;
		case CREATE_SERVER_MENU:	
			createServerMenu = new CreateServerMenu(this);
			this.setScreen(createServerMenu);
			break;
		case JOIN_SERVER_MENU:	
			joinServerMenu = new JoinServerMenu(this);
			this.setScreen(joinServerMenu);
			break;
		case PROFILES_MENU:	
			profilesMenu = new ProfilesMenu(this);
			this.setScreen(profilesMenu);
			break;
		case SETTINGS_MENU:	
			settingsMenu = new SettingsMenu(this);
			this.setScreen(settingsMenu);
			break;

		case GAME_SCREEN:	
			gameScreen = new GameScreen(this);//?
			this.setScreen(gameScreen);
			break;

		case GAME_OVER_SCREEN:
			gameOverScreen = new GameOverScreen(this);
			this.setScreen(gameOverScreen);
			break;

		case CONTROLS_MENU:
			controlsMenu = new ControlsMenu(this);
			this.setScreen(controlsMenu);
			break;
		}
	}
	@Override
	public void create () {
		this.mainMenu = new MainMenu(this);
		batch = new SpriteBatch();
		setScreen(mainMenu);
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

	public SpriteBatch getBatch() {
		return this.batch;
	}
}
