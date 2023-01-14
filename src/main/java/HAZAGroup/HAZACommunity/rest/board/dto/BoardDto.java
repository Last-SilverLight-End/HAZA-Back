package HAZAGroup.HAZACommunity.rest.board.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
public class BoardDto {
    private String id;
    private String title;
    private String content;
    private int hit;
    private String created_date;
    private String modified_date;
    private String user_name;
    private String user_email;
    private String mainCategory;
    private String midCategory;

}
