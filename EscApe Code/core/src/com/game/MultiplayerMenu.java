package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * This class creates a multiplayer game menu
 * @author Ali Kaan Şahin
 */
public class MultiplayerMenu implements Screen{

	private GameMain parent;
	private Table table;
	private final Stage stage;
	private ImageButton createServerButton, joinServerButton,
	statsButton, backButton;
	private BitmapFont whiteFont;
	private Label heading;
	private final Texture background;

	/**
	 * Constructs a multiplayer game menu
	 * @param gameMain is a place where multiplayer game menu is created
	 */
	public MultiplayerMenu(GameMain gameMain) {
		setParent(gameMain);
		stage = new Stage(new ScreenViewport());
		//adding processor to process inputs to stage
		Gdx.input.setInputProcessor(stage);
		background = new Texture("CB-5.jpg");
		//performing actions of stage
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));//?
		stage.draw();
		table = new Table();
	}
	
	@Override
	public void show() {

		//creating new table object
		table = new Table();
		table.setFillParent(true);//?
		//table.setDebug(true);//?
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		//creating the buttons
		backButton = new ImageButton(new SpriteDrawable(new Sprite(new Texture("back.png"))));
		createServerButton = new ImageButton(new SpriteDrawable(new Sprite(new Texture("MultiMenu/createServer.png"))));
		joinServerButton = new ImageButton(new SpriteDrawable(new Sprite(new Texture("MultiMenu/joinServer.png"))));

		//adding functionality to buttons
		backButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent e, Actor actor) {
				parent.changeScreen(GameMain.MAIN_MENU);
			}
		});
		createServerButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent e, Actor actor) {
				parent.changeScreen(GameMain.CREATE_SERVER_MENU);
			}
		});
		joinServerButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent e, Actor actor) {
				parent.changeScreen(GameMain.JOIN_SERVER_MENU);
			}
		});

		//adding buttons to the table
		table.add(backButton).fillX().uniformX();
		table.row();
		table.add(createServerButton).fillX().uniformX();
		table.row().pad(10, 0, 10, 0);//adding some spaces within row
		table.add(joinServerButton).fillX().uniformX();
		table.row();
		table.add(statsButton).fillX().uniformX();
		table.row();

		//adding table to stage
		stage.addActor(table);

	}
	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		parent.getBatch().begin();
		parent.getBatch().draw(background, 0, 0);
		parent.getBatch().end();
		stage.draw();
	}
	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}
	@Override
	public void pause() {

	}
	@Override
	public void resume() {

	}
	@Override
	public void hide() {

	}
	@Override
	public void dispose() {
		stage.dispose();
		parent.dispose();
		background.dispose();
	}

	public GameMain getParent() {
		return parent;
	}

	public void setParent(GameMain parent) {
		this.parent = parent;
	}

}