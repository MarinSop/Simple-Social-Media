package com.marinsop.sc.dtos;

import com.marinsop.sc.entities.Post;
import com.marinsop.sc.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {

    private String content;
    private int userId;
    private int postId;

}
