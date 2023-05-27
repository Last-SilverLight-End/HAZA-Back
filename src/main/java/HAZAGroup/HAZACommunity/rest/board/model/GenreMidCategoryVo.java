package HAZAGroup.HAZACommunity.rest.board.model;

import lombok.*;


@Getter
@Setter
@RequiredArgsConstructor

public class GenreMidCategoryVo {

    private int midCategoryId;


    private int parentCategoryId;

    private String name;

}

