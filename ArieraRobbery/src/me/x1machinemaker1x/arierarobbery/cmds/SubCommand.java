package me.x1machinemaker1x.arierarobbery.cmds;

import org.bukkit.entity.Player;

public abstract class SubCommand {
	
	public abstract void onCommand(Player paramPlayer, String[] paramArrayOfString);

	public abstract String name();

	public abstract String info();

	public abstract String[] aliases();

	public abstract String permission();

	public abstract int argsReq();

	public abstract String format();
}
