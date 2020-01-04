package com.jwbutler.roguelike.units;

class UnitImpl implements Unit
{
    private final int m_x;
    private final int m_y;

    UnitImpl(int x, int y)
    {
        m_x = x;
        m_y = y;
    }

    @Override
    public int getX()
    {
        return m_x;
    }

    @Override
    public int getY()
    {
        return m_y;
    }
}
