package com.eministerios.www.business.validation;

import com.eministerios.www.business.entity.domain.Worker;
import com.eministerios.www.business.util.ConstMessagesPT;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by alexandre on 21/03/16.
 */
@Component
public class WorkerValidator extends ValidationSupport implements Validator<Worker> {

    @Override
    public Optional<ValidationError> validate(Worker worker) {
        if (isNullOrEmptyString(worker.getName()) ||
                isNullOrEmptyString(worker.getLastname()) ||
                isNullOrEmptyString(worker.getAddress()) ||
                isNullOrEmptyString(worker.getEmail1()) ||
                isNullOrEmptyString(worker.getEmail2()) ||
                /*isNullOrEmptyString(worker.getPhone1()) ||*/
                isNullOrEmptyString(worker.getPhone2()) ||
                isNullOrEmptyString(worker.getProfession()) ||
                isNullOrEmptyString(worker.getDescription()))
                {
            return Optional.of(new ValidationError(ConstMessagesPT.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }

        return Optional.empty();
    }

}
