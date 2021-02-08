package justsiri.loop.commands;

import justsiri.loop.Loop;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;

public class DefaultCommand implements CommandExecutor {

    private final Loop plugin;

    int loopTime;

    public DefaultCommand(Loop plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {
                return false;
            } else {
                String command = StringUtils.join(Arrays.copyOfRange(args, 1, args.length), " ");
                loopTime = Integer.parseInt(args[0]);

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        loopTime--;

                        player.performCommand(command);

                        if (loopTime < 1) {
                            cancel();
                        }
                    }

                }.runTaskTimer(plugin, 0, 5);
            }


        } else {
            sender.sendMessage("Only player can execute this command");
        }


        return true;
    }

}
