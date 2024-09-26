package HAZAGroup.HAZACommunity.rest.board.service;

interface FunctionThrowsException<T, R> {
    R apply(T arg) throws Exception;
}