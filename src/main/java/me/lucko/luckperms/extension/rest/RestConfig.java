/*
 * This file is part of LuckPerms, licensed under the MIT License.
 *
 *  Copyright (c) lucko (Luck) <luck@lucko.me>
 *  Copyright (c) contributors
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package me.lucko.luckperms.extension.rest;

import java.util.List;

public class RestConfig {

    private final org.bukkit.configuration.file.FileConfiguration config;

    public RestConfig(org.bukkit.configuration.file.FileConfiguration config) {
        this.config = config;
    }

    public int getHttpPort() {
        return this.config.getInt("http-port", 8080);
    }

    public boolean isAuthEnabled() {
        return this.config.getBoolean("auth", false);
    }

    public List<String> getAuthKeys() {
        String value = this.config.getString("auth-keys", "");
        if (value.isBlank()) {
            return List.of();
        }
        return java.util.Arrays.stream(value.split(","))
                .map(String::trim)
                .filter(key -> !key.isEmpty())
                .toList();
    }

    public boolean isUserCacheEnabled() {
        return this.config.getBoolean("cache-users", true);
    }

    public boolean isGroupCacheEnabled() {
        return this.config.getBoolean("cache-groups", true);
    }

    public boolean isTrackCacheEnabled() {
        return this.config.getBoolean("cache-tracks", true);
    }

}
