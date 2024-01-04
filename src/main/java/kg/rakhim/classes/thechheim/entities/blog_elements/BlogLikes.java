package kg.rakhim.classes.thechheim.entities.blog_elements;

import jakarta.persistence.*;
import kg.rakhim.classes.thechheim.entities.BlogEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "blog_likes")
@Getter
@Setter
public class BlogLikes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Integer like_id;
    @Column(name = "count")
    private Long like;
    @ManyToOne
    @JoinColumn(name = "like_id", referencedColumnName = "like_id")
    private BlogEntity blog;
}
