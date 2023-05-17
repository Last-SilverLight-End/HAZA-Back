package HAZAGroup.HAZACommunity.rest.board.service;

import HAZAGroup.HAZACommunity.rest.board.model.CommentVo;
import HAZAGroup.HAZACommunity.sql.dao.CommentDao;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class CommentService extends ServiceBase {
    CommentService() {
        super(LoggerFactory.getLogger(CommentService.class));
    }

    public List<CommentVo> getAllComment() throws Exception {
        return get(dao -> sqlSession -> dao.getCommentLists(sqlSession));
    }

    private <T> T get(Function<CommentDao, FunctionThrowsException<SqlSession, T>> fn) throws Exception {
        return getWithDao(fn, new CommentDao());
    }
}