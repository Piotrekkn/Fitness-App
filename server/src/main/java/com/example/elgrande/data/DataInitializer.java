package com.example.elgrande.data;

import com.example.elgrande.model.diet.Diet;
import com.example.elgrande.model.diet.Ingredient;
import com.example.elgrande.model.diet.Meal;
import com.example.elgrande.model.enums.enums_diet.FoodType;
import com.example.elgrande.model.enums.enums_training.Body;
import com.example.elgrande.model.enums.enums_training.Type;
import com.example.elgrande.model.training.Exercise;
import com.example.elgrande.model.training.Training;
import com.example.elgrande.model.user.UserEntity;
import com.example.elgrande.repository.UserRepository;
import com.example.elgrande.service.diet_service.DietRepository;
import com.example.elgrande.service.diet_service.IngredientRepository;
import com.example.elgrande.service.diet_service.MealRepository;
import com.example.elgrande.service.training_service.ExerciseRepository;
import com.example.elgrande.service.training_service.TrainingRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private TrainingRepository trainingRepository;
    private ExerciseRepository exerciseRepository;
    private DietRepository dietRepository;
    private MealRepository mealRepository;
    private IngredientRepository ingredientRepository;
@Autowired
    public DataInitializer(UserRepository userRepository, TrainingRepository trainingRepository, ExerciseRepository exerciseRepository, DietRepository dietRepository, MealRepository mealRepository, IngredientRepository ingredientRepository) {
        this.userRepository = userRepository;
        this.trainingRepository = trainingRepository;
        this.exerciseRepository = exerciseRepository;
        this.dietRepository = dietRepository;
        this.mealRepository = mealRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void run(String... args) throws Exception {


//Proper Diet Database
        //Meso
/*
        Ingredient beefStrips = new Ingredient("Beef Strips", 250);
        Ingredient chickenBreast = new Ingredient("Chicken Breast", 165);
        Ingredient chickenStrips = new Ingredient("Chicken Strips", 239);
        Ingredient eggs = new Ingredient("Eggs", 155);
        Ingredient grilledChickenStrips = new Ingredient("Grilled Chicken Strips", 300);
        Ingredient grilledShrimp = new Ingredient("Grilled Shrimp", 154);
        Ingredient groundBeef = new Ingredient("Ground Beef", 330);
        Ingredient groundTurkey = new Ingredient("Ground Turkey", 203);
        Ingredient gyroMeat = new Ingredient("Gyro Meat", 209);
        Ingredient hardBoiledEggs = new Ingredient("Hard-Boiled Eggs", 155);
        Ingredient pork = new Ingredient("Pork", 242);
        Ingredient pulledPork = new Ingredient("Pulled Pork", 167);
        Ingredient salmonFillet = new Ingredient("Salmon Fillet", 334);
        Ingredient shrimp = new Ingredient("Shrimp", 99);
        Ingredient tuna = new Ingredient("Tuna", 132);
        Ingredient turkeySlices = new Ingredient("Turkey Slices", 189);
        Ingredient sirloinSteak = new Ingredient("Sirloin Steak", 244);
        Ingredient porkRibs = new Ingredient("Pork Ribs", 361);
        Ingredient porkShoulder = new Ingredient("Pork Shoulder", 269);
        Ingredient baconStrips = new Ingredient("Bacon Strips", 477);
        Ingredient lambChops = new Ingredient("Lamb Chops", 294);
        Ingredient chickenWings = new Ingredient("Chicken Wings", 203);
        //Nabiał
        Ingredient cheddarCheese = new Ingredient("Cheddar Cheese", 402);
        Ingredient fetaCheese = new Ingredient("Feta Cheese", 263);
        Ingredient mozzarellaCheese = new Ingredient("Mozzarella Cheese", 248);
        Ingredient parmesanCheese = new Ingredient("Parmesan Cheese", 431);
        Ingredient ricottaCheese = new Ingredient("Ricotta Cheese", 174);
        Ingredient tofu = new Ingredient("Tofu", 76);
        Ingredient butter = new Ingredient("Butter", 717);
        Ingredient sourCream = new Ingredient("SourCream", 193);
        //Warzywa
        Ingredient avocado = new Ingredient("Avocado", 160);
        Ingredient basil = new Ingredient("Basil", 23);
        Ingredient blackBeans = new Ingredient("Black Beans", 132);
        Ingredient broccoli = new Ingredient("Broccoli", 34);
        Ingredient carrots = new Ingredient("Carrots", 41);
        Ingredient celery = new Ingredient("Celery", 8);
        Ingredient cherryTomatoes = new Ingredient("Cherry Tomatoes", 18);
        Ingredient chickpeas = new Ingredient("Chickpeas", 364);
        Ingredient coleslaw = new Ingredient("Coleslaw", 152);
        Ingredient corn = new Ingredient("Corn", 86);
        Ingredient cucumber = new Ingredient("Cucumber", 16);
        Ingredient eggplantSlices = new Ingredient("Eggplant Slices", 25);
        Ingredient freshBasil = new Ingredient("Fresh Basil", 22);
        Ingredient garlic = new Ingredient("Garlic", 150);
        Ingredient ginger = new Ingredient("Ginger", 80);
        Ingredient greenBeans = new Ingredient("Green Beans", 31);
        Ingredient kalamataOlives = new Ingredient("Kalamata Olives", 88);
        Ingredient kale = new Ingredient("Kale ", 50);
        Ingredient lemon = new Ingredient("Lemon", 29);
        Ingredient lentils = new Ingredient("Lentils", 353);
        Ingredient lettuce = new Ingredient("Lettuce", 15);
        Ingredient lime = new Ingredient("Lime", 30);
        Ingredient mixedGreens = new Ingredient("Mixed Greens", 9);
        Ingredient mushrooms = new Ingredient("Mushrooms", 22);
        Ingredient onion = new Ingredient("Onion", 40);
        Ingredient orange = new Ingredient("Orange", 47);
        Ingredient parsley = new Ingredient("Parsley", 36);
        Ingredient pickles = new Ingredient("Pickles", 11);
        Ingredient pineappleChunks = new Ingredient("Pineapple Chunks", 50);
        Ingredient potatoes = new Ingredient("Potatoes", 313);
        Ingredient redBellPeppers = new Ingredient("Red Bell Peppers", 31);
        Ingredient redOnion = new Ingredient("Red Onion", 42);
        Ingredient romaineLettuce = new Ingredient("Romaine Lettuce", 17);
        Ingredient rosemary = new Ingredient("Rosemary", 131);
        Ingredient scallions = new Ingredient("Scallions", 32);
        Ingredient snowPeas = new Ingredient("Snow Peas", 67);
        Ingredient spinach = new Ingredient("Spinach", 23);
        Ingredient sweetPotatoes = new Ingredient("Sweet Potatoes", 86);
        Ingredient tomatoes = new Ingredient("Tomatoes", 19);
        Ingredient zucchini = new Ingredient("Zucchini", 17);
        //Zapychacze
        Ingredient arborioRice = new Ingredient("Arborio Rice", 130);
        Ingredient brownRice = new Ingredient("Brown Rice", 111);
        Ingredient cornTortillas = new Ingredient("Corn Tortillas", 218);
        Ingredient fettuccinePasta = new Ingredient("Fettuccine Pasta", 99);
        Ingredient flourTortillas = new Ingredient("Flour Tortillas", 287);
        Ingredient hamburgerBun = new Ingredient("Hamburger Bun", 150);
        Ingredient jasmineRice = new Ingredient("Jasmine Rice", 170);
        Ingredient lasagnaPasta = new Ingredient("Lasagna Pasta", 354);
        Ingredient linguinePasta = new Ingredient("Linguine Pasta", 353);
        Ingredient pennePasta = new Ingredient("Penne Pasta", 157);
        Ingredient pitaBread = new Ingredient("Pita Bread", 275);
        Ingredient quinoa = new Ingredient("Quinoa", 370);
        Ingredient spaghettiPasta = new Ingredient("Spaghetti Pasta", 158);
        Ingredient sushiRice = new Ingredient("Sushi Rice", 139);
        Ingredient tagliatellePasta = new Ingredient("Tagliatelle Pasta", 288);
        Ingredient wholeWheatWrap = new Ingredient("Whole Wheat Wrap", 263);
        //Sosy
        Ingredient alfredoSauce = new Ingredient("Alfredo Sauce", 410);
        Ingredient BBQSauce = new Ingredient("BBQ Sauce", 172);
        Ingredient caesarDressing = new Ingredient("Caesar Dressing", 269);
        Ingredient dijonMustard = new Ingredient("Dijon Mustard", 66);
        Ingredient hotSauce = new Ingredient("Hot Sauce", 11);
        Ingredient marinaraSauce = new Ingredient("Marinara Sauce", 51);
        Ingredient pestoSauce = new Ingredient("Pesto Sauce", 534);
        Ingredient salsa = new Ingredient("Salsa", 36);
        Ingredient teriyakiSauce = new Ingredient("Teriyaki Sauce", 84);
        Ingredient tomatoSauce = new Ingredient("Tomato Sauce", 29);
        Ingredient tzatzikiSauce = new Ingredient("Tzatziki Sauce", 85);
        //Dodatki
        Ingredient balsamicGlaze = new Ingredient("Balsamic Glaze", 88);
        Ingredient brownSugar = new Ingredient("Brown Sugar", 380);
        Ingredient breadCrumbs = new Ingredient("Bread Crumbs", 395);
        Ingredient cayennePepper = new Ingredient("Cayenne Pepper", 318);
        Ingredient chickenBroth = new Ingredient("Chicken Broth", 267);
        Ingredient chiliPowder = new Ingredient("Chili Powder", 282);
        Ingredient coconutMilk = new Ingredient("Coconut Milk", 230);
        Ingredient croutons = new Ingredient("Croutons", 465);
        Ingredient cumin = new Ingredient("Cumin", 375);
        Ingredient curryPowder = new Ingredient("Curry Powder", 325);
        Ingredient freshMint = new Ingredient("Fresh Mint", 58);
        Ingredient garlicPowder = new Ingredient("Garlic Powder", 331);
        Ingredient vegetableBroth = new Ingredient("Vegetable Broth", 11);
        Ingredient mixedHerbs = new Ingredient("Mixed Herbs", 303);
        Ingredient oliveOil = new Ingredient("Olive Oil", 884);
        Ingredient paprika = new Ingredient("Paprika", 282);
        Ingredient pineNuts = new Ingredient("Pine Nuts", 673);
        Ingredient soySauce = new Ingredient("Soy Sauce", 53);
        Ingredient tacoSeasoning = new Ingredient("Taco Seasoning", 292);
        Ingredient whiteWine = new Ingredient("White Wine", 82);

// 1. Spaghetti Bolognese
        Meal spaghettiBolognese = new Meal("Spaghetti Bolognese", FoodType.NORMAL, List.of(groundBeef, tomatoSauce, spaghettiPasta, onion, garlic),
                List.of(250, 200, 150, 50, 10), "1. Cook spaghetti according to package instructions.\n" +
                "2. In a pan, brown ground beef with chopped onions and garlic.\n" +
                "3. Add tomato sauce to the beef mixture and let it simmer.\n" +
                "4. Serve the Bolognese sauce over the cooked spaghetti.");

// 2. Vegetarian Stir-Fry
        Meal vegetarianStirFry = new Meal("Vegetarian Stir-Fry", FoodType.VEGAN, List.of(tofu, broccoli, redBellPeppers, carrots, soySauce),
                List.of(200, 150, 100, 80, 20), "1. Press tofu to remove excess water and cut into cubes.\n" +
                "2. Stir-fry tofu, broccoli, bell peppers, and carrots in a wok.\n" +
                "3. Add soy sauce and toss until well-cooked.\n" +
                "4. Serve over rice or noodles.");

// 3. Salmon Quinoa Bowl
        Meal salmonQuinoaBowl = new Meal("Salmon Quinoa Bowl", FoodType.VEGETARIAN, List.of(salmonFillet, quinoa, avocado, kale, lemon),
                List.of(180, 100, 80, 50, 10), "1. Grill salmon fillet until cooked through.\n" +
                "2. Cook quinoa according to package instructions.\n" +
                "3. Assemble the bowl with quinoa, grilled salmon, sliced avocado, and kale.\n" +
                "4. Squeeze lemon juice over the bowl before serving.");

// 4. Caprese Salad
        Meal capreseSalad = new Meal("Caprese Salad", FoodType.VEGETARIAN, List.of(mozzarellaCheese, tomatoes, freshBasil, balsamicGlaze, oliveOil),
                List.of(150, 100, 30, 20, 20), "1. Slice fresh mozzarella, tomatoes, and arrange on a plate.\n" +
                "2. Sprinkle fresh basil over the mozzarella and tomatoes.\n" +
                "3. Drizzle balsamic glaze and olive oil on top.\n" +
                "4. Season with salt and pepper to taste.");

// 5. Chicken Caesar Wrap
        Meal chickenCaesarWrap = new Meal("Chicken Caesar Wrap", FoodType.NORMAL, List.of(grilledChickenStrips, romaineLettuce, parmesanCheese, caesarDressing, wholeWheatWrap),
                List.of(200, 100, 50, 30, 50), "1. Grill chicken strips until fully cooked.\n" +
                "2. In a bowl, mix Romaine lettuce, Parmesan cheese, and Caesar dressing.\n" +
                "3. Lay out a whole wheat wrap, add the lettuce mixture, and top with grilled chicken.\n" +
                "4. Roll up the wrap and secure with a toothpick.");

// 6. Shrimp and Broccoli Alfredo
        Meal shrimpBroccoliAlfredo = new Meal("Shrimp and Broccoli Alfredo", FoodType.VEGETARIAN, List.of(shrimp, broccoli, fettuccinePasta, alfredoSauce, parmesanCheese),
                List.of(250, 150, 120, 100, 30), "1. Cook fettuccine pasta according to package instructions.\n" +
                "2. In a pan, sauté shrimp and broccoli until shrimp is pink and broccoli is tender.\n" +
                "3. Add Alfredo sauce and cooked pasta to the pan, toss until well coated.\n" +
                "4. Sprinkle Parmesan cheese on top before serving.");

// 7. Mushroom Risotto
        Meal mushroomRisotto = new Meal("Mushroom Risotto", FoodType.NORMAL, List.of(arborioRice, mushrooms, chickenBroth, whiteWine, parmesanCheese),
                List.of(200, 150, 250, 50, 40), "1. Sauté mushrooms in a pan until browned.\n" +
                "2. In a separate pot, cook Arborio rice in chicken broth.\n" +
                "3. Add sautéed mushrooms and white wine to the rice, stirring until creamy.\n" +
                "4. Finish by stirring in grated Parmesan cheese.");

// 7.1. Mushroom Risotto
        Meal vegetarianMushroomRisotto = new Meal("Vegetarian Mushroom Risotto", FoodType.VEGETARIAN, List.of(arborioRice, mushrooms, vegetableBroth, whiteWine, parmesanCheese),
                List.of(200, 150, 250, 50, 40), "1. Sauté mushrooms in a pan until browned.\n" +
                "2. In a separate pot, cook Arborio rice in vegetable broth.\n" +
                "3. Add sautéed mushrooms and white wine to the rice, stirring until creamy.\n" +
                "4. Finish by stirring in grated Parmesan cheese.");

// 8. Taco Salad
        Meal tacoSalad = new Meal("Taco Salad", FoodType.NORMAL, List.of(groundTurkey, lettuce, cherryTomatoes, blackBeans, cheddarCheese),
                List.of(200, 100, 75, 50, 40), "1. Cook ground turkey in a skillet until fully browned.\n" +
                "2. In a large bowl, combine cooked turkey, lettuce, cherry tomatoes, black beans, and shredded cheddar cheese.\n" +
                "3. Toss with your favorite dressing and top with crushed tortilla chips.");

// 9. Veggie Omelette
        Meal veggieOmelette = new Meal("Veggie Omelette", FoodType.VEGETARIAN, List.of(eggs, redBellPeppers, spinach, tomatoes, fetaCheese),
                List.of(300, 100, 50, 50, 30), "1. Whisk eggs in a bowl and season with salt and pepper.\n" +
                "2. In a non-stick skillet, sauté bell peppers, spinach, and tomatoes.\n" +
                "3. Pour the whisked eggs over the veggies and cook until set.\n" +
                "4. Fold the omelette in half and serve with crumbled feta cheese.");

// 10. Beef and Vegetable Stir-Fry
        Meal beefVegetableStirFry = new Meal("Beef and Vegetable Stir-Fry", FoodType.NORMAL, List.of(beefStrips, broccoli, snowPeas, carrots, ginger),
                List.of(250, 100, 80, 50, 10), "1. Sauté beef strips in a wok until browned.\n" +
                "2. Add broccoli, snow peas, carrots, and ginger, stir-frying until vegetables are tender.\n" +
                "3. Pour soy sauce over the stir-fry and toss until well-coated.\n" +
                "4. Serve over rice.");

// 11. Caesar Salad with Grilled Shrimp
        Meal caesarSaladGrilledShrimp = new Meal("Caesar Salad with Grilled Shrimp", FoodType.VEGETARIAN, List.of(grilledShrimp, romaineLettuce, croutons, caesarDressing, parmesanCheese),
                List.of(200, 100, 50, 30, 20), "1. Grill shrimp until pink and fully cooked.\n" +
                "2. In a large bowl, mix Romaine lettuce, croutons, Parmesan cheese, and Caesar dressing.\n" +
                "3. Top the salad with grilled shrimp.\n" +
                "4. Toss the salad and serve.");

// 12. Pesto Pasta with Cherry Tomatoes
        Meal pestoPastaCherryTomatoes = new Meal("Pesto Pasta with Cherry Tomatoes", FoodType.VEGETARIAN, List.of(pestoSauce, cherryTomatoes, pennePasta, pineNuts, parmesanCheese),
                List.of(100, 150, 120, 30, 80), "1. Cook penne pasta according to package instructions.\n" +
                "2. In a blender, combine pesto sauce, cherry tomatoes, and pine nuts.\n" +
                "3. Toss the cooked pasta in the pesto mixture.\n" +
                "4. Sprinkle grated Parmesan cheese on top before serving.");

// 13. Hawaiian Chicken Skewers
        Meal hawaiianChickenSkewers = new Meal("Hawaiian Chicken Skewers", FoodType.NORMAL, List.of(chickenBreast, pineappleChunks, redBellPeppers, redOnion, teriyakiSauce),
                List.of(200, 100, 80, 50, 30), "1. Thread chicken, pineapple chunks, bell peppers, and red onion onto skewers.\n" +
                "2. Grill skewers until chicken is fully cooked.\n" +
                "3. Baste with teriyaki marinade during grilling.\n" +
                "4. Serve skewers over rice.");

// 14. Sweet Potato and Black Bean Bowl
        Meal sweetPotatoBlackBeanBowl = new Meal("Sweet Potato and Black Bean Bowl", FoodType.VEGAN, List.of(sweetPotatoes, blackBeans, corn, avocado, lime),
                List.of(150, 100, 80, 50, 10), "1. Roast sweet potatoes until tender.\n" +
                "2. Mix roasted sweet potatoes with black beans, corn, and diced avocado.\n" +
                "3. Squeeze lime juice over the bowl before serving.\n" +
                "4. Season with salt and pepper to taste.");

// 15. Lentil Soup
        Meal lentilSoup = new Meal("Lentil Soup", FoodType.VEGAN, List.of(lentils, carrots, celery, onion, vegetableBroth),
                List.of(200, 80, 50, 50, 300), "1. Rinse lentils and cook them in vegetable broth.\n" +
                "2. Sauté carrots, celery, and onions in a pot until softened.\n" +
                "3. Add sautéed vegetables to the lentils and simmer until flavors meld.\n" +
                "4. Season with salt and pepper to taste.");

// 16. BBQ Pulled Pork Sandwich
        Meal bbqPulledPorkSandwich = new Meal("BBQ Pulled Pork Sandwich", FoodType.NORMAL, List.of(pulledPork, BBQSauce, coleslaw, hamburgerBun, pickles),
                List.of(200, 50, 80, 50, 10), "1. Slow-cook pulled pork in BBQ sauce until tender.\n" +
                "2. Assemble the sandwich with pulled pork, coleslaw, and pickles.\n" +
                "3. Serve the sandwich on a toasted hamburger bun.");
// 17. Greek Gyro Wrap
        Meal greekGyroWrap = new Meal("Greek Gyro Wrap", FoodType.NORMAL, List.of(gyroMeat, tzatzikiSauce, tomatoes, redOnion, pitaBread),
                List.of(200, 50, 50, 30, 50), "1. Cook gyro meat until fully cooked.\n" +
                "2. In a pita bread, layer gyro meat, Tzatziki sauce, diced tomatoes, and red onion.\n" +
                "3. Roll up the wrap and secure with a toothpick.\n" +
                "4. Serve with additional Tzatziki sauce for dipping.");

// 18. Teriyaki Salmon Bowl
        Meal teriyakiSalmonBowl = new Meal("Teriyaki Salmon Bowl", FoodType.VEGETARIAN, List.of(salmonFillet, brownRice, broccoli, carrots, teriyakiSauce),
                List.of(180, 100, 80, 50, 30), "1. Grill salmon fillet until fully cooked.\n" +
                "2. Cook brown rice according to package instructions.\n" +
                "3. Steam broccoli and carrots.\n" +
                "4. Assemble the bowl with rice, grilled salmon, and steamed vegetables.\n" +
                "5. Drizzle teriyaki sauce over the bowl.");

// 19. Mediterranean Quinoa Salad
        Meal mediterraneanQuinoaSalad = new Meal("Mediterranean Quinoa Salad", FoodType.VEGETARIAN, List.of(quinoa, cherryTomatoes, cucumber, kalamataOlives, fetaCheese),
                List.of(100, 80, 50, 30, 40), "1. Cook quinoa according to package instructions.\n" +
                "2. In a bowl, mix cooked quinoa with cherry tomatoes, cucumber, Kalamata olives, and feta cheese.\n" +
                "3. Toss the salad and serve chilled.");

// 20. Chickpea Curry
        Meal chickpeaCurry = new Meal("Chickpea Curry", FoodType.VEGAN, List.of(chickpeas, coconutMilk, spinach, tomatoes, curryPowder),
                List.of(200, 150, 80, 50, 10), "1. Sauté chickpeas in coconut milk.\n" +
                "2. Add spinach, tomatoes, and curry powder to the chickpea mixture.\n" +
                "3. Simmer until spinach is wilted.\n" +
                "4. Serve over rice.");

// 21. Tuna Nicoise Salad
        Meal tunaNicoiseSalad = new Meal("Tuna Nicoise Salad", FoodType.VEGETARIAN, List.of(tuna, mixedGreens, potatoes, greenBeans, hardBoiledEggs),
                List.of(150, 100, 80, 50, 200), "1. In a bowl, combine mixed greens, canned tuna, boiled potatoes, and green beans.\n" +
                "2. Top the salad with hard-boiled eggs.\n" +
                "3. Serve with your favorite dressing.");

// 22. Pork Fried Rice
        Meal porkFriedRice = new Meal("Pork Fried Rice", FoodType.NORMAL, List.of(pork, jasmineRice, snowPeas, carrots, scallions, soySauce),
                List.of(200, 150, 40, 40, 50, 20), "1. Cook diced pork in a wok until browned.\n" +
                "2. Add jasmine rice, peas, carrots, and scallions to the wok.\n" +
                "3. Stir-fry the ingredients and add soy sauce for flavor.\n" +
                "4. Serve hot.");

// 23. Chicken Fajitas
        Meal chickenFajitas = new Meal("Chicken Fajitas", FoodType.NORMAL, List.of(chickenStrips, redBellPeppers, onion, flourTortillas, salsa),
                List.of(200, 100, 80, 50, 30), "1. Sauté chicken strips in a skillet until fully cooked.\n" +
                "2. Add sliced bell peppers and onions to the skillet.\n" +
                "3. Warm flour tortillas in the oven.\n" +
                "4. Assemble fajitas with the chicken and vegetable mixture.\n" +
                "5. Serve with salsa.");

// 24. Eggplant Parmesan
        Meal eggplantParmesan = new Meal("Eggplant Parmesan", FoodType.VEGETARIAN, List.of(eggplantSlices, marinaraSauce, mozzarellaCheese, parmesanCheese, basil),
                List.of(200, 150, 100, 50, 10), "1. Bread eggplant slices and bake until golden brown.\n" +
                "2. In a baking dish, layer marinara sauce, eggplant slices, mozzarella cheese, and Parmesan cheese.\n" +
                "3. Bake until the cheese is melted and bubbly.\n" +
                "4. Garnish with fresh basil before serving.");

// 25. Beef Tacos
        Meal beefTacos = new Meal("Beef Tacos", FoodType.NORMAL, List.of(groundBeef, tacoSeasoning, lettuce, tomatoes, cheddarCheese),
                List.of(200, 30, 80, 50, 40), "1. Brown ground beef in a skillet and season with taco seasoning.\n" +
                "2. In taco shells, layer the seasoned beef, lettuce, tomatoes, and shredded cheddar cheese.\n" +
                "3. Serve with your favorite taco toppings.");

// 26. Shrimp Scampi
        Meal shrimpScampi = new Meal("Shrimp Scampi", FoodType.VEGETARIAN, List.of(shrimp, linguinePasta, garlic, lemon, parsley),
                List.of(250, 120, 20, 30, 10), "1. Cook linguine pasta according to package instructions.\n" +
                "2. Sauté shrimp in garlic and lemon until fully cooked.\n" +
                "3. Toss the cooked pasta with the shrimp mixture.\n" +
                "4. Garnish with chopped parsley before serving.");

// 27. Sushi Bowl
        Meal sushiBowl = new Meal("Sushi Bowl", FoodType.VEGETARIAN, List.of(sushiRice, salmonFillet, avocado, cucumber, soySauce),
                List.of(150, 100, 80, 50, 20), "1. Cook sushi rice according to package instructions.\n" +
                "2. Assemble the bowl with sushi rice, sliced salmon, avocado, and cucumber.\n" +
                "3. Drizzle soy sauce over the bowl before serving.");

// 28. Vegetable Lasagna
        Meal vegetableLasagna = new Meal("Vegetable Lasagna", FoodType.VEGETARIAN, List.of(lasagnaPasta, marinaraSauce, zucchini, ricottaCheese, mozzarellaCheese),
                List.of(150, 100, 80, 50, 40), "1. Cook lasagna noodles according to package instructions.\n" +
                "2. In a baking dish, layer marinara sauce, lasagna noodles, zucchini, ricotta cheese, and mozzarella cheese.\n" +
                "3. Repeat the layers and bake until bubbly and golden brown.\n" +
                "4. Let it cool before serving.");

// 29. Turkey and Avocado Wrap
        Meal turkeyAvocadoWrap = new Meal("Turkey and Avocado Wrap", FoodType.NORMAL, List.of(turkeySlices, avocado, lettuce, tomatoes, wholeWheatWrap),
                List.of(150, 75, 50, 30, 50), "1. Layer turkey slices, avocado, lettuce, and tomato on a whole wheat wrap.\n" +
                "2. Roll up the wrap and secure with a toothpick.\n" +
                "3. Slice in half and serve.");

// 30. Chicken Noodle Soup
        Meal chickenNoodleSoup = new Meal("Chicken Noodle Soup", FoodType.NORMAL, List.of(chickenBreast, tagliatellePasta, carrots, celery, chickenBroth),
                List.of(200, 100, 80, 50, 300), "1. Poach chicken breast in chicken broth until fully cooked.\n" +
                "2. Add egg noodles, carrots, celery, and onions to the pot.\n" +
                "3. Simmer until the noodles are tender.\n" +
                "4. Season with salt and pepper to taste.");

// 31. Steak with Garlic Butter
        Meal steakWithGarlicButter = new Meal("Steak with Garlic Butter", FoodType.CARNIVORE, List.of(sirloinSteak, garlic, butter, rosemary),
                List.of(250, 30, 50, 20), "1. Season the sirloin steak with salt and pepper.\n" +
                "2. Grill the steak to your preferred doneness.\n" +
                "3. In a pan, melt butter and sauté minced garlic until fragrant.\n" +
                "4. Add rosemary to the garlic butter and baste the grilled steak with the mixture.");

// 32. BBQ Ribs
        Meal bbqRibs = new Meal("BBQ Ribs", FoodType.CARNIVORE, List.of(porkRibs, BBQSauce, brownSugar, paprika, garlicPowder),
                List.of(1000, 240, 60, 20, 10), "1. Preheat the oven to 275°F (135°C).\n" +
                "2. Mix brown sugar, paprika, and garlic powder to create a dry rub.\n" +
                "3. Rub the mixture over the pork ribs.\n" +
                "4. Place ribs in the oven and bake for 2.5 to 3 hours.\n" +
                "5. Brush the ribs with BBQ sauce during the last 30 minutes of cooking.");

// 33. Grilled Chicken Breast with Lemon Herb Marinade
        Meal grilledChickenBreast = new Meal("Grilled Chicken Breast with Lemon Herb Marinade", FoodType.CARNIVORE, List.of(chickenBreast, lemon, oliveOil, garlic, mixedHerbs),
                List.of(360, 30, 60, 10, 20), "1. Marinate chicken breasts in a mixture of lemon juice, olive oil, minced garlic, and mixed herbs for at least 30 minutes.\n" +
                "2. Grill the chicken breasts until fully cooked.\n" +
                "3. Serve with additional lemon wedges and herbs for garnish.");

// 34. Beef Stir-Fry with Vegetables
        Meal beefStirFry = new Meal("Beef Stir-Fry with Vegetables", FoodType.CARNIVORE, List.of(beefStrips, broccoli, redBellPeppers, soySauce, ginger),
                List.of(300, 400, 400, 60, 20), "1. Stir-fry beef strips in a hot pan until browned.\n" +
                "2. Add sliced broccoli, bell peppers, and minced ginger to the pan.\n" +
                "3. Pour soy sauce over the ingredients and stir-fry until vegetables are tender.\n" +
                "4. Adjust seasoning if necessary.");

// 35. Carnitas Tacos
        Meal carnitasTacos = new Meal("Carnitas Tacos", FoodType.CARNIVORE, List.of(porkShoulder, cumin, chiliPowder, orange, cornTortillas),
                List.of(1000, 20, 20, 60, 110), "1. Cut pork shoulder into chunks and season with cumin, chili powder, and salt.\n" +
                "2. Place seasoned pork in a slow cooker, add orange juice, and cook on low for 6-8 hours.\n" +
                "3. Shred the cooked pork and assemble tacos with your favorite toppings.");

// 36. Lamb Chops with Mint Sauce
        Meal lambChopsWithMint = new Meal("Lamb Chops with Mint Sauce", FoodType.CARNIVORE, List.of(lambChops, freshMint, garlic, oliveOil, lemon),
                List.of(500, 120, 20, 60, 30), "1. Season lamb chops with salt, pepper, and minced garlic.\n" +
                "2. Grill lamb chops to your desired doneness.\n" +
                "3. Mix fresh mint, minced garlic, olive oil, and lemon juice to create a mint sauce.\n" +
                "4. Serve lamb chops with the mint sauce drizzled on top.");

// 37. Chicken Parmesan
        Meal chickenParmesan = new Meal("Chicken Parmesan", FoodType.CARNIVORE, List.of(chickenBreast, marinaraSauce, mozzarellaCheese, parmesanCheese, breadCrumbs),
                List.of(400, 480, 240, 120, 240), "1. Preheat the oven to 375°F (190°C).\n" +
                "2. Bread chicken breasts with breadcrumbs.\n" +
                "3. Bake the breaded chicken in the oven until cooked through.\n" +
                "4. Top each chicken breast with marinara sauce and shredded mozzarella.\n" +
                "5. Bake until the cheese is melted and bubbly.\n" +
                "6. Garnish with grated Parmesan and fresh basil before serving.");

// 38. Bacon-Wrapped Shrimp Skewers
        Meal baconWrappedShrimp = new Meal("Bacon-Wrapped Shrimp Skewers", FoodType.CARNIVORE, List.of(shrimp, baconStrips, garlicPowder, paprika),
                List.of(500, 250, 20, 10), "1. Preheat the grill or oven to medium-high heat.\n" +
                "2. Season shrimp with garlic powder and paprika.\n" +
                "3. Wrap each shrimp with a strip of bacon and thread onto skewers.\n" +
                "4. Grill or bake until the bacon is crispy and the shrimp is cooked through.\n" +
                "5. Brush with olive oil before serving.");

// 39. Beef and Mushroom Stroganoff
        Meal beefStroganoff = new Meal("Beef and Mushroom Stroganoff", FoodType.CARNIVORE, List.of(sirloinSteak, mushrooms, onion, sourCream, dijonMustard),
                List.of(400, 250, 170, 240, 30), "1. In a pan, sauté thinly sliced beef until browned.\n" +
                "2. Remove beef from the pan and sauté sliced mushrooms and diced onions.\n" +
                "3. Deglaze the pan with sour cream and add Dijon mustard.\n" +
                "4. Return the cooked beef to the pan and simmer until heated through.\n" +
                "5. Serve over egg noodles or rice.");

// 40. Spicy Grilled Chicken Wings
        Meal spicyChickenWings = new Meal("Spicy Grilled Chicken Wings", FoodType.CARNIVORE, List.of(chickenWings, hotSauce, butter, garlicPowder, cayennePepper),
                List.of(1000, 120, 60, 20, 10), "1. Preheat the grill to medium-high heat.\n" +
                "2. Toss chicken wings in a mixture of melted butter, hot sauce, garlic powder, and cayenne pepper.\n" +
                "3. Grill the chicken wings until crispy and fully cooked.\n" +
                "4. Serve with your favorite dipping sauce.");

        Diet dietNormal = new Diet("Basic diet", List.of(
                spaghettiBolognese, chickenCaesarWrap, mushroomRisotto, beefVegetableStirFry, hawaiianChickenSkewers, tunaNicoiseSalad, chickenFajitas, sushiBowl, turkeyAvocadoWrap, chickenNoodleSoup),
                FoodType.NORMAL, "Basic diet with a perfect mix of meat and vegetables.", List.of(),"https://cdn.galleries.smcloud.net/t/photos/gf-Yz2K-uho6-f6NT_spaghetti-bolognese-przepis-na-wloskie-danie-dla-4-osob.jpg");
        Diet dietCarnivorous = new Diet("Carnivore", List.of(
                chickenNoodleSoup, steakWithGarlicButter, bbqRibs, grilledChickenBreast, beefStirFry, carnitasTacos, lambChopsWithMint, chickenParmesan, baconWrappedShrimp, beefStroganoff, spicyChickenWings),
                FoodType.CARNIVORE, "High in meat carnivorous diet!",   List.of(), "https://img.freepik.com/free-photo/juicy-steak-medium-rare-beef-with-spices-grilled-vegetables_24972-2328.jpg?size=626&ext=jpg&ga=GA1.1.1546980028.1703116800&semt=sph");
        Diet dietSemiCarni = new Diet("Semi Carnivore", List.of(
                mushroomRisotto, tacoSalad, bbqPulledPorkSandwich, greekGyroWrap, porkFriedRice, beefTacos, sushiBowl, bbqRibs, spicyChickenWings, beefStirFry),
                FoodType.NORMAL, "A good diet with a lot of proteins", List.of(), "https://www.twopeasandtheirpod.com/wp-content/uploads/2022/12/Beef-Tacos-55.jpg");
        Diet dietVeganAbsolutely = new Diet("Absolutely Vegan",List.of(
                sweetPotatoBlackBeanBowl, lentilSoup, chickpeaCurry),
                FoodType.VEGAN, "Try Vegan Diet, with no animal products.", List.of(), "https://plantbasedrdblog.com/wp-content/uploads/2023/03/sweet-potato-black-bean-bowl_feat.jpg");
        Diet dietVegetarianSea = new Diet("Sea Food Vegetarian Diet", List.of(
                salmonQuinoaBowl, shrimpBroccoliAlfredo, vegetarianMushroomRisotto, caesarSaladGrilledShrimp, teriyakiSalmonBowl, tunaNicoiseSalad, shrimpScampi, sushiBowl),
                FoodType.VEGETARIAN, "Normal Vegetarian Diet with a bit of sea food", List.of(), "https://img.taste.com.au/LihKd2Oa/taste/2016/11/chargrilled-prawn-caesar-salad-98269-1.jpeg");
        Diet dietVegetarianNoMeat = new Diet("Vegetarian Diet with Animal Products", List.of(
                vegetarianStirFry, capreseSalad, vegetarianMushroomRisotto, veggieOmelette, pestoPastaCherryTomatoes, mediterraneanQuinoaSalad, chickpeaCurry, eggplantParmesan, vegetableLasagna),
                FoodType.VEGETARIAN, "Vegetarian diet with absolutely no meat or fish", List.of(), "https://realfood.tesco.com/media/images/RFO-1400x919-Tomato-and-pesto-spaghetti-da6e99ed-0b77-4285-8122-124232a744b2-0-1400x919.jpg");

        ingredientRepository.saveAll(List.of(beefStrips, chickenBreast, chickenStrips, eggs, grilledChickenStrips, grilledShrimp, groundBeef,
                groundTurkey, gyroMeat, hardBoiledEggs, pork, pulledPork, salmonFillet, shrimp, tuna, turkeySlices, sirloinSteak,
                porkRibs, porkShoulder, baconStrips, lambChops, chickenWings, cheddarCheese, fetaCheese, mozzarellaCheese, parmesanCheese,
                ricottaCheese, tofu, butter, sourCream, avocado, basil, blackBeans, broccoli, carrots, celery, cherryTomatoes, chickpeas,
                coleslaw, corn, cucumber, eggplantSlices, freshBasil, garlic, ginger, greenBeans, kalamataOlives, kale, lemon, lentils,
                lettuce, lime, mixedGreens, mushrooms, onion, orange, parsley, pickles, pineappleChunks, potatoes, redBellPeppers, redOnion,
                romaineLettuce, rosemary, scallions, snowPeas, spinach, sweetPotatoes, tomatoes, zucchini, arborioRice, brownRice, cornTortillas,
                fettuccinePasta, flourTortillas, hamburgerBun, jasmineRice, lasagnaPasta, linguinePasta, pennePasta, pitaBread, quinoa,
                spaghettiPasta, sushiRice, tagliatellePasta, wholeWheatWrap, alfredoSauce, BBQSauce, caesarDressing, dijonMustard, hotSauce,
                marinaraSauce, pestoSauce, salsa, teriyakiSauce, tomatoSauce, tzatzikiSauce, balsamicGlaze, brownSugar, breadCrumbs, cayennePepper,
                chickenBroth, chiliPowder, coconutMilk, croutons, cumin, curryPowder, freshMint, garlicPowder, vegetableBroth, mixedHerbs, oliveOil,
                paprika, pineNuts, soySauce, tacoSeasoning, whiteWine));

        mealRepository.saveAll(List.of(spaghettiBolognese, vegetarianStirFry, salmonQuinoaBowl, capreseSalad, chickenCaesarWrap, shrimpBroccoliAlfredo, mushroomRisotto,
                vegetarianMushroomRisotto, tacoSalad, veggieOmelette, beefVegetableStirFry, caesarSaladGrilledShrimp, pestoPastaCherryTomatoes,
                hawaiianChickenSkewers, sweetPotatoBlackBeanBowl, lentilSoup, bbqPulledPorkSandwich, greekGyroWrap, teriyakiSalmonBowl,
                mediterraneanQuinoaSalad, chickpeaCurry, tunaNicoiseSalad, porkFriedRice, chickenFajitas, eggplantParmesan, beefTacos, shrimpScampi,
                sushiBowl, vegetableLasagna, turkeyAvocadoWrap, chickenNoodleSoup, steakWithGarlicButter, bbqRibs, grilledChickenBreast, beefStirFry,
                carnitasTacos, lambChopsWithMint, chickenParmesan, baconWrappedShrimp, beefStroganoff, spicyChickenWings));

        dietRepository.saveAll(List.of(dietNormal, dietCarnivorous, dietSemiCarni, dietVeganAbsolutely, dietVegetarianSea, dietVegetarianNoMeat));
*/

/*
        //CHEST
        Exercise BarDip = new Exercise("Bar Dip", Type.CALISTHENICS, Body.CHEST, 8, 0, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/09/Muscles-worked-by-bar-dip-exercise.jpg?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/02/Dips.gif?resize=600%2C600&ssl=1");

        Exercise BenchPress = new Exercise("Bench Press", Type.WEIGHTS, Body.CHEST, 4, 30, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2021/11/Bench-press-muscles-worked.jpg?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2021/09/bench-press.gif?resize=600%2C600&ssl=1");

        Exercise CableChestPress = new Exercise("Cable Chest Press", Type.WEIGHTS, Body.CHEST, 7, 5, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-by-cable-chest-press.png?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/cable-chest-press.gif?resize=600%2C600&ssl=1");

        Exercise DeclineBenchPress = new Exercise("Decline Bench Press",  Type.WEIGHTS, Body.CHEST, 4, 30, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-in-decline-bench-press-exercise.png?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/Decline-Bench-Press.gif?resize=600%2C600&ssl=1");

        Exercise DumbbellChestFly = new Exercise("Dumbb Chest Fly", Type.WEIGHTS, Body.CHEST, 4, 5, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2023/06/Muscles-worked-by-dumbbell-chest-flyes-2.png?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/Dumbbell-Chest-Fly.gif?resize=600%2C600&ssl=1");

        Exercise DumbbellChestPress = new Exercise("Dumbbell Chest Press",  Type.WEIGHTS, Body.CHEST, 5, 15, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-by-dumbbell-chest-press.png?resize=768%2C769&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/Dumbbell-Chest-Press.gif?resize=600%2C600&ssl=1");

        Exercise DumbbellPullover = new Exercise("Dumbbell Pull Over", Type.WEIGHTS, Body.CHEST, 5, 5, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-by-dumbbell-pullover.png?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/Dumbbell-Pullover.gif?resize=600%2C600&ssl=1");

        Exercise InclineBenchPress = new Exercise("Incline Bench Press",  Type.WEIGHTS, Body.CHEST, 5, 30, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-by-incline-bench-press.png?resize=768%2C769&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/Incline-Bench-Press.gif?resize=600%2C600&ssl=1");

        Exercise InclineDumbbellPress = new Exercise("Incline Dumbell Press",  Type.WEIGHTS, Body.CHEST, 5, 20, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2023/04/muscles-worked-by-dumbbell-incline-press-female.png?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/Dumbbell-Incline-Press.gif?resize=600%2C600&ssl=1");

        Exercise MachineChestFly = new Exercise("Machine Chest Fly",  Type.WEIGHTS, Body.CHEST, 8, 15, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2023/07/Muscles-worked-by-machine-chest-fly.png?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/machine-chest-fly.gif?resize=600%2C600&ssl=1");

        Exercise MachineChestPress = new Exercise("Machine Chest Press",  Type.WEIGHTS, Body.CHEST, 5, 20, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-by-machine-chest-press.png?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/machine-chest-press.gif?resize=600%2C600&ssl=1");

        Exercise PushUp = new Exercise("Push Up", Type.CALISTHENICS, Body.CHEST, 5, 0, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-by-push-ups.jpg?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/02/Push-up.gif?resize=600%2C600&ssl=1");

        Exercise BandExternalShoulderRotation = new Exercise("Band External Shoulder Rotation",  Type.CALISTHENICS, Body.SHOULDER, 10, 0, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/12/Muscles-worked-by-band-shoulder-external-rotation.jpg?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/12/Band-shoulder-external-rotation.gif?resize=600%2C600&ssl=1");

        Exercise BandInternalShoulderRotation = new Exercise("Band Internal Shoulder Rotation",  Type.CALISTHENICS, Body.SHOULDER, 10, 0, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/12/Muscles-worked-by-band-shoulder-external-rotation.jpg?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/12/Band-shoulder-internal-rotation.gif?resize=600%2C600&ssl=1");

        Exercise BandPullApart = new Exercise("Band Pull-Apart",  Type.CALISTHENICS, Body.SHOULDER, 10, 0, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-by-band-pull-aparts-1.png?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/04/Band-Pull-Apart.gif?resize=600%2C600&ssl=1");

        Exercise BarbellFrontRaise = new Exercise("Barbell Front Raise",  Type.WEIGHTS, Body.SHOULDER, 5, 5, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-by-barbell-front-raise.png?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/Barbell-Front-Raise.gif?resize=600%2C600&ssl=1");

        Exercise BarbellRearDeltRow = new Exercise("Barbell Rear Delt Row",  Type.WEIGHTS, Body.SHOULDER, 4, 20, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2021/01/Muscles-worked-in-rear-delt-row.jpg?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2021/01/Barbell-Rear-Delt-Row.gif?resize=600%2C600&ssl=1");

        Exercise BarbellUprightRow = new Exercise("Barbell Upright Row",  Type.WEIGHTS, Body.SHOULDER, 4, 5, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2023/07/Muscles-worked-by-barbell-upright-row.png?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/11/Barbell-upright-row.gif?resize=600%2C600&ssl=1");

        Exercise DumbbellHorizontalExternalShoulderRotation = new Exercise("Dumbbell Horizontal External Shoulder Rotation",  Type.WEIGHTS, Body.SHOULDER, 8, 0, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/12/Muscles-worked-by-band-shoulder-external-rotation.jpg?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/12/DB-standing-external-shoulder-rotation.gif?resize=600%2C600&ssl=1");

        Exercise DumbbellLateralRaise = new Exercise("Dumbbell Lateral Raise",  Type.WEIGHTS, Body.SHOULDER, 5, 5, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2023/05/Muscles-worked-by-dumbbell-lateral-raise-2.png?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/12/Dumbbell-Lateral-Raise.gif?resize=600%2C600&ssl=1");

        Exercise DumbbellShoulderPress = new Exercise("Dumbbell Shoulder Press",  Type.WEIGHTS, Body.SHOULDER, 5, 10, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-trained-by-dumbbell-shoulder-press-exercise.jpg?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/02/Dumbbell-shoulder-press.gif?resize=600%2C600&ssl=1");

        Exercise OverheadPress = new Exercise("Overhead Press",  Type.WEIGHTS, Body.SHOULDER, 5, 10, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2023/01/Muscles-worked-in-overhead-press-exercise.png?w=563&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/12/Overhead-press-exercise.gif?resize=600%2C600&ssl=1");

        Exercise BarbellCurl = new Exercise("Barbell Curl", Type.WEIGHTS, Body.BICEPS, 5, 10, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2023/05/Muscles-worked-in-the-barbell-curl-2.png?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/12/Barbell-biceps-curl.gif?resize=600%2C600&ssl=1");

        Exercise BarbellPreacherCurl = new Exercise("Barbell Preacher Curl", Type.WEIGHTS, Body.BICEPS, 5, 5, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2023/06/muscles-worked-in-preacher-curl-2.png?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/04/preacher-curl-barbell.gif?resize=600%2C600&ssl=1");

        Exercise CurlWithBar = new Exercise("Curl With Bar", Type.WEIGHTS, Body.BICEPS, 5, 10, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-by-cable-curl.png?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/cable-curl-with-handle.gif?resize=600%2C600&ssl=1");

        Exercise ConcentrationCurl = new Exercise("Concentration Curl", Type.WEIGHTS, Body.BICEPS, 5, 10, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-by-concentration-curl-exercise.jpg?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/Concentration-curl.gif?resize=600%2C600&ssl=1");

        Exercise HammerCurl = new Exercise("Hammer Curl", Type.WEIGHTS, Body.BICEPS, 5, 10, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2023/05/Muscles-worked-in-the-hammer-curl-2.png?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/02/Hammer-curl.gif?resize=600%2C600&ssl=1");

        Exercise SpiderCurl = new Exercise("Spider Curl", Type.WEIGHTS, Body.BICEPS, 4, 5, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2022/09/Muscles-worked-in-spider-curl-exercise-1024x1024-1.jpg?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2022/09/spider-curl-does-whatever-a-spider-curl-does-2.gif?resize=600%2C600&ssl=1");

        Exercise InclineDumbbellCurl = new Exercise("Incline Dumbbell Curl",Type.WEIGHTS,Body.BICEPS,5,5,4,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-by-Incline-Dumbbell-Curl.png?resize=768%2C768&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Incline-Dumbbell-Curl.gif?resize=600%2C600&ssl=1");

        Exercise BarbellStandingTricepsExtension = new Exercise("Barbell Standing Triceps Extension", Type.WEIGHTS, Body.TRICEPS, 5, 10, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2023/07/Muscles-worked-by-standing-tricep-extension.png?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/Barbell-Standing-Triceps-Extension.gif?resize=600%2C600&ssl=1");

        Exercise BenchDip = new Exercise("Bench Dip", Type.CALISTHENICS, Body.TRICEPS, 5, 0, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2021/11/Muscles-worked-in-bench-dips.jpg?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2022/12/C7251A7B-7A1B-47AE-A88C-7054692BCEF0.gif?resize=600%2C600&ssl=1");

        Exercise CloseGripPushUp = new Exercise("Close-Grip Push-Up", Type.CALISTHENICS, Body.TRICEPS, 5, 0, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2022/09/Muscles-worked-in-close-grip-push-up-exercise-1024x1024-1.jpg?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2022/09/close-grip-push-up.gif?resize=600%2C600&ssl=1");

        Exercise DumbbellLyingTricepsExtension = new Exercise("Dumbbell Lying Triceps Extension", Type.WEIGHTS, Body.TRICEPS, 5, 5, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2022/09/Muscles-worked-by-lying-triceps-extension-1024x1024-2.png?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2023/03/Lying-Dumbbell-Triceps-Extension-1.gif?resize=600%2C600&ssl=1");

        Exercise PushdownWithRope = new Exercise("Pushdown With Rope", Type.WEIGHTS, Body.TRICEPS, 5, 10, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2023/07/Muscles-worked-by-triceps-pushdown.png?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/triceps-pushdown-with-rope.gif?resize=600%2C600&ssl=1");

        Exercise BarbellLyingTricepsExtension = new Exercise("Do Barbell Lying Triceps Extension", Type.WEIGHTS, Body.TRICEPS,5,5,4,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2023/05/muscles-worked-barbell-lying-tricep-extension-2.png?resize=768%2C768&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/Barbell-Lying-Tricep-Extension.gif?resize=600%2C600&ssl=1");

        Exercise TricepsBodyweightExtension = new Exercise("Triceps Bodyweight Extension",Type.CALISTHENICS,Body.TRICEPS,5,0,4,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2023/02/muscle_map_triceps_bodyweight_extension.png?w=563&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2023/02/Bodyweight-triceps-extension.gif?resize=600%2C600&ssl=1");

        Exercise BarbellLunge = new Exercise("Barbell Lunge", Type.WEIGHTS, Body.LEGS, 5, 20, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-by-barbell-lunge.png?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/Barbell-Lunge.gif?resize=600%2C600&ssl=1");

        Exercise BulgarianSplitSquat = new Exercise("Bulgarian Split Squat", Type.WEIGHTS, Body.LEGS, 5, 5, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2023/04/muscles-worked-bulgarian-split-squat-2.png?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2023/02/Bulgarian-split-squat-barbell.gif?resize=600%2C600&ssl=1");

        Exercise BarbellSquat = new Exercise("Barbell Squat", Type.WEIGHTS, Body.LEGS, 5, 30, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/05/Squat-muscles-worked.png?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2021/11/squat.gif?resize=600%2C600&ssl=1");

        Exercise LegExtension = new Exercise("Leg Extension", Type.WEIGHTS, Body.LEGS, 5, 10, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2023/05/muscles-worked-in-leg-extension-2.png?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/leg-extension-seated.gif?resize=600%2C600&ssl=1");

        Exercise RomanianDeadlift = new Exercise("Romanian Deadlift", Type.WEIGHTS, Body.LEGS, 5, 10, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/09/Muscles-worked-by-romanian-deadlifts.jpg?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2022/01/Romanian-deadlift.gif?resize=600%2C600&ssl=1");

        Exercise BoxSquat = new Exercise("Box Squat", Type.WEIGHTS,Body.LEGS,5,20,4,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-by-box-squat.png?resize=768%2C768&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Box-Squat.gif?resize=600%2C600&ssl=1");

        Exercise Squat = new Exercise("Squat",Type.WEIGHTS,Body.LEGS,5,30,4,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/05/Squat-muscles-worked.png?resize=768%2C768&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2021/11/squat.gif?resize=600%2C600&ssl=1");

        Exercise BarbellRows = new Exercise("Barbell Rows", Type.WEIGHTS, Body.BACK, 5, 10, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2023/01/Barbell-row-muscles-worked.png?w=563&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2022/03/Barbell-Row.gif?resize=600%2C600&ssl=1");

        Exercise CableWideGripSeatedRow = new Exercise("Cable Wide Grip Seated Row",  Type.WEIGHTS, Body.BACK, 5, 10, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-by-seated-cable-row-with-wide-grip.png?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/cable-row-seated-wide-grip.gif?resize=600%2C600&ssl=1");

        Exercise CableCloseGripSeatedRow = new Exercise("Cable Close Grip Seated Row", Type.WEIGHTS,Body.BACK,5,10,4,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2023/03/Muscles-worked-by-seated-cable-row-with-close-grip.png?resize=768%2C768&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/cable-row-seated-narrow-grip.gif?resize=600%2C600&ssl=1");

        Exercise ChinUp = new Exercise("Chin-Up", Type.CALISTHENICS, Body.BACK, 3, 0, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-by-chin-ups.png?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/chin-up.gif?resize=600%2C600&ssl=1");

        Exercise Deadlift = new Exercise("Deadlift", Type.WEIGHTS, Body.BACK, 5, 30, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/04/Deadlift-muscles-worked.png?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/11/Deadlift.gif?resize=600%2C600&ssl=1");

        Exercise PullUps = new Exercise("Pull-Ups", Type.CALISTHENICS, Body.BACK, 2, 0, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-by-pull-ups.png?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/pull-up.gif?resize=600%2C600&ssl=1");

        Exercise GoodMorning = new Exercise("Good Morning",  Type.WEIGHTS, Body.BACK, 5, 10, 4, "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/09/Muscles-worked-in-the-good-morning-exercise.jpg?resize=768%2C768&ssl=1", "https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/02/Good-morning.gif?resize=600%2C600&ssl=1");

        Exercise DumbbellShrugs = new Exercise("Dumbbell Shrugs",Type.WEIGHTS,Body.BACK,5,5,4,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2023/07/Muscles-worked-by-dumbbell-shrug.png?resize=768%2C768&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/Dumbbell-Shrug.gif?resize=600%2C600&ssl=1");

        Exercise SumoDeadlift = new Exercise("Sumo Deadlift",Type.WEIGHTS,Body.BACK,6,30,4,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-by-sumo-deadlift.png?resize=768%2C768&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Sumo-deadlift.gif?resize=600%2C600&ssl=1");

        Exercise BandedSideKick = new Exercise("Banded Side Kick",Type.CALISTHENICS,Body.GLUTE,5,0,4,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-by-banded-side-kicks.png?resize=768%2C768&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/Banded-Side-Kick.gif?resize=600%2C600&ssl=1");

        Exercise CablePullThrough = new Exercise("Cable Pull-Through",Type.WEIGHTS,Body.GLUTE,5,10,4,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-by-cable-pull-through.jpg?resize=768%2C768&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/04/cable-pull-through.gif?resize=600%2C600&ssl=1");

        Exercise DumbbellRomanianDeadlift = new Exercise("Dumbbell Romanian Deadlift",Type.WEIGHTS,Body.GLUTE,5,10,4,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2022/09/Muscles-worked-by-dumbbell-romanian-deadlifts-1024x1024-1.jpg?resize=768%2C768&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2022/09/romanian-deadlift-with-dumbbells.gif?resize=600%2C600&ssl=1");

        Exercise FireHydrants = new Exercise("Fire Hydrants",Type.CALISTHENICS,Body.GLUTE,8,0,4,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2023/01/muscles-worked-by-fire-hydrants.png?w=563&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/06/Fire-Hydrants.gif?resize=510%2C510&ssl=1");

        Exercise FrogPumps = new Exercise("Frog Pumps",Type.CALISTHENICS,Body.GLUTE,5,0,4,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2023/01/muscles-worked-frog-pumps.jpg?resize=768%2C768&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2023/01/Frog-pump.gif?resize=600%2C600&ssl=1");

        Exercise HipThrust = new Exercise("Hip Thrust",Type.WEIGHTS,Body.GLUTE,4,20,4,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2023/03/Muscles-worked-in-barbell-hip-thrust.png?w=563&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/02/Hip-thrust.gif?resize=600%2C600&ssl=1");

        Exercise CableCrunch = new Exercise("Cable Crunch:",Type.WEIGHTS,Body.ABS,5,10,4,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-by-crunches.png?resize=768%2C768&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/cable-crunch.gif?resize=600%2C600&ssl=1");

        Exercise Crunches = new Exercise("Crunches",Type.CALISTHENICS,Body.ABS,8,0,4,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-by-crunches.jpg?resize=768%2C768&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2023/01/Crunch.gif?resize=600%2C600&ssl=1");

        Exercise HangingLegRaise = new Exercise("Hanging Leg Raise",Type.CALISTHENICS,Body.ABS,3,0,5,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-by-hanging-leg-raises.png?resize=768%2C768&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/hanging-leg-raise.gif?resize=600%2C600&ssl=1");

        Exercise KneelingAbWheelRollOut = new Exercise("Kneeling Ab Wheel Roll-Out",Type.CALISTHENICS,Body.ABS,4,0,3,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-by-kneeling-ab-wheel.jpg?resize=768%2C768&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/05/kneeling-ab-wheel.gif?resize=600%2C600&ssl=1");

        Exercise ObliqueCrunch = new Exercise("Oblique Crunch",Type.CALISTHENICS,Body.ABS,8,0,4,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/12/Muscles-worked-by-oblique-crunches.jpg?resize=768%2C768&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/12/Oblique-crunch.gif?resize=600%2C600&ssl=1");

        Exercise SitUp = new Exercise("Sit-Up",Type.CALISTHENICS,Body.ABS,6,0,5,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-by-sit-ups.jpg?resize=768%2C768&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/Sit-up.gif?resize=600%2C600&ssl=1");

        Exercise HeelDrop = new Exercise("Heel Drop",Type.CALISTHENICS,Body.CALVES,10,0,4,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/11/Muscles-worked-by-eccentric-heel-drop-exercise.jpg?resize=768%2C768&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/11/Eccentric-heel-raise.gif?resize=600%2C600&ssl=1");

        Exercise HeelRaise = new Exercise("Heel Raise",Type.CALISTHENICS,Body.CALVES,10,0,4,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/11/Muscles-worked-by-heel-raise.jpg?resize=768%2C768&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/11/Heel-raise.gif?resize=600%2C600&ssl=1");

        Exercise SeatedCalfRaise = new Exercise("Seated Calf Raise",Type.WEIGHTS,Body.CALVES,5,20,4,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-by-calf-raises.png?resize=768%2C768&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/calf-raise-seated.gif?resize=600%2C600&ssl=1");

        Exercise StandingCalfRaise = new Exercise("Standing Calf Raise",Type.WEIGHTS,Body.CALVES,5,30,4,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/10/Muscles-worked-by-calf-raises.png?resize=768%2C768&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2020/03/calf-raise-standing.gif?resize=600%2C600&ssl=1");

        Exercise BarbellWristCurl = new Exercise("Barbell Wrist Curl",Type.WEIGHTS,Body.FOREARM,8,10,3,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2021/01/Muscles-worked-by-barbell-wrist-curl.jpg?resize=768%2C768&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2021/01/Barbell-Wrist-Curl.gif?resize=600%2C600&ssl=1");

        Exercise Gripper = new Exercise("Gripper",Type.CALISTHENICS,Body.FOREARM,10,0,3,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2021/01/Muscles-worked-by-grippers.jpg?resize=768%2C768&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2021/01/Gripper-1.gif?resize=600%2C600&ssl=1");

        Exercise PlatePinch = new Exercise("Plate Pinch",Type.WEIGHTS,Body.FOREARM,5,5,3,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2021/01/Muscles-worked-by-the-plate-pinch.jpg?resize=768%2C768&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2021/01/Plate-Pinch.gif?resize=600%2C600&ssl=1");

        Exercise DumbbellWristExtension = new Exercise("Dumbbell Wrist Extension",Type.WEIGHTS,Body.FOREARM,5,5,4,"https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2021/01/Muscles-worked-by-dumbbell-wrist-extension-exercise.jpg?resize=768%2C768&ssl=1","https://i0.wp.com/www.strengthlog.com/wp-content/uploads/2021/01/Dumbbell-Wrist-Extension.gif?resize=600%2C600&ssl=1");

        List<Exercise> allExercises = List.of(
                BarDip, BenchPress, CableChestPress, DeclineBenchPress,
                DumbbellChestFly, DumbbellChestPress, DumbbellPullover,
                InclineBenchPress, InclineDumbbellPress, MachineChestFly,
                MachineChestPress, PushUp, BandExternalShoulderRotation,
                BandInternalShoulderRotation, BandPullApart, BarbellFrontRaise,
                BarbellRearDeltRow, BarbellUprightRow,
                DumbbellHorizontalExternalShoulderRotation, DumbbellLateralRaise,
                DumbbellShoulderPress, OverheadPress, BarbellCurl,
                BarbellPreacherCurl, CurlWithBar, ConcentrationCurl,
                HammerCurl, SpiderCurl, BarbellStandingTricepsExtension,
                BenchDip, CloseGripPushUp, DumbbellLyingTricepsExtension,
                PushdownWithRope, BarbellLunge, BulgarianSplitSquat,
                BarbellSquat, LegExtension, RomanianDeadlift, BoxSquat,
                Squat, BarbellRows, CableWideGripSeatedRow,
                CableCloseGripSeatedRow, ChinUp, Deadlift, PullUps, GoodMorning,InclineDumbbellCurl,
                TricepsBodyweightExtension,DumbbellShrugs,SumoDeadlift,BandedSideKick,CablePullThrough,DumbbellRomanianDeadlift,FireHydrants,
                FrogPumps,HipThrust,CableCrunch,HangingLegRaise,KneelingAbWheelRollOut,HeelDrop,HeelRaise,SeatedCalfRaise,
                StandingCalfRaise,BarbellWristCurl,Gripper,PlatePinch,DumbbellWristExtension
        );





        Training fullBodyBlast = new Training("Full Body Blast",
                List.of(Body.CHEST, Body.BACK, Body.LEGS, Body.SHOULDER, Body.TRICEPS, Body.BICEPS, Body.ABS),
                List.of(PullUps, Squat, Deadlift,PushdownWithRope, BarbellCurl, SitUp));

        // Training routine 2: Arm Fury
        Training armFury = new Training("Arm Fury",
                List.of(Body.BICEPS, Body.TRICEPS),
                List.of(HammerCurl, BarbellPreacherCurl, BenchDip, BarbellCurl));

        // Training routine 3: Full Body Pump
        Training fullBodyPump = new Training("Full Body Pump",
                List.of(Body.CHEST, Body.BACK, Body.LEGS, Body.SHOULDER, Body.TRICEPS, Body.BICEPS, Body.ABS),
                List.of(DumbbellChestFly, CableWideGripSeatedRow, RomanianDeadlift, DumbbellLateralRaise, BarbellLyingTricepsExtension, HammerCurl, ObliqueCrunch));


        Training cardioBurn = new Training("Cardio Burn",
                List.of(Body.LEGS, Body.TRICEPS, Body.ABS),
                List.of(Squat, Deadlift, PushdownWithRope, SitUp));

// Training routine 5: Chest Sculpt
        Training chestSculpt = new Training("Chest Sculpt",
                List.of(Body.CHEST),
                List.of(DumbbellChestFly, CableWideGripSeatedRow));

// Training routine 6: Core Blaster
        Training coreBlaster = new Training("Core Blaster",
                List.of(Body.ABS),
                List.of(SitUp, ObliqueCrunch));

// Training routine 7: Arm Toner
        Training armToner = new Training("Arm Toner",
                List.of(Body.BICEPS, Body.TRICEPS),
                List.of(HammerCurl, BarbellPreacherCurl, BarbellCurl));

// Training routine 8: Total Body Revitalize
        Training totalBodyRevitalize = new Training("Total Body Revitalize",
                List.of(Body.CHEST, Body.BACK, Body.LEGS, Body.SHOULDER, Body.TRICEPS, Body.BICEPS, Body.ABS),
                List.of(PullUps, Squat, Deadlift, PushdownWithRope, BarbellCurl, SitUp));

        // Training routine 9: Leg Power
        Training legPower = new Training("Leg Power",
                List.of(Body.LEGS),
                List.of(Squat, Deadlift));

// Training routine 10: Back Builder
        Training backBuilder = new Training("Back Builder",
                List.of(Body.BACK),
                List.of(CableWideGripSeatedRow, RomanianDeadlift));


// Training routine 12: Triceps Toner
        Training tricepsToner = new Training("Triceps Toner",
                List.of(Body.TRICEPS),
                List.of(PushdownWithRope, BarbellLyingTricepsExtension));

// Training routine 13: Bicep Burn
        Training bicepBurn = new Training("Bicep Burn",
                List.of(Body.BICEPS),
                List.of(HammerCurl, BarbellPreacherCurl, BarbellCurl));

// Training routine 14: Full Body Challenge
        Training fullBodyChallenge = new Training("Full Body Challenge",
                List.of(Body.CHEST, Body.BACK, Body.LEGS, Body.SHOULDER, Body.TRICEPS, Body.BICEPS, Body.ABS),
                List.of(PullUps, Squat, Deadlift, DumbbellChestFly, RomanianDeadlift, DumbbellLateralRaise, BarbellLyingTricepsExtension, HammerCurl, ObliqueCrunch));

// Training routine 15: High Intensity Circuit
        Training highIntensityCircuit = new Training("High Intensity Circuit",
                List.of(Body.CHEST, Body.BACK, Body.LEGS, Body.SHOULDER, Body.TRICEPS, Body.BICEPS, Body.ABS),
                List.of(PullUps, Squat, Deadlift, CableWideGripSeatedRow, DumbbellLateralRaise, BarbellCurl, SitUp, ObliqueCrunch));

        // Training routine 16: Core Crusher
        Training coreCrusher = new Training("Core Crusher",
                List.of(Body.ABS),
                List.of(SitUp, ObliqueCrunch, BarbellSquat));

// Training routine 17: Total Upper Body
        Training totalUpperBody = new Training("Total Upper Body",
                List.of(Body.CHEST, Body.BACK, Body.SHOULDER),
                List.of(DumbbellChestFly, CableWideGripSeatedRow, DumbbellLateralRaise));

// Training routine 18: Arm Annihilation
        Training armAnnihilation = new Training("Arm Annihilation",
                List.of(Body.BICEPS, Body.TRICEPS),
                List.of(BarbellPreacherCurl, BenchDip, BarbellCurl));

// Training routine 19: Strength Surge
        Training strengthSurge = new Training("Strength Surge",
                List.of(Body.LEGS, Body.BACK, Body.SHOULDER),
                List.of(Squat, Deadlift, CableWideGripSeatedRow, DumbbellLateralRaise));

// Training routine 20: Cardio Blast
        Training cardioBlast = new Training("Cardio Blast",
                List.of(Body.CHEST, Body.LEGS, Body.TRICEPS),
                List.of(PullUps, Squat, SitUp));


// Training routine 22: Upper Body Sculpt
        Training upperBodySculpt = new Training("Upper Body Sculpt",
                List.of(Body.CHEST, Body.BACK, Body.SHOULDER, Body.BICEPS, Body.TRICEPS),
                List.of(DumbbellChestFly, CableWideGripSeatedRow, DumbbellLateralRaise, BarbellPreacherCurl, BarbellLyingTricepsExtension));

// Training routine 23: Functional Fitness
        Training functionalFitness = new Training("Functional Fitness",
                List.of(Body.CHEST, Body.BACK, Body.LEGS, Body.SHOULDER, Body.BICEPS, Body.TRICEPS, Body.ABS),
                List.of(Squat, Deadlift, PullUps, DumbbellLateralRaise, BenchDip, ObliqueCrunch));

// Training routine 24: Power Pump
        Training powerPump = new Training("Power Pump",
                List.of(Body.CHEST, Body.SHOULDER, Body.BICEPS),
                List.of(DumbbellChestFly, DumbbellLateralRaise, BarbellCurl));

// Training routine 25: Full Body Burn
        Training fullBodyBurn = new Training("Full Body Burn",
                List.of(Body.CHEST, Body.BACK, Body.LEGS, Body.SHOULDER, Body.TRICEPS, Body.BICEPS, Body.ABS),
                List.of(Squat, RomanianDeadlift, PullUps, BarbellCurl, BarbellLyingTricepsExtension, SitUp));

// Training routine 26: Arm Assault
        Training armAssault = new Training("Arm Assault",
                List.of(Body.BICEPS, Body.TRICEPS),
                List.of(HammerCurl, BenchDip, BarbellLyingTricepsExtension));

// Training routine 27: Core Strength Builder
        Training coreStrengthBuilder = new Training("Core Strength Builder",
                List.of(Body.ABS),
                List.of(SitUp, ObliqueCrunch, Crunches));

// Training routine 28: Total Body Toning
        Training totalBodyToning = new Training("Total Body Toning",
                List.of(Body.CHEST, Body.BACK, Body.LEGS, Body.SHOULDER, Body.BICEPS, Body.TRICEPS, Body.ABS),
                List.of(DumbbellChestFly, CableWideGripSeatedRow, Squat, BarbellPreacherCurl, ObliqueCrunch, BenchDip));



// Training routine 29: Leg Day Burn
        Training legDayBurn = new Training("Leg Day Burn",
                List.of(Body.LEGS),
                List.of(Squat, RomanianDeadlift));



// Training routine 31: Push-Pull Intensity
        Training pushPullIntensity = new Training("Push-Pull Intensity",
                List.of(Body.CHEST, Body.BACK, Body.TRICEPS, Body.BICEPS),
                List.of(Deadlift, PushdownWithRope, BenchDip, BarbellCurl));

// Training routine 32: Full Body Revitalize
        Training fullBodyRevitalize = new Training("Full Body Revitalize",
                List.of(Body.CHEST, Body.BACK, Body.LEGS, Body.SHOULDER, Body.TRICEPS, Body.BICEPS, Body.ABS),
                List.of(DumbbellChestFly, CableWideGripSeatedRow, Squat, DumbbellLateralRaise, BarbellLyingTricepsExtension, BarbellCurl, ObliqueCrunch));

// Training routine 33: Arm Definition
        Training armDefinition = new Training("Arm Definition",
                List.of(Body.BICEPS, Body.TRICEPS),
                List.of(HammerCurl, BarbellPreacherCurl, PushdownWithRope));

// Training routine 34: Lower Body Strength
        Training lowerBodyStrength = new Training("Lower Body Strength",
                List.of(Body.LEGS),
                List.of(Squat, Deadlift, RomanianDeadlift));

// Training routine 36: Upper Body Power
        Training upperBodyPower = new Training("Upper Body Power",
                List.of(Body.CHEST, Body.BACK, Body.SHOULDER, Body.TRICEPS, Body.BICEPS),
                List.of(Deadlift, PullUps, BarbellLyingTricepsExtension));

// Training routine 37: Leg Pump
        Training legPump = new Training("Leg Pump",
                List.of(Body.LEGS),
                List.of(Squat, RomanianDeadlift, DumbbellLateralRaise));

// Training routine 38: Cardio Conditioning
        Training cardioConditioning = new Training("Cardio Conditioning",
                List.of(Body.CHEST, Body.LEGS, Body.SHOULDER),
                List.of(Squat, Deadlift, DumbbellLateralRaise, SitUp));

// Training routine 39: Push-Pull Sculpt
        Training pushPullSculpt = new Training("Push-Pull Sculpt",
                List.of(Body.CHEST, Body.BACK, Body.TRICEPS, Body.BICEPS),
                List.of(PushdownWithRope, BarbellPreacherCurl, CableWideGripSeatedRow, HammerCurl));

// Training routine 40: Full Body Burnout
        Training fullBodyBurnout = new Training("Full Body Burnout",
                List.of(Body.CHEST, Body.BACK, Body.LEGS, Body.SHOULDER, Body.TRICEPS, Body.BICEPS, Body.ABS),
                List.of(DumbbellChestFly, Deadlift, BenchDip, DumbbellLateralRaise, BarbellCurl, ObliqueCrunch, Crunches));

        Training dynamicBodyCircuit = new Training("Dynamic Body Circuit",
                List.of(Body.CHEST, Body.BACK, Body.LEGS, Body.SHOULDER, Body.TRICEPS, Body.BICEPS, Body.ABS),
                List.of(Squat, Deadlift, PushdownWithRope, DumbbellLateralRaise, BarbellCurl, SitUp ));

// Training routine 42: Total Body Pump
        Training totalBodyPump = new Training("Total Body Pump",
                List.of(Body.CHEST, Body.BACK, Body.LEGS, Body.SHOULDER, Body.TRICEPS, Body.BICEPS, Body.ABS),
                List.of(DumbbellChestFly, CableWideGripSeatedRow, RomanianDeadlift, DumbbellLateralRaise, BarbellLyingTricepsExtension, HammerCurl, ObliqueCrunch));

// Training routine 43: Strength Fusion
        Training strengthFusion = new Training("Strength Fusion",
                List.of(Body.CHEST, Body.BACK, Body.LEGS, Body.SHOULDER, Body.TRICEPS, Body.BICEPS, Body.ABS),
                List.of(Deadlift, BenchDip, HammerCurl, BarbellCurl, PushdownWithRope, SitUp ));

// Training routine 44: Ultimate Body Blitz
        Training ultimateBodyBlitz = new Training("Ultimate Body Blitz",
                List.of(Body.CHEST, Body.BACK, Body.LEGS, Body.SHOULDER, Body.TRICEPS, Body.BICEPS, Body.ABS),
                List.of(DumbbellChestFly, Squat, PullUps, CableWideGripSeatedRow, BarbellLyingTricepsExtension, BarbellPreacherCurl, ObliqueCrunch));

        Training completeBodyChallenge = new Training("Complete Body Challenge",
                List.of(
                        Body.CHEST, Body.BACK, Body.LEGS, Body.SHOULDER, Body.TRICEPS, Body.BICEPS, Body.ABS),
                List.of(
                        BarDip, BenchPress, CableChestPress, DeclineBenchPress,
                        DumbbellChestFly, DumbbellChestPress, DumbbellPullover,
                        InclineBenchPress, InclineDumbbellPress, MachineChestFly,
                        MachineChestPress, PushUp, BandExternalShoulderRotation,
                        BandInternalShoulderRotation, BandPullApart, BarbellFrontRaise,
                        BarbellRearDeltRow, BarbellUprightRow,
                        DumbbellHorizontalExternalShoulderRotation, DumbbellLateralRaise,
                        DumbbellShoulderPress, OverheadPress, BarbellCurl,
                        BarbellPreacherCurl, CurlWithBar, ConcentrationCurl,
                        HammerCurl, SpiderCurl, BarbellStandingTricepsExtension,
                        BenchDip, CloseGripPushUp, DumbbellLyingTricepsExtension,
                        PushdownWithRope, BarbellLunge, BulgarianSplitSquat,
                        BarbellSquat, LegExtension, RomanianDeadlift, BoxSquat,
                        Squat, BarbellRows, CableWideGripSeatedRow,
                        CableCloseGripSeatedRow, ChinUp, Deadlift, PullUps, GoodMorning,
                        InclineDumbbellCurl, TricepsBodyweightExtension, DumbbellShrugs,
                        SumoDeadlift, BandedSideKick, CablePullThrough, DumbbellRomanianDeadlift,
                        FireHydrants, FrogPumps, HipThrust, CableCrunch, HangingLegRaise,
                        KneelingAbWheelRollOut, HeelDrop, HeelRaise, SeatedCalfRaise,
                        StandingCalfRaise, BarbellWristCurl, Gripper, PlatePinch, DumbbellWristExtension));

        List<Training> trainingList = List.of(
                fullBodyBlast,
                armFury,
                fullBodyPump,
                cardioBurn,
                chestSculpt,
                coreBlaster,
                armToner,
                totalBodyRevitalize,
                legPower,
                backBuilder,
                tricepsToner,
                bicepBurn,
                fullBodyChallenge,
                highIntensityCircuit,
                coreCrusher,
                totalUpperBody,
                armAnnihilation,
                strengthSurge,
                cardioBlast,
                upperBodySculpt,
                functionalFitness,
                powerPump,
                fullBodyBurn,
                armAssault,
                coreStrengthBuilder,
                totalBodyToning,
                legDayBurn,
                pushPullIntensity,
                fullBodyRevitalize,
                armDefinition,
                lowerBodyStrength,
                upperBodyPower,
                legPump,
                cardioConditioning,
                pushPullSculpt,
                fullBodyBurnout,
                dynamicBodyCircuit,totalBodyPump,strengthFusion,ultimateBodyBlitz,
                completeBodyChallenge
        );


        //exerciseRepository.saveAll(allExercises);
        //trainingRepository.saveAll(trainingList);


*/
    }
}

