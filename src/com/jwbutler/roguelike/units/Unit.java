package com.jwbutler.roguelike.units;

import javax.annotation.Nonnull;

public interface Unit
{
    int getX();
    int getY();

    @Nonnull
    static Unit create(int x, int y)
    {
        return new UnitImpl(x, y);
    }
}
