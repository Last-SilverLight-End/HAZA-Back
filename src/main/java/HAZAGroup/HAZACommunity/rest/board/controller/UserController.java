package HAZAGroup.HAZACommunity.rest.board.controller;

import HAZAGroup.HAZACommunity.common.response.model.BasicResponse;
import HAZAGroup.HAZACommunity.common.response.model.CommonResponse;
import HAZAGroup.HAZACommunity.common.response.model.ErrorResponse;
import HAZAGroup.HAZACommunity.rest.board.model.UserVo;
import HAZAGroup.HAZACommunity.rest.board.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Mapper
@RequestMapping("api/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    private final UserService userService;
    // 필드 인젝션 주입 방지
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * http://localhost:8080/api/users/all
     * */
    @RequestMapping (value = "all", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<BasicResponse> getAllUserInfo() throws Exception {
        try {
            CommonResponse<List<UserVo>> commonResponse = new CommonResponse<>(userService.getAllUser());
            commonResponse.setStatus(200);
            System.out.println("finished ");
            return ResponseEntity.ok().body(commonResponse);
        }
        catch (Exception e) {
            System.out.println(" ERROR OCCURRED");
            System.out.println(e);
            return ResponseEntity.internalServerError()
                .body(new ErrorResponse("유저 정보 불러오기 실패", HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }
}