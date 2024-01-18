package kg.rakhim.classes.thechheim.services;

import kg.rakhim.classes.thechheim.dto.BlogDTO;
import kg.rakhim.classes.thechheim.entities.BlogEntity;
import kg.rakhim.classes.thechheim.entities.blog_elements.*;
import kg.rakhim.classes.thechheim.repository.BlogRepository;
import kg.rakhim.classes.thechheim.utils.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BlogService {
    private final BlogRepository repository;

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

//    @Transactional
//    public void save(BlogDTO blog){
//        BlogEntity entity = (BlogEntity) Converter.convert(blog, BlogEntity.class);
//        repository.save(entity);
//    }
}
