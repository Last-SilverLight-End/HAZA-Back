package HAZAGroup.HAZACommunity.rest.board.controller;

import HAZAGroup.HAZACommunity.common.response.model.BasicResponse;
import HAZAGroup.HAZACommunity.common.response.model.CommonResponse;
import HAZAGroup.HAZACommunity.common.response.model.ErrorResponse;
import HAZAGroup.HAZACommunity.rest.board.model.UserVo;
import HAZAGroup.HAZACommunity.rest.board.service.UserService;
import HAZAGroup.HAZACommunity.sql.dao.UserDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("api/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private UserService userService;

    @GetMapping(produces = "application/json;charset=UTF-8")
    public ResponseEntity<BasicResponse> getDrawingUserInform() throws Exception{
        CommonResponse<UserVo> commonResponse;

        try{
            commonResponse = new CommonResponse<UserVo>(userService.getUserSample());
            commonResponse.setStatus(200);

            return ResponseEntity.ok().body(commonResponse);
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(new ErrorResponse("유저 정보 불러오기 실패", HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }
}
