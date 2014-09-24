package net.probossgamers.turtlemod.common;

import cpw.mods.fml.common.FMLLog;
import org.apache.logging.log4j.Level;

public class LogHelper
{
    public static void log(Level logLevel, Object object)
    {
        FMLLog.log("Turtle Mod", logLevel, String.valueOf(object));
    }

    protected static void all(Object object)
    {
        log(Level.ALL, object);
    }

    protected static void debug(Object object)
    {
        log(Level.DEBUG, object);
    }

    protected static void error(Object object)
    {
        log(Level.ERROR, object);
    }

    protected static void fatal(Object object)
    {
        log(Level.FATAL, object);
    }

    protected static void info(Object object)
    {
        log(Level.INFO, object);
    }

    protected static void off(Object object)
    {
        log(Level.OFF, object);
    }

    protected static void trace(Object object)
    {
        log(Level.TRACE, object);
    }

    protected static void warn(Object object)
    {
        log(Level.WARN, object);
    }
}
