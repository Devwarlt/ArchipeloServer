package net.hollowbit.archipeloserver.network.packets;

import com.badlogic.gdx.graphics.Color;

import net.hollowbit.archipeloserver.items.ItemType;
import net.hollowbit.archipeloserver.network.Packet;
import net.hollowbit.archipeloserver.network.PacketType;

public class PlayerPickPacket extends Packet {
	
	public static final int RESULT_SUCCESSFUL = 0;
	public static final int RESULT_NAME_ALREADY_TAKEN = 1;
	public static final int RESULT_INVALID_USERNAME = 2;
	public static final int RESULT_ALREADY_LOGGED_IN = 3;
	public static final int RESULT_NO_PLAYER_WITH_NAME = 4;
	public static final int RESULT_TOO_MANY_CHARACTERS = 5;
	
	public static final ItemType[] HAIR_STYLES = {ItemType.HAIR1};
	public static final ItemType[] FACE_STYLES = {ItemType.FACE1};
	public static final ItemType BODY = ItemType.BODY;
	public static final ItemType SHIRT = ItemType.SHIRT_BASIC;
	public static final ItemType PANTS = ItemType.PANTS_BASIC;
	
	public static final Color[] HAIR_COLORS = {new Color(39 / 255f, 28 / 255f, 3 / 255f, 1), new Color(0.627f, 0.412f, 0.071f, 1), new Color(0.843f, 0.824f, 0.275f, 1)};
	public static final Color[] EYE_COLORS = {new Color(0.0549f,0.608f,0.819f,1), Color.BROWN, Color.RED, new Color(0.09f,0.784f,0.125f,1)};
	public static final Color[] BODY_COLORS = {new Color(251 / 255f, 222 / 255f, 136 / 255f, 1), new Color(0.7f, 0.5f, 0.08f, 1), new Color(249 / 255f, 240 / 255f, 138 / 255f, 1)};
	
	public String name;
	public boolean isNew = false;
	public int result = 0;
	
	//If character is new
	public int selectedHair = 0, selectedFace = 0;
	public int hairColor = 0, eyeColor = 0, bodyColor = 0;
	
	public PlayerPickPacket () {
		super(PacketType.PLAYER_PICK);
	}
	
}
