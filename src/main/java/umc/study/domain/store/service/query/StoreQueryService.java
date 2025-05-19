package umc.study.domain.store.service.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umc.study.domain.review.entity.Review;
import umc.study.domain.store.entity.Store;

public interface StoreQueryService {
    Page<Review> getReviewList(Long StoreId, Integer page);
}
