package kg.rakhim.classes.thechheim.entities.blog_elements;

import jakarta.persistence.*;
import kg.rakhim.classes.thechheim.entities.BlogEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "blog_tags")
@Getter
@Setter
public class BlogTags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Integer id;
    @Column(name = "tag")
    private String tag;
    @ManyToOne
    @JoinColumn(name = "tag_id", referencedColumnName = "tag_id")
    private BlogEntity blog;
}
