package kg.rakhim.classes.thechheim.entities.blog_elements;

import jakarta.persistence.*;
import kg.rakhim.classes.thechheim.entities.BlogEntity;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "blog_categories")
@Getter
@Setter
public class BlogCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private BlogEntity blog;
}
