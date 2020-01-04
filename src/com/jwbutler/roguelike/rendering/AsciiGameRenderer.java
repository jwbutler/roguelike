package com.jwbutler.roguelike.rendering;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

import com.jwbutler.roguelike.items.MapItem;
import com.jwbutler.roguelike.map.GameMap;
import com.jwbutler.roguelike.terrain.Terrain;
import com.jwbutler.roguelike.units.Unit;

class AsciiGameRenderer implements GameRenderer
{
    @Override
    public void renderMap(@Nonnull GameMap map)
    {
        String rendered = IntStream.range(0, map.getHeight())
            .mapToObj(y ->
            {
                StringBuilder stringBuilder = new StringBuilder();
                IntStream.range(0, map.getWidth())
                    .map(x -> _renderTile(map.getTerrain(x, y), map.getItem(x, y), map.getUnit(x, y)))
                    .forEach(c -> stringBuilder.append((char) c));
                return stringBuilder.toString();
            })
            .collect(Collectors.joining("\n"));

        System.out.println(rendered + "\n\n\n");
    }

    private static char _renderTile(@Nonnull Terrain terrain, @CheckForNull MapItem item, @CheckForNull Unit unit)
    {
        return Stream.of(unit, item, terrain)
            .filter(Objects::nonNull)
            .findFirst()
            .map(AsciiGameRenderer::_renderObject)
            .orElseThrow()
            .charValue();
    }

    private static char _renderObject(@Nonnull Object object)
    {
        if (object instanceof Unit)
        {
            return _renderUnit((Unit) object);
        }
        else if (object instanceof MapItem)
        {
            return _renderItem((MapItem) object);
        }
        else if (object instanceof Terrain)
        {
            return _renderTerrain((Terrain) object);
        }
        throw new UnsupportedOperationException();
    }

    private static char _renderUnit(@Nonnull Unit unit)
    {
        return '@';
    }

    private static char _renderItem(@Nonnull MapItem item)
    {
        return '$';
    }

    private static char _renderTerrain(@Nonnull Terrain terrain)
    {
        switch (terrain.getType())
        {
            case WALL:
                return '#';
            case FLOOR:
                return '.';
            case NONE:
                return ' ';
            default:
        }
        throw new UnsupportedOperationException();
    }
}
