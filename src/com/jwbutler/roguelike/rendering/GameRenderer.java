package com.jwbutler.roguelike.rendering;

import javax.annotation.Nonnull;

import com.jwbutler.roguelike.map.GameMap;

public interface GameRenderer
{
    void renderMap(@Nonnull GameMap map);

    @Nonnull
    static GameRenderer create()
    {
        return new AsciiGameRenderer();
    }
}
