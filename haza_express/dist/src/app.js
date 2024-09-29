"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = __importDefault(require("express"));
const BoardController_1 = __importDefault(require("../controller/BoardController"));
const swagger_ui_express_1 = __importDefault(require("swagger-ui-express"));
const swagger_jsdoc_1 = __importDefault(require("swagger-jsdoc"));
const swagger_1 = __importDefault(require("./swagger")); // .js 확장자 사용
const child_process_1 = require("child_process");
const specs = (0, swagger_jsdoc_1.default)(swagger_1.default);
const app = (0, express_1.default)();
app.use('/api/board', BoardController_1.default);
app.use('/swagger', swagger_ui_express_1.default.serve, swagger_ui_express_1.default.setup(specs, { explorer: true }));
app.listen(1234, () => {
    console.log(`
    ################################################
    🛡️  Server listening on port: 1234 🛡️
    ################################################
  `);
    (0, child_process_1.exec)("explorer http://localhost:1234/swagger");
});
