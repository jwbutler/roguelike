package com.jwbutler.roguelike.input;

import com.jwbutler.roguelike.map.GameMap;
import com.jwbutler.roguelike.rendering.GameRenderer;
import com.jwbutler.roguelike.state.GlobalState;
import com.jwbutler.roguelike.units.Unit;

import javax.annotation.Nonnull;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter
{
    @Nonnull
    private final GameRenderer m_renderer;

    public InputHandler(@Nonnull GameRenderer renderer)
    {
        m_renderer = renderer;
    }

    @Override
    public void keyTyped(@Nonnull KeyEvent event)
    {
        _handleInput(event.getKeyChar());
    }

    private void _handleInput(@Nonnull Character keyChar)
    {
        System.out.println(keyChar);
        GameMap map = GlobalState.getInstance().getMap();
        switch (keyChar)
        {
            case 'w':
                _tryMove(0, -1);
                break;
            case 'a':
                _tryMove(-1, 0);
                break;
            case 's':
                _tryMove(0, 1);
                break;
            case 'd':
                _tryMove(1, 0);
                break;
            default:
        }
        m_renderer.renderMap(map);
    }

    private void _tryMove(int dx, int dy)
    {
        GameMap map = GlobalState.getInstance().getMap();
        Unit unit = map.getPlayerUnit();
        int x = unit.getX() + dx;
        int y = unit.getY() + dy;
        if (map.contains(x, y) && !map.isBlocked(x, y))
        {
            unit.moveTo(x, y);
        }
    }
}
