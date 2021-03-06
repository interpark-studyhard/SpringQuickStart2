package com.interpark.sts.board.client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.interpark.sts.board.service.BoardService;
import com.interpark.sts.board.vo.BoardVO;

/**
 * Created by 최지혜 on 2017-07-31.
 */
public class BoardServiceClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(BoardServiceClient.class);

    public static void main(String[] args) {

        // 1. Spring container 를 구동한다
        AbstractApplicationContext container = new GenericXmlApplicationContext("application-context.xml");

        // 2. Spring container로부터 boardServiceImpl lookup
        BoardService boardService = (BoardService) container.getBean("boardService");

        // 3. 글 등록 테스트
        BoardVO vo = new BoardVO();
//        vo.setSeq(0);
        vo.setTitle("What the hell..");
        vo.setWriter("Yuna");
        vo.setContent(" . ..... 냉무  ,.... 예뻐 . . .ㅋ");
 
//        boardService.insertBoard(vo);

        // 4. 글 목록 검색 기능 테스트
        List<BoardVO> boardList = boardService.getBoardList(vo);
        for(BoardVO vos : boardList) {
            LOGGER.info(" board :: {} ", vos.toString());
        }

        // 5. container 종료
        container.close();
    }
}
