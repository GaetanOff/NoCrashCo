package com.gaetan.nocrashco;

import com.gaetan.api.plugin.SimplePlugin;
import com.gaetan.nocrashco.listener.PacketListener;
import io.github.retrooper.packetevents.PacketEvents;

public final class CrashPlugin extends SimplePlugin {
    /**
     * This is trigger when the server loading
     * Note: This is the same as the classic onLoad
     * <p>
     * Info: This will config and load PacketEvents and set
     * the core count available to JVM.
     */
    @Override
    protected void onPluginLoad() {
        PacketEvents.getSettings()
                .injectAsync(true)
                .ejectAsync(true)
                .packetHandlingThreadCount(Runtime.getRuntime().availableProcessors() * 2)
                .injectEarly(false)
                .checkForUpdates(false);

        PacketEvents.load();
    }

    /**
     * Method to launch the plugin
     * Note: This is the same as the classic onEnable
     * <p>
     * Info: This will initialize PacketEvents.
     */
    @Override
    protected void onPluginStart() {
        PacketEvents.init(this);
    }

    /**
     * Method to register listener
     * Note: This will be trigger after the loading of the server
     * <p>
     * Info: This will register the PacketListener to listen the packet.
     */
    @Override
    protected void registerListener() {
        PacketEvents.getAPI().getEventManager().registerListener(new PacketListener(this));
    }

    /**
     * Method to stop the plugin
     * Note: This is the same as the classic onDisable
     * <p>
     * Info: This will stop PacketEvents.
     */
    @Override
    protected void onPluginStop() {
        PacketEvents.stop();
    }
}
