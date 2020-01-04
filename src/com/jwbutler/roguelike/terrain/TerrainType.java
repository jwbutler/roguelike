package com.jwbutler.roguelike.terrain;

public enum TerrainType
{
    FLOOR(false),
    WALL(true),
    NONE(true),
    ;

    private final boolean m_isBlocking;

    TerrainType(boolean isBlocking)
    {
        m_isBlocking = isBlocking;
    }

    public boolean isBlocking()
    {
        return m_isBlocking;
    }
}
