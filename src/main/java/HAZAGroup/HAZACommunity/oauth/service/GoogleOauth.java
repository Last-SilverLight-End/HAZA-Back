package HAZAGroup.HAZACommunity.oauth.service;

import HAZAGroup.HAZACommunity.oauth.model.GoogleUser;
import HAZAGroup.HAZACommunity.oauth.token.GoogleOAuthToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class GoogleOauth implements SocialOauth {

    Logger log = LoggerFactory.getLogger(GoogleOauth.class);

    @Value("${spring.security.oauth2.client.registration.google.uri}")
    private String GOOGLE_SNS_LOGIN_URL;

    @Value("${spring.security.oauth2.client.registration.google.client-id}")
    private String GOOGLE_SNS_CLIENT_ID;

    @Value("${spring.security.oauth2.client.registration.google.redirect-uri}")
    private String GOOGLE_SNS_CALLBACK_URL;

    @Value("${spring.security.oauth2.client.registration.google.client-secret}")
    private String GOOGLE_SNS_CLIENT_SECRET;

    @Value("${spring.security.oauth2.client.registration.google.scope}")
    private String GOOGLE_DATA_ACCESS_SCOPE;


    private RestTemplate restTemplate = new RestTemplate();
    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * GOOGLE OAUTH 2.0 서버로 리디렉션할 URL 생성
     *
     * @return GOOGLE OAUTH 2.0 Server URL
     */
    public String getOauthRedirectURL() {
        Map<String, Object> params = new HashMap<>();

        log.info(GOOGLE_SNS_LOGIN_URL);

        // yml 에서 공백처리가 안됨..
        params.put("scope", GOOGLE_DATA_ACCESS_SCOPE.replace('@', ' '));
        params.put("response_type", "code");
        params.put("client_id", GOOGLE_SNS_CLIENT_ID);
        params.put("redirect_uri", GOOGLE_SNS_CALLBACK_URL);

        // GOOGLE OAUTH 사용에 필요한 정보를 담아 URL 생성
        String parameterString = params.entrySet().stream()
                .map(x -> x.getKey() + "=" + x.getValue())
                .collect(Collectors.joining("&"));
        String redirectURL = GOOGLE_SNS_LOGIN_URL + "?" + parameterString;

        log.info("redirect-URL={}", redirectURL);
        return redirectURL;
    }

    /**
     * 로그인 후 받아온 code 로 Google API를 사용을 위한 Access Token 발급
     *
     * @param code authorization_code
     * @return Access Token
     */
    public ResponseEntity<String> requestAccessToken(String code) {
        String GOOGLE_TOKEN_REQUEST_URL = "https://oauth2.googleapis.com/token";
        Map<String, Object> params = new HashMap<>();

        // 구글 Google 요청으로 받은 Code
        params.put("code", code);

        // Google API 를 사용하기 위한 인증 정보
        params.put("client_id", GOOGLE_SNS_CLIENT_ID);
        params.put("client_secret", GOOGLE_SNS_CLIENT_SECRET);
        params.put("redirect_uri", GOOGLE_SNS_CALLBACK_URL);

        // 고정인 부분
        params.put("grant_type", "authorization_code");

        // post 요청
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(GOOGLE_TOKEN_REQUEST_URL, params, String.class);

        return stringResponseEntity;
    }

    /**
     * Access Token 을 객체에 Mapping
     *
     * @param accessToken accessToken
     * @return GoogleOAuthToken
     * @throws JsonProcessingException
     */
    public GoogleOAuthToken getAccessToken(ResponseEntity<String> accessToken) throws JsonProcessingException {
        log.info("accessTokenBody: {}", accessToken.getBody());
        GoogleOAuthToken googleOAuthToken = objectMapper.readValue(accessToken.getBody(), GoogleOAuthToken.class);
        return googleOAuthToken;
    }

    /**
     * GoogleOAuthToken 으로 Google API 를 사용해 로그인한 유저 정보 요청
     *
     * @param googleOAuthToken GoogleOAuthToken
     * @return User Info
     */
    public ResponseEntity<String> requestUserInfo(GoogleOAuthToken googleOAuthToken) {
        String GOOGLE_USERINFO_REQUEST_URL = "https://www.googleapis.com/oauth2/v2/userinfo";

        // 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(headers);
        headers.add("Authorization", "Bearer " + googleOAuthToken.getAccess_token());

        // get 요청
        ResponseEntity<String> exchange = restTemplate.exchange(GOOGLE_USERINFO_REQUEST_URL, HttpMethod.GET, request, String.class);
        log.info(exchange.getBody());
        return exchange;
    }

    /**
     * 유저 정보를 객체에 Mapping
     *
     * @param userInfoResponse
     * @return
     * @throws JsonProcessingException
     */
    public GoogleUser getUserInfo(ResponseEntity<String> userInfoResponse) throws JsonProcessingException {
        GoogleUser googleUser = objectMapper.readValue(userInfoResponse.getBody(), GoogleUser.class);
        return googleUser;
    }
}