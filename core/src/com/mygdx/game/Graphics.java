package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Graphics {
    private static SpriteBatch batch;
    private static ShapeRenderer shapeRenderer;
    private static BitmapFont font;

    static {
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        font = new BitmapFont(Gdx.files.internal("font.fnt"));
    }

    public static void begin() {
        batch.begin();
    }

    public static void end() {
        batch.end();
    }

    public static void draw(Texture texture, int x, int y, int width, int height) {
        batch.draw(texture, x, y, width, height);
    }

    public static void draw(Texture texture, int x, int y) {
        draw(texture, x, y, texture.getWidth(), texture.getHeight());
    }

    public static ShapeRenderer getShapeRenderer() {
        return shapeRenderer;
    }

    public static void drawWord(String word, int x, int y) {
        font.draw(batch, word, x, y);
    }

    public static void resize(float scale) {
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        font.getData().setScale(scale);
    }

    public static void setWordColor(Color color) {
        font.setColor(color);
    }
}
