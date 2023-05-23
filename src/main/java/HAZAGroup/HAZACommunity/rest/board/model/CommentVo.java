package HAZAGroup.HAZACommunity.rest.board.model;


import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class CommentVo {

    private int id;

    private int mainCategoryId;

    private int midCategoryId;

    private int userId;

    private String userName;

    private String userEmail;

    private int boardId;

    private String content;

    private String createdDate;

    private String modifiedDate;
}