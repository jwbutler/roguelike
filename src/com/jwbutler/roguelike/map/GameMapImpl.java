package com.jwbutler.roguelike.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

import com.google.common.base.Preconditions;
import com.jwbutler.roguelike.items.MapItem;
import com.jwbutler.roguelike.terrain.Terrain;
import com.jwbutler.roguelike.units.Unit;
import com.jwbutler.roguelike.geometry.Coordinates;

class GameMapImpl implements GameMap
{
    private final int m_width;
    private final int m_height;

    @Nonnull
    private final Map<Coordinates, Terrain> m_terrain;
    @Nonnull
    private final Map<Coordinates, MapItem> m_items;
    @Nonnull
    private final Map<Coordinates, Unit> m_units;
    @Nonnull
    private final Unit m_playerUnit;

    GameMapImpl(
        int width,
        int height,
        @Nonnull Map<Coordinates, Terrain> terrain,
        @Nonnull Map<Coordinates, MapItem> items,
        @Nonnull Map<Coordinates, Unit> units,
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
        return new ArrayList<>(m_terrain.values());
    }

    @Nonnull
    @Override
    public Terrain getTerrain(int x, int y)
    {
        Terrain terrain = m_terrain.get(new Coordinates(x, y));
        Preconditions.checkState(terrain != null);
        return terrain;
    }

    @Nonnull
    @Override
    public Collection<MapItem> getItems()
    {
        return new ArrayList<>(m_items.values());
    }

    @CheckForNull
    @Override
    public MapItem getItem(int x, int y)
    {
        return m_items.get(new Coordinates(x, y));
    }

    @Nonnull
    @Override
    public Collection<Unit> getUnits()
    {
        return new ArrayList<>(m_units.values());
    }

    @CheckForNull
    @Override
    public Unit getUnit(int x, int y)
    {
        return m_units.get(new Coordinates(x, y));
    }

    @Nonnull
    @Override
    public Unit getPlayerUnit()
    {
        return m_playerUnit;
    }
}
