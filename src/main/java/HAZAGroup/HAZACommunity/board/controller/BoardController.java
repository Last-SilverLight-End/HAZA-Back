package HAZAGroup.HAZACommunity.board.controller;

import HAZAGroup.HAZACommunity.board.dto.BoardDto;
import HAZAGroup.HAZACommunity.board.service.BoardService;
import HAZAGroup.HAZACommunity.board.vo.BoardVo;
import HAZAGroup.HAZACommunity.sql.SqlSessionManager;
import HAZAGroup.HAZACommunity.sql.dao.BoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping(produces = "application/json;charset=UTF-8")
    public ResponseEntity<BoardDto> getDrawingInform() throws Exception {
        return ResponseEntity.ok(boardService.getBoardSample());
    }
}
