import express, { Request, Response } from 'express';
import BoardServices from '../service/BoardService'; 
import { BoardData } from '../model/Board';

const boardRouter = express.Router();

// GET /api/boards
boardRouter.get('/', async (req: Request, res: Response) => {
  try {
    const boardList: BoardData[] = await BoardServices.getBoardStatus(); 
    return res.status(200).json({
      status: 200,
      data: boardList,
    });
  } catch (error) {
    console.error('Error fetching board list:', error);
    return res.status(500).json({
      message: '조회 실패',
      status: 500,
    });
  }
});

// GET /api/boards/specific?id=3


boardRouter.get('/specific', async (req: Request, res: Response) => {
  const { id } = req.query;

  if (!id) {
    return res.status(400).json({
      message: 'ID가 필요합니다.',
      status: 400,
    });
  }

  try {
    const boardList: BoardData[] = await BoardServices.getSpecificStatus(Number(id)); // 인스턴스화 없이 사용
    return res.status(200).json({
      status: 200,
      data: boardList,
    });
  } catch (error) {
    console.error('Error fetching specific board info:', error);
    return res.status(500).json({
      message: '게시판 상세내용 확인 실패',
      status: 500,
    });
  }
});

export default boardRouter;
