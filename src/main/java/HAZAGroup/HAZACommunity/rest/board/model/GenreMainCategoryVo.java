package HAZAGroup.HAZACommunity.rest.board.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@RequiredArgsConstructor
public class GenreMainCategoryVo {
    @NonNull
    private int mainCategory_Id;
    @NonNull
    private String Name;
}
