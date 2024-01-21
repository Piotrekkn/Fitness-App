package com.example.elgrande.model.user;

import com.example.elgrande.model.diet.Diet;
import com.example.elgrande.model.enums.Level;
import com.example.elgrande.model.enums.enums_diet.Allergy;
import com.example.elgrande.model.enums.enums_diet.DietType;
import com.example.elgrande.model.enums.enums_diet.FoodType;
import com.example.elgrande.model.enums.enums_training.Body;
import com.example.elgrande.model.enums.enums_training.Type;
import com.example.elgrande.model.role.Role;
import com.example.elgrande.model.training.Training;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Data
@Entity(name = "\'User\'")
@JsonIgnoreProperties({ "diets" })
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @CreationTimestamp
    private Date creationDate;
    @Column(name = "name")
    private String username;
    private String password;
    private String email;
    private String gender;
    private int age;
    private int weight;
    private int height;
    private int timesToMultiply;
    //private int timesToUpgradeTraining;
    @Enumerated(EnumType.STRING)
    private Level level;
    @Enumerated(EnumType.STRING)
    private DietType dietType;
    @Enumerated(EnumType.STRING)
    private FoodType foodType;
    private LocalDate dateOfTrainingAssosiation;
    private int amountOfTrainingsDone;
    @Enumerated(EnumType.STRING)
    private List<Allergy> allergies;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name= "users_roles", joinColumns = @JoinColumn(name = "users_user_id"), inverseJoinColumns = @JoinColumn(name = "roles_role_id"))
    private Set<Role> roles = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "user_training",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name = "trening_id"))
    private List<Training> trainings;

    @ManyToOne
    @JoinColumn(name = "diet_id")
    private Diet diet;

    public UserEntity(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
//    public UserEntity(String gender, int age, int weight, int height, Level level, DietType dietType, FoodType foodType, List<Allergy> allergies) {
//        this.gender = gender;
//        this.age = age;
//        this.weight = weight;
//        this.height = height;
//        this.level = level;
//        this.dietType = dietType;
//        this.foodType = foodType;
//        this.allergies = allergies;
//    }

//    public void setDiet(Diet diet, List<Diet>diets) {
//        if(diets.contains(diet)) {
//            diets.remove(diets.indexOf(diet));
//        }
//        diets.add(0, diet);
//    }


    public Diet getDiet() {
        return diet;
    }

    public double getBMI() {
        return weight / (Math.pow((double)height / 100, 2));
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", name='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", level=" + level +
                ", dietType=" + dietType +
                ", foodType=" + foodType +
                ", amountOfTrainingsDone=" + amountOfTrainingsDone +
                ", allergies=" + allergies +
                ", trainings=" + trainings +
                '}';
    }
}
