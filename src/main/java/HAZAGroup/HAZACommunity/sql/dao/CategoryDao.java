package HAZAGroup.HAZACommunity.sql.dao;

import HAZAGroup.HAZACommunity.rest.board.model.GenreMainCategoryVo;
import HAZAGroup.HAZACommunity.rest.board.model.GenreMidCategoryVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class CategoryDao {
    @Autowired
    private DataSource dataSource;

    // 전체 MainCategory 조회
    public List<GenreMainCategoryVo> getAllMainCategoryLists(SqlSession sqlSession) throws Exception{
        System.out.println("show all MainCategory lists");
        List<GenreMainCategoryVo> mainAllCategoryLists = sqlSession.selectList("category.getAllMainCategoryLists");
        System.out.println("MainCategoryLists = " + mainAllCategoryLists);
        return mainAllCategoryLists;
    }
    // 전체 MidCategory 조회
    public List<GenreMidCategoryVo> getAllMidCategoryLists(SqlSession sqlSession) throws Exception{
        System.out.println("show all MidCategory lists");
        List<GenreMidCategoryVo> midAllCategoryLists = sqlSession.selectList("category.getAllMidCategoryLists");
        System.out.println("MidCategoryLists = " + midAllCategoryLists);
        return midAllCategoryLists;
    }
    // MainCategoryBoard 조회
    public List<GenreMainCategoryVo> getMainCategoryLists(Map<String, Object> map, SqlSession sqlSession) throws Exception {
        System.out.println(map);
        List<GenreMainCategoryVo> MainCategoryLists = sqlSession.selectList("category.getMainCategoryLists", map);
        System.out.println("MainCategoryLists = " + MainCategoryLists);
        return MainCategoryLists;
    }
    // MidCategoryBoard 조회
    public List<GenreMidCategoryVo> getMidCategoryLists(Map<String, Object> map,SqlSession sqlSession) throws Exception {
        System.out.println(map);
        List<GenreMidCategoryVo> MidCategoryLists = sqlSession.selectList("category.getMidCategoryLists", map);
        System.out.println("MidCategoryLists = " + MidCategoryLists);
        return MidCategoryLists;
    }
}