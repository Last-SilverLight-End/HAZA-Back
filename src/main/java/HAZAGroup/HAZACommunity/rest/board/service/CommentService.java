package HAZAGroup.HAZACommunity.rest.board.service;

import HAZAGroup.HAZACommunity.rest.board.model.CommentVo;
import HAZAGroup.HAZACommunity.sql.SqlSessionManager;
import HAZAGroup.HAZACommunity.sql.dao.CommentDao;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    Logger logger = LoggerFactory.getLogger(BoardService.class);
    SqlSession sqlSession = null;

    public List<CommentVo> getAllComment() throws Exception{
        try{
            CommentDao commentDao = new CommentDao();
            SqlSessionManager sqlSessionManager = new SqlSessionManager();
            sqlSession = sqlSessionManager.getSqlSession();

            return commentDao.getCommentLists(sqlSession);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            throw e;
        }
        finally{
            sqlSession.close();
        }
    }
}