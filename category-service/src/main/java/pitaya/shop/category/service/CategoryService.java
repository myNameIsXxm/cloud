package pitaya.shop.category.service;

import pitaya.shop.category.model.Category;

import java.util.List;

/**
 * @author xixiaoming
 * @create 2017/2/15
 */
public interface CategoryService {

    Category findOne(Long id);

    List<Category>  findByLevelAndName(Integer level, String name);

    Category save(Category category);
}
