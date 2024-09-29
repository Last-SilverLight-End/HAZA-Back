import { BoardData } from '../model/Board';

// 게시물 서비스 함수 정의
const getBoardStatus = async (): Promise<BoardData[]> => {
  // PostgreSQL 쿼리 등을 이용해 데이터베이스에서 데이터를 가져옵니다.
  return []; // 예시로 빈 배열 반환
};

const getSpecificStatus = async (id: number): Promise<BoardData[]> => {
  // 특정 ID의 게시물 데이터를 가져옵니다.
  return []; // 예시로 빈 배열 반환
};

// 모든 함수를 객체로 내보내기
const BoardServices = {
  getBoardStatus,
  getSpecificStatus,
};

export default BoardServices;