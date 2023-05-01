package HAZAGroup.HAZACommunity.rest.board.model;


import lombok.*;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class CommentVo {
    @NonNull
    private int comment_id;
    @NonNull
    private String name;
    @NonNull
    private String content;
    @NonNull
    private String created_date;
    @NonNull
    private String modified_date;
}
