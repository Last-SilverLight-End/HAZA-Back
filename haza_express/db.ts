import { Pool } from "pg";
import dotenv from "dotenv";

dotenv.config();

// PostgreSQL 연결 설정
const pool = new Pool({
  user: process.env.PG_USER, // PostgreSQL 사용자명
  host: process.env.PG_HOST, // 호스트 (로컬일 경우 localhost)
  database: process.env.PG_DATABASE, // 데이터베이스 이름
  password: process.env.PG_PASSWORD, // 비밀번호
  port: Number(process.env.PG_PORT), // PostgreSQL 기본 포트
});

// 연결 테스트
/*pool.connect((err, client, release) => {
  if (err) {
    return console.error('Error acquiring client', err.stack);
  }
  console.log('PostgreSQL 연결 성공');
  release();
});
*/

async function testConnection() {
  const client = await pool.connect(); // 클라이언트 연결
  try {
    console.log("PostgreSQL 연결 성공");

    // 여기서 쿼리 실행 (예: 모든 게시물 조회)
    const result = await client.query("SELECT * FROM tb_board");
    console.log("게시물:", result.rows);
  } catch (err) {
    console.error("쿼리 실행 중 오류 발생:", err);
  } finally {
    client.release(); // 클라이언트 반환 (연결 종료)
    console.log("클라이언트 연결 종료");
  }
}
// 연결 테스트 실행
testConnection().catch((err) => console.error("연결 중 오류 발생:", err.stack));

export default pool;
