package pitaya.shop.model;

import java.io.Serializable;
import java.util.List;

/**
 * 分类
 *
 * @author xixiaoming
 * @create 2018-05-01 14:41
 */
public class Category implements Serializable {

    private Long id;

    /**
     * 分类层级，从0开始
     */
    private Integer level;

    private Long parentId;

    private List<Category> childs;

    /**
     * 分类名字
     */
    private String name;

    /**
     * 排序数字
     */
    private Long orderNumber;

    public Category() {
    }

    public Category(Long id, Integer level, Long parentId, List<Category> childs, String name, Long orderNumber) {
        this.id = id;
        this.level = level;
        this.parentId = parentId;
        this.childs = childs;
        this.name = name;
        this.orderNumber = orderNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<Category> getChilds() {
        return childs;
    }

    public void setChilds(List<Category> childs) {
        this.childs = childs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", level=" + level +
                ", parentId=" + parentId +
                ", childs=" + childs +
                ", name='" + name + '\'' +
                ", orderNumber=" + orderNumber +
                '}';
    }
}
