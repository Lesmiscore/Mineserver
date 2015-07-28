/*
 * Copyright 2015 RandomAltThing (@TheDiamondYT)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in wr iting, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mineserver.plugin;

import org.mineserver.command.Command;
import org.mineserver.command.CommandSender;
import org.mineserver.Logger;
import org.mineserver.Mineserver;
import org.mineserver.Server;
import org.mineserver.Logger;

public class PluginBase implements Plugin {
	public static Logger logger = new Logger();
	private Server server;
	private boolean isEnabled = false;
	
	@Override
	public void onLoad(){
		
	}

	@Override
	public void onEnable(){	
	
	}

	@Override
	public void onDisable(){
		
	}

	@Override
	public boolean isEnabled() {
		return isEnabled;
	}
	
    @Override
	public Server getServer() {
		return server;
	}

	@Override
	public Logger getLogger() {
		return logger;
	}
	
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
	}
	
	protected final void setEnabled(final boolean enabled) {
        if (isEnabled != enabled) {
            isEnabled = enabled;

            if (isEnabled) {
                onEnable();
            } else {
                onDisable();
            }
        }
	}
}