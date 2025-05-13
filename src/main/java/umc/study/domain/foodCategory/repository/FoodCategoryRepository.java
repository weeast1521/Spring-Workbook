package umc.study.domain.foodCategory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.foodCategory.entity.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
