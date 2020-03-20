package com.tianhy.javabase.multithread;

/**
 * {@link}
 *
 * @Desc: 投票数据
 * @Author: thy
 * @CreateTime: 2020/3/3 7:31
 **/
public class BallotPosition {
    String question;
    //票数
    int votes;

    public BallotPosition(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public int getVotes() {
        return votes;
    }
}
