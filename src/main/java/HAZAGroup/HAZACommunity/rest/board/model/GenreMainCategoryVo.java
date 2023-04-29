package HAZAGroup.HAZACommunity.rest.board.model;

import lombok.*;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class GenreMainCategoryVo {
    @NonNull
    private int main_category_id;
    @NonNull
    private String name;
}
