package me.mattstudios.citizenscmd.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import me.mattstudios.citizenscmd.CitizensCMD;
import net.citizensnpcs.api.event.NPCCloneEvent;
import net.citizensnpcs.api.event.NPCRemoveByCommandSenderEvent;

public class NPCListener implements Listener {

    private final CitizensCMD plugin;

    public NPCListener(CitizensCMD plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onNPCClone(NPCCloneEvent event) {
        if (!plugin.getDataHandler().hasNPCData(event.getNPC().getId())) {
            return;
        }

        plugin.getDataHandler().cloneData(event.getNPC().getId(), event.getClone().getId());
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onNPCRemove(NPCRemoveByCommandSenderEvent event) {
        if (!plugin.getDataHandler().hasNPCData(event.getNPC().getId())) {
            return;
        }

        plugin.getDataHandler().removeNPCData(event.getNPC().getId());
    }
}
