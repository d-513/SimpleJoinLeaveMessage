package space.d513.plugins.simplejoinleavemessage;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class Placeholders extends PlaceholderExpansion {

  @Override
  public String getIdentifier() {
    return "sm";
  }

  @Override
  public String getAuthor() {
    return SimpleJoinLeaveMessage.getPlugin().getDescription().getAuthors().get(0);
  }

  @Override
  public boolean persist() {
    return true; // This is required or else PlaceholderAPI will unregister the Expansion on reload
  }

  @Override
  public String getVersion() {
    return SimpleJoinLeaveMessage.getPlugin().getDescription().getVersion();
  }

  @Override
  public String onRequest(OfflinePlayer player, String args) {
    if(args.equalsIgnoreCase("lastJoined")) {
      Player lastJoined = JoinLeaveListener.getInstance().getLastJoined();
      if(lastJoined == null) {
        return null;
      }
      return lastJoined.getName();
    }
    if(args.equalsIgnoreCase("lastLeft")) {
      Player lastLeft= JoinLeaveListener.getInstance().getLastLeft();
      if(lastLeft == null) {
        return null;
      }
      return lastLeft.getName();
    }
    return null;
  }
}
