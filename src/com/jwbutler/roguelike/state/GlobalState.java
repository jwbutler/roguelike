package com.jwbutler.roguelike.state;

import com.jwbutler.roguelike.map.GameMap;

import javax.annotation.Nonnull;

public interface GlobalState
{
    @Nonnull GameMap getMap();
    void setMap(@Nonnull GameMap map);

    @Nonnull
    static GlobalState getInstance()
    {
        return GlobalStateImpl.getInstance();
    }

    @Nonnull
    static GlobalState create()
    {
        return GlobalStateImpl.create();
    }
}
