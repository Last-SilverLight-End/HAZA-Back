package HAZAGroup.HAZACommunity.oauth.token;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
public class GoogleOAuthToken {
    private String accessToken;
    private int expiresIn;
    private String scope;
    private String tokenType;
    private String idToken;
}