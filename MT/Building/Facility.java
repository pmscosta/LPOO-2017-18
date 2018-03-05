import java.util.HashSet;

public abstract class Facility {

	protected String number;
	
	protected HashSet<User> authorized;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Facility other = (Facility) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

	public Facility(String number) {
		this.number = number;
		this.authorized = new HashSet<>();
	}
	
	public String getName() {

		if (this instanceof Building) {

			return ((Building) this).getName();

		}

		else if (this instanceof Room) {

			return ((Room) this).getName();
		}

		return "";
	}

	public abstract boolean canEnter(User u1);

}
