package pitaya.shop.category.service.impl;

import pitaya.shop.category.model.Category;
import pitaya.shop.category.repository.CategoryRepository;
import pitaya.shop.category.service.CategoryService;
import pitaya.shop.commons.api.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xixiaoming
 * @create 2017/2/15
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category findOne(Long id) {
        Category category = categoryRepository.findOne(id);
        if (category == null)
            throw new ResourceNotFoundException(id);
        return category;
    }

    @Override
    public List<Category> findByLevelAndName(Integer level, String name) {
        return categoryRepository.findByLevelAndName(level, name);
    }

//    @Override
//    public List<Category> findByParentId(Long parentId) {
//        return categoryRepository.findByParentId(parentId);
//    }
//
//    @Override
//    public List<Category> findByLevel(Integer level) {
//        return categoryRepository.findByLevel(level);
//    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }
}
