package HAZAGroup.HAZACommunity.rest.board.controller;

import HAZAGroup.HAZACommunity.common.response.model.BasicResponse;
import HAZAGroup.HAZACommunity.common.response.model.CommonResponse;
import HAZAGroup.HAZACommunity.common.response.model.ErrorResponse;
import HAZAGroup.HAZACommunity.rest.board.model.GenreMainCategoryVo;
import HAZAGroup.HAZACommunity.rest.board.service.CategoryService;
import org.apache.catalina.connector.Response;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Mapper
@RequestMapping("/api/boards")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/", produces = "application/json;charset=UTF-8" )
    public ResponseEntity<BasicResponse> getAllGenres(String main, String sub) throws Exception{
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("main",main);
        map.put("sub",sub);
        CommonResponse<List<GenreMainCategoryVo>> commonResponse;
        try{

            commonResponse = new CommonResponse<>(categoryService.getMainCategoryStatus(map));
            commonResponse.setStatus(200);

            return ResponseEntity.ok().body(commonResponse);
        }
        catch (Exception e){
            return ResponseEntity.internalServerError()
                    .body(
                            new ErrorResponse("조회 실패",HttpStatus.INTERNAL_SERVER_ERROR.value())
                    );
        }
    }

}
