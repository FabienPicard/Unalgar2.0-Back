package com.unalgar.APIUnalgar.payload;

import com.unalgar.APIUnalgar.entity.Score;

public class AddScoreRequest {

   private Score score;

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
