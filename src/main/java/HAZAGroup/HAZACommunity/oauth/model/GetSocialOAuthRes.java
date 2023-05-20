package HAZAGroup.HAZACommunity.oauth.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetSocialOAuthRes {
    private String jwtToken;
    private int userNum;
    private String accessToken;
    private String tokenType;
}