package HAZAGroup.HAZACommunity.oauth.service;

import HAZAGroup.HAZACommunity.oauth.model.GoogleUser;
import HAZAGroup.HAZACommunity.oauth.token.GoogleOAuthToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class OauthService {

    Logger log = LoggerFactory.getLogger(OauthService.class);

    @Autowired
    private GoogleOauth googleOauth;

    public String request(String type) throws IOException {
        switch (type) {
            case "GOOGLE":
                String redirectURL = googleOauth.getOauthRedirectURL();
                return redirectURL;
            case "KAKAO":
                break;
            case "NAVER":
                break;
            case "GITHUB":
                break;
        }
        return "NOT ALLOW TYPE";
    }

    //    GetSocialOAuthRes
    public String oAuthLogin(String code) throws JsonProcessingException {
        // Access Token 발급
        ResponseEntity<String> accessToken = googleOauth.requestAccessToken(code);
        GoogleOAuthToken googleOAuthToken = googleOauth.getAccessToken(accessToken);

        log.info("GoogleOAuthToken: {}", googleOAuthToken);

        // Access Token 으로 유저 정보 조회
        ResponseEntity<String> userInfoResponse = googleOauth.requestUserInfo(googleOAuthToken);
        GoogleUser googleUser = googleOauth.getUserInfo(userInfoResponse);

        log.info("GoogleUser: {}", googleUser);

        String user_id = googleUser.getEmail();

//        new GetSocialOAuthRes("1234",1,"asdf", googleOAuthToken.getToken_type());
        return user_id;
    }

}