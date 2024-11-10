"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const pg_1 = require("pg");
const dotenv_1 = __importDefault(require("dotenv"));
dotenv_1.default.config();
// PostgreSQL 연결 설정
const pool = new pg_1.Pool({
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
function testConnection() {
    return __awaiter(this, void 0, void 0, function* () {
        const client = yield pool.connect(); // 클라이언트 연결
        try {
            console.log("PostgreSQL 연결 성공");
            // 여기서 쿼리 실행 (예: 모든 게시물 조회)
            const result = yield client.query("SELECT * FROM tb_board");
            console.log("게시물:", result.rows);
        }
        catch (err) {
            console.error("쿼리 실행 중 오류 발생:", err);
        }
        finally {
            client.release(); // 클라이언트 반환 (연결 종료)
            console.log("클라이언트 연결 종료");
        }
    });
}
// 연결 테스트 실행
testConnection().catch((err) => console.error("연결 중 오류 발생:", err.stack));
exports.default = pool;
