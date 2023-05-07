package HAZAGroup.HAZACommunity.rest.board.controller;


import HAZAGroup.HAZACommunity.common.response.model.BasicResponse;
import HAZAGroup.HAZACommunity.common.response.model.CommonResponse;
import HAZAGroup.HAZACommunity.common.response.model.ErrorResponse;
import HAZAGroup.HAZACommunity.rest.board.model.CommentVo;
import HAZAGroup.HAZACommunity.rest.board.service.CommentService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Mapper
@RequestMapping("/api/comments")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    /***
     * 전체 comments 출력
     * http://localhost:8080/api/comments/all
     */

    @RequestMapping(value = "all", method = RequestMethod.GET, produces ="application/json;charset=UTF-8")
    public @ResponseBody
    ResponseEntity<BasicResponse> getAllComments() throws Exception{
        CommonResponse<List<CommentVo>> commonResponse;
        try{
            commonResponse = new CommonResponse<>(commentService.getAllComment());
            commonResponse.setStatus(200);
            return ResponseEntity.ok().body(commonResponse);
        }

        catch (Exception e){
            return ResponseEntity.internalServerError()
                    .body(
                            new ErrorResponse("코멘트 조회 실패", HttpStatus.INTERNAL_SERVER_ERROR.value());
                    );
        }
    }
}
