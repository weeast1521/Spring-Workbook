package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.domain.store.repository.StoreRepository;
import umc.study.validation.annotation.ExistStore;

@Component
@RequiredArgsConstructor
public class MemberExistValidator implements ConstraintValidator<ExistStore, Long> {

    private final StoreRepository storeRepository;

    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {
        if (storeId == null) return false;
        return storeRepository.existsById(storeId); // 존재 여부만 확인
    }
}
