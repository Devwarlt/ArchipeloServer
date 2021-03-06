package net.hollowbit.archipeloserver.tools.executables;

import java.util.HashMap;

import com.badlogic.gdx.utils.Json;

import net.hollowbit.archipeloserver.entity.Entity;
import net.hollowbit.archipeloserver.entity.living.Player;
import net.hollowbit.archipeloserver.items.Item;

public class ExecutableManager {
	
	private HashMap<String, Executable> executables;
	private Json json;
	
	public ExecutableManager () {
		executables = new HashMap<String, Executable>();
		json = new Json();
		load();
	}
	
	/**
	 * Execute a command with a specified id. Returns whether successful or not.
	 * @param id Case insensitive
	 * @param sender
	 * @param target
	 * @param arguments
	 * @return
	 */
	public boolean execute (String id, Entity sender, Entity target, HashMap<String, String> arguments) {
		if (executables.containsKey(id.toUpperCase()))
			return executables.get(id.toUpperCase()).execute(sender, target, arguments);
		else
			return false;
	}
	
	/**
	 * Execute and unparsed command. Returns whether successful or not.
	 * @param executionCommandJson
	 * @param sender
	 * @param target
	 * @return
	 */
	public boolean execute (String executionCommandJson, Entity sender, Entity target) {
		ExecutionCommand command = parseCommandString(executionCommandJson);
		return this.execute(command, sender, target);
	}
	
	/**
	 * Execute a command with an already parse execution command
	 * @param executionCommand
	 * @param sender
	 * @param target
	 * @return
	 */
	public boolean execute (ExecutionCommand executionCommand, Entity sender, Entity target) {
		if (executables.containsKey(executionCommand.id.toUpperCase()))
			return executables.get(executionCommand.id.toUpperCase()).execute(sender, target, executionCommand.args);
		else
			return false;
	}
	
	/**
	 * Parses a command string json
	 * @param executionCommandJson
	 * @return
	 */
	public ExecutionCommand parseCommandString (String executionCommandJson) {
		return json.fromJson(ExecutionCommand.class, executionCommandJson);
	}
	
	public interface Executable {
		
		public abstract boolean execute (Entity sender, Entity target, HashMap<String, String> arguments);
		
	}
	
	/**
	 * Loads all executables
	 */
	private void load() {
		executables.put("ADDFLAG", new Executable() {
			
			@Override
			public boolean execute(Entity sender, Entity target, HashMap<String, String> arguments) {
				if (target != null && target instanceof Player) {
					Player player = (Player) target;
					
					if (arguments.containsKey("flag")) {
						player.getFlagsManager().addFlag(arguments.get("flag"));//Set condition to player if available
						return true;
					}else
						return false;
				} else
					return false;
			}
		});
		
		executables.put("GIVEITEMS", new Executable() {

			@Override
			public boolean execute (Entity sender, Entity target, HashMap<String, String> arguments) {
				if (target != null && target instanceof Player) {
					Player player = (Player) target;
					
					if (arguments.containsKey("items")) {
						for (Item item : Item.getManyFromString(arguments.get("items")))
							player.getInventory().add(item);
						return true;
					}else
						return false;
				} else
					return false;
			}
			
		});
		
		//TODO add more executables here
	}
	
}
