package HAZAGroup.HAZACommunity.common.response.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse extends BasicResponse{
        private String errorMessage;
        private int errorCode;

        public ErrorResponse(String errorMessage, int errorCode) {
            this.errorMessage = errorMessage;
            this.errorCode = errorCode;
        }
}
