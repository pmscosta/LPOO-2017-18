import java.util.HashMap;
import java.util.Map;

public class OvenStep extends RecipeStep {


	private int temperature;

	public OvenStep(String name, String action, int temperature) {
		super(name, action);
		this.temperature = temperature;
	}

//	public void addIngredient(Ingredient ingredient, int amount) {
//
//		if (!this.ingredients.containsKey(ingredient))
//			this.ingredients.put(ingredient, amount);
//
//	}


	public int getTemperature() {
		return this.temperature;
	}

}
