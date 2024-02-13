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
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * This class creates a single player game menu
 * @author Ali Kaan Şahin
 */
public class SinglePlayerMenu implements Screen{

	private GameMain parent;
	private Table table;
	private Stage stage;
	private ImageButton playButton,
	shopButton, scoresButton, backButton;
	private Texture background, escape;

	/**
	 * Constructs a single player menu
	 * @param gameMain is a place where single player menu is created
	 */
	public SinglePlayerMenu(GameMain gameMain) {

		setParent(gameMain);
		stage = new Stage(new ScreenViewport());
		//adding processor to process inputs to stage
		Gdx.input.setInputProcessor(stage);
		background = new Texture("CB-5.jpg");
		//performing actions of stage
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));//?
		stage.draw();
		table = new Table();
		backButton = new ImageButton(new SpriteDrawable(new Sprite(new Texture("back.png"))));
	}

	@Override
	public void show() {

		//creating new table object

		table.setFillParent(true);//?
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		//creating the buttons
		playButton = new ImageButton(new SpriteDrawable(new Sprite(new Texture("SinglePlayerMenu/play.png"))));
		shopButton = new ImageButton(new SpriteDrawable(new Sprite(new Texture("SinglePlayerMenu/Shop.png"))));
		scoresButton = new ImageButton(new SpriteDrawable(new Sprite(new Texture("SinglePlayerMenu/score.png"))));

		//adding functionality to buttons
		backButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent e, Actor actor) {
				parent.changeScreen(GameMain.MAIN_MENU);
			}
		});
		playButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent e, Actor actor) {
				parent.changeScreen(GameMain.GAME_SCREEN);
			}
		});
		shopButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent e, Actor actor) {
				parent.changeScreen(GameMain.SHOP_MENU);
			}
		});
		scoresButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent e, Actor actor) {
				parent.changeScreen(GameMain.GAME_OVER_SCREEN);
			}
		});

		//adding buttons to the table
		table.add(backButton);
		table.row().pad(10, 0, 10, 0);//adding some spaces within row
		table.add(playButton).fillX().uniformX();
		table.row().pad(10, 0, 10, 0);//adding some spaces within row
		table.add(shopButton).fillX().uniformX();
		table.row();
		table.add(scoresButton).fillX().uniformX();
		table.row();

		//adding table to stage
		stage.addActor(table);

	}
	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		parent.getBatch().begin();
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		parent.getBatch().draw(background,0,0);
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