package HAZAGroup.HAZACommunity.board.vo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVo {
    private String id;
    private String title;
    private String content;
    private int hit;
    private String created_date;
    private String modified_date;

}
