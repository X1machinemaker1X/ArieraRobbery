package me.x1machinemaker1x.arierarobbery.cmds;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import me.x1machinemaker1x.arierarobbery.objects.BankVault;
import me.x1machinemaker1x.arierarobbery.utils.Messages;
import me.x1machinemaker1x.arierarobbery.utils.Vaults;

public class DeleteSign extends SubCommand {
	
	public void onCommand(Player p, String[] args) {
		BankVault vault = Vaults.getInstance().getVault(args[0]);
		if (vault == null) {
			p.sendMessage(Messages.PREFIX.toString() + Messages.NOT_VAULT.toString());
			return;
		}
		if (vault.getSign() == null) {
			p.sendMessage(Messages.PREFIX.toString() + Messages.NO_SIGN.toString());
			return;
		}
		vault.getSign().getBlock().setType(Material.AIR);
		vault.setSign(null);
		Vaults.getInstance().saveVaults();
		p.sendMessage(Messages.PREFIX.toString() + Messages.SIGN_DELETED.toString().replace("%vaultname%", vault.getName()));
	}
	
	public String name() {
		return "deletesign";
	}
	
	public String info() {
		return "Deletes a sign from a vault";
	}
	
	public String permission() {
		return "arierarobbery.deletesign";
	}
	
	public String format() {
		return "/ar deletesign <vaultname>";
	}
	
	public String[] aliases() {
		return new String[] { "delsign", "ds" };
	}
	
	public int argsReq() {
		return 1;
	}
}
