"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = __importDefault(require("express"));
const BoardController_1 = __importDefault(require("../controller/BoardController"));
const app = (0, express_1.default)();
app.use('/api', BoardController_1.default);
app.listen('1234', () => {
    console.log(`
  ################################################
  🛡️  Server listening on port: 1234🛡️
  ################################################
`);
});
