package HAZAGroup.HAZACommunity.sql;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class SqlSessionManager {
    public static final String RESOURCE = "sql/mybatis-config.xml";
    private static final Logger logger = LoggerFactory.getLogger(SqlSessionManager.class);

    public SqlSession getSqlSession() throws Exception {
        SqlSession sqlSession = null;
        try {
            InputStream is = Resources.getResourceAsStream(RESOURCE);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession(true);
            // openSession 이라는메소드는 세션을 가져오는 메소드
            // 세션을 생성하고 가져올때,
            // 인자 값 true 혹은 빈 인자값 : AutoCommit이 활성화된 상태
            // 인자 값 false: AutoCommit을 비활성화된 상태
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return sqlSession;
    }
}