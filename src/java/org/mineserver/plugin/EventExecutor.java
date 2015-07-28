package org.mineserver.plugin;

import org.mineserver.event.Event;
import org.mineserver.event.EventException;
import org.mineserver.event.Listener;

/**
 * Interface which defines the class for event call backs to plugins
 */
public interface EventExecutor {
    public void execute(Listener listener, Event event) throws EventException;
}