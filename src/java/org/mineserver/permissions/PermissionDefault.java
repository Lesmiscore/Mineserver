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
package org.mineserver.permissions;

import java.util.HashMap;
import java.util.Map;

public enum PermissionDefault {
    TRUE("true"),
    FALSE("false"),
    OP("op", "isop", "operator", "isoperator", "admin", "isadmin"),
    NOT_OP("!op", "notop", "!operator", "notoperator", "!admin", "notadmin");

    private final String[] names;
    private final static Map<String, PermissionDefault> lookup = new HashMap<String, PermissionDefault>();

    private PermissionDefault(String... names) {
        this.names = names;
    }

    
    public boolean getValue(boolean op) {
        switch (this) {
        case TRUE:
            return true;
        case FALSE:
            return false;
        case OP:
            return op;
        case NOT_OP:
            return !op;
        default:
            return false;
        }
    }

    
    public static PermissionDefault getByName(String name) {
        return lookup.get(name.toLowerCase().replaceAll("[^a-z!]", ""));
    }

    @Override
    public String toString() {
        return names[0];
    }

    static {
        for (PermissionDefault value : values()) {
            for (String name : value.names) {
                lookup.put(name, value);
            }
        }
    }
}