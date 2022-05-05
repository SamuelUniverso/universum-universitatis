package dev.asor.univitatis.view.config.enums;

public enum GuiModeConfig
{
      LIGHT_MODE      ('L')
    , DARK_MODE       ('D')
    , SYSTEM_NATIVE   ('S')
    , CROSS_PLATAFORM ('J')
    ;

    private Character config;

    GuiModeConfig(Character config)
    {
        setConfing(config);
    }
    
    private void setConfing(Character config)
    {
        this.config = config;
    }

    public Character getConfig()
    {
        return this.config;
    }
}
