package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class TestPlatformer extends Game {
	SpriteBatch batch;
	Texture img;
	static final int G_WIDTH = 1024, G_HEIGHT = 768;


	Music nothingHappenedInTiananmen;

	private TestPlatformer game; //the class is called as object
	private OrthographicCamera camera;
	private int screenWidth, screenHeight;
	private Viewport viewport;
	private TmxMapLoader mapLoader;
	private TiledMap map;
	private OrthogonalTiledMapRenderer mapRenderer;




	@Override
	public void create () {


		nothingHappenedInTiananmen = Gdx.audio.newMusic(Gdx.files.internal("wad.mp3"));
		nothingHappenedInTiananmen.setLooping(true);
		nothingHappenedInTiananmen.play();

		setScreen(new Level1(this));


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
	public void update(float delta){}

	public void render (float delta) {
		update(delta);
		ScreenUtils.clear(0, 0, 0, 1); //refreshes the screen
		mapRenderer.render();
	}
	
	@Override
	public void dispose () {
		super.render();

	}

	@Override public void resize(int width, int height){
		//resizes the game
		viewport.update(width,height);
	}

}
