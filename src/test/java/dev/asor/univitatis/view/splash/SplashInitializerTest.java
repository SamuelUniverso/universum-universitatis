package dev.asor.univitatis.view.splash;

import org.junit.Test;

import dev.asor.univitatis.view.gui.splash.SplashInitializer;

public class SplashInitializerTest
{
    @Test
    public void testSplash()
    {
        new SplashInitializer("mascote-univates.jpg", 442, 442, 2500);
    }
}
