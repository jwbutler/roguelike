package com.jwbutler.roguelike;

import com.jwbutler.roguelike.map.GameMap;
import com.jwbutler.roguelike.map.SampleMapFactory;
import com.jwbutler.roguelike.rendering.GameRenderer;

public class Main
{
    public static void main(String[] args)
    {
        GameMap gameMap = SampleMapFactory.createSampleMap();
        GameRenderer gameRenderer = GameRenderer.create();

        while (true)
        {
            gameRenderer.renderMap(gameMap);
        }
    }
}
