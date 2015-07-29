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
package org.mineserver;

import java.util.ArrayList;
import java.util.List;

import org.mineserver.Mineserver;
import org.mineserver.Logger;
import org.mineserver.entity.Player;

public class Server{
	
	private Logger logger = new Logger();
	private List<Player> players = new ArrayList<>();
	public boolean running = false;
	
	public Server(){
		if(!running){
			logger.info("This server is running " + Mineserver.SOFTWARE + " v" + Mineserver.VERSION + " (Implementing API Version " + Mineserver.API_VERSION + ")");
			logger.info(Mineserver.SOFTWARE + " is licensed under the " + Mineserver.LICENSE);
			logger.info("Done! Type \"help\" or \"?\" for help");
			running = true;
		}
	}
	
	public void addPlayer(Player player){
        synchronized (players){
            players.add(player);
            this.getLogger().debug("Connected players " + players.size());
        }
    }
	
	 	public Player getPlayer(String name){
        synchronized (players){
            for(Player player : players){
                if(player.getName().equals(name)){
                    return player;
                }
            }
        }
        return null;
    }

	public void removePlayer(Player player){
		players.remove(player);
	}

	public List<Player> getOnlinePlayers() {
        return players;
    }

	public Logger getLogger(){
		return logger;
	}

	public void stop(){
		for(Player p : getOnlinePlayers()) {
			p.kick("Server closed.");
		}
		this.getLogger().server("Server was stopped");
	}
	
}