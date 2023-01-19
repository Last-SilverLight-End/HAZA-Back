package HAZAGroup.HAZACommunity.rest.board.service;

import HAZAGroup.HAZACommunity.rest.board.model.BoardVo;
import HAZAGroup.HAZACommunity.sql.dao.BoardDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    Logger logger = LoggerFactory.getLogger(BoardService.class);

    public BoardVo getBoardStatus() throws Exception {
        try {
            //BoardVo boardVo = new BoardVo();
            BoardDao boardDao = new BoardDao();
            List<BoardDao> boardLists;
            // 이 부분을 다 불러와야 한다. 짜는중....
            return boardDao.getBoardLists().get(1);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            throw e;
        }
    }
}
