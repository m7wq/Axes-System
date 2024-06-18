package org.m7moud.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.m7moud.Axe.Axe;

public class PlayerDamagePlayerWithAxeEvent extends Event{
    Player damager;
    Player victim;
    Axe axe;
    boolean cancelled;

    public PlayerDamagePlayerWithAxeEvent(Axe axe, Player damager, Player victim) {
        this.axe = axe;
        this.damager = damager;
        this.victim = victim;
    }



    @Override
    public HandlerList getHandlers() {
        throw new UnsupportedOperationException("Unimplemented method 'getHandlers'");
    }

    public Player getDamager() {
        return damager;
    }

    public Player getVictim() {
        return victim;
    }

    public Axe getAxe() {
        return axe;
    }

    public boolean isCancelled(){
        return cancelled;
    }

    public void setCancelled(boolean b){
        this.cancelled = b;
    }

}
