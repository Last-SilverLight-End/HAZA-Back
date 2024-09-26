package HAZAGroup.HAZACommunity.oauth.controller;

import HAZAGroup.HAZACommunity.common.response.model.BasicResponse;
import HAZAGroup.HAZACommunity.common.response.model.CommonResponse;
import HAZAGroup.HAZACommunity.oauth.model.GetSocialOAuthRes;
import HAZAGroup.HAZACommunity.oauth.service.OauthService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class OauthController {
    @Autowired
    private final OauthService oauthService;
    Logger logger = LoggerFactory.getLogger(OauthService.class);

    /**
     * 로그인 인증을 할 수 있도록 리디렉션 해주는 핸들러
     *
     * @param type     platform Name
     * @param response HttpServletResponse
     * @throws IOException
     */
    @GetMapping("/login/{type}")
    public void socialLoginRequest(@PathVariable(value = "type") String type, HttpServletResponse response) throws IOException {
//         허용되지 않은 type 일 경우 Redirect할 페이지 주소 필요?
        logger.info("Start!");
        String requestURL = oauthService.request(type.toUpperCase());
        response.sendRedirect(requestURL);
        logger.info("End!");
    }

//    http://localhost:8080/api/auth/code/google

    /**
     * login 후 리디렉션 할 URL
     *
     * @param type platform Name
     * @param code return code
     * @return
     */
    @GetMapping("/code/{type}")
    public ResponseEntity<BasicResponse> getAuthorizationCode(
            @PathVariable(value = "type") String type, @RequestParam(value = "code") String code) throws JsonProcessingException {
        //  TODO: platform type 별로 분기 처리
        GetSocialOAuthRes response = oauthService.oAuthLogin(code);
        return new ResponseEntity<>(new CommonResponse<>(response.getJwtToken()), HttpStatus.OK);
    }
}
