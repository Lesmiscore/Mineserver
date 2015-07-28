/*
 * Copyright 2015 RandomAltThing (@TheDiamondYT)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 package org.mineserver.command;

 import java.util.ArrayList;
 import java.util.Collections;
 import java.util.List;
 import java.util.Set;
 
 import org.mineserver.command.CommandSender;
 //import org.mineserver.command.CommandMap;
 import org.mineserver.ChatColor;
 
 public abstract class Command{
	 
	private final String name;
    private String nextLabel;
    private String label;
    private List<String> aliases;
    private List<String> activeAliases;
  //  private CommandMap commandMap = null;
    protected String description = "";
    protected String usageMessage;
    private String permission;
    private String permissionMessage;

    protected Command(String name) {
        this(name, "", "/" + name, new ArrayList<String>());
    }

    protected Command(String name, String description, String usageMessage, List<String> aliases) {
        this.name = name;
        this.nextLabel = name;
        this.label = name;
        this.description = description;
        this.usageMessage = usageMessage;
        this.aliases = aliases;
        this.activeAliases = new ArrayList<String>(aliases);
    }
	

    public abstract boolean execute(CommandSender sender, String commandLabel, String[] args);
	
	public String getName(){
		return name;
	}
	
	public String getPermission(){
		return permission;
	}
	
	public void setPermission(String permission) {
        this.permission = permission;
    }

    public boolean testPermission(CommandSender target) {
        if (testPermissionSilent(target)) {
            return true;
        }

        if (permissionMessage == null) {
            target.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
        } else if (permissionMessage.length() != 0) {
            for (String line : permissionMessage.replace("<permission>", permission).split("\n")) {
                target.sendMessage(line);
            }
        }

        return false;
    }
    
    public boolean testPermissionSilent(CommandSender target) {
        if ((permission == null) || (permission.length() == 0)) {
            return true;
        }

   /*     for (String p : permission.split(";")) {
            if (target.hasPermission(p)) {
                return true;
            }
        }
*/

        return false;
    }
    
    public String getLabel() {
        return label;
    }

    public boolean setLabel(String name) {
        this.nextLabel = name;
    //    if (!isRegistered()) {
            this.label = name;
         //   return true;
    //    }
        return false;
    }
	
 }