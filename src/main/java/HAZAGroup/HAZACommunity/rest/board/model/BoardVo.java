package HAZAGroup.HAZACommunity.rest.board.model;


import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardVo {
    @NonNull
    private int id;
    @NonNull
    private String title;
    @NonNull
    private String content;
    @NonNull
    private int hit;
    @NonNull
    private String createdDate;
    @NonNull
    private String modifiedDate;
    @NonNull
    private int userId;
    @NonNull
    private String userName;
    @NonNull
    private String userEmail;

    private String mainCategoryId;
    private String midCategoryId;
}