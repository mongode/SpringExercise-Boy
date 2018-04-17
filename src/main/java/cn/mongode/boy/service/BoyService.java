package cn.mongode.boy.service;

import cn.mongode.boy.domain.Boy;
import cn.mongode.boy.enums.ResultEnum;
import cn.mongode.boy.exception.BoyException;
import cn.mongode.boy.repository.BoyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class BoyService {
    
    @Autowired
    private BoyRepository boyRepository;
    
    /**
     * 测试事务 - 确保两个操作同时执行成功，否则回滚。
     */
    @Transactional
    public void addTwo() {
        Boy boyA = new Boy();
        boyA.setAge(boyA.getAge());
        boyA.setHeight(boyA.getHeight());
        boyA.setHight(boyA.getHight());
        boyA.setName(boyA.getName());
        boyRepository.save(boyA);
    
        Boy boyB = new Boy();
        boyB.setAge(boyB.getAge());
        boyB.setHeight(boyB.getHeight());
        boyB.setHight(boyB.getHight());
        boyB.setName(boyB.getName());
        boyRepository.save(boyB);
    }
    
    /**
     * 根据id查询boy信息
     * @param id
     * @return
     */
    public Boy boyFindOne(Integer id) throws Exception{
        Boy boy = boyRepository.findById(id).get();
        Integer age = boy.getAge();
        if (age < 10) {
            throw new BoyException(ResultEnum.AGE_TOO_SMALL);
        } else if (age >= 10 && age < 18) {
            throw new BoyException(ResultEnum.AGE_TOO_BIG);
        }
        return boy;
    }
    
    /**
     * 根据id获取boy的年龄
     * @param id
     * @return
     */
    public Integer getAge(Integer id) throws Exception {
        Integer age = boyRepository.findById(id).get().getAge();
        if (age < 10) {
            throw new BoyException(ResultEnum.AGE_TOO_SMALL);
        } else if (age >= 10 && age < 18) {
            throw new BoyException(ResultEnum.AGE_TOO_BIG);
        }
        return age;
    }
    
}
