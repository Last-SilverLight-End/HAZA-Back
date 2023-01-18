package HAZAGroup.HAZACommunity.rest.board.service;

import HAZAGroup.HAZACommunity.rest.board.model.UserVo;
import HAZAGroup.HAZACommunity.sql.SqlSessionManager;
import HAZAGroup.HAZACommunity.sql.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service

public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserVo getUserSample() throws Exception {
        try {
            UserDao userDao = new UserDao();
            SqlSessionManager sqlSessionManager = new SqlSessionManager();
            SqlSession sqlSession = sqlSessionManager.getSqlSession();
            return userDao.getUserList(sqlSession).get(0);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            throw e;
        }
    }
}
