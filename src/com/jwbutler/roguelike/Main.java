package com.jwbutler.roguelike;

import com.jwbutler.roguelike.input.InputHandler;
import com.jwbutler.roguelike.map.GameMap;
import com.jwbutler.roguelike.map.SampleMapFactory;
import com.jwbutler.roguelike.rendering.GameRenderer;
import com.jwbutler.roguelike.state.GlobalState;

import javax.swing.SwingUtilities;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        _setupExceptionHandlers();

        GlobalState globalState = GlobalState.create();
        GameMap gameMap = SampleMapFactory.createSampleMap();
        globalState.setMap(gameMap);

        GameRenderer gameRenderer = GameRenderer.create();
        gameRenderer.renderMap(gameMap);

        InputHandler inputHandler = new InputHandler(gameRenderer);

        gameRenderer.addKeyListener(inputHandler);
    }

    private static void _setupExceptionHandlers() throws Exception
    {
        SwingUtilities.invokeAndWait(() ->
        {
            Thread.currentThread().setUncaughtExceptionHandler((Thread t, Throwable e) ->
            {
                e.printStackTrace();
                System.exit(-1);
            });
        });
    }
}
