package HAZAGroup.HAZACommunity.rest.board.service;

import HAZAGroup.HAZACommunity.sql.SqlSessionManager;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;

import java.util.function.Function;

public abstract class ServiceBase {
    Logger logger;
    ServiceBase(Logger logger) {
        this.logger = logger;
    }
    protected <D, T> T getWithDao(Function<D, FunctionThrowsException<SqlSession, T>> fn, D dao) throws Exception {
        try (SqlSession sqlSession = new SqlSessionManager().getSqlSession()) {
            return fn.apply(dao).apply(sqlSession);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw e;
        }
    }
}