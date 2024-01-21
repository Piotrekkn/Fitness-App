package com.example.elgrande.model.diet;

import com.example.elgrande.model.enums.enums_diet.Allergy;
import com.example.elgrande.model.enums.enums_diet.DietType;
import com.example.elgrande.model.enums.enums_diet.FoodType;
import com.example.elgrande.model.user.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dietName;
    private String imageUrl;
    @ManyToMany
    @JoinTable(name = "diets", joinColumns = @JoinColumn(name="diet_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id"))
    private List<Meal> meals;
    private List<Allergy> allergies;
    private FoodType foodType;
    private String dietDescription;
    private int dietCaloriesPerDay;
    private int favNumber;

    @OneToMany
    @JsonIgnore
    private List<UserEntity> users;
    public Diet(String dietName, List<Meal> mealsArray, FoodType foodType, String dietDescription, List<Allergy> allergies, String imageUrl) {
        this.dietName = dietName;
        this.meals = mealsArray;
        this.foodType = foodType;
        this.dietDescription = dietDescription;
        this.allergies = allergies;
        this.dietCaloriesPerDay = calculateDailyCalories();
        this.imageUrl = imageUrl;
    }


    private int calculateDailyCalories() {
        double sum = 0;
        for(Meal meal : meals) {
            sum += meal.getMealCalories();
        }
        return (int) sum/7;
    }

    public void setUser(List<UserEntity> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Diet{" +
                "dietName='" + dietName + '\'' +
                ", mealsArray=" + meals +
                ", foodType=" + foodType +
                ", dietCalories=" + dietCaloriesPerDay +
                '}';
    }

    //Getters
    public String getDietName() {
        return dietName;
    }

    public List<Meal> getMealsArray() {
        return meals;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public int getDailyCalories() {
        return dietCaloriesPerDay;
    }

    public List<Allergy> getAllergies() {
        return allergies;
    }

    public int getFavNumber() {
        return favNumber;
    }

    //Setters
    public void setDietName(String dietName) {
        this.dietName = dietName;
    }

    public void setMealsArray(List<Meal> mealsArray) {
        this.meals = mealsArray;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }
}