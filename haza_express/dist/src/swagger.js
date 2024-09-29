"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const options = {
    swaggerDefinition: {
        openapi: '3.0.0',
        info: {
            title: 'Express Service with Swagger!',
            version: '1.0.0',
            description: 'A REST API using swagger and express.',
        },
        servers: [
            {
                url: 'http://localhost:1234',
            },
        ],
    },
    apis: [],
};
exports.default = options;
