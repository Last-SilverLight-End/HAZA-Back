package HAZAGroup.HAZACommunity.rest.board.controller;

import HAZAGroup.HAZACommunity.common.response.model.CommonResponse;
import HAZAGroup.HAZACommunity.rest.board.dto.BoardDto;
import HAZAGroup.HAZACommunity.rest.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping(produces = "application/json;charset=UTF-8")
    public ResponseEntity<CommonResponse<BoardDto>> getDrawingInform() throws Exception {
        return ResponseEntity.ok(new CommonResponse<BoardDto>(boardService.getBoardSample()));
    }
}
