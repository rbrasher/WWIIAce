package com.ronb.wwiiace;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.ui.activity.BaseGameActivity;

import com.ronb.wwiiace.SceneManager.AllScenes;

public class GameActivity extends BaseGameActivity {
	protected static final int CAMERA_WIDTH = 480;
	protected static final int CAMERA_HEIGHT = 800;
	
	BitmapTextureAtlas playerTexture;
	ITextureRegion playerTextureRegion;
	Scene scene;
	PhysicsWorld physicsWorld;
	SceneManager sceneManager;
	Camera mCamera;
	
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		//define our camera
		mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		//define camera options. i.e. pFullScreen, pScreenOrientation, pResolutionPolicy, pCamera
		EngineOptions options = new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), mCamera);
		
		return options;
	}
	
	
	@Override
	public void onCreateResources(
			OnCreateResourcesCallback pOnCreateResourcesCallback)
			throws Exception {
		
		sceneManager = new SceneManager(this, mEngine, mCamera);
		sceneManager.loadSplashResources();
		
		//must call the callback method to say we are finished with this method
		pOnCreateResourcesCallback.onCreateResourcesFinished();
	}
	
	
	@Override
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback)
			throws Exception {
		// TODO Auto-generated method stub
		
		
		//must call the callback method to say we are finished with this method
		pOnCreateSceneCallback.onCreateSceneFinished(sceneManager.createSplashScene());
	}
	
	
	@Override
	public void onPopulateScene(Scene pScene, OnPopulateSceneCallback pOnPopulateSceneCallback) throws Exception {
		/*
		Sprite sPlayer = new Sprite(CAMERA_WIDTH / 2, CAMERA_HEIGHT / 2, playerTextureRegion, this.mEngine.getVertexBufferObjectManager());
		sPlayer.setRotation(45.0f);
		
		final FixtureDef PLAYER_FIX = PhysicsFactory.createFixtureDef(10.0f, 1.0f, 1.0f);
		Body body = PhysicsFactory.createBoxBody(physicsWorld, sPlayer, BodyType.DynamicBody, PLAYER_FIX);
		this.scene.attachChild(sPlayer);
		
		physicsWorld.registerPhysicsConnector(new PhysicsConnector(sPlayer, body, true, false));
		
		//must call the callback method to say we are finished with this method
		pOnPopulateSceneCallback.onPopulateSceneFinished();
		*/
		
		//register and update handler with a TimerHandler
		mEngine.registerUpdateHandler(new TimerHandler(3f, new ITimerCallback() {

			@Override
			public void onTimePassed(TimerHandler pTimerHandler) {
				mEngine.unregisterUpdateHandler(pTimerHandler);
				
				//sceneManager.loadMenuResources();
				//sceneManager.createMenuScene();
				//sceneManager.setCurrentScene(AllScenes.MENU);
				
				sceneManager.loadLevelFinishedResources();
				sceneManager.createLevelFinishedScene();
				sceneManager.setCurrentScene(AllScenes.LEVELFINISHED);
			}
			
		}));
		
		pOnPopulateSceneCallback.onPopulateSceneFinished();
	}

}
