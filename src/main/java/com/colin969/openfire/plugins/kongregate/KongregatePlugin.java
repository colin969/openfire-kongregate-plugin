package com.colin969.openfire.plugins.kongregate;

import org.jivesoftware.openfire.container.Plugin;
import org.jivesoftware.openfire.container.PluginManager;
import org.jivesoftware.openfire.handler.IQHandler;
import org.jivesoftware.openfire.IQRouter;
import org.jivesoftware.openfire.XMPPServer;

import java.io.File;

public class KongregatePlugin implements Plugin {

    public void initializePlugin(PluginManager manager, File pluginDirectory) {
        IQHandler kongHandler = new KongregateIQHandler();
        IQRouter iqRouter = XMPPServer.getInstance().getIQRouter();
        iqRouter.addHandler(kongHandler);
    }

    public void destroyPlugin() {
        // Your code goes here
    }
}