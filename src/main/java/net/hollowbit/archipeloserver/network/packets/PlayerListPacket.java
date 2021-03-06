package net.hollowbit.archipeloserver.network.packets;

import net.hollowbit.archipeloserver.items.Item;
import net.hollowbit.archipeloserver.network.Packet;
import net.hollowbit.archipeloserver.network.PacketType;

public class PlayerListPacket extends Packet {
	
	public static final int RESULT_SUCCESSFUL = 0;
	public static final int RESULT_INVALID_LOGIN = 1;
	
	public Item[][] playerEquippedInventories;
	public String[] names;
	public String[] islands;
	public String[] lastPlayedDateTimes;
	public String[] creationDateTimes;
	public int[] levels;
	
	public String email;
	public int result = 0;
	
	public PlayerListPacket () {
		super(PacketType.PLAYER_LIST);
	}

}
