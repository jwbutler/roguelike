package com.jwbutler.roguelike.state;

import com.google.common.base.Preconditions;
import com.jwbutler.roguelike.map.GameMap;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

public class GlobalStateImpl implements GlobalState
{
    @CheckForNull
    private static GlobalStateImpl INSTANCE = null;

    @CheckForNull
    private GameMap m_map;

    @Nonnull
    @Override
    public GameMap getMap()
    {
        Preconditions.checkState(m_map != null);
        return m_map;
    }

    @Override
    public void setMap(@Nonnull GameMap map)
    {
        m_map = map;
    }

    @Nonnull
    public static GlobalState getInstance()
    {
        Preconditions.checkState(INSTANCE != null);
        return INSTANCE;
    }

    @Nonnull
    public static GlobalState create()
    {
        INSTANCE = new GlobalStateImpl();
        return INSTANCE;
    }
}
