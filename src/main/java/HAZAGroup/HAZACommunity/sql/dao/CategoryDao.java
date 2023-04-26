package HAZAGroup.HAZACommunity.sql.dao;

import HAZAGroup.HAZACommunity.rest.board.model.BoardVo;
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



    // 전체 Category 조회
    public List<GenreMidCategoryVo> getAllCategoryLists(SqlSession sqlSession) throws Exception{
        System.out.println("show all lists");
        List<GenreMidCategoryVo> AllCategoryLists = sqlSession.selectList("category.getAllCategoryLists");
        System.out.println("MainCategoryLists = " + AllCategoryLists);
        return AllCategoryLists;
    }
    // MainCategoryBoard 조회
    public List<GenreMainCategoryVo> getMainCategoryLists(Map<String, Object> map, SqlSession sqlSession) throws Exception {
        System.out.println(map);
        List<GenreMainCategoryVo> MainCategoryLists = sqlSession.selectList("category.getMainCategoryLists",map);
        System.out.println("MainCategoryLists = " + MainCategoryLists);
        return MainCategoryLists;
    }
    // MidCategoryBoard 조회
    public List<GenreMidCategoryVo> getMidCategoryLists(Map<String, Object> map,SqlSession sqlSession) throws Exception{
        System.out.println(map);
        List<GenreMidCategoryVo> MidCategoryLists = sqlSession.selectList("category.getMidCategoryLists",map);
        System.out.println("MidCategoryLists = " + MidCategoryLists);
        return MidCategoryLists;
    }



}
