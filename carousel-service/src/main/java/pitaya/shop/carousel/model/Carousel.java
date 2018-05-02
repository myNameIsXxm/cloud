package pitaya.shop.carousel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 轮播
 *
 * @author xixiaoming
 * @create 2017-02-16 10:20
 */
@Entity
public class Carousel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用于哪个应用
     */
    private String usedFor;

    /**
     * 排序数字
     */
    private Long orderNumber;

    /**
     * 图片url
     * 主要是获取其它域名的图片
     */
    private String pictureUrl;

    /**
     * 链接URI
     * 根据上下文拼接完整url
     */
    private String pictureUri;


    /**
     * 链接地址
     * 主要是跳到其它域名
     */
    private String hrefUrl;

    /**
     * 链接URI
     * 根据上下文拼接完整url
     */
    private String hrefUri;

    public Carousel() {
    }

    /**
     * 主要内容
     */
    private String body;

    public Carousel(Long id, String usedFor, Long orderNumber, String pictureUrl, String pictureUri, String hrefUrl, String hrefUri, String body) {
        this.id = id;
        this.usedFor = usedFor;
        this.orderNumber = orderNumber;
        this.pictureUrl = pictureUrl;
        this.pictureUri = pictureUri;
        this.hrefUrl = hrefUrl;
        this.hrefUri = hrefUri;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsedFor() {
        return usedFor;
    }

    public void setUsedFor(String usedFor) {
        this.usedFor = usedFor;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPictureUri() {
        return pictureUri;
    }

    public void setPictureUri(String pictureUri) {
        this.pictureUri = pictureUri;
    }

    public String getHrefUrl() {
        return hrefUrl;
    }

    public void setHrefUrl(String hrefUrl) {
        this.hrefUrl = hrefUrl;
    }

    public String getHrefUri() {
        return hrefUri;
    }

    public void setHrefUri(String hrefUri) {
        this.hrefUri = hrefUri;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
