import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Building extends Facility {

	private int minFloor;
	private int maxFloor;
	private String name;
	private HashSet<Room> roomVec;

	public HashSet<Room> getRoomVec() {
		return roomVec;
	}

	public int getCapacity() {

		int result = 0;

		for (Room e : this.roomVec)
			result += e.getCapacity();

		return result;

	}

	public void addRoom(Room e) throws DuplicateRoomException {

		if (this.roomVec.contains(e))
			throw new DuplicateRoomException();
		this.roomVec.add(e);
	}

	public int getMinFloor() {
		return minFloor;
	}

	public int getMaxFloor() {
		return maxFloor;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		String result = new String("Building");

		result += "(" + this.name + ")";

		return result;
	}

	public Building(String name, int minFloor, int maxFloor) throws IllegalArgumentException {
		super(name);
		if (minFloor > maxFloor)
			throw new IllegalArgumentException();

		this.minFloor = minFloor;
		this.maxFloor = maxFloor;
		this.name = name;
		this.roomVec = new HashSet<>();
	}

	@Override
	public boolean canEnter(User u1) {
		for(Room r : this.roomVec) {
			
			for (User u : r.authorized)
				if( u == u1)
					return true;
			
			
		}
		return false;
	}

}
