package com.jwbutler.roguelike.geometry;

import java.util.Objects;

public abstract class IntPair
{
    private final int m_x;
    private final int m_y;

    protected IntPair(int x, int y)
    {
        m_x = x;
        m_y = y;
    }

    public final int getX()
    {
        return m_x;
    }

    public final int getY()
    {
        return m_y;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        IntPair intPair = (IntPair) o;
        return m_x == intPair.m_x && m_y == intPair.m_y;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(m_x, m_y);
    }
}
