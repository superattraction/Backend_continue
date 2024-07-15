package edu.pnu.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.*;

import java.io.IOException;
import java.util.List;


@Entity
@Table(name="keyword")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Senti_keyword {

    @Id
    @Column(name="course_id")
    private int courseId;

    private String Course_name;
    private String edu_institute;
    private int result;

    @JsonIgnore
    @Column(name = "top_10_words")
    private String keyword10Json;

    @Transient
    private List<String[]> keyword10;

    @PostLoad
    private void loadKeyword10() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.keyword10 = objectMapper.readValue(this.keyword10Json, new TypeReference<List<String[]>>() {});
    }
    @PrePersist
    @PreUpdate
    private void saveKeyword10() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.keyword10Json = objectMapper.writeValueAsString(this.keyword10);
    }

}
