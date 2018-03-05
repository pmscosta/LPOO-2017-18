import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RecipeStep extends Ingredient {

	private String action;
	protected TreeMap<Ingredient, Float> ingredients;
	private TreeMap<Ingredient, Float> ingToPrint;

	@Override
	public String toString() {

		String result = new String();

		result += "to make " + this.getName() + ", " + this.action + " ";

		for (Map.Entry<Ingredient, Float> entry : this.ingToPrint.entrySet()) {

			result += entry.getValue().toString() + " " + entry.getKey().toString() + ", ";
		}

		result = result.substring(0, result.lastIndexOf(", "));

		return result;
	}

	public RecipeStep(String name, String action) throws IllegalArgumentException {

		super(name);

		if (action == null)
			throw new IllegalArgumentException();

		this.action = action;
		this.ingredients = new TreeMap<>();
		this.ingToPrint = new TreeMap<>();
	}

	public String getAction() {
		return this.action;
	}

	public void addIngredient(Ingredient ingredient, float amount) {

		if (this.ingredients.containsKey(ingredient))
			return;

		if (ingredient instanceof RecipeStep) {
			
			
			SimpleIngredient idontevenknow = new SimpleIngredient(ingredient.getName());
			this.ingToPrint.put(idontevenknow, amount);

			for (Map.Entry<Ingredient, Float> entry : ((RecipeStep) ingredient).ingredients.entrySet()) {

				if (!this.ingredients.containsKey(entry.getKey()))
					this.ingredients.put(entry.getKey(), entry.getValue() * amount);

			}

		}

		this.ingredients.put(ingredient, amount);
		this.ingToPrint.put(ingredient, amount);

	}

	public int getIngredientCount() {
		return this.ingredients.size();
	}

	public float getQuantity(Ingredient ingredient) {
		if (!this.ingredients.containsKey(ingredient))
			return 0.0f;
		else
			return this.ingredients.get(ingredient);
	}
}
