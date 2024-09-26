package HAZAGroup.HAZACommunity.rest.board.model;

import lombok.*;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class GenreMainCategoryVo {
    @NonNull
    private int mainCategoryId;
    @NonNull
    private String name;
}
