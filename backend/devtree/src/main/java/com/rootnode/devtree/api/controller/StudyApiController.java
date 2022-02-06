package com.rootnode.devtree.api.controller;

import com.rootnode.devtree.api.request.StudyCreateRequestDto;
import com.rootnode.devtree.api.request.StudyJoinRequestDto;
import com.rootnode.devtree.api.request.StudyRespondRequestDto;
import com.rootnode.devtree.api.request.StudyUpdateRequestDto;
import com.rootnode.devtree.api.response.CommonResponseDto;
import com.rootnode.devtree.api.response.StudyCreateResponseDto;
import com.rootnode.devtree.api.response.StudyDetailResponseDto;
import com.rootnode.devtree.api.response.StudyListResponseDto;
import com.rootnode.devtree.api.service.StudyService;
import com.rootnode.devtree.db.entity.TeamType;
import com.rootnode.devtree.db.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudyApiController {
    private final StudyService studyService;

    /**
     *  기능 : 스터디 생성
     */
    @PostMapping("/v1/study")
    public ResponseEntity<StudyCreateResponseDto> studyCreate(@RequestBody StudyCreateRequestDto requestDto) {
        StudyCreateResponseDto responseDto = new StudyCreateResponseDto(studyService.save(requestDto));

        return ResponseEntity.status(201).body(responseDto);
    }

    /**
     * 기능 : 스터디 리스트 조회
     */
    @GetMapping("/v1/study")
    public ResponseEntity<Result> studyList() {
        List<StudyListResponseDto> responseDto = studyService.findStudy(TeamType.STUDY);
        return ResponseEntity
                .status(200)
                .body(new Result(responseDto));
    }


    /**
     * 기능 : 스터디 상세 조회
     */
    @GetMapping("/v1/study/{team_seq}")
    public ResponseEntity<Result> studyDetail(@PathVariable Long team_seq) {
        StudyDetailResponseDto responseDto = studyService.findStudyDetail(team_seq);
        return ResponseEntity
                .status(200)
                .body(new Result(responseDto));
    }

    /**
     * 기능 : 스터디 신청
     */
    @PostMapping("/v1/study/{team_seq}")
    public ResponseEntity<CommonResponseDto> studyJoin(@PathVariable Long team_seq, @RequestBody StudyJoinRequestDto requestDto) {
        System.out.println("user_seq >>> " + requestDto.getUserSeq());
        return ResponseEntity
                .status(200)
                .body(studyService.joinStudy(team_seq, requestDto));
    }

    /**
     * 기능 : 스터디 신청 응답
     */
    @PostMapping("/v1/study/join/{team_seq}/{user_seq}")
    public ResponseEntity<CommonResponseDto> studyJoinResponse(@PathVariable Long team_seq,
                                                               @PathVariable Long user_seq,
                                                               @RequestBody StudyRespondRequestDto requestDto) {
        return ResponseEntity
                .status(201)
                .body(studyService.respondStudy(team_seq, user_seq, requestDto));
    }

    /**
     * 기능 : 스터디 신청 조회
     */


    /**
     * 기능 : 스터디 정보 수정
     */
    @PutMapping("/v1/study/{team_seq}")
    public ResponseEntity<CommonResponseDto> studyDetailUpdate(@PathVariable Long team_seq,
                                                               @RequestBody StudyUpdateRequestDto requestDto) {
        return ResponseEntity
                .status(201)
                .body(studyService.updateStudy(team_seq, requestDto));
    }

    /**
     * 기능 : 스터디 삭제
     */

    /**
     * List를 한번 감싸서 보내기 위하여 만든 클래스
     */
    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }
}
