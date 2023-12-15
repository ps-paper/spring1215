package com.hello.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BoardService {
    @Autowired
    BoardDAO boardDAO;
    public List<BoardVO> getBoardList(){ return boardDAO.getBoardList(); }

    public int insertBoard(BoardVO vo){
        return boardDAO.insertBoard(vo);
    }
    public int deleteBoard(int seq){
        return boardDAO.deleteBoard(seq);
    }
    public int updateBoard(BoardVO vo){
        return boardDAO.updateBoard(vo);
    }
}
