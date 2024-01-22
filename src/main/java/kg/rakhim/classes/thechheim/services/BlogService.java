package kg.rakhim.classes.thechheim.services;

import kg.rakhim.classes.thechheim.dto.BlogDTO;
import kg.rakhim.classes.thechheim.entities.BlogEntity;
import kg.rakhim.classes.thechheim.entities.User;
import kg.rakhim.classes.thechheim.repository.BlogRepository;
import kg.rakhim.classes.thechheim.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BlogService {
    private final BlogRepository repository;
    private final UserRepository userRepository;

    public List<BlogDTO> getAll(){
        List<BlogEntity> entities = repository.findAll();
        List<BlogDTO> result = new ArrayList<>();
        for(BlogEntity entity:entities){
            BlogDTO dto = BlogDTO.builder()
                    .id(entity.getId())
                    .title(entity.getTitle())
                    .categories(entity.getCategories())
                    .comments(entity.getComments())
                    .paragraphs(entity.getParagraphs())
                    .likes(entity.getLikes())
                    .tags(entity.getTags())
                    .build();
            result.add(dto);
        }
        return result;
    }

    public BlogDTO getOne(int id) {
        Optional<BlogEntity> entity = repository.findById(id);
        BlogDTO dto;
        if (entity.isEmpty()) {
            return new BlogDTO();
        } else {
            dto = BlogDTO.builder()
                    .id(entity.get().getId())
                    .title(entity.get().getTitle())
                    .categories(entity.get().getCategories())
                    .comments(entity.get().getComments())
                    .paragraphs(entity.get().getParagraphs())
                    .likes(entity.get().getLikes())
                    .tags(entity.get().getTags())
                    .build();
        }
        return dto;
    }

    @Transactional
    @PreAuthorize(value = "ROLE_USER")
    public int like(int blog_id, int user_id) {
        BlogEntity blog = repository.getReferenceById(blog_id);
        User user = userRepository.getReferenceById(user_id);
        Integer updatedLike;
            if (likedYet(user.getId(), blog.getId())){
                return blog.getLikes();
            }
            else {
                Integer like = blog.getLikes();
                if (blog.getLikes() == null) {
                    like = 0;
                }
                blog.setLikes(like + 1);
                blog.getLikedByUser().add(user);
                user.getLikedBlogs().add(blog);
                repository.save(blog);
                userRepository.save(user);
                updatedLike = blog.getLikes();
            }
            return updatedLike;
    }

    public boolean likedYet(int user_id, int blog_id){
        boolean yes = false;
        BlogEntity blog = repository.getReferenceById(blog_id);
        User user = userRepository.getReferenceById(user_id);
        for(User u : blog.getLikedByUser()){
            if (u.getId() == user_id) {
                yes = true;
                break;
            }
        }
        for(BlogEntity b : user.getLikedBlogs()){
            if (b.getId() == blog_id) {
                yes = true;
                break;
            }
        }
        return yes;
    }

//    @Transactional
//    public void save(BlogDTO blog){
//        BlogEntity entity = (BlogEntity) Converter.convert(blog, BlogEntity.class);
//        repository.save(entity);
//    }
}
