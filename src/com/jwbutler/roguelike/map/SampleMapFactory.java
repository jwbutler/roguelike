package com.jwbutler.roguelike.map;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.annotation.Nonnull;

import com.jwbutler.roguelike.terrain.Terrain;
import com.jwbutler.roguelike.terrain.TerrainType;
import com.jwbutler.roguelike.units.Unit;

public class SampleMapFactory
{
    @Nonnull
    public static GameMap createSampleMap()
    {
        int width = 40;
        int height = 10;
        Collection<Terrain> terrains = IntStream.range(0, height)
            .mapToObj(y ->
            {
                return IntStream.range(0, width)
                    .mapToObj(x ->
                    {
                        TerrainType terrainType = (x % 5 == 0 && y % 4 != 0) ? TerrainType.WALL : TerrainType.FLOOR;
                        return new Terrain(x, y, terrainType);
                    })
                    .collect(Collectors.toList());
            })
            .flatMap(List::stream)
            .collect(Collectors.toList());

        Unit unit = Unit.create(3, 3);
        return GameMap.create(width, height, terrains, Set.of(), Set.of(unit), unit);
    }
}
