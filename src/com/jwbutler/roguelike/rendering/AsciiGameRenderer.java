package com.jwbutler.roguelike.rendering;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.KeyListener;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.jwbutler.roguelike.items.MapItem;
import com.jwbutler.roguelike.map.GameMap;
import com.jwbutler.roguelike.terrain.Terrain;
import com.jwbutler.roguelike.units.Unit;

class AsciiGameRenderer implements GameRenderer
{
    @Nonnull
    private final Frame m_frame;
    @Nonnull
    private final JTextArea m_textArea;

    AsciiGameRenderer()
    {
        m_frame = new JFrame();
        m_frame.setVisible(true);
        m_frame.setLocation(400, 400);
        m_textArea = new JTextArea();
        m_textArea.setLocation(0, 0);
        m_textArea.setBackground(Color.BLACK);
        m_textArea.setForeground(Color.WHITE);
        m_textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        m_textArea.setEditable(false);
        m_frame.add(m_textArea);
    }

    @Override
    public void renderMap(@Nonnull GameMap map)
    {
        m_textArea.setColumns(map.getWidth());
        m_textArea.setRows(map.getHeight());
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

        m_textArea.setText(rendered);
        m_textArea.repaint();
        m_frame.pack();
        m_frame.repaint();
    }

    @Override
    public void addKeyListener(@Nonnull KeyListener keyListener)
    {
        m_textArea.addKeyListener(keyListener);
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
        System.out.println("Rendering " + unit);
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
