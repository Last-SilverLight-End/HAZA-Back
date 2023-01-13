package HAZAGroup.HAZACommunity.common.response.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CommonResponse<T> extends BasicResponse {
    private int count;
    private int status;
    private T data;


    public CommonResponse(T data) {
        this.data = data;
        if(data instanceof List) {
            this.count = ((List<?>)data).size();
        } else {
            this.count = 1;
        }
    }
}
