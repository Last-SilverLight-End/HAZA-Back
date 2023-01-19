package HAZAGroup.HAZACommunity.rest.board.model;

import HAZAGroup.HAZACommunity.oauth.model.ProviderType;
import HAZAGroup.HAZACommunity.oauth.model.RoleType;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@RequiredArgsConstructor
public class UserVo {

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