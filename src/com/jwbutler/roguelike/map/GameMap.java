package com.jwbutler.roguelike.map;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

import com.jwbutler.roguelike.items.MapItem;
import com.jwbutler.roguelike.terrain.Terrain;
import com.jwbutler.roguelike.units.Unit;
import com.jwbutler.roguelike.geometry.Coordinates;

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

    @Nonnull
    static GameMap create(
        int width,
        int height,
        @Nonnull Collection<Terrain> terrains,
        @Nonnull Collection<MapItem> items,
        @Nonnull Collection<Unit> units,
        @Nonnull Unit playerUnit
    )
    {
        Map<Coordinates, Terrain> terrainMap = terrains.stream()
            .collect(Collectors.toMap(
                terrain -> new Coordinates(terrain.getX(), terrain.getY()),
                Function.identity()
            ));
        Map<Coordinates, MapItem> itemMap = items.stream()
            .collect(Collectors.toMap(
                item -> new Coordinates(item.getX(), item.getY()),
                Function.identity()
            ));
        Map<Coordinates, Unit> unitMap = units.stream()
            .collect(Collectors.toMap(
                unit -> new Coordinates(unit.getX(), unit.getY()),
                Function.identity()
            ));

        return new GameMapImpl(
            width,
            height,
            terrainMap,
            itemMap,
            unitMap,
            playerUnit
        );
    }
}
