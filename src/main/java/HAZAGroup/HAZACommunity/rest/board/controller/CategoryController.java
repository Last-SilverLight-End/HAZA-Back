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
@CrossOrigin(origins = "http://localhost:3000/", allowedHeaders = "*")
public class CategoryController {
    private final CategoryService categoryService;

    // 필드 인젝션 주입 방지
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    /**
     * 전체 main Category 출력
     * //http://localhost:8080/api/categories/mainAll
     */
    @RequestMapping(value = "/mainAll", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody ResponseEntity<BasicResponse> getAllMainCategories() throws Exception {
        try {
            CommonResponse<List<GenreMainCategoryVo>> commonResponse = new CommonResponse<>(categoryService.getAllMainCategory());
            commonResponse.setStatus(200);
            return ResponseEntity.ok().body(commonResponse);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError()
                .body(new ErrorResponse("조회 실패",HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }

    /**
     * 전체 mid Category 출력
     * http://localhost:8080/api/categories/midAll
     */
    @RequestMapping(value = "/midAll", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody ResponseEntity<BasicResponse> getAllMidCategories() throws Exception {
        try {
            CommonResponse<List<GenreMidCategoryVo>> commonResponse = new CommonResponse<>(categoryService.getAllMidCategory());
            commonResponse.setStatus(200);
            return ResponseEntity.ok().body(commonResponse);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError()
                .body(new ErrorResponse("조회 실패",HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    // required false 일 경우 null로 반환되는걸 이용한다.
    public @ResponseBody ResponseEntity<BasicResponse> getAllGenres(
        @RequestParam("mainCategoryId") Integer mainCategoryId,
        @RequestParam(value = "midCategoryId", required = false) Integer midCategoryId
    ) throws Exception {
        Map<String, Object> map = new HashMap<>();
        System.out.println("mainCategoryId = " + mainCategoryId);
        System.out.println("midCategoryId = " + midCategoryId);
        map.put("mainCategoryId", mainCategoryId);
        map.put("midCategoryId", midCategoryId);

        /** 상세 세부 정보 찾기
         * http://localhost:8080/api/categories?mainCategoryId=1&midCategoryId=1
         * */

        if (midCategoryId == null) {
            CommonResponse<List<GenreMainCategoryVo>> commonResponse;
            try {
                commonResponse = new CommonResponse<>(categoryService.getMainCategoryStatus(map));
                commonResponse.setStatus(200);
                return ResponseEntity.ok().body(commonResponse);
            }
            catch (Exception e) {
                return ResponseEntity.internalServerError()
                    .body(new ErrorResponse("조회 실패", HttpStatus.INTERNAL_SERVER_ERROR.value()));
            }
        }
        //http://localhost:8080/api/categories?main=Movie
        else{
            try{
                CommonResponse<List<GenreMidCategoryVo>> commonResponse = new CommonResponse<>(categoryService.getMidCategoryStatus(map));
                commonResponse.setStatus(200);
                return ResponseEntity.ok().body(commonResponse);
            }

            catch (Exception e){
                return ResponseEntity.internalServerError()
                    .body(new ErrorResponse("조회 실패",HttpStatus.INTERNAL_SERVER_ERROR.value()));
            }
        }
    }
}