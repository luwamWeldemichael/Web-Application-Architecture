package assignment1.postv2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostV2 {
    long id;
    String title;
    String content;
    String author;
}
