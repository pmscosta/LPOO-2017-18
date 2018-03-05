import java.util.Objects;

public abstract class Ingredient implements Comparable<Ingredient>{

	private String name;
	
	public Ingredient(String string) throws IllegalArgumentException{
		
		if(string == null)
			throw new IllegalArgumentException();
		
		this.name = string;
		
	}
	

	public String getName() {
		return this.name;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(o instanceof SimpleIngredient)
			return Objects.equals(((SimpleIngredient) o).getName(), this.name);
		else
			return false;
		
	}
	
	@Override
	public String toString() {
		return this.name;
	} 
	
	@Override
	public int compareTo(Ingredient lhs) {
		return this.name.compareTo(lhs.getName());
	}

}
