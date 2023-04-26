package HAZAGroup.HAZACommunity.rest.board.controller;

import HAZAGroup.HAZACommunity.common.response.model.BasicResponse;
import HAZAGroup.HAZACommunity.common.response.model.CommonResponse;
import HAZAGroup.HAZACommunity.common.response.model.ErrorResponse;
import HAZAGroup.HAZACommunity.rest.board.model.GenreMainCategoryVo;
import HAZAGroup.HAZACommunity.rest.board.model.GenreMidCategoryVo;
import HAZAGroup.HAZACommunity.rest.board.service.CategoryService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Mapper
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*", allowedHeaders = "*")


public class CategoryController {


    private final CategoryService categoryService;

    // 필드 인젝션 주입 방지
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //전체 Category 출력
    //http://localhost:8080/api/categories/all
    @RequestMapping(value ="/all" , method = RequestMethod.GET, produces = "application/json;charset=UTF-8")

    public @ResponseBody
    ResponseEntity<BasicResponse> getAllCategories() throws Exception{
        CommonResponse<List<GenreMidCategoryVo>> commonResponse;

        try{
            commonResponse = new CommonResponse<>(categoryService.getAllCategory());
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

    //http://localhost:8080/api/categories?main=Movie&sub=Horror
    @RequestMapping( method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
        public @ResponseBody
        ResponseEntity<BasicResponse> getAllGenres(@RequestParam(value = "main") String main,@RequestParam(value = "sub") String sub) throws Exception{
        Map<String,Object> map = new HashMap<String,Object>();

        main = "Movie"; sub = "Horror";

        map.put("main",main);
        map.put("sub",sub);
        CommonResponse<List<GenreMidCategoryVo>> commonResponse;

        try{
            commonResponse = new CommonResponse<>(categoryService.getMidCategoryStatus(map));
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

    //http://localhost:8080/api/categories?main=Movie

    @RequestMapping(method = RequestMethod.GET, produces = "application/json;charset=UTF-8" )
        public @ResponseBody
        ResponseEntity<BasicResponse> getMainGenres(@RequestParam(value = "main") String main) throws Exception{
            Map<String,Object> map = new HashMap<String,Object>();
            main = "Movie";
            map.put("main",main);
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
