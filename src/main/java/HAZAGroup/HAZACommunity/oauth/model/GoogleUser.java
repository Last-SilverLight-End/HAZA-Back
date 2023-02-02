package HAZAGroup.HAZACommunity.oauth.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter

// GOOGLE API

public class GoogleUser {
    public String id;
    public String email;
    public Boolean verified_email;
    public String name;
    public String given_name;
    public String picture;
    public String locale;
}
