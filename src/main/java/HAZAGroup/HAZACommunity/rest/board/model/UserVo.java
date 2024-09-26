package HAZAGroup.HAZACommunity.rest.board.model;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class UserVo {
    @NonNull
    private int id;
    @NonNull
    private String email;
    @NonNull
    private String name;

    //api 호출 용도
    private String roleType;

    // 로그인 용도
    private String providerType;
}