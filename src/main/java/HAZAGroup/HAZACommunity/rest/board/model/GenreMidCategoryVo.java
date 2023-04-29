package HAZAGroup.HAZACommunity.rest.board.model;

import lombok.*;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class GenreMidCategoryVo {

    @NonNull
    private int mid_category_id;

    @NonNull
    private int parent_category_id;

    @NonNull
    private String name;

}
