package HAZAGroup.HAZACommunity.sql.dao;

import HAZAGroup.HAZACommunity.rest.board.model.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@Mapper
public class UserDao {
    public List<UserVo> getUserList(SqlSession sqlSession) throws Exception {
        List<UserVo> AllUserLists = sqlSession.selectList("user.getAllUserLists");
        return AllUserLists;
    }

    public UserVo getUserToEmail(SqlSession sqlSession, String id) throws Exception {
        return sqlSession.selectOne("user.getUserToEmail", id);
    }
}
