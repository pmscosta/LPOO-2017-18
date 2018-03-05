
public class ATM {

	private int id;
	private String city;
	private String institution;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + id;
		result = prime * result + ((institution == null) ? 0 : institution.hashCode());
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
		ATM other = (ATM) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (id != other.id)
			return false;
		if (institution == null) {
			if (other.institution != null)
				return false;
		} else if (!institution.equals(other.institution))
			return false;
		return true;
	}

	public ATM(int id, String city, String institution) {
		this.id = id;
		this.city = city;
		this.institution = institution;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

}
