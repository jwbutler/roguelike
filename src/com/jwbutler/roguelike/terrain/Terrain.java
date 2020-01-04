package com.jwbutler.roguelike.terrain;

import javax.annotation.Nonnull;

public class Terrain
{
    private final int m_x;
    private final int m_y;
    @Nonnull
    private final TerrainType m_type;

    public Terrain(int x, int y, @Nonnull TerrainType type)
    {
        m_x = x;
        m_y = y;
        m_type = type;
    }

    public int getX()
    {
        return m_x;
    }

    public int getY()
    {
        return m_y;
    }

    @Nonnull
    public TerrainType getType()
    {
        return m_type;
    }

    public boolean isBlocking()
    {
        return m_type.isBlocking();
    }
}
