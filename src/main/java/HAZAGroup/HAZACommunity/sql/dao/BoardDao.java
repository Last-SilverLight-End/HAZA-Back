package HAZAGroup.HAZACommunity.sql.dao;

import HAZAGroup.HAZACommunity.rest.board.model.BoardVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class BoardDao {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private SqlSession sqlSession;

    public List<BoardVo> getBoardLists() throws Exception{
        List<BoardVo> BoardLists = sqlSession.selectList("board.getBoardLists");
        return BoardLists;
    }
}
