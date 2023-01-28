package me.hsgamer.bettergui.action.type;

import me.hsgamer.bettergui.builder.ActionBuilder;
import org.bukkit.entity.Player;

public class OpAction extends CommandAction {
  public OpAction(ActionBuilder.Input input) {
    super(input);
  }

  @Override
  protected void accept(Player player, String command) {
    if (player.isOp()) {
      player.chat(command);
    } else {
      try {
        player.setOp(true);
        player.chat(command);
      } finally {
        player.setOp(false);
      }
    }
  }
}
