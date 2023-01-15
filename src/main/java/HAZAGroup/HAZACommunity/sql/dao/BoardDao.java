package HAZAGroup.HAZACommunity.sql.dao;

import HAZAGroup.HAZACommunity.rest.board.model.BoardVo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BoardDao {
    public List<BoardVo> getBoardList(SqlSession sqlSession) throws Exception{
        return sqlSession.selectList("board.getBoardList");
    }
}
