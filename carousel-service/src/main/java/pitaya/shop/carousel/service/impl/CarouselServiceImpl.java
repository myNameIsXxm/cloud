package pitaya.shop.carousel.service.impl;

import pitaya.shop.carousel.data.CarouselRepository;
import pitaya.shop.carousel.model.Carousel;
import pitaya.shop.carousel.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 轮播服务Spring Data JPA实现
 *
 * @author xixiaoming
 * @create 2017-02-16 10:40
 */
@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselRepository carouselRepository;

    @Override
    public List<Carousel> findByUsedFor(String usedFor) {
        return carouselRepository.findByUsedFor(usedFor);
    }

    @Override
    public Carousel findOne(Long id) {
        return carouselRepository.findOne(id);
    }

    @Override
    public Carousel save(Carousel carousel) {
        return carouselRepository.save(carousel);
    }

    @Override
    public void delete(Long id) {
        carouselRepository.delete(id);
    }
}
