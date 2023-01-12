package HAZAGroup.HAZACommunity.board.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {
    private String id;
    private String title;
    private String content;
    private int hit;
    private String created_date;
    private String modified_date;

}
