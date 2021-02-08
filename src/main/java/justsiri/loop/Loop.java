package justsiri.loop;

import justsiri.loop.commands.DefaultCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Loop extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("loop").setExecutor(new DefaultCommand(this));
    }

}
