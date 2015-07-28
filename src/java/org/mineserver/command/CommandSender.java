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

import org.mineserver.Server;

public interface CommandSender{

    /**
     * Sends this sender a message
     *
     * @param message Message to be displayed
     */
    public void sendMessage(String message);

    /**
     * Sends this sender multiple messages
     *
     * @param messages An array of messages to be displayed
     */
    public void sendMessage(String[] messages);

    /**
     * Returns the server instance that this command is running on
     *
     * @return Server instance
     */
    public Server getServer();

    /**
     * Gets the name of this command sender
     *
     * @return Name of the sender
     */
    public String getName();
}