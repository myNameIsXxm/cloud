package pitaya.shop.carousel.data;

import pitaya.shop.carousel.model.Carousel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 轮播服务数据访问
 *
 * @author xixiaoming
 * @create 2017-02-16 10:42
 */
@Repository
public interface CarouselRepository extends JpaRepository<Carousel, Long> {

    List<Carousel> findByUsedFor(String usedFor);

    Carousel save(Carousel carousel);
}
