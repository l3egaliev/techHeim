package kg.rakhim.classes.thechheim.entities.blog_elements;

import jakarta.persistence.*;
import kg.rakhim.classes.thechheim.entities.BlogEntity;
import lombok.Getter;
import lombok.Setter;

@Table(name = "blog_comments")
@Entity
@Getter
@Setter
public class BlogComments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer id;
    @Column(name = "comment")
    private String comment;
    @ManyToOne
    @JoinColumn(name = "comment_id", referencedColumnName = "comment_id")
    private BlogEntity blog;
}
