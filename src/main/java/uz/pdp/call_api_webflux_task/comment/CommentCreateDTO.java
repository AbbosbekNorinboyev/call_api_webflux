package uz.pdp.call_api_webflux_task.comment;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CommentCreateDTO {
    private String name;
    private String body;
    private Integer postId;
}
