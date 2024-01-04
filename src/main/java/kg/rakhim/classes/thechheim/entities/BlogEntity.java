package kg.rakhim.classes.thechheim.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.Timespan;
import jdk.jfr.Timestamp;
import kg.rakhim.classes.thechheim.entities.blog_elements.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="blogs")
@Getter
@Setter
@NoArgsConstructor
public class BlogEntity {
    @Id
    @Column(name = "blog_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    @NotNull
    private String title;

    @OneToMany(mappedBy = "blog")
    private List<BlogParagraphs> description;

    @OneToMany(mappedBy = "blog")
    private List<BlogCategories> categories;

    @OneToMany(mappedBy = "blog")
    private List<BlogComments> comments;

    @OneToMany(mappedBy = "blog")
    private List<BlogLikes> likes;

    @OneToMany(mappedBy = "blog")
    private List<BlogTags> tags;

    @Column(name = "created_at")
    @Timestamp
    private Date created_at;
}
