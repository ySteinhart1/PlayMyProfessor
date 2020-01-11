package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayMyProfessor extends ApplicationAdapter {

	private static Game game;
	
	@Override
	public void create () {
		try {
			game = new Game(new Professor(25, 50, 75, 100, 10));
		} catch (Exception e) {
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, .5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		Graphics.begin();
//		Graphics.resize(1);
//		Graphics.setWordColor(Color.WHITE);
//		Graphics.drawWord("Hello world!", 200, 200);
//		Graphics.end();

		game.render();
	}

	public static Game getGame() {
		return game;
	}

}
