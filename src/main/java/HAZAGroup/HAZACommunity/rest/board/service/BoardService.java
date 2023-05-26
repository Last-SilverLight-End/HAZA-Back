package HAZAGroup.HAZACommunity.rest.board.service;

import HAZAGroup.HAZACommunity.rest.board.model.BoardVo;
import HAZAGroup.HAZACommunity.sql.SqlSessionManager;
import HAZAGroup.HAZACommunity.sql.dao.BoardDao;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardService {
    Logger logger = LoggerFactory.getLogger(BoardService.class);
    SqlSession sqlSession = null;


    // 전체 보드 상태 불러오기
    public List<BoardVo> getBoardStatus() throws Exception {

        try {
            BoardDao boardDao = new BoardDao();
            SqlSessionManager sqlSessionManager = new SqlSessionManager();
            sqlSession = sqlSessionManager.getSqlSession();

            System.out.println("sqlSessionManager = " + sqlSessionManager);
            System.out.println("sqlSession = " + sqlSession);
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
    // 특정 카테고리 id 보드들 불러오기
    public List<BoardVo> getSpecificMainCategoryBoard(int mainCategoryId) throws Exception{
        System.out.println("mainCategoryId = " + mainCategoryId);
        try {
            BoardDao boardDao = new BoardDao();
            SqlSessionManager sqlSessionManager = new SqlSessionManager();
            sqlSession = sqlSessionManager.getSqlSession();

            return boardDao.getSpecificMainCategoryBoardLists(mainCategoryId,sqlSession);
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            throw e;
        }
        finally {
            sqlSession.close();
        }
    }
    // 특정 id 보드 상태 불러오기
    public List<BoardVo> getSpecificStatus(int id) throws Exception {
        System.out.println("service id = " + id);
        try {
            BoardDao boardDao = new BoardDao();
            SqlSessionManager sqlSessionManager = new SqlSessionManager();
            sqlSession = sqlSessionManager.getSqlSession();
            return boardDao.getSpecificBoardLists(id,sqlSession);
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            throw e;
        }
        finally {
            sqlSession.close();
        }
    }

    // 특정 id 보드 삭제
    public String getDeleteBoardStatus(Integer id) throws Exception {
        System.out.println("service id = " + id);
        try {
            BoardDao boardDao = new BoardDao();
            SqlSessionManager sqlSessionManager = new SqlSessionManager();
            sqlSession = sqlSessionManager.getSqlSession();
            String responseString ="";
            responseString = BoardDao.deleteBoardList(id,sqlSession);
            return responseString;
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            throw e;
        }
        finally {
            sqlSession.close();
        }
    }
    //보드 생성
    public String insertBoard(BoardVo boardVo) throws Exception{
        System.out.println("start inserting");
        try {
            BoardDao boardDao = new BoardDao();
            SqlSessionManager sqlSessionManager = new SqlSessionManager();
            sqlSession = sqlSessionManager.getSqlSession();
            String responseString ="";

            responseString = 0 < BoardDao.insertBoardList(boardVo, sqlSession) ? "complete" : "error";
            return responseString;
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            throw e;
        }
        finally {
            sqlSession.close();
        }
    }
    //특정 메인 카테고리 내 전체 미드 카테고리 불러오기
    public  List<BoardVo> getSpecificMidAllCategoryBoard(Map<String, Object> map)throws Exception{
        System.out.println("map = " + map);
        try{
            BoardDao boardDao = new BoardDao();
            SqlSessionManager sqlSessionManager = new SqlSessionManager();
            sqlSession = sqlSessionManager.getSqlSession();
            return boardDao.getSpecificMidAllCategoryBoardLists(map,sqlSession);
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            throw e;
        }
        finally {
            sqlSession.close();
        }
    }
    // 보드 수정하기
    public String modifyBoard(BoardVo boardVo) throws Exception{
        System.out.println(" start modifying" + boardVo);
        try{
            BoardDao boardDao = new BoardDao();
            SqlSessionManager sqlSessionManager = new SqlSessionManager();
            sqlSession = sqlSessionManager.getSqlSession();
            String responseString ="";

            responseString = 0 < BoardDao.modifyBoardList(boardVo, sqlSession) ? "complete" : "error";
            return responseString;
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            throw e;
        }
        finally {
            sqlSession.close();
        }
    }
}