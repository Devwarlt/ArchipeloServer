package net.hollowbit.archipeloserver.tools.event;

import java.util.LinkedList;

import net.hollowbit.archipeloserver.tools.event.events.*;

public class EventManager {
	
	private LinkedList<EventHandler> eventHandlers;
	
	public EventManager () {
		eventHandlers = new LinkedList<EventHandler>();
	}
	
	/**
	 * DO NOT CALL DIRECTLY, call EventHandler.add() instead.
	 * Add an event handler to manager so it can handle events
	 * @param eventHandler
	 */
	public void add (EventHandler eventHandler) {
		eventHandlers.add(eventHandler);
	}
	
	/**
	 * DO NOT CALL DIRECTLY, call EventHandler.remove() instead.
	 * Remove an event handler from the manager to release it from memory.
	 * @param eventHandler
	 */
	public void remove (EventHandler eventHandler) {
		eventHandlers.remove(eventHandler);
	}
	
	private LinkedList<EventHandler> cloneHandlerList() {
		LinkedList<EventHandler> handlersClone = new LinkedList<EventHandler>();
		handlersClone.addAll(eventHandlers);
		return handlersClone;
	}
	
	/**
	 * Trigger an event to be handled by the handlers.
	 * @param event
	 */
	public Event triggerEvent (Event event) {
		boolean handled = false;
		for (EventHandler eventHandler : cloneHandlerList()) {
			switch (event.getType()) {
			case EntityMove:
				if (eventHandler.onEntityMove((EntityMoveEvent) event))
					handled = true;
				break;
			case PlayerJoin:
				if (eventHandler.onPlayerJoin((PlayerJoinEvent) event))
					handled = true;
				break;
			case PlayerLeave:
				if (eventHandler.onPlayerLeave((PlayerLeaveEvent) event))
					handled = true;
				break;
			case EntityTeleport:
				if (eventHandler.onEntityTeleport((EntityTeleportEvent) event))
					handled = true;
				break;
			case PlayerBankAdd:
				if (eventHandler.onPlayerBankAdd((PlayerBankAddEvent) event))
					handled = true;
				break;
			case PlayerInventoryAdd:
				if (eventHandler.onPlayerInventoryAdd((PlayerInventoryAddEvent) event))
					handled = true;
				break;
			case PlayerInventoryChange:
				if (eventHandler.onPlayerInventoryChanged((PlayerInventoryChangeEvent) event))
					handled = true;
				break;
			case PlayerInventoryMove:
				if (eventHandler.onPlayerInventoryMove((PlayerInventoryMoveEvent) event))
					handled = true;
				break;
			case PlayerInventoryRemove:
				if (eventHandler.onPlayerInventoryRemove((PlayerInventoryRemoveEvent) event))
					handled = true;
				break;
			case PlayerStatsChange:
				if (eventHandler.onPlayerStatsChange((PlayerStatsChangeEvent) event))
					handled = true;
				break;
			case EntityInteraction:
				if (eventHandler.onEntityInteraction((EntityInteractionEvent) event))
					handled = true;
				break;
			case EntityDeath:
				if (eventHandler.onEntityDeath((EntityDeathEvent) event))
					handled = true;
				break;
			}
		}
		event.setHandled(handled);
		return event;
	}
	
}
