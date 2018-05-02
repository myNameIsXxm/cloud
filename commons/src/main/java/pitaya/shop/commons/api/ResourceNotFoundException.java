package pitaya.shop.commons.api;

/**
 * 资源未找到异常
 *
 * @author xixiaoming
 * @create 2017/2/15
 */
public class ResourceNotFoundException extends RuntimeException {

    private Long resourceId;

    public ResourceNotFoundException(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Long getResourceId() {
        return this.resourceId;
    }

}
