package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * This class creates shop menu.
 * @author Ali Kaan Şahin
 * @date 24/12/2021
 */
public class ShopMenu implements Screen{

	private GameMain parent;
	private Table table, table2;
	private Stage stage;
	private ImageButton backButton, unlockShieldButton,
	purchaseExtraLifeButton, upgradeWingButton;
	private BitmapFont font;
	private Label unlockInfoShield;
	private Label unlockInfoWing;
	private Label shieldPrice;
	private Label wingPrice;
	private Label extraLife;
	private Label purchaseInfo;
	private Label profileCoins;
	private Texture background, escape;

	/**
	 * Constructs a shop menu
	 * @param gameMain is a place where shop menu is created.
	 */
	public ShopMenu(GameMain gameMain) {

		setParent(gameMain);
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Alien Eclipse.otf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 80;

		font = generator.generateFont(parameter);
		this.unlockInfoShield = new Label("UNLOCK", new Label.LabelStyle(font, Color.WHITE) );
		this.unlockInfoWing =  new Label("UNLOCK", new Label.LabelStyle(font, Color.WHITE) );
		this.purchaseInfo =  new Label("PURCHASE", new Label.LabelStyle(font, Color.WHITE) );
		this.shieldPrice = new Label (" "+ Profile.getShield().UNLOCK_POWER_UP, new Label.LabelStyle(font, Color.WHITE));
		this.wingPrice = new Label (" "+ Profile.getWing().UNLOCK_POWER_UP, new Label.LabelStyle(font, Color.WHITE));
		this.extraLife = new Label (" " + Profile.getExtraLife().EXTRA_LIFE_PRICE, new Label.LabelStyle(font, Color.WHITE));
		profileCoins = new Label ("Coins " + Profile.getCoinCount(), new Label.LabelStyle(font, Color.WHITE));
		stage = new Stage(new ScreenViewport());
		//adding processor to process inputs to stage
		Gdx.input.setInputProcessor(stage);

		//performing actions of stage
		background = new Texture("CB-5.jpg");
		escape = new Texture("escape.png");
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));//?
		stage.draw();
		table = new Table();
		table2 = new Table ();
	}

	@Override
	public void show() {

		//creating new table object
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		//creating the buttons
		backButton = new ImageButton(new SpriteDrawable(new Sprite(new Texture("back.png"))));
		unlockShieldButton = new ImageButton(new SpriteDrawable(new Sprite(new Texture("Shop/shield.png"))));
		purchaseExtraLifeButton = new ImageButton(new SpriteDrawable(new Sprite(new Texture("Shop/extralife.png"))));
		upgradeWingButton = new ImageButton(new SpriteDrawable(new Sprite(new Texture("Shop/wings.png"))));

		//adding functionality to buttons
		backButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent e, Actor actor) {
				parent.changeScreen(GameMain.SINGLE_PLAYER_MENU);
			}
		});
		unlockShieldButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				Profile.getShield().upgrade();
				if(!Profile.getShield().getIsLocked()) {
					unlockInfoShield.setText("UPGRADE");
					shieldPrice.setText("" +Profile.getShield().UNLOCK_POWER_UP * Math.pow(2, Profile.getShield().getLevel() ));

				}
				if (Profile.getShieldLevel() == Profile.getShield().MAX_LEVEL) {
					unlockInfoShield.setText("MAXIMUM LEVEL");
					shieldPrice.setText("");
				}
				profileCoins.setText("Coins " + Profile.getCoinCount());
			}
		});
		purchaseExtraLifeButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				Profile.getExtraLife().purchase();
				profileCoins.setText("Coins " + Profile.getCoinCount());
			}
		});
		upgradeWingButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				Profile.getWing().upgrade();
				//Profile.setWingLevel(Profile.gryWingLevel() + 1);
				if (!Profile.getWing().getIsLocked()) {
					unlockInfoWing.setText("UPGRADE");
					wingPrice.setText("" +Profile.getWing().UNLOCK_POWER_UP * Math.pow(2, Profile.getWing().getLevel()));
				}
				if (Profile.getShieldLevel() == Profile.getShield().MAX_LEVEL) {
					unlockInfoShield.setText("MAXIMUM LEVEL");
					shieldPrice.setText("");
				}
				profileCoins.setText("Coins " + Profile.getCoinCount());
			}
		});

		//adding buttons to the table

		table.add(backButton).fillX().uniformX();//back
		table.row();
		table.add(purchaseExtraLifeButton);
		table.add(purchaseInfo);
		table.add(extraLife);
		table.row();
		table.add(unlockShieldButton).fillX().uniformX();
		table.add(unlockInfoShield);
		table.add(shieldPrice);
		table.row();
		table.add(upgradeWingButton).fillX().uniformX();
		table.add(unlockInfoWing);
		table.add(wingPrice);
		table.row();
		table2.top().left();
		table2.setFillParent(true);
		table2.add(profileCoins).padTop(10).padLeft(10);

		//adding table to stage
		stage.addActor(table);
		stage.addActor(table2);
	}

	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		parent.getBatch().begin();
		parent.getBatch().draw(background, 0, 0);
		parent.getBatch().draw(escape, 1450, 800);

		parent.getBatch().end();
		parent.getBatch().setProjectionMatrix(stage.getCamera().combined);
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
		escape.dispose();
		background.dispose();
	}

	public GameMain getParent() {
		return parent;
	}

	public void setParent(GameMain parent) {
		this.parent = parent;
	}
}