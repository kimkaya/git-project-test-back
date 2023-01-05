package com.example.web.repository;

import com.example.web.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, String> {

    Optional<Board> findByPostid(Integer postid);

    Optional<Board> findByUserid(String userid);

    void deleteByUserid(String userid);
}
