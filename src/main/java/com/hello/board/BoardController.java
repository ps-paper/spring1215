package com.hello.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @RequestMapping("/board/list")
    public String boardlist(Model model){
        model.addAttribute("list", boardService.getBoardList());

        return  "boardlist";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addpost(){
        return "addpostform";
    }

    @RequestMapping(value = "/addok", method = RequestMethod.POST)
    public String addPostOk(BoardVO vo){
        if (boardService.insertBoard(vo)==0)
            System.out.println("데이터추가실패");
        else
            System.out.println(("데이터추가성공"));
        return "redirect:/board/list";
    }

    @RequestMapping(value = "/editform/{id}", method = RequestMethod.GET)
    public String editPost(@PathVariable("id") int id, Model model){
        BoardVO boardVO = boardService.getBoardList().get(id);
        model.addAttribute("one",boardVO);
        return "editform";
    }

    @RequestMapping(value = "/editok", method = RequestMethod.POST)
    public String editPostOk(BoardVO vo){
        if (boardService.updateBoard(vo)==0)
            System.out.println("시스템수정실패");
        else
            System.out.println(("수우정완료"));
        return "redirect:/board/list";
    }

    @RequestMapping(value = "/deleteok/{id}", method = RequestMethod.GET)
    public String deletePost(@PathVariable("id") int id){
        if (boardService.deleteBoard(id)==0)
            System.out.println("데이터삭제실패");
        else
            System.out.println(("데이터삭제완료"));
        return "redirect:/board/list";
    }
}
