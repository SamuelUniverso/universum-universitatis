package dev.asor.univitatis.view.config;

public enum GuiModeConfig
{
      LIGHT_MODE  ('L')
    , DARK_MODE   ('D')
    , SYS_DEFAULT ('S')
    ;

    private final Character config;

    GuiModeConfig(Character config)
    {
        this.config = config;
    }

    public Character getMessage()
    {
        return this.config;
    }
}
