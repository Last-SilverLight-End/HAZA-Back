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
    private int board_id;
    @NonNull
    private String title;
    @NonNull
    private String content;
    @NonNull
    private int hit;
    @NonNull
    private String created_date;
    @NonNull
    private String modified_date;
    @NonNull
    private int user_id;
    @NonNull
    private String user_name;
    @NonNull
    private String user_email;

    private String main_Category_Id;
    private String mid_Category_Id;


}
