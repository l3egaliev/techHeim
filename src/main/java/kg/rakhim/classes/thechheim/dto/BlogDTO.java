package kg.rakhim.classes.thechheim.dto;

import jakarta.persistence.OneToMany;
import kg.rakhim.classes.thechheim.entities.blog_elements.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogDTO {
    private Integer id;
    private String title;
    private List<BlogParagraph> paragraphs = new ArrayList<>();
    private List<BlogCategory> categories = new ArrayList<>();
    private List<BlogComment> comments = new ArrayList<>();
    private List<BlogLike> likes = new ArrayList<>();
    private List<BlogTag> tags = new ArrayList<>();
}
