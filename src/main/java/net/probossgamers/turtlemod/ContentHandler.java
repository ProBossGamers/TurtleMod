package net.probossgamers.turtlemod;

import net.probossgamers.turtlemod.common.LogHelper;
import org.apache.logging.log4j.Level;

import java.util.ArrayList;

public class ContentHandler
{
    private ArrayList<IContentProvider> contentProviders = new ArrayList<IContentProvider>();

    public void addContentProvider(Class<? extends IContentProvider> cp)
    {
        try
        {
            IContentProvider contentProvider = cp.newInstance();
            contentProviders.add(contentProvider);
        }
        catch (Exception x)
        {
            x.printStackTrace();
        }
    }

    public void init()
    {
        for (IContentProvider contentProvider : contentProviders)
        {
            contentProvider.init();
            LogHelper.log(Level.INFO, "Initialized Content Provider -- " + contentProvider.getClass().getSimpleName());
        }
    }

    public static interface IContentProvider
    {
        public void init();
    }
}
