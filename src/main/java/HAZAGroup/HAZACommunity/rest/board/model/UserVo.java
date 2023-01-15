package HAZAGroup.HAZACommunity.rest.board.model;

import HAZAGroup.HAZACommunity.rest.oauth.model.ProviderType;
import HAZAGroup.HAZACommunity.rest.oauth.model.RoleType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter(AccessLevel.PROTECTED)
@Data
@Component
public class UserVo {


    private String id;
    private String name;
    private String email;
    private RoleType roleType;
    private ProviderType providerType;



}