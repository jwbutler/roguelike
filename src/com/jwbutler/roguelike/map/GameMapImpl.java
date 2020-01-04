package com.jwbutler.roguelike.map;

import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

import com.jwbutler.roguelike.items.MapItem;
import com.jwbutler.roguelike.terrain.Terrain;
import com.jwbutler.roguelike.units.Unit;

class GameMapImpl implements GameMap
{
    private final int m_width;
    private final int m_height;

    @Nonnull
    private final Collection<Terrain> m_terrain;
    @Nonnull
    private final Collection<MapItem> m_items;
    @Nonnull
    private final Collection<Unit> m_units;
    @Nonnull
    private final Unit m_playerUnit;

    GameMapImpl(
        int width,
        int height,
        @Nonnull Collection<Terrain> terrain,
        @Nonnull Collection<MapItem> items,
        @Nonnull Collection<Unit> units,
        @Nonnull Unit playerUnit
    )
    {
        m_width = width;
        m_height = height;
        m_terrain = terrain;
        m_items = items;
        m_units = units;
        m_playerUnit = playerUnit;
    }

    @Override
    public int getWidth()
    {
        return m_width;
    }

    @Override
    public int getHeight()
    {
        return m_height;
    }

    @Nonnull
    @Override
    public Collection<Terrain> getTerrain()
    {
        return new ArrayList<>(m_terrain);
    }

    @Nonnull
    @Override
    public Terrain getTerrain(int x, int y)
    {
        return m_terrain.stream()
            .filter(t -> t.getX() == x && t.getY() == y)
            .findFirst()
            .orElseThrow(IllegalStateException::new);
    }

    @Nonnull
    @Override
    public Collection<MapItem> getItems()
    {
        return new ArrayList<>(m_items);
    }

    @CheckForNull
    @Override
    public MapItem getItem(int x, int y)
    {
        return m_items.stream()
            .filter(t -> t.getX() == x && t.getY() == y)
            .findFirst()
            .orElse(null);
    }

    @Nonnull
    @Override
    public Collection<Unit> getUnits()
    {
        return new ArrayList<>(m_units);
    }

    @CheckForNull
    @Override
    public Unit getUnit(int x, int y)
    {
        return m_units.stream()
            .filter(t -> t.getX() == x && t.getY() == y)
            .findFirst()
            .orElse(null);
    }

    @Nonnull
    @Override
    public Unit getPlayerUnit()
    {
        return m_playerUnit;
    }

    @Override
    public boolean contains(int x, int y)
    {
        return x >= 0 && x < m_width
            && y >= 0 && y < m_height;
    }

    @Override
    public boolean isBlocked(int x, int y)
    {
        return getUnit(x, y) != null
            || getTerrain(x, y).isBlocking();
    }
}
