package cn.mongode.boy.repository;

import cn.mongode.boy.domain.Boy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoyRepository extends JpaRepository<Boy, Integer> {
    
    public List<Boy> findByAge(Integer age);
}
