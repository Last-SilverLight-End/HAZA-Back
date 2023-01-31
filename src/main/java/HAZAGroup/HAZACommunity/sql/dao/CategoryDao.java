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




    // MainCategoryBoard 조회
    public List<GenreMainCategoryVo> getMainCategoryLists( SqlSession sqlSession) throws Exception {

        List<GenreMainCategoryVo> MainCategoryLists = sqlSession.selectList("category.getMainCategoryLists");
        return MainCategoryLists;
    }
    // MidCategoryBoard 조회
    public List<GenreMidCategoryVo> getMidCategoryLists(Map<String, Object> map,SqlSession sqlSession) throws Exception{
        System.out.println(map);
        List<GenreMidCategoryVo> MidCategoryLists = sqlSession.selectList("category.getMidCategoryLists",map);
        System.out.println(MidCategoryLists);
        return MidCategoryLists;
    }

}
