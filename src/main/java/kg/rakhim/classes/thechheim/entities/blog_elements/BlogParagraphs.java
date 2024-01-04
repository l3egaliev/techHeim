package kg.rakhim.classes.thechheim.entities.blog_elements;

import jakarta.persistence.*;
import kg.rakhim.classes.thechheim.entities.BlogEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "blog_paragraphs")
@Getter
@Setter
public class BlogParagraphs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paragraph_id")
    private Integer paragraph_id;
    @Column(name = "paragraph")
    private String paragraph;
    @ManyToOne
    @JoinColumn(name = "paragraph_id", referencedColumnName = "paragraph_id")
    private BlogEntity blog;
}
