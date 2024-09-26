package HAZAGroup.HAZACommunity.rest.board.service;

import HAZAGroup.HAZACommunity.rest.board.model.BoardVo;
import HAZAGroup.HAZACommunity.sql.dao.BoardDao;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class BoardService extends ServiceBase {
    BoardService() {
        super(LoggerFactory.getLogger(BoardService.class));
    }

    // 전체 보드 상태 불러오기
    public List<BoardVo> getBoardStatus() throws Exception {
        return get(dao -> sqlSession -> dao.getBoardLists(sqlSession));
    }
    // 특정 카테고리 id 보드들 불러오기
    public List<BoardVo> getSpecificMainCategoryBoard(int mainCategoryId) throws Exception {
        return get(dao -> sqlSession -> dao.getSpecificMainCategoryBoardLists(mainCategoryId, sqlSession));
    }
    // 특정 id 보드 상태 불러오기
    public List<BoardVo> getSpecificStatus(int id) throws Exception {
        return get(dao -> sqlSession -> dao.getSpecificBoardLists(id, sqlSession));
    }
    // 특정 id 보드 삭제
    public String getDeleteBoardStatus(int id) throws Exception {
        return get(dao -> sqlSession -> dao.deleteBoardList(id, sqlSession));
    }

    private <T> T get(Function<BoardDao, FunctionThrowsException<SqlSession, T>> fn) throws Exception {
        return getWithDao(fn, new BoardDao());
    }
}