package HAZAGroup.HAZACommunity.rest.board.service;

import HAZAGroup.HAZACommunity.rest.board.model.BoardVo;
import HAZAGroup.HAZACommunity.sql.SqlSessionManager;
import HAZAGroup.HAZACommunity.sql.dao.BoardDao;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    Logger logger = LoggerFactory.getLogger(BoardService.class);

    public List<BoardVo> getBoardStatus() throws Exception {
        SqlSession sqlSession = null;
        try {
            BoardDao boardDao = new BoardDao();
            SqlSessionManager sqlSessionManager = new SqlSessionManager();
            sqlSession = sqlSessionManager.getSqlSession();
            
            return boardDao.getBoardLists(sqlSession);

        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            throw e;
        }
        finally {
            sqlSession.close();
        }
    }
    public List<BoardVo> getSpecificStatus(int id) throws Exception {
        SqlSession sqlSession = null;
        try {
            BoardDao boardDao = new BoardDao();
            SqlSessionManager sqlSessionManager = new SqlSessionManager();
            sqlSession = sqlSessionManager.getSqlSession();

            return boardDao.getSpecificBoardLists(id,sqlSession);

        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            throw e;
        }
        finally {
            sqlSession.close();
        }
    }
}
