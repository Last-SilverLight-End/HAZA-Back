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
    public List<BoardVo> getBoardLists(SqlSession sqlSession) throws Exception {
        return sqlSession.selectList("board.getBoardLists");
    }
    // board mainCategory id lists
    public List<BoardVo> getSpecificMainCategoryBoardLists(int mainCategoryId, SqlSession sqlSession) throws Exception {
        return sqlSession.selectList("board.getSpecificMainCategoryBoardLists", mainCategoryId);
    }
    // board detail id
    public List<BoardVo> getSpecificBoardLists(int id, SqlSession sqlSession) throws Exception {
        return sqlSession.selectList("board.getSpecificBoardLists", id);
    }
    // delete board
    public int getDeleteBoardLists(int id, SqlSession sqlSession) throws Exception {
        return sqlSession.delete("board.getDeleteBoard", id);
    }
    // modify board
    public List<BoardVo> modifyBoardList(int id, SqlSession sqlSession) throws Exception {
        return sqlSession.selectList("board.modifyBoardList", id);
    }
    // delete board
    public static String deleteBoardList(int id, SqlSession sqlSession) throws Exception {
        return sqlSession.selectList("board.deleteBoardList", id).toString();
    }
    // create board

}