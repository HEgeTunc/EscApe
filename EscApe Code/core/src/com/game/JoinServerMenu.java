package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;

/**
 * NOT ACTIVE CLASS!
 * This class creates a join server menu
 * @authors Ali Kaan Şahin
 */
public class JoinServerMenu implements Screen{

	private GameMain parent;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table;
	private Stage stage;
	private TextButton joinServerButton, readyButton;
	private BitmapFont whiteFont;
	private LabelStyle heading;

	/**
	 * Constructs a join server menu
	 * @param gameMain is a place where join server menu is created.
	 */
	public JoinServerMenu(GameMain gameMain) {
		setParent(gameMain);
	}
	
	@Override
	public void show() {

		//creating new table object
		table = new Table(skin);
		table.setFillParent(true);//?
		//table.setDebug(true);//?
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		//creating the buttons
		joinServerButton = new TextButton("Join Server", skin);
		readyButton = new TextButton("READY!", skin);

		//adding functionality to buttons
		joinServerButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent e, Actor actor) {
				//TODO creating server with this button
			}
		});
		readyButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent e, Actor actor) {
				//TODO starting the game with this button
			}
		});

		//adding buttons to the table
		table.add(joinServerButton).fillX().uniformX();
		table.row().pad(10, 0, 10, 0);//adding some spaces within row
		table.add(readyButton).fillX().uniformX();
		table.row();
		
		//adding table to stage
		stage.addActor(table);

	}
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
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
	}

	public GameMain getParent() {
		return parent;
	}

	public void setParent(GameMain parent) {
		this.parent = parent;
	}

}