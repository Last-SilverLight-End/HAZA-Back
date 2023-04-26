package HAZAGroup.HAZACommunity.rest.board.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class GenreMainCategoryVo {
    @NonNull
    private int mainCategory_Id;
    @NonNull
    private String Name;
}
