package kg.rakhim.classes.thechheim.entities.blog_elements;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kg.rakhim.classes.thechheim.entities.BlogEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "blog_paragraph")
@Getter
@Setter
@NoArgsConstructor
public class BlogParagraph {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paragraph_id")
    private Integer paragraph_id;
    @Column(name = "paragraph")
    private String paragraph;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "blog_id")
    public BlogEntity blog;
    public BlogParagraph(String paragraph){
        this.paragraph = paragraph;
    }
}
