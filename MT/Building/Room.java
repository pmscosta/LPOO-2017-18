import java.util.Objects;

public class Room extends Facility {

	private Building building;

	private String name;

	private int floor;

	private int capacity;

	@Override
	public String toString() {
		
		String result = new String("Room");

		result += "(" + this.building.getName() + "," + this.number + ")";

		return result;

	}

	public Room(Building b, String number, int floor) throws IllegalArgumentException,DuplicateRoomException {
		
		super(number);

		if (floor < b.getMinFloor() || floor > b.getMaxFloor())
			throw new IllegalArgumentException();

		this.building = b;
		this.number = number;
		this.floor = floor;
		this.name = b.getName() + number;
		b.addRoom(this);
	}


	public Room(Building b, String number, int floor, int capacity) throws IllegalArgumentException, DuplicateRoomException {
		super(number);

		if (floor < b.getMinFloor() || floor > b.getMaxFloor())
			throw new IllegalArgumentException();

		this.building = b;
		this.number = number;
		this.floor = floor;
		this.name = b.getName() + number;
		this.setCapacity(capacity);
		b.addRoom(this);
		
	}

	public Building getBuilding() {
		return building;
	}

	public String getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public int getFloor() {
		return floor;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public boolean canEnter(User u1) {
		if( this.authorized.contains(u1))
			return true;
		return false;
	}

	public void authorize(User u1) {
		
		this.authorized.add(u1);
		
	}

}
