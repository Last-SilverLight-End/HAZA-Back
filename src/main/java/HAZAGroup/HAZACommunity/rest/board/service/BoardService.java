package HAZAGroup.HAZACommunity.rest.board.service;

import HAZAGroup.HAZACommunity.rest.board.dto.BoardDto;
import HAZAGroup.HAZACommunity.sql.SqlSessionManager;
import HAZAGroup.HAZACommunity.sql.dao.BoardDao;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    Logger logger = LoggerFactory.getLogger(BoardService.class);

    public BoardDto getBoardSample(){
        try {
            BoardDao boardDao = new BoardDao();
            SqlSessionManager sqlSessionManager = new SqlSessionManager();
            SqlSession sqlSession = sqlSessionManager.getSqlSession();

            return boardDao.getBoardList(sqlSession).get(0);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            return null;
        }
    }
}
