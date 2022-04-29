package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Level1 implements Screen {
    private TestPlatformer game; //the class is called as object
    private OrthographicCamera camera;
    private int screenWidth, screenHeight;
    private Viewport viewport;
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer mapRenderer;







    public void update(float delta){}

    private void handleInput(float delta){}

    public Level1(TestPlatformer game){
        screenWidth =1024;
        screenHeight=768;
        this.game = game;

        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        camera = new OrthographicCamera();
        camera.setToOrtho(false,TestPlatformer.G_WIDTH,TestPlatformer.G_HEIGHT);
        viewport = new FitViewport(screenWidth,screenHeight);

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("map0.tmx");
        mapRenderer = new OrthogonalTiledMapRenderer(map);
        camera.position.set(viewport.getWorldWidth()/2, viewport.getWorldHeight()/2, 0);


    }

    @Override public void show(){
        //show your screen here
    }

    public void render(float delta){
        //draw screen here. delta is the last time screen is refreshed in seconds
        update(delta);
        ScreenUtils.clear(0, 0, 0, 1); //refreshes the screen
        mapRenderer.render();

    }

    @Override public void resize(int width, int height){
        //resizes the game
        viewport.update(width,height);
    }

    @Override public void pause(){
        //this method pauses the game
    }

    @Override public void resume(){
        //this method is called when the game resumes after being paused
    }
    @Override public void hide(){
        //this method is called when another screen replaces this
    }
    @Override public void dispose(){
        //Destroy screen assets here
    }



}
