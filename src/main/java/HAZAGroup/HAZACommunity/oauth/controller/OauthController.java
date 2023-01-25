package HAZAGroup.HAZACommunity.oauth.controller;

import HAZAGroup.HAZACommunity.oauth.service.GoogleOauth;
import HAZAGroup.HAZACommunity.oauth.service.OauthService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class OauthController {
    private final OauthService oauthService = new OauthService();

    // 로그인 인증을 할 수 있도록 리디렉션 해주는 핸들러
    @GetMapping("/login/{type}")
    public void socialLoginRequest(@PathVariable("type")String type, HttpServletResponse response) throws IOException {
        String requestURL = oauthService.request(type.toUpperCase());
        response.sendRedirect(requestURL);
    }
}
