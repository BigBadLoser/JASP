package com.bigbadloser.JASP;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Main extends JavaPlugin {

    private ConcurrentHashMap<UUID, Integer> lastFireTime = new ConcurrentHashMap<>();
    private ConcurrentHashMap<UUID, Integer> lastDrownTime = new ConcurrentHashMap<>();
    private ConcurrentHashMap<UUID, Integer> lastPoisonTime = new ConcurrentHashMap<>();
    private ConcurrentHashMap<UUID, Integer> lastWitherTime = new ConcurrentHashMap<>();

    public final int getLastFireTime(final UUID uuid) {
        Integer time = lastFireTime.get(uuid);
        return time == null ? 0 : time;
    }

    public final int getLastDrownTime(final UUID uuid) {
        Integer time = lastDrownTime.get(uuid);
        return time == null ? 0 : time;
    }

    public final int getLastPoisonTime(final UUID uuid) {
        Integer time = lastPoisonTime.get(uuid);
        return time == null ? 0 : time;
    }

    public final int getLastWitherTime(final UUID uuid) {
        Integer time = lastWitherTime.get(uuid);
        return time == null ? 0 : time;
    }

    public final void setLastFireTime(final UUID uuid, final int time) {
        lastFireTime.put(uuid, time);
    }

    public final void setLastDrowningTime(final UUID uuid, final int time) {
        lastDrownTime.put(uuid, time);
    }

    public final void setLastPoisonTime(final UUID uuid, final int time) {
        lastPoisonTime.put(uuid, time);
    }

    public final void setLastWitherTime(final UUID uuid, final int time) {
        lastWitherTime.put(uuid, time);
    }

    @Override
    public void onEnable(){
        getServer().getPluginManager().registerEvents(new StatusListener(this), this);
    }

    @Override
    public void onDisable(){

    }
}



