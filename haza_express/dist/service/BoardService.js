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
Object.defineProperty(exports, "__esModule", { value: true });
exports.BoardService = void 0;
class BoardService {
    getBoardStatus() {
        return __awaiter(this, void 0, void 0, function* () {
            // PostgreSQL 쿼리 등을 이용해 데이터베이스에서 데이터를 가져옵니다.
            return []; // 예시로 빈 배열 반환
        });
    }
    getSpecificStatus(id) {
        return __awaiter(this, void 0, void 0, function* () {
            // 특정 ID의 게시물 데이터를 가져옵니다.
            return []; // 예시로 빈 배열 반환
        });
    }
}
exports.BoardService = BoardService;
