package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;

/**
 * NOT ACTIVE CLASS!
 * Creates a scores menu
 * @author Ali Kaan Şahin
 */
public class ScoresMenu implements Screen{

	private GameMain parent;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table;
	private Stage stage;
	private TextButton backButton;
	private BitmapFont whiteFont;
	private LabelStyle heading;
	private Label label, scoreLabel;

	/**
	 * Constructs a scores menu
	 * @param gameMain is a place where score menu is constructed
	 */
	public ScoresMenu(GameMain gameMain) {
		setParent(gameMain);
	}
	@Override
	public void show() {

		//importing font
		//whiteFont = new BitmapFont(Gdx.files.internal("assets/whiteTxt.fnt"), false);

		//atlas = new TextureAtlas(Gdx.files.internal("badlogic.jpg"));
		//creating skin
		//skin = new Skin(atlas);

		//skin.add(whiteFont);

		//creating new table object
		table = new Table();
		table.setFillParent(true);//?
		//table.setDebug(true);//?
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		//creating label
		label = new Label("Best score: ", heading);
		//creating the buttons
		scoreLabel = new Label("" + Profile.getHighestScore(), heading);


		//adding functionality to buttons
		backButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent e, Actor actor) {
				parent.changeScreen(GameMain.SINGLE_PLAYER_MENU);
			}
		});

		//adding buttons to the table
		table.add(label);//from the database best
		table.row();
		table.add( scoreLabel );//from the database second
		table.row();

		//adding table to stage
		stage.addActor(table);

	}
	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));

		//Table.drawDebug(stage);

		//stage.act(delta);
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