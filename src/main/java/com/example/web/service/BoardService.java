package com.example.web.service;

import com.example.web.entity.Board;
import com.example.web.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;

    public void writeBoard(Board board) throws Exception {
        boardRepository.save(board);
    }
    public void writeBoard2(Board board) throws Exception {
        boardRepository.save(board);
    }
    public void writeBoard3(Board board) throws Exception {
        boardRepository.save(board);
    }

    public void Boardview(Integer postid, String subject, String content) throws Exception {
        Optional<Board> oboard = boardRepository.findByPostid(postid);
        if(oboard.isEmpty()) throw new Exception("글 조회 오류");
        Board board = oboard.get();
        board.setSubject(subject);
        board.setContent(content);
        boardRepository.save(board);
    }

    public Integer deleteBoard(Integer postid,String userid) throws Exception {
        Optional<Board> oboard = boardRepository.findByPostid(postid);
        boardRepository.findByUserid(userid);
        if(oboard.isEmpty()) return -1;
        Board board = oboard.get();
        boardRepository.deleteByUserid(userid);
        return 0;
    }
}

