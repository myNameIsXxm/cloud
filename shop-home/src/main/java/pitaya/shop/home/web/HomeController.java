package pitaya.shop.home.web;

import pitaya.shop.home.service.HomeService;
import pitaya.shop.model.Carousel;
import pitaya.shop.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @author xixiaoming
 * @create 2018-05-01 17:41
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @RequestMapping(method = RequestMethod.GET)
    public String home(Map<String, Object> model) {
        Category category = homeService.getCategory(1L);
        List<Carousel> carousels = homeService.getCarousels("home");
        // 楼层
        model.put("category", category);
        model.put("carousels", carousels);
        // 楼层
        return "home";
    }
}
