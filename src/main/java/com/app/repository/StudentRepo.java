package com.app.repository;

import com.app.VO.StudentVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<StudentVO,Long> {
}
