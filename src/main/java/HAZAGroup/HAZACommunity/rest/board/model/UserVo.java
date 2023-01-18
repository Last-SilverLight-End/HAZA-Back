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
    @NonNull
    private String roleType;
    @NonNull
    private String providerType;



}