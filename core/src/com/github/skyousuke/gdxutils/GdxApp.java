package com.github.skyousuke.gdxutils;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.InputAdapter;

public abstract class GdxApp extends InputAdapter implements ApplicationListener {

    @Override
    public void create() {}

    @Override
    public void resize(int width, int height) {}

    @Override
    public void render() {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void dispose() {}
}
