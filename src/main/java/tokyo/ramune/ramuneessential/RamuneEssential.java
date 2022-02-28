package tokyo.ramune.ramuneessential;

import net.md_5.bungee.api.plugin.Plugin;
import tokyo.ramune.ramuneessential.Commands.Command;
import tokyo.ramune.ramuneessential.Listeners.PlayerJoinListener;
import tokyo.ramune.ramuneessential.Listeners.PlayerKickedListener;

public final class RamuneEssential extends Plugin {

    private static Plugin instance;

    @Override
    public void onEnable() {
        instance = this;
        registerListeners(this);
        registerCommands(this);
        getLogger().info("The plugin has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("The plugin has been disabled.");
    }

    private void registerListeners(Plugin plugin) {
        plugin.getProxy().getPluginManager().registerListener(plugin, new PlayerKickedListener());
        plugin.getProxy().getPluginManager().registerListener(plugin, new PlayerJoinListener());
    }

    private void registerCommands(Plugin plugin) {
        plugin.getProxy().getPluginManager().registerCommand(plugin, new Command());
    }

    public static Plugin getInstance() {
        return instance;
    }
}
