package HAZAGroup.HAZACommunity.rest.board.service;

import HAZAGroup.HAZACommunity.rest.board.model.UserVo;
import HAZAGroup.HAZACommunity.sql.SqlSessionManager;
import HAZAGroup.HAZACommunity.sql.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);
    SqlSession sqlSession = null;

    // 유저 전체 리스트 불러오기
    public List<UserVo> getAllUser() throws Exception {
        System.out.println("userDao = " );
        try {
            UserDao userDao = new UserDao();
            System.out.println("userDao = " + userDao);
            SqlSessionManager sqlSessionManager = new SqlSessionManager();
            sqlSession = sqlSessionManager.getSqlSession();

            return  userDao.getUserList(sqlSession);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw e;
        }
    }

    public UserVo getUserToEmail(String userId) throws Exception {
        try {
            UserDao userDao = new UserDao();
            SqlSessionManager sqlSessionManager = new SqlSessionManager();
            SqlSession sqlSession = sqlSessionManager.getSqlSession();
            return userDao.getUserToEmail(sqlSession, userId);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {

        }
    }
}
