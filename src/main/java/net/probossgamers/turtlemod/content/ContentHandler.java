package net.probossgamers.turtlemod.content;

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
            System.out.println("[TurtleMod] Initialized contentProvider:" + contentProvider.getClass().getSimpleName());
        }
    }

    public static interface IContentProvider
    {
        public void init();
    }
}
