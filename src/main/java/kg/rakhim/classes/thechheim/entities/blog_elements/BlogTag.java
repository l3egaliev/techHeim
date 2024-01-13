package kg.rakhim.classes.thechheim.entities.blog_elements;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kg.rakhim.classes.thechheim.entities.BlogEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "blog_tag")
@Getter
@Setter
@NoArgsConstructor
public class BlogTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Integer id;
    @Column(name = "tag")
    private String tag;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "blog_id")
    public BlogEntity blog;
    public BlogTag(String tag){
        this.tag = tag;
    }
}
