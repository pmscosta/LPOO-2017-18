import java.util.HashSet;

public class Session implements Countable{
	
	public int count() {
		return this.transSet.size();
	}
	
	private HashSet<Transaction> transSet = new HashSet<>();

	private ATM atm;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atm == null) ? 0 : atm.hashCode());
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
		Session other = (Session) obj;
		if (atm == null) {
			if (other.atm != null)
				return false;
		} else if (!atm.equals(other.atm))
			return false;
		return true;
	}

	public ATM getATM() {
		return atm;
	}

	public void setATM(ATM atm) {
		this.atm = atm;
	}

	public Session(ATM atm) {
		this.atm = atm;
	}

	public void addTransaction(Transaction w) {
		
		this.transSet.add(w);
		
	}

}
