package com.example.application.model;

//import com.example.application.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "Nazwa restauracji nie może być pusta")
    private String name;
    private String timeOfDeliverence;
    private String priceOfDeliverence;
    private String minimumPrice;
    private Boolean status;
    private String imageUrl;
}
