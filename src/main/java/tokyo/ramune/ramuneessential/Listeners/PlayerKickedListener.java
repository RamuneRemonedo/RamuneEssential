package tokyo.ramune.ramuneessential.Listeners;

import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import tokyo.ramune.ramuneessential.RamuneEssential;

public class PlayerKickedListener implements Listener {

    @EventHandler
    public void onKick(PlayerDisconnectEvent event) {
        RamuneEssential.getInstance().getLogger().info("aatatatataw");
    }
}
