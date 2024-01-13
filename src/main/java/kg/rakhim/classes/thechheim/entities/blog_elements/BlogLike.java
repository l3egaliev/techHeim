package kg.rakhim.classes.thechheim.entities.blog_elements;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kg.rakhim.classes.thechheim.entities.BlogEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "blog_like")
@Getter
@Setter
@NoArgsConstructor
public class BlogLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Integer like_id;
    @Column(name = "count")
    private Integer like;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "blog_id")
    public BlogEntity blog;
    public BlogLike(Integer like){
        this.like = like;
    }
}
