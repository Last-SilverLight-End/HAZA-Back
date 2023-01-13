package HAZAGroup.HAZACommunity.rest.board.vo;


import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardVo {
    @NonNull
    private String title;
    @NonNull
    private String content;
    private int hit;
    @NonNull
    private String user_name;
    @NonNull
    private String user_email;
    private String mainCategory;
    private String midCategory;

}
