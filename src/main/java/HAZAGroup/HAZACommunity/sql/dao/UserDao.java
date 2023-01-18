package HAZAGroup.HAZACommunity.sql.dao;

import HAZAGroup.HAZACommunity.rest.board.model.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@Mapper
public class UserDao {
    public List<UserVo> getUserList(SqlSession sqlSession) throws Exception{
        // 지금 여기에서는 1개만 넘기지만 나중에 hashmap으로 해서 전체로 넘겨야 한다.
        return sqlSession.selectList("user.getUserList");
    }
}
