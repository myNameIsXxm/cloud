package pitaya.shop.carousel.api;

import pitaya.shop.carousel.model.Carousel;
import pitaya.shop.carousel.service.CarouselService;
import pitaya.shop.commons.api.Error;
import pitaya.shop.commons.api.ResourceNotFoundException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * 轮播服务API
 *
 * @author xixiaoming
 * @create 2017-02-16 10:41
 */
@RestController
@RequestMapping("/carousels")
public class CarouselController {

    private final Logger logger = LogManager.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private CarouselService carouselService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Carousel get(@PathVariable Long id) {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/carousels, method: get, host:" + instance.getHost() + ", serviceId:" + instance.getServiceId() + ",carousel: " + id);
        Carousel carousel = carouselService.findOne(id);
        return carousel;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Carousel> save(@RequestBody Carousel carousel, UriComponentsBuilder ucb) {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/carousel, method: get, host: " + instance.getHost() + ", serviceId: " + instance.getServiceId() + "usedFor: " + carousel.getUsedFor());

        Carousel saved = carouselService.save(carousel);

        HttpHeaders headers = new HttpHeaders();
        URI locationUri = ucb.path("/carousel")
                .path(String.valueOf(carousel.getId()))
                .build()
                .toUri();
        headers.setLocation(locationUri);

        ResponseEntity<Carousel> responseEntity = new ResponseEntity<>(saved, headers, HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/carousels, method: delete, host:" + instance.getHost() + ", serviceId:" + instance.getServiceId() + ",carousel: " + id);
        carouselService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Carousel> carousels(@RequestParam(value = "usedFor", defaultValue = "home") String usedFor) {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/carousel, get, host:" + instance.getHost() + ", serviceId:" + instance.getServiceId() + ",usedFor: " + usedFor);
        List<Carousel> carousels = carouselService.findByUsedFor(usedFor);
        return carousels;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error resourceNotFound(ResourceNotFoundException e) {
        Long resourceId = e.getResourceId();
        return new Error(4, "Carousel [" + resourceId + "] not found");
    }
}
