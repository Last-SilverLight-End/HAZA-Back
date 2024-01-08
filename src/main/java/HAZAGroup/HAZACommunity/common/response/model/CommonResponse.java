package HAZAGroup.HAZACommunity.common.response.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CommonResponse<T> extends BasicResponse {
    private int count;
    private int status;
    private T data;

    public CommonResponse(T data) {
        this.data = data;

        System.out.println("data = " + data + " data type = " + data.getClass().getName());
        if (data instanceof ArrayList) {
            this.count = ((ArrayList<?>)data).size();
        } else if (data instanceof List) {
            this.count = ((List<?>)data).size();
        } else if (data instanceof Integer) {
            this.count = (int) data;
        } else {
            this.count = 1;
        }
    }

    public void setStatus(int status) {
        this.status = status;
    }
}