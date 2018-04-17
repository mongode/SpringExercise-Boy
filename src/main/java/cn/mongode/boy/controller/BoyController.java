package cn.mongode.boy.controller;

import cn.mongode.boy.domain.Boy;
import cn.mongode.boy.repository.BoyRepository;
import cn.mongode.boy.service.BoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoyController {
    
    @Autowired
    private BoyRepository boyRepository;
    
    @Autowired
    private BoyService boyService;
    
    /**
     * 查询所有的boy
     * @return
     */
    @GetMapping(value = "/boys")
    public List<Boy> boyList() {
        return boyRepository.findAll();
    }
    
    /**
     * 新增boy信息
     * @param name
     * @param age
     * @param hight
     * @param height
     * @return
     */
    @PostMapping(value = "/boys")
    public Boy boyAdd(@RequestParam("name") String name,
                      @RequestParam("age") Integer age,
                      @RequestParam("hight") Integer hight,
                      @RequestParam("height") Integer height) {
        Boy boy = new Boy();
        boy.setName(name);
        boy.setAge(age);
        boy.setHight(hight);
        boy.setHeight(height);
        return boyRepository.save(boy);
    }
    
    /**
     * 根据id删除boy信息
     * @param id
     */
    @DeleteMapping(value = "/boys/{id}")
    public void boyDelete(@PathVariable("id") Integer id) {
        boyRepository.deleteById(id);
    }
    
    /**
     * 根据id修改boy信息
     * @param id
     * @param name
     * @param age
     * @param hight
     * @param height
     * @return
     */
    @PutMapping(value = "/boys/{id}")
    public Boy boyUpdate(@PathVariable("id") Integer id,
                          @RequestParam("name") String name,
                          @RequestParam("age") Integer age,
                          @RequestParam("hight") Integer hight,
                          @RequestParam("height") Integer height) {
        Boy boy = new Boy();
//        boy = boyRepository.findById(id);
        boy.setId(id);
        boy.setName(name);
        boy.setAge(age);
        boy.setHeight(height);
        boy.setHight(hight);
        return boyRepository.save(boy);
    }
    
    /**
     * 根据id查询boy信息
     * @param id
     * @return
     */
    @GetMapping(value = "/boys/{id}")
    public Boy boyFindById(@PathVariable("id") Integer id) throws Exception{
//        return boyRepository.findById(id).get();
        return boyService.boyFindOne(id);
    }
    
    @PostMapping(value = "/boys/trans")
    public void boyTransAddTwo() {
        boyService.addTwo();
    }
    
    /**
     * 根据age查询boy信息列表(方法名只能是findByAge)
     * @param age
     * @return
     */
    @GetMapping(value = "/boys/age/{age}")
    public List<Boy> boyListByAge(@PathVariable("age") Integer age) {
        return boyRepository.findByAge(age);
    }
    
    @GetMapping(value = "/boys/getage/{id}")
    public Integer getAgeById(@PathVariable("id") Integer id) throws Exception {
        return boyService.getAge(id);
    }

}
