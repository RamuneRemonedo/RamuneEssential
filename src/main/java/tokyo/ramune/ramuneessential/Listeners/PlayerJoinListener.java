package tokyo.ramune.ramuneessential.Listeners;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import tokyo.ramune.ramuneessential.RamuneEssential;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(LoginEvent event) {
        for(ProxiedPlayer player : RamuneEssential.getInstance().getProxy().getPlayers()) {
            player.sendMessage(ChatColor.AQUA + "§l[中継鯖] " + ChatColor.GRAY +  event.getConnection().getName() + "がサーバーに参加しました");
        }
    }
}

