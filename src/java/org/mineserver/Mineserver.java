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
 package org.mineserver;

import org.mineserver.Server;
import org.mineserver.Logger;
 
 public class Mineserver{
	 
	 public static Logger logger = new Logger();
	 
	 public static String SOFTWARE = "Mineserver";
	 public static String VERSION = "0.0.1";
     public static String LICENSE = "Apache License v2.0";
	 public static int API_VERSION = 1;
	 
	 public static boolean DEBUG = false;
	 
	 public static void main(String[] args){
		 Mineserver mineserver = new Mineserver();
		 mineserver.run();
	 }
	 
	 public void run(){
		 Server server = new Server();
		// ServerConfig config = new ServerConfig();
	 }
	 
	 public Logger getLogger(){
		 return logger;
	 }
	 
 }