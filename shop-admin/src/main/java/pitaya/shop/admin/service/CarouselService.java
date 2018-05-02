package pitaya.shop.admin.service;

import pitaya.shop.model.Carousel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 轮播服务
 * @author xixiaoming
 * @create 2017-02-16 17:29
 */
@FeignClient(name = "CAROUSEL-SERVICE", fallback = CarouselService.CarouselServiceFallback.class)
@Primary
public interface CarouselService {

    @RequestMapping(value = "/carousels", method = RequestMethod.GET)
    List<Carousel> carousels(@RequestParam("usedFor") String usedFor);

    @RequestMapping(value = "/carousels/{id}", method = RequestMethod.GET)
    Carousel get(@PathVariable("id") Long id);

    @RequestMapping(value = "/carousels", method = RequestMethod.POST)
    Carousel save(@RequestBody Carousel carousel);

    @RequestMapping(value = "carousels/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable("id") Long id);

    @Component
    static class CarouselServiceFallback implements CarouselService {

        private Logger logger = LogManager.getLogger(CarouselServiceFallback.class);

        @Override
        public List<Carousel> carousels(String usedFor) {
            logger.error("CAROUSEL-SERVICE unavailable");
            return null;
        }

        @Override
        public Carousel get(Long id) {
            logger.error("CAROUSEL-SERVICE unavailable");
            return null;
        }

        @Override
        public Carousel save(Carousel carousel) {
            logger.error("CAROUSEL-SERVICE unavailable");
            return null;
        }

        @Override
        public void delete(Long id) {
            logger.error("CAROUSEL-SERVICE unavailable");
        }
    }

}
