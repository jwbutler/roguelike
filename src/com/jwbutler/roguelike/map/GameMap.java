package com.jwbutler.roguelike.map;

import java.util.Collection;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

import com.jwbutler.roguelike.items.MapItem;
import com.jwbutler.roguelike.terrain.Terrain;
import com.jwbutler.roguelike.units.Unit;

public interface GameMap
{
    int getWidth();
    int getHeight();

    @Nonnull Collection<Terrain> getTerrain();
    @Nonnull Terrain getTerrain(int x, int y);

    @Nonnull Collection<MapItem> getItems();
    @CheckForNull MapItem getItem(int x, int y);

    @Nonnull Collection<Unit> getUnits();
    @CheckForNull Unit getUnit(int x, int y);

    @Nonnull Unit getPlayerUnit();

    boolean contains(int x, int y);
    boolean isBlocked(int x, int y);

    @Nonnull
    static GameMap create(
        int width,
        int height,
        @Nonnull Collection<Terrain> terrain,
        @Nonnull Collection<MapItem> items,
        @Nonnull Collection<Unit> units,
        @Nonnull Unit playerUnit
    )
    {
        return new GameMapImpl(
            width,
            height,
            terrain,
            items,
            units,
            playerUnit
        );
    }
}
