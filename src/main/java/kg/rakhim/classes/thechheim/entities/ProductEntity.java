package kg.rakhim.classes.thechheim.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "model")
    @NotNull(message = "Model couldn't be empty")
    private String model;

    @Column(name = "name")
    @NotNull(message = "Product name couldn't be empty")
    private String name;

    @Column(name = "year")
    @NotNull(message = "Product year couldn't be empty")
    private Integer year;

    @Column(name = "description")
    private String description;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private Double price;

    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne
    private ProductCategory category;
}
