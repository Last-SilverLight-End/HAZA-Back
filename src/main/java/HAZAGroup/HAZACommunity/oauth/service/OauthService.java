package HAZAGroup.HAZACommunity.oauth.service;

import HAZAGroup.HAZACommunity.oauth.model.GetSocialOAuthRes;
import HAZAGroup.HAZACommunity.oauth.model.GoogleUser;
import HAZAGroup.HAZACommunity.oauth.token.GoogleOAuthToken;
import HAZAGroup.HAZACommunity.rest.board.model.UserVo;
import HAZAGroup.HAZACommunity.rest.board.service.UserService;
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
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserService userService;

    public String request(String type) throws IOException {
        switch (type) {
            case "GOOGLE":
                return googleOauth.getOauthRedirectURL();
            case "KAKAO":
                break;
            case "NAVER":
                break;
            case "GITHUB":
                break;
        }
        return "NOT ALLOW TYPE";
    }

    public GetSocialOAuthRes oAuthLogin(String code) throws JsonProcessingException {
        try {
            // Access Token 발급
            ResponseEntity<String> accessToken = googleOauth.requestAccessToken(code);
            GoogleOAuthToken googleOAuthToken = googleOauth.getAccessToken(accessToken);

            log.info("GoogleOAuthToken: {}", googleOAuthToken);

            // Access Token 으로 유저 정보 조회
            ResponseEntity<String> userInfoResponse = googleOauth.requestUserInfo(googleOAuthToken);
            GoogleUser googleUser = googleOauth.getUserInfo(userInfoResponse);

            log.info("GoogleUser: {}", googleUser);

            String userId = googleUser.getEmail();

            // 1. user validation And get UserId

            UserVo userVo = userService.getUserToEmail(userId);

            // 2. jwt token 생성

            String jwtToken = jwtService.createJwt(userVo.getId());

            // 3. GetSocialOAuthRes 객체 리턴

            return new GetSocialOAuthRes(jwtToken, userVo.getId(), googleOAuthToken.getAccessToken(), googleOAuthToken.getTokenType());
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
            throw e;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}