package pitaya.shop.carousel.service;

import pitaya.shop.carousel.model.Carousel;

import java.util.List;

/**
 * 轮播服务接口
 *
 * @author xixiaoming
 * @create 2017-02-16 10:16
 */
public interface CarouselService {

    List<Carousel> findByUsedFor(String usedFor);

    Carousel findOne(Long id);

    Carousel save(Carousel carousel);

    void delete(Long id);

}
