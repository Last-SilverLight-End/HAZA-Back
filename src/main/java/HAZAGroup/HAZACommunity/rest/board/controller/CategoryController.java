package HAZAGroup.HAZACommunity.rest.board.controller;

import HAZAGroup.HAZACommunity.common.response.model.BasicResponse;
import HAZAGroup.HAZACommunity.common.response.model.CommonResponse;
import HAZAGroup.HAZACommunity.common.response.model.ErrorResponse;
import HAZAGroup.HAZACommunity.rest.board.model.GenreMainCategoryVo;
import HAZAGroup.HAZACommunity.rest.board.model.GenreMidCategoryVo;
import HAZAGroup.HAZACommunity.rest.board.service.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.connector.Response;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.HandlerMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Mapper
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //http://localhost:8080/api/category?main=Movie&sub=Horror
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json;charset=UTF-8" )
//    public ResponseEntity<BasicResponse> getAllGenres(HttpSession session, HttpServletRequest request, ModelMap modelMap) throws Exception{
//        String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
//        Map<String, Object> map = new HashMap<String, Object>();
        public @ResponseBody
        ResponseEntity<BasicResponse> getAllGenres(@RequestParam String main,@RequestParam String sub) throws Exception{
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

}
