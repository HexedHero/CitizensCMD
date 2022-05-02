package me.mattstudios.citizenscmd.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import me.mattstudios.citizenscmd.CitizensCMD;
import net.citizensnpcs.api.event.NPCCloneEvent;
import net.citizensnpcs.api.event.NPCRemoveEvent;

public class NPCListener implements Listener {

    private final CitizensCMD plugin;

    public NPCListener(CitizensCMD plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onCloneNPC(NPCCloneEvent event) {
        if (!plugin.getDataHandler().hasNPCData(event.getNPC().getId())) {
            return;
        }

        plugin.getDataHandler().cloneData(event.getNPC().getId(), event.getClone().getId());
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onRemoveNPC(NPCRemoveEvent event) {
        if (!plugin.getDataHandler().hasNPCData(event.getNPC().getId())) {
            return;
        }

        plugin.getDataHandler().removeNPCData(event.getNPC().getId());
    }
}
