package com.jwbutler.roguelike.units;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.jwbutler.roguelike.map.GameMap;
import com.jwbutler.roguelike.state.GlobalState;

class UnitImpl implements Unit
{
    private int m_x;
    private int m_y;

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

    @Override
    public void moveTo(int x, int y)
    {
        GameMap map = GlobalState.getInstance().getMap();
        Preconditions.checkState(map.getUnit(x, y) == null);
        Preconditions.checkState(!map.getTerrain(x, y).isBlocking());

        m_x = x;
        m_y = y;
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this).add("m_x", m_x).add("m_y", m_y).toString();
    }
}
