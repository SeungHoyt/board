package com.study.board.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController{

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write")//어떤 url로 접근할건지에 대해 지정해주는 어노테이션 (localhost:8080/board/write 접속)
    public String boardWriteForm(){

        return "boardwrite"; //boardwrite로 보내줌 (어떤 뷰 파일로 보내줄지)
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board){

        boardService.write(board);

        return "";
    }

    @GetMapping("/board/list")
    public String boardList(Model model){

        model.addAttribute("list",boardService.boardList());
        return "boardlist";
    }

}