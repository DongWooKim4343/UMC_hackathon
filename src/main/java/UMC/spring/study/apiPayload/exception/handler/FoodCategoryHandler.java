package UMC.spring.study.apiPayload.exception.handler;

import UMC.spring.study.apiPayload.code.BaseErrorCode;
import UMC.spring.study.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
