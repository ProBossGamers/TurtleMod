package net.probossgamers.turtlemod;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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
            Calendar cal = Calendar.getInstance();
            cal.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            contentProvider.init();
            System.out.println("[" + sdf.format(cal.getTime()) + "] [TurtleMod/INFO] Initialized Content Provider -- " + contentProvider.getClass().getSimpleName());
        }
    }

    public static interface IContentProvider
    {
        public void init();
    }
}
