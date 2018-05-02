package pitaya.shop.admin.service;

import pitaya.shop.admin.service.fallback.CategoryServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pitaya.shop.model.Category;

/**
 * 分类客户端
 *
 * @author xixiaoming
 * @create 2017-02-16 17:14
 */
@FeignClient(value = "CATEGORY-SERVICE", fallback = CategoryServiceFallback.class)
public interface CategoryService {

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    Category get(@PathVariable("id") Long id);

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    Category save(@RequestParam Category category);
};
