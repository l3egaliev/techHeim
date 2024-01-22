package kg.rakhim.classes.thechheim.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kg.rakhim.classes.thechheim.entities.blog_elements.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JoinColumnOrFormula;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="blog")
@Getter
@Setter
@NoArgsConstructor
public class BlogEntity {
    @Id
    @Column(name = "blog_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    @NonNull
    private String title;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BlogParagraph> paragraphs = new ArrayList<>();

    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BlogCategory> categories = new ArrayList<>();

    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BlogComment> comments = new ArrayList<>();

    @Column(name = "likes")
    private Integer likes;

    @JsonIgnore
    @ManyToMany(mappedBy = "likedBlogs")
    private List<User> likedByUser = new ArrayList<>();

    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BlogTag> tags = new ArrayList<>();

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date created_at;
}
