package HAZAGroup.HAZACommunity.rest.board.controller;

import HAZAGroup.HAZACommunity.common.response.model.BasicResponse;
import HAZAGroup.HAZACommunity.common.response.model.CommonResponse;
import HAZAGroup.HAZACommunity.common.response.model.ErrorResponse;
import HAZAGroup.HAZACommunity.rest.board.model.BoardVo;
import HAZAGroup.HAZACommunity.rest.board.service.BoardService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Mapper
@RequestMapping("/api/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    //http://localhost:8080/api/boards
    @GetMapping(produces = "application/json;charset=UTF-8")
    public ResponseEntity<BasicResponse> getDrawingInform() throws Exception {

        CommonResponse<List<BoardVo>> commonResponse;
        System.out.println("this is all id");
        try {
            commonResponse = new CommonResponse<List<BoardVo>>(boardService.getBoardStatus());
            commonResponse.setStatus(200);

            return ResponseEntity.ok().body(commonResponse);

        }catch (Exception e){
            // 임시 예외처리 향후 Exception별로 구현 필요
            return ResponseEntity.internalServerError()
                    .body(new ErrorResponse(
                            "조회 실패", HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }

    //http://localhost:8080/api/boards?id=3
    @GetMapping(produces = "application/json;charset=UTF-8",params = "id")
    public ResponseEntity<BasicResponse> getSpecificInform(@RequestParam("id") int id) throws Exception{
        CommonResponse<List<BoardVo>> commonResponse;

        System.out.println("this is inserted id : " + id);
        try{
            commonResponse = new CommonResponse<List<BoardVo>>(boardService.getSpecificStatus(id));
            commonResponse.setStatus(200);

            return ResponseEntity.ok().body(commonResponse);

        }catch (Exception e){
            // 임시 예외처리 향후 Exception별로 구현 필요
            return ResponseEntity.internalServerError()
                    .body(new ErrorResponse(
                            "게시판 상세내용 확인 실패", HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }


}


