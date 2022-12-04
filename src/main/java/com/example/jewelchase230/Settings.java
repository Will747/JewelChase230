package com.example.jewelchase230;

/**
 * All changeable settings for the game that
 * can be found in the settings menu.
 *
 * @author Will Kaye
 */
public class Settings extends Config {
    /** The path to the file storing the settings. */
    private static final String SETTINGS_FILE = "config.txt";

    /** The music volume level. */
    private int musicVolume;

    /** The sound effects volume level. */
    private int sfxVolume;

    /** True if the game should be full screened. */
    private boolean fullScreen;

    /**
     * Constructs a new settings object.
     * Setting all fields based on the config file.
     */
    public Settings() {
        super(SETTINGS_FILE);
    }

    /**
     * @return The music volume level.
     */
    public int getMusicVolume() {
        return musicVolume;
    }

    /**
     * @param inMusicVolume The music volume level.
     */
    public void setMusicVolume(final int inMusicVolume) {
        musicVolume = inMusicVolume;
    }

    /**
     * @return The sound effects volume level.
     */
    public int getSfxVolume() {
        return sfxVolume;
    }

    /**
     * @param inSfxVolume The sound effects volume level.
     */
    public void setSfxVolume(final int inSfxVolume) {
        sfxVolume = inSfxVolume;
    }

    /**
     * @return True if the game should be full screened.
     */
    public boolean isFullScreen() {
        return fullScreen;
    }

    /**
     * @param inFullScreen True if the game should be full screened.
     */
    public void setFullScreen(final boolean inFullScreen) {
        fullScreen = inFullScreen;
    }
}
