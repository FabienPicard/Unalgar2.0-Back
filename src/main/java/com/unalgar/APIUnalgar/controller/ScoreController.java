package com.unalgar.APIUnalgar.controller;

import com.unalgar.APIUnalgar.entity.Score;
import com.unalgar.APIUnalgar.payload.AddScoreRequest;
import com.unalgar.APIUnalgar.payload.GetTopScoreRequest;
import com.unalgar.APIUnalgar.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/score/")
public class ScoreController {

    @Autowired
    private ScoreRepository scoreRepository;

    @PostMapping("addScore")
    public ResponseEntity<?> addScore(@Valid @RequestBody AddScoreRequest addScoreRequest){
        try {

            Score score = new Score();
            score.setName(addScoreRequest.getScore().getName());
            score.setScore(addScoreRequest.getScore().getScore());
            score.setCardType(addScoreRequest.getScore().getCardType());
            scoreRepository.save(score);
            return ResponseEntity.ok().body(score);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("getTopScore")
    public ResponseEntity<?>getTopScore(@Valid @RequestBody GetTopScoreRequest getTopScoreRequest){
        try {

            List<Score>scoreList = scoreRepository.findTop3ByCardTypeOrderByScoreDesc(getTopScoreRequest.getCardType());
            return ResponseEntity.ok().body(scoreList);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
