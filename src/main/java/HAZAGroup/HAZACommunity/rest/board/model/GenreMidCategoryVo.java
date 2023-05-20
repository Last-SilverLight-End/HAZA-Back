package HAZAGroup.HAZACommunity.rest.board.model;

import lombok.*;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class GenreMidCategoryVo {

    @NonNull
    private int midCategoryId;

    @NonNull
    private int parentCategoryId;

    @NonNull
    private int name;

}