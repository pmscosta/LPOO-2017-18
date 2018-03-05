import java.util.TreeSet;

public class Recipe {
	
	private String name;

	private TreeSet<Ingredient> ingSet;
	
	public Recipe(String string) throws IllegalArgumentException {
		
		if(string == null)
			throw new IllegalArgumentException();
		
		this.name = string;
		this.ingSet = new TreeSet<>();
	}

	public String getName() {
		return this.name;
	}

	public void addStep(RecipeStep item) {
		
		this.ingSet.add(item);
		
	}

	public int getStepCount() {
		return this.ingSet.size();
	}

}
