package org.m7moud.Events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class DropLockedItemEvent extends Event{
    private static final HandlerList HANDLERS = new HandlerList();
    
    private boolean cancelled = false;
    private String lockedString = "&cLOCKED";

    @Override
    public HandlerList getHandlers() {
            return  HANDLERS;
    }

    public String getLockedString(){
        return lockedString;
    }
    public void setLockedString(String string){
        this.lockedString = string;
    }

    public boolean isCancelled(){
        return cancelled;
    }

    public void setCancelled(boolean b){
        this.cancelled = true;
    }


}
