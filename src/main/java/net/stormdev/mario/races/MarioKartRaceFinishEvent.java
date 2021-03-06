package net.stormdev.mario.races;

import net.stormdev.mario.rewards.RewardConfiguration;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * An event to be used to dish out rewards, etc... at the end of a race
 */
public class MarioKartRaceFinishEvent extends Event implements Cancellable {
	public Boolean cancelled = false;
	private static final HandlerList handlers = new HandlerList();
	Player player = null;
	Race race;
	int position = 1;
	String pos = "";
	private RewardConfiguration rewards;

	public MarioKartRaceFinishEvent(Player player, int position,
			String positionFriendly, RewardConfiguration rewards, Race race) {
		this.player = player;
		this.position = position;
		this.pos = positionFriendly;
		this.rewards = rewards;
		this.race = race;
	}

	@Override
	public boolean isCancelled() {
		return this.cancelled;
	}

	@Override
	public void setCancelled(boolean arg0) {
		this.cancelled = arg0;
	}
	
	public RewardConfiguration getRewardConfig(){
		return rewards;
	}

	public Integer getFinishPosition() {
		return position;
	}

	public String getPlayerFriendlyPosition() {
		return pos;
	}
	
	public Race getRace() {
		return race;
	}

	public Player getPlayer() {
		return player;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
