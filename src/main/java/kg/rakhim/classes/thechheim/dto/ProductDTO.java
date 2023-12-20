package kg.rakhim.classes.thechheim.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String model;

    private String name;

    private Integer year;

    private String description;

    private String color;

    private Double price;

    private String category;
}
