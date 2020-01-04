package com.jwbutler.roguelike.units;

import javax.annotation.Nonnull;

public interface Unit
{
    int getX();
    int getY();

    void moveTo(int x, int y);

    @Nonnull
    static Unit create(int x, int y)
    {
        return new UnitImpl(x, y);
    }
}
