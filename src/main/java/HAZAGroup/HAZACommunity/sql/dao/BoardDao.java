package HAZAGroup.HAZACommunity.sql.dao;

import HAZAGroup.HAZACommunity.rest.board.dto.BoardDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BoardDao {
    public List<BoardDto> getBoardList(SqlSession sqlSession) throws Exception{
        return sqlSession.selectList("board.getBoardList");
    }
}
