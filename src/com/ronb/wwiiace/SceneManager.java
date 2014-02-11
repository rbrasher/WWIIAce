package com.ronb.wwiiace;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.ui.activity.BaseGameActivity;

import android.util.Log;

public class SceneManager {
	private AllScenes currentScene;
	private BaseGameActivity activity;
	private Engine engine;
	private Camera camera;
	private BitmapTextureAtlas splashTA, levelFinishedTA;
	private ITextureRegion splashTR, levelFinishedTR;
	private Scene splashScene, menuScene, gameScene, helpScene, highScoresScene, optionsScene, levelFinishedScene, creditsScene;
	
	public enum AllScenes {
		SPLASH, MENU, GAME, HELP, HIGHSCORES, OPTIONS, LEVELFINISHED, CREDITS
	}
	
	public SceneManager(BaseGameActivity act, Engine eng, Camera cam) {
		this.activity = act;
		this.engine = eng;
		this.camera = cam;
	}
	
	public void loadSplashResources() {
		//splash image 320 x 480
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		
		splashTA = new BitmapTextureAtlas(this.activity.getTextureManager(), 320, 480);
		splashTR = BitmapTextureAtlasTextureRegionFactory.createFromAsset(splashTA, this.activity, "SplashScreen.png", 0, 0);
		
		splashTA.load();
	}
	
	public void loadMenuResources() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		
		
	}
	
	public void loadGameResources() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
	}
	
	public void loadHelpResources() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
	}
	
	public void loadHighScoresResources() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
	}
	
	public void loadOptionsResources() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
	}
	
	public void loadLevelFinishedResources() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		
		levelFinishedTA = new BitmapTextureAtlas(this.activity.getTextureManager(), 320, 480);
		levelFinishedTR = BitmapTextureAtlasTextureRegionFactory.createFromAsset(levelFinishedTA, this.activity, "missioncompleted.png", 0, 0);
		levelFinishedTA.load();
	}
	
	public void loadCreditsResources() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		
	}
	
	public Scene createSplashScene() {
		splashScene = new Scene();
		splashScene.setBackground(new Background(0,0,0));
		
		Sprite splashImage = new Sprite(0, 0, splashTR, engine.getVertexBufferObjectManager());
		splashImage.setSize(camera.getWidth(), camera.getHeight());
		splashImage.setPosition((camera.getWidth() - splashImage.getWidth())/2, (camera.getHeight() - splashImage.getHeight())/2);
		splashScene.attachChild(splashImage);
		
		return splashScene;
	}
	
	public Scene createMenuScene() {
		menuScene = new Scene();
		
		
		return menuScene;
	}
	
	public Scene createGameScene() {
		gameScene = new Scene();
		
		return gameScene;
	}
	
	public Scene createLevelFinishedScene() {
		levelFinishedScene = new Scene();
		
		levelFinishedScene.setBackground(new Background(0,0,0));
		
		Sprite levelFinishedImage = new Sprite(0, 0, levelFinishedTR, engine.getVertexBufferObjectManager());
		levelFinishedImage.setSize(camera.getWidth(), camera.getHeight());
		levelFinishedImage.setPosition((camera.getWidth() - levelFinishedImage.getWidth())/2, (camera.getHeight() - levelFinishedImage.getHeight())/2);
		levelFinishedScene.attachChild(levelFinishedImage);
		
		return levelFinishedScene;
	}
	
	public AllScenes getCurrentScene() {
		return currentScene;
	}
	
	public void setCurrentScene(AllScenes currentScene) {
		this.currentScene = currentScene;
		
		switch(currentScene) {
		case SPLASH:
			Log.v("setCurrentScene()", "current scene = SPLASH");
			break;
		case MENU:
			Log.v("setCurrentScene()", "current scene = MENU");
			//engine setScene
			engine.setScene(menuScene);
			break;
		case GAME:
			Log.v("setCurrentScene()", "current scene = GAME");
			//engine setScene
			engine.setScene(gameScene);
			break;
		case HELP:
			Log.v("setCurrentScene()", "current scene = HELP");
			//engine setScene
			engine.setScene(helpScene);
			break;
		case HIGHSCORES:
			Log.v("setCurrentScene()", "current scene = HIGHSCORES");
			//engine setScene
			engine.setScene(highScoresScene);
			break;
		case OPTIONS:
			Log.v("setCurrentScene()", "current scene = OPTIONS");
			//engine setScene
			engine.setScene(optionsScene);
			break;
		case LEVELFINISHED:
			Log.v("setCurrentScene()", "current scene = LEVELFINISHED");
			//engine setScene
			engine.setScene(levelFinishedScene);
			break;
		case CREDITS:
			Log.v("setCurrentScene()", "current scene = CREDITS");
			//engine setScene
			engine.setScene(creditsScene);
			break;
		default:
			break;
		}
	}
}
