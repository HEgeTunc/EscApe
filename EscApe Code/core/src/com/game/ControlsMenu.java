package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * Creates control screen which is accessible from settings
 * @author Ali Kaan Şahin
 * @version 1.0
 * @date 24/12/2012
 */
public class ControlsMenu implements Screen {

    private GameMain parent;
    private Table table;
    private Stage stage;
    private ImageButton backButton;
    private Texture controls;
    private Texture background;

    /**
     * Constructs a control menu
     * @param gameMain is the class, where execution is started and screen is set
     */
    public ControlsMenu(GameMain gameMain) {
        setParent(gameMain);
        stage = new Stage(new ScreenViewport());

        //adding processor to process inputs to stage
        Gdx.input.setInputProcessor(stage);
        controls = new Texture("controls.png");
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
        table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        //creating the buttons
        backButton = new ImageButton(new SpriteDrawable(new Sprite(new Texture("back.png"))));

        //adding functionality to buttons
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent e, Actor actor) {
                parent.changeScreen(GameMain.MAIN_MENU);
            }
        });

        //adding buttons to the table
        table.add(backButton);//from the database best
        table.row();
        table.top().padTop(30);

        //adding table to stage
        stage.addActor(table);

    }
    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        parent.getBatch().begin();
        parent.getBatch().draw(background,0,0);
        parent.getBatch().draw(controls, 500, 200);
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
    }

    public GameMain getParent() {
        return parent;
    }

    public void setParent(GameMain parent) {
        this.parent = parent;
    }
}
