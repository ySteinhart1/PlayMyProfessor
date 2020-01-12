package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Align;

public abstract class Graphics {
    private static SpriteBatch batch;
    private static ShapeRenderer shapeRenderer;
    private static BitmapFont font;

    static {
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        font = new BitmapFont(Gdx.files.internal("font.fnt"));
    }

    public static boolean xIsBetween(int x1, int x2) {
        return Gdx.input.getX() > x1 && Gdx.input.getX() < x2;
    }

    public static boolean yIsBetween(int y1, int y2) {
        return (790 - Gdx.input.getY()) > y1 && (790 - Gdx.input.getY()) < y2;
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
        font.draw(batch, word, x, y, 0, word.length(), 1240, Align.left, true);
    }

    public static void resize(float scale) {
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        font.getData().setScale(scale);
    }

    public static void setWordColor(Color color) {
        font.setColor(color);
    }
}
