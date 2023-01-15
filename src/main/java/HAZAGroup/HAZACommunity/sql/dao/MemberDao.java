package HAZAGroup.HAZACommunity.sql.dao;

import HAZAGroup.HAZACommunity.rest.board.vo.MemberVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@Mapper
public class MemberDao {
    public List<MemberVo> getMemberList(SqlSession sqlSession) throws Exception{
        return sqlSession.selectList("member.getMemberList");
    }
}
