package HAZAGroup.HAZACommunity.rest.board.model;


import lombok.*;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class CommentVo {
    @NonNull
    private int id;
    @NonNull
    private int mainCategoryId;
    @NonNull
    private int midCategoryId;
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String content;
    @NonNull
    private String createdDate;
    @NonNull
    private String modifiedDate;
}