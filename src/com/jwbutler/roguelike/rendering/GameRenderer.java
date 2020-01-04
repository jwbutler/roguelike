package com.jwbutler.roguelike.rendering;

import javax.annotation.Nonnull;

import com.jwbutler.roguelike.map.GameMap;

import java.awt.event.KeyListener;

public interface GameRenderer
{
    void renderMap(@Nonnull GameMap map);
    void addKeyListener(@Nonnull KeyListener keyListener);

    @Nonnull
    static GameRenderer create()
    {
        return new AsciiGameRenderer();
    }
}
