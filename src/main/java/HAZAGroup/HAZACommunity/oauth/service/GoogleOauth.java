package HAZAGroup.HAZACommunity.oauth.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class GoogleOauth{

    Logger log = LoggerFactory.getLogger(GoogleOauth.class);

    @Value("${spring.security.oauth2.client.registration.google.url}")
    private String GOOGLE_SNS_LOGIN_URL;

    @Value("${spring.security.oauth2.client.registration.google.client-id}")
    private String GOOGLE_SNS_CLIENT_ID;

    @Value("${spring.security.oauth2.client.registration.google.redirect-url}")
    private String GOOGLE_SNS_CALLBACK_URL;

    @Value("${spring.security.oauth2.client.registration.google.client-secret}")
    private String GOOGLE_SNS_CLIENT_SECRET;

    @Value("${spring.security.oauth2.client.registration.google.scope}")
    private String GOOGLE_DATA_ACCESS_SCOPE;

//    // Stirng 값을 객체로 바꾸는 Mapper
//    private final ObjectMapper objectMapper;
//
//    // Google API로 요청을 보내고 받을 객체
//    private final RestTemplate restTemplate;

    public String getOauthRedirectURL() {
        Map<String,Object> params = new HashMap<>();

        log.info(GOOGLE_SNS_LOGIN_URL);

        params.put("scope",GOOGLE_DATA_ACCESS_SCOPE);
        params.put("response_type","code");
        params.put("client_id",GOOGLE_SNS_CLIENT_ID);
        params.put("redirect_uri",GOOGLE_SNS_CALLBACK_URL);

        String parameterString = params.entrySet().stream()
                .map(x->x.getKey()+"="+x.getValue())
                .collect(Collectors.joining("&"));
        String redirectURL = GOOGLE_SNS_LOGIN_URL + "?" + parameterString;
        log.info("redirect-URL={}", redirectURL);
        return redirectURL;
    }

    public ResponseEntity<String> requestAccessToken(String code) {
        return null;
    }
}