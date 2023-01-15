package HAZAGroup.HAZACommunity.rest.board.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter(AccessLevel.PROTECTED)
@Data
@Component
public class GenreMidCategoryVo {

    private int midCategory_Id;
    private int parentsCategory_Id;
    private String Name;
}
