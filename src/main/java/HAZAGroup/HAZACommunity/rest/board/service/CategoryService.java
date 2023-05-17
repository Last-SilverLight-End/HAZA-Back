package HAZAGroup.HAZACommunity.rest.board.service;

import HAZAGroup.HAZACommunity.rest.board.model.GenreMainCategoryVo;
import HAZAGroup.HAZACommunity.rest.board.model.GenreMidCategoryVo;
import HAZAGroup.HAZACommunity.sql.dao.CategoryDao;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class CategoryService extends ServiceBase {
    CategoryService() {
        super(LoggerFactory.getLogger(CategoryService.class));
    }

    public List<GenreMainCategoryVo> getAllMainCategory() throws Exception {
        return get(dao -> sqlSession -> dao.getAllMainCategoryLists(sqlSession));
    }
    public List<GenreMidCategoryVo> getAllMidCategory() throws Exception {
        return get(dao -> sqlSession -> dao.getAllMidCategoryLists(sqlSession));
    }
    public List<GenreMainCategoryVo> getMainCategoryStatus(Map<String, Object> map) throws Exception {
        return get(dao -> sqlSession -> dao.getMainCategoryLists(map, sqlSession));
    }
    public List<GenreMidCategoryVo> getMidCategoryStatus(Map<String, Object> map) throws Exception {
        return get(dao -> sqlSession -> dao.getMidCategoryLists(map, sqlSession));
    }

    private <T> T get(Function<CategoryDao, FunctionThrowsException<SqlSession, T>> fn) throws Exception {
        return getWithDao(fn, new CategoryDao());
    }
}