package HAZAGroup.HAZACommunity.oauth.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class OauthService {

    private final GoogleOauth socialOauth = new GoogleOauth();

    public String request(String type) throws IOException {
        String redirectURL = socialOauth.getOauthRedirectURL();
        return redirectURL;
    }
}