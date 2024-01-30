package HAZAGroup.HAZACommunity.rest.board.model;


import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardVo {
    private int number;
    private String id;
    private String title;
    private String content;
    private int hit;
    private String createdDate;
    private String changedDate;
    private int userId;
    private String userName;
    private String userEmail;
    private String topCateId;
    private int topCateNo;
    private String midCateId;
    private int midCateNo;
    private String botCateId;
    private int botCateNo;

}

