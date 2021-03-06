package com.github.skyousuke.gdxutils.skin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.github.skyousuke.gdxutils.font.ThaiFont;
import com.github.skyousuke.gdxutils.font.ThaiFontLoader;

public enum Skins {
    DEFAULT,
    DEFAULT_THAI;

    public Skin createSkin() {
        Skin skin = new Skin(getFile());
        configSkin(skin);
        return skin;
    }

    public void loadTo(AssetManager manager) {
        AssetDescriptor<Skin> descriptor = new AssetDescriptor<Skin>(getFile(), Skin.class);
        manager.load(descriptor);
    }

    public Skin getFrom(AssetManager manager) {
        AssetDescriptor<Skin> descriptor = new AssetDescriptor<Skin>(getFile(), Skin.class);
        Skin skin = manager.get(descriptor);
        configSkin(skin);
        return skin;
    }

    private void configSkin(Skin skin) {
        if (this == DEFAULT_THAI) {
            BitmapFont thaiFont = new ThaiFont(skin.getFont("default"), new ThaiFontLoader.ThaiFontParameter(-3, 5, 4, 6));
            SkinUtils.replaceFont(skin, "default", thaiFont);
        }
    }

    private FileHandle getFile() {
        switch (this) {
            case DEFAULT:
                return Gdx.files.internal("skin/default.json");
            case DEFAULT_THAI:
                return Gdx.files.internal("skin/default-thai.json");
            default:
                throw new IllegalStateException("the execution flow must not reach here!");
        }
    }

}
