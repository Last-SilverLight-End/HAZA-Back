package HAZAGroup.HAZACommunity.rest.board.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@RequiredArgsConstructor
public class GenreMidCategoryVo {
    @NonNull
    private int midCategory_Id;
    @NonNull
    private int parentsCategory_Id;
    @NonNull
    private String Name;
}
