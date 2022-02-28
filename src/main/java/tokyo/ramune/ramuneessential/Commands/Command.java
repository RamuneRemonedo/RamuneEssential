package tokyo.ramune.ramuneessential.Commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import tokyo.ramune.ramuneessential.RamuneEssential;

public class Command extends net.md_5.bungee.api.plugin.Command {

    public Command() {
        super("ramune");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        try {
            if (sender.equals(RamuneEssential.getInstance().getProxy().getConsole())) {
                return;
            }
            ProxiedPlayer player = (ProxiedPlayer) sender;

            switch (args[0]) {

                case "send":
                    if (!player.hasPermission("RamuneEssential.command.send")) {
                        player.sendMessage(ChatColor.RED + "そのコマンドを実行する権限がありません");
                        return;
                    }
                    if (args[1].isEmpty() || args[2].isEmpty()) {
                        player.sendMessage(ChatColor.RED + "使用法: /ramune send [player / all] [server]");
                        return;
                    }
                    if (args[1].equals("all")) {
                        for (ProxiedPlayer targetPlayer : RamuneEssential.getInstance().getProxy().getPlayers()) {
                            targetPlayer.connect(RamuneEssential.getInstance().getProxy().getServerInfo(args[2]));
                        }
                    } else {
                        ProxiedPlayer targetPlayer = RamuneEssential.getInstance().getProxy().getPlayer(args[1]);
                        targetPlayer.connect(RamuneEssential.getInstance().getProxy().getServerInfo(args[2]));
                    }
                    player.sendMessage(ChatColor.GREEN + "テレポートされました");


            }
        } catch (Exception e) {
            sender.sendMessage(ChatColor.RED + "実行されませんでした 原因:" + ChatColor.GRAY + e);
            return;
        }
    }
}
