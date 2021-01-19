package com.gaetan.nocrashco.listener;

import com.gaetan.nocrashco.CrashPlugin;
import io.github.retrooper.packetevents.event.PacketListenerDynamic;
import io.github.retrooper.packetevents.event.impl.PacketReceiveEvent;
import io.github.retrooper.packetevents.event.priority.PacketEventPriority;
import io.github.retrooper.packetevents.packettype.PacketType;
import io.github.retrooper.packetevents.packetwrappers.in.flying.WrappedPacketInFlying;
import net.minecraft.server.v1_8_R3.PacketPlayInFlying;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PacketListener extends PacketListenerDynamic {
    /**
     * Reference to the CrashPlugin class
     */
    private final CrashPlugin crashPlugin;

    /**
     * Constructor for the PacketListener runnable.
     *
     * @param crashPlugin   Reference to the CrashPlugin class
     */
    public PacketListener(final CrashPlugin crashPlugin) {
        super(PacketEventPriority.MONITOR);

        this.crashPlugin = crashPlugin;
    }

    /**
     * When a packet is received
     */
    @Override
    public void onPacketReceive(final PacketReceiveEvent event) {
        if (event.getNMSPacket() instanceof PacketPlayInFlying) {
            final WrappedPacketInFlying packetPlayInFlying = new WrappedPacketInFlying(event.getNMSPacket());

        }
    }
}
