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
    private int main_category_id;
    @NonNull
    private int mid_category_id;
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String content;
    @NonNull
    private String created_date;
    @NonNull
    private String modified_date;
}
