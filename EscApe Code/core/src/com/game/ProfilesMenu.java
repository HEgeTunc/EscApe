package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
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
 * This class creates a profiles menu
 * @author Ali Kaan Şahin
 */
public class ProfilesMenu implements Screen {

	private GameMain parent;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table;
	private Stage stage;
	private TextButton addProfileButton, profileButton1, profileButton2;
	private Texture background;

	/**
	 * Constructs a profiles menu
	 * @param gameMain is a place where profiles menu is created
	 */
	public ProfilesMenu(GameMain gameMain) {
		setParent(gameMain);
	}
	
	@Override
	public void show() {

		//creating new table object
		table = new Table();
		table.setFillParent(true);//?
		//table.setDebug(true);//?
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		//creating the buttons
		addProfileButton = new TextButton("create", skin);
		profileButton1 = new TextButton("Ege", skin);
		profileButton2 = new TextButton("Deniz", skin);

		//adding functionality to buttons
		profileButton1.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent e, Actor actor) {
				//TODO getting the data from Database
			}
		});
		profileButton2.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent e, Actor actor) {
				//TODO getting the data from the user
			}
		});
		addProfileButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent e, Actor actor) {
				//TODO adding user
			}
		});

		//adding buttons to the table
		table.add(profileButton1).fillX().uniformX();
		table.row();
		table.add(profileButton2).fillX().uniformX();
		table.row();
		table.add(addProfileButton).fillX().uniformX();
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
	}

	public GameMain getParent() {
		return parent;
	}

	public void setParent(GameMain parent) {
		this.parent = parent;
	}
}