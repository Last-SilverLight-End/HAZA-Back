package HAZAGroup.HAZACommunity.rest.board.vo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter(AccessLevel.PROTECTED)
@Data
@Component
public class MemberVo {


    private String id;
    private String name;
    private String email;

    private Boolean IsAdmin;
}