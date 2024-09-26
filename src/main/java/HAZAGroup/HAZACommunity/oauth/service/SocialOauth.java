package HAZAGroup.HAZACommunity.oauth.service;

import HAZAGroup.HAZACommunity.oauth.model.GoogleUser;
import HAZAGroup.HAZACommunity.oauth.token.GoogleOAuthToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface SocialOauth {
    String getOauthRedirectURL();

    ResponseEntity<String> requestAccessToken(String code);

    GoogleOAuthToken getAccessToken(ResponseEntity<String> accessToken) throws JsonProcessingException;

    ResponseEntity<String> requestUserInfo(GoogleOAuthToken googleOAuthToken);

    GoogleUser getUserInfo(ResponseEntity<String> userInfoResponse) throws JsonProcessingException;
}