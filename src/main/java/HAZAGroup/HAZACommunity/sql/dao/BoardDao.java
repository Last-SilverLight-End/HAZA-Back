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

    // all board data
    public List<BoardVo> getBoardLists(SqlSession sqlSession) throws Exception{
        List<BoardVo> BoardLists = sqlSession.selectList("board.getBoardLists");
        return BoardLists;
    }

    // board detail
    public List<BoardVo> getSpecificBoardLists(int id,SqlSession sqlSession) throws Exception{

        List<BoardVo> BoardSpecificLists = sqlSession.selectList("board.getSpecificBoardLists",id);
        return BoardSpecificLists;
    }

    // delete board
    public int getDeleteBoardLists(int id,SqlSession sqlSession) throws Exception{
        int result = sqlSession.delete("board.getDeleteBoard",id);

        return result;
    }

    // modify board
    public List<BoardVo> modifyBoardList(int id, SqlSession sqlSession) throws Exception{
        List<BoardVo> BoardModifyList = sqlSession.selectList("board.modifyBoardList",id);
        return BoardModifyList;
    }

}
