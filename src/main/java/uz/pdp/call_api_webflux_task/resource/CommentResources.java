package uz.pdp.call_api_webflux_task.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import uz.pdp.call_api_webflux_task.comment.CommentCreateDTO;
import uz.pdp.call_api_webflux_task.comment.CommentDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentResources {
    private final WebClient webClient;
    @Value("${comments.url.postComments}")
    private String postCommentsURL;
    @Value("${comments.url.saveComments}")
    private String saveCommentsURL;

    public List<CommentDTO> getAllComments(@NonNull Integer postId) {
        return webClient.get()
                .uri(postCommentsURL, postId)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<CommentDTO>>() {
                }).block();
    }

    public void saveAllComments(List<CommentCreateDTO> commentCreateDTOList) {
        webClient.post()
                .uri(postCommentsURL)
                .body(BodyInserters.fromValue(commentCreateDTOList))
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}
