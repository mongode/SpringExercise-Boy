package cn.mongode.boy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Boy {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private String name;
    
    private Integer age;
    
    private Integer hight;
    
    private Integer height;
    
    public Boy() {
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public Integer getHight() {
        return hight;
    }
    
    public void setHight(Integer hight) {
        this.hight = hight;
    }
    
    public Integer getHeight() {
        return height;
    }
    
    public void setHeight(Integer height) {
        this.height = height;
    }
    
    @Override
    public String toString() {
        return "Boy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hight=" + hight +
                ", height=" + height +
                '}';
    }
}
