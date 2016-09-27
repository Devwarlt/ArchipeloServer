package net.hollowbit.archipeloserver.network.packets;

import com.badlogic.gdx.graphics.Color;

import net.hollowbit.archipeloserver.items.ItemType;
import net.hollowbit.archipeloserver.network.Packet;
import net.hollowbit.archipeloserver.network.PacketType;

public class PlayerCreationPacket extends Packet {
	
	public static final ItemType[] HAIR_STYLES = {ItemType.HAIR1};
	public static final ItemType[] FACE_STYLES = {ItemType.FACE1};
	public static final ItemType BODY = ItemType.BODY;
	public static final ItemType SHIRT = ItemType.SHIRT_BASIC;
	public static final ItemType PANTS = ItemType.PANTS_BASIC;
	
	public static final Color[] HAIR_COLORS = {new Color(1, 1, 1, 1), new Color(0.627f, 0.412f, 0.071f, 1), new Color(0.843f, 0.824f, 0.275f, 1)};
	public static final Color[] EYE_COLORS = {Color.BLUE, Color.BROWN, Color.RED, Color.GREEN};
	public static final Color[] BODY_COLORS = {new Color(1, 1, 1, 1), new Color(0.7f, 0.5f, 0.08f, 1)};
	
	public int selectedHair, selectedFace;
	public int hairColor, eyeColor, bodyColor;
	
	public PlayerCreationPacket () {
		super(PacketType.PLAYER_CREATION);
	}

}
