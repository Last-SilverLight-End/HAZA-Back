package HAZAGroup.HAZACommunity.sql.dao;

import HAZAGroup.HAZACommunity.rest.board.model.CommentVo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CommentDao {

    public List<CommentVo> getCommentLists (SqlSession sqlSession) throws Exception {
        System.out.println("show all comment Lists");
        List<CommentVo> allCommentLists = sqlSession.selectList("comment.getAllCommentLists");
        System.out.println("allCommentLists = " + allCommentLists);
        return allCommentLists;
    }

}
