
public abstract class Transaction {

	private int id;
	private double amount;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Transaction other = (Transaction) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		String result = new String();

		if (this instanceof Withdrawal) {
			result += "Withdrawal at ATM " + String.valueOf(this.atm.getID()) + " (" + this.atm.getCity() + ", "
					+ this.atm.getInstitution() + ")" + " of " + String.format("%.2f", (double) this.amount);
		} else if (this instanceof Deposit)
			result += "Deposit at ATM " + String.valueOf(this.atm.getID()) + " (" + this.atm.getCity() + ", "
					+ this.atm.getInstitution() + ")" + " of " + String.format("%.2f", getAmount());

		return result;
	}

	private ATM atm;
	private Session session;
	private Card card;

	public Transaction(ATM atm, Session s, Card c, int i) {
		this.atm = atm;
		this.session = s;
		this.card = c;
		this.id = i;
	}

	public int getID() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public ATM getATM() {
		return atm;
	}

	public void setATM(ATM atm) {
		this.atm = atm;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session s) {
		this.session = s;
	}

	public Card getCard() {
		return card;
	}

	public void setC(Card c) {
		this.card = c;
	}

}
