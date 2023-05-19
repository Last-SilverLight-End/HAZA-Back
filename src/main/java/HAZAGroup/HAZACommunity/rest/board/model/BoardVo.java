package HAZAGroup.HAZACommunity.rest.board.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardVo {

    private int id;

    private String title;

    private String content;

    private int hit;

    private String createdDate;

    private String modifiedDate;

    private int userId;

    private String userName;
    private String userEmail;

    private String mainCategoryId;
    private String midCategoryId;
<<<<<<< HEAD
}
