package HAZAGroup.HAZACommunity.rest.board.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter(AccessLevel.PROTECTED)
@Data
@Component
public class GenreMainCategoryVo {
    private int mainCategory_Id;
    private String Name;
}
