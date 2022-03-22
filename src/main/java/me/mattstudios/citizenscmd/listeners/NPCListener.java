package me.mattstudios.citizenscmd.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import me.mattstudios.citizenscmd.CitizensCMD;
import net.citizensnpcs.api.event.NPCCloneEvent;

public class NPCListener implements Listener {

    private final CitizensCMD plugin;

    public NPCListener(CitizensCMD plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void on(NPCCloneEvent event) {
        if (!plugin.getDataHandler().hasNPCData(event.getNPC().getId())) {
            return;
        }

        plugin.getDataHandler().cloneData(event.getNPC().getId(), event.getClone().getId());
    }
}
