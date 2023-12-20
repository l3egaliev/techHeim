package kg.rakhim.classes.thechheim.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "product_category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductCategory {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", unique = true)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<ProductEntity> product;
}
