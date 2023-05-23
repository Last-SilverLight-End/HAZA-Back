package HAZAGroup.HAZACommunity.rest.board.service;

import HAZAGroup.HAZACommunity.rest.board.model.GenreMainCategoryVo;
import HAZAGroup.HAZACommunity.rest.board.model.GenreMidCategoryVo;
import HAZAGroup.HAZACommunity.sql.SqlSessionManager;
import HAZAGroup.HAZACommunity.sql.dao.CategoryDao;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CategoryService {

    Logger logger = LoggerFactory.getLogger(CategoryService.class);
    SqlSession sqlSession = null;

    public List<GenreMainCategoryVo> getAllMainCategory() throws Exception {
        try{
            CategoryDao categoryDao = new CategoryDao();
            SqlSessionManager sqlSessionManager = new SqlSessionManager();
            sqlSession = sqlSessionManager.getSqlSession();

            return categoryDao.getAllMainCategoryLists(sqlSession);
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            throw e;
        }
    }

    public List<GenreMidCategoryVo> getAllMidCategory() throws Exception {
        try{
            CategoryDao categoryDao = new CategoryDao();
            SqlSessionManager sqlSessionManager = new SqlSessionManager();
            sqlSession = sqlSessionManager.getSqlSession();

            return categoryDao.getAllMidCategoryLists(sqlSession);
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            throw e;
        }
    }

    public List<GenreMainCategoryVo> getMainCategoryStatus(Map<String, Object> map) throws Exception{

        try{
            CategoryDao categoryDao = new CategoryDao();
            SqlSessionManager sqlSessionManager = new SqlSessionManager();
            sqlSession = sqlSessionManager.getSqlSession();

            return categoryDao.getMainCategoryLists(map,sqlSession);

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

    public List<GenreMidCategoryVo> getMidCategoryStatus(Map<String, Object> map) throws Exception{
        try{
            CategoryDao categoryDao = new CategoryDao();
            SqlSessionManager sqlSessionManager = new SqlSessionManager();
            sqlSession = sqlSessionManager.getSqlSession();

            return categoryDao.getMidCategoryLists(map,sqlSession);

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