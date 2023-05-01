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
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class BoardController {

    private final BoardService boardService;

    // 필드 인젝션 주입 방지
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    //http://localhost:8080/api/boards/all
    @RequestMapping(value ="all",method = {RequestMethod.OPTIONS,RequestMethod.GET},produces = "application/json;charset=UTF-8")
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

    /**
     *
     * @param main_category_id
     * 메인 카테고리에 맞는 board list 출력
     * http://localhost:8080/api/boards?main_category_id=3
     */
    @RequestMapping(produces = "application/json;charset=UTF-8",method = RequestMethod.GET,params = "main_category_id")
    public ResponseEntity<BasicResponse> getSpecificMainCategory(@RequestParam("main_category_id")Integer main_category_id) throws Exception{
        CommonResponse<List<BoardVo>> commonResponse;

        System.out.println("this is inserted main_category_id : " + main_category_id);


        try{
            commonResponse = new CommonResponse<List<BoardVo>>(boardService.getSpecificMainCategoryBoard(main_category_id));
            commonResponse.setStatus(200);

            return ResponseEntity.ok().body(commonResponse);

        }catch (Exception e){
            // 임시 예외처리 향후 Exception별로 구현 필요
            return ResponseEntity.internalServerError()
                    .body(new ErrorResponse(
                            "게시판 상세내용 확인 실패", HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }

    /**
     * http://localhost:8080/api/boards?id=3
     * 특정 id 보드 출력
     * @param id
     * @return 특정 보드 내용 반환
     * @throws 예외 반환
     */

    @RequestMapping(produces = "application/json;charset=UTF-8",method = RequestMethod.GET,params = "id")
    public ResponseEntity<BasicResponse> getSpecificInform(@RequestParam("id") Integer id) throws Exception{
        CommonResponse<List<BoardVo>> commonResponse;

        System.out.println("this is inserted id : " + id);
        System.out.println(id != null);

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
    /**
     * http://localhost:8080/api/boards?id=3
     * 특정 id 보드 삭제
     * @param id
     * @return 삭제 완료 여부 반환
     * @throws 예외 반환
     */
    @RequestMapping(produces = "application/json;charset=UTF-8",method = RequestMethod.DELETE,params = "id")
    public ResponseEntity<BasicResponse> getDeleteInform(@RequestParam("id") Integer id) throws Exception{
        CommonResponse<String> commonResponse;
        System.out.println("id = " + id);

        try{
            commonResponse = new CommonResponse<>(boardService.getDeleteBoardStatus(id));
            commonResponse.setStatus(200);
            System.out.println("result is = " + commonResponse.toString());
            System.out.println("delete completed  ");
            return ResponseEntity.ok().body(commonResponse);
        }catch (Exception e){
            // 임시 예외처리 향후 Exception별로 구현 필요
            return ResponseEntity.internalServerError()
                    .body(new ErrorResponse(
                            "게시판 상세내용 확인 실패", HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }

}


