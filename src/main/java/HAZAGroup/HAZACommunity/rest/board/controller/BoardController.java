package HAZAGroup.HAZACommunity.rest.board.controller;

import HAZAGroup.HAZACommunity.common.response.model.BasicResponse;
import HAZAGroup.HAZACommunity.common.response.model.CommonResponse;
import HAZAGroup.HAZACommunity.common.response.model.ErrorResponse;
import HAZAGroup.HAZACommunity.rest.board.model.BoardVo;
import HAZAGroup.HAZACommunity.rest.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    /**
     *
     * boardlist 입력
     * http://localhost:8080/api/boards/push
     *
     */

    @PostMapping(value = "push", produces = "application/json;charset=UTF-8")
    public String ResponseEntity(@RequestBody BoardVo boardVo) throws Exception {
        try {
            System.out.println("boardVo = " + boardVo);
            CommonResponse<String> commonResponse = new CommonResponse<>(boardService.insertBoard(boardVo));
            commonResponse.setStatus(200);

            return ResponseEntity.ok().body(commonResponse).toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError()
                    .body(new ErrorResponse("조회 실패", HttpStatus.INTERNAL_SERVER_ERROR.value())).toString();
        }
    }

    /**
     * board list 전체 출력
     * http://localhost:8080/api/boards/all
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "all", method = {RequestMethod.OPTIONS, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public ResponseEntity<BasicResponse> getDrawingInform() throws Exception {
        System.out.println("this is all id");
        try {
            CommonResponse<List<BoardVo>> commonResponse = new CommonResponse<>(boardService.getBoardStatus());
            commonResponse.setStatus(200);
            return ResponseEntity.ok().body(commonResponse);
        }
        catch (Exception e) {
            // 임시 예외처리 향후 Exception별로 구현 필요
            return ResponseEntity.internalServerError()
                    .body(new ErrorResponse("조회 실패", HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }

    /**
     * 메인 카테고리에 맞는 board list 출력
     * http://localhost:8080/api/boards?mainCategoryId=3
     */
    @RequestMapping(produces = "application/json;charset=UTF-8", method = RequestMethod.GET, params = "mainCategoryId")
    public ResponseEntity<BasicResponse> getSpecificMainCategory(@RequestParam("mainCategoryId") Integer mainCategoryId) throws Exception {
        System.out.println("this is inserted mainCategoryId : " + mainCategoryId);
        try {
            CommonResponse<List<BoardVo>> commonResponse = new CommonResponse<>(boardService.getSpecificMainCategoryBoard(mainCategoryId));
            commonResponse.setStatus(200);
            return ResponseEntity.ok().body(commonResponse);
        }
        catch (Exception e) {
            // 임시 예외처리 향후 Exception별로 구현 필요
            return ResponseEntity.internalServerError()
                    .body(new ErrorResponse("게시판 상세내용 확인 실패", HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }

    /**
     * 메인 카테고리에 맞는 board list 출력
     * http://localhost:8080/api/boards?midCategoryId=3
     */
    /*@RequestMapping(produces = "application/json;charset=UTF-8", method = RequestMethod.GET, params = "midCategoryId")
    public ResponseEntity<BasicResponse>getSpecificMainCategory(@RequestParam("mainCategoryId") Integer mainCategoryId) throws Exception {
        System.out.println("this is inserted mainCategoryId : " + mainCategoryId);
        try {
            CommonResponse<List<BoardVo>> commonResponse = new CommonResponse<>(boardService.getSpecificMainCategoryBoard(mainCategoryId));
            commonResponse.setStatus(200);
            return ResponseEntity.ok().body(commonResponse);
        }
        catch (Exception e) {
            // 임시 예외처리 향후 Exception별로 구현 필요
            return ResponseEntity.internalServerError()
                    .body(new ErrorResponse("게시판 상세내용 확인 실패", HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }*/

    /**
     * 메인 카테고리 내 미드 카테고리의 모든 board list 출력
     *  http://localhost:8080/api/boards?mainCategoryId=1&midCategoryId=1
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(produces = "application/json;charset=UTF-8", method = RequestMethod.GET,params = {"mainCategoryId","midCategoryId"})
    public ResponseEntity<BasicResponse> getSpecificMidAllInform(@RequestParam("mainCategoryId") int main,
                                                                 @RequestParam("midCategoryId") int mid) throws Exception {
        System.out.println("main = " + main);
        System.out.println("mid = " + mid);

        Map<String, Object> map = new HashMap<>();
        map.put("mainCategoryId", main);
        map.put("midCategoryId", mid);

        try {
            CommonResponse<List<BoardVo>> commonResponse = new CommonResponse<>(boardService.getSpecificMidAllCategoryBoard(map));
            commonResponse.setStatus(200);
            return ResponseEntity.ok().body(commonResponse);
        }
        catch (Exception e) {
            // 임시 예외처리 향후 Exception별로 구현 필요
            return ResponseEntity.internalServerError()
                    .body(new ErrorResponse("게시판 상세내용 확인 실패", HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }

    /**
     * http://localhost:8080/api/boards?id=3
     * 특정 id 보드 반환
     */
    @RequestMapping(produces = "application/json;charset=UTF-8", method = RequestMethod.GET, params = "id")
    public ResponseEntity<BasicResponse> getSpecificInform(@RequestParam("id") Integer id) throws Exception {
        System.out.println("this is inserted id : " + id);
        System.out.println(id != null);

        try {
            CommonResponse<List<BoardVo>> commonResponse = new CommonResponse<>(boardService.getSpecificStatus(id));
            commonResponse.setStatus(200);

            return ResponseEntity.ok().body(commonResponse);
        }
        catch (Exception e) {
            // 임시 예외처리 향후 Exception별로 구현 필요
            return ResponseEntity.internalServerError()
                    .body(new ErrorResponse("게시판 상세내용 확인 실패", HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }

    /**
     * http://localhost:8080/api/boards?id=3
     * 특정 id 보드 삭제
     *
     * @return 삭제 완료 여부 반환
     */
    @RequestMapping(produces = "application/json;charset=UTF-8", method = RequestMethod.DELETE, params = "id")
    public ResponseEntity<BasicResponse> getDeleteInform(@RequestParam("id") Integer id) throws Exception {
        System.out.println("id = " + id);

        try {
            CommonResponse<String> commonResponse = new CommonResponse<>(boardService.getDeleteBoardStatus(id));
            commonResponse.setStatus(200);
            System.out.println("result is = " + commonResponse);
            System.out.println("delete completed  ");
            return ResponseEntity.ok().body(commonResponse);
        } catch (Exception e) {
            // 임시 예외처리 향후 Exception별로 구현 필요
            return ResponseEntity.internalServerError()
                    .body(new ErrorResponse("게시판 상세내용 확인 실패", HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }

    /**
     * http://localhost:8080/api/boards/modify
     * 보드 수정하는 api
     */
    @PostMapping(value = "modify", produces = "application/json;charset=UTF-8")
    public String modifyInform(@RequestBody BoardVo boardVo) throws Exception {
        try {
            System.out.println("boardVo = ");
            // 가져오기
            CommonResponse<String> commonResponse = new CommonResponse<>(boardService.modifyBoard(boardVo));
            commonResponse.setStatus(200);

            return ResponseEntity.ok().body(commonResponse).toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError()
                    .body(new ErrorResponse("조회 실패", HttpStatus.INTERNAL_SERVER_ERROR.value())).toString();
        }
    }
}
