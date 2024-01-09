package tacos.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tacos.data.IngredientRepository;
import tacos.entity.Ingredient;

@RestController
@RequestMapping(path = "/api/ingredient", produces = {"application/json", "text/xml"})
public class IngredientController {
    private IngredientRepository ingredientRepository;

    public IngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping
    public Iterable<Ingredient> allIngredients() {
        return ingredientRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient saveIngredient(@RequestBody Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }
}
