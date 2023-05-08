package HAZAGroup.HAZACommunity.oauth.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.crypto.spec.SecretKeySpec;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String JWT_SECRET_KEY;

    /**
     * jwt 토큰 생성
     */
    public String createJwt(int userNum) {
        SignatureAlgorithm algorithm = SignatureAlgorithm.HS256;
        return Jwts.builder()
                .setHeaderParam("type", "jwt")
                .claim("userNum", userNum)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + Duration.of(1, ChronoUnit.YEARS).toMillis())) //발급날짜 계산
                .signWith(new SecretKeySpec(Decoders.BASE64.decode(JWT_SECRET_KEY), algorithm.getJcaName()), algorithm) //signature 부분
                .compact();
    }
    /**
     * Header에서 X-ACCESS-TOKEN 으로 JWT 추출
     */
    public String getJwt() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        return request.getHeader("X-ACCESS-TOKEN");
    }
    /**
     * JWT에서 userIdx 추출
     */
    public int getUserNum() throws Exception {
        //1. JWT 추출
        String accessToken = getJwt();
        if (accessToken == null || accessToken.length() == 0) {
            throw new Exception("Empty Jwt Token");
        }

        // 2. JWT parsing
        Jws<Claims> claims;
        try {
            claims = Jwts.parserBuilder()
                .setSigningKey(JWT_SECRET_KEY)
                .build()
                .parseClaimsJws(accessToken);
        } catch (Exception ignored) {
            throw new Exception("INVALID JWT");
        }

        // 3. userNum 추출
        return claims.getBody().get("userNum", Integer.class);
    }
}