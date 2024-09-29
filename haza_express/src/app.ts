import express, { Request, Response, NextFunction } from 'express';
import boardRouter from '../controller/BoardController';

const app = express();

app.use('/api/board', boardRouter);



app.listen('1234', () => {
    console.log(`
  ################################################
  🛡️  Server listening on port: 1234🛡️
  ################################################
`);
});