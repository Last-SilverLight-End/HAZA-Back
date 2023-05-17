package HAZAGroup.HAZACommunity.rest.board.service;

import HAZAGroup.HAZACommunity.rest.board.model.UserVo;
import HAZAGroup.HAZACommunity.sql.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class UserService extends ServiceBase {
    UserService() {
        super(LoggerFactory.getLogger(UserService.class));
    }

    // 유저 전체 리스트 불러오기
    public List<UserVo> getAllUser() throws Exception {
        return get(dao -> sqlSession -> dao.getUserList(sqlSession));
    }
    public UserVo getUserToEmail(String id) throws Exception {
        return get(dao -> sqlSession -> dao.getUserToEmail(sqlSession, id));
    }

    private <T> T get(Function<UserDao, FunctionThrowsException<SqlSession, T>> fn) throws Exception {
        return getWithDao(fn, new UserDao());
    }
}