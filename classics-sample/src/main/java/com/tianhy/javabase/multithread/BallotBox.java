package com.tianhy.javabase.multithread;

import com.fasterxml.jackson.databind.util.ArrayIterator;

import java.util.*;

/**
 * {@link}
 *
 * @Desc: 投票
 * @Author: thy
 * @CreateTime: 2020/3/3 7:36
 **/
public class BallotBox implements Iterable<BallotPosition> {
    final BallotPosition[] data;

    public BallotBox(List<String> list) {
        data = new BallotPosition[list.size()];
        for (int i = 0; i < list.size(); i++) {
            data[i] = new BallotPosition(list.get(i));
        }
    }

    @Override
    public Iterator<BallotPosition> iterator() {
        return new ArrayIterator<>(data);
    }

    //投票
    public void voteFor(int i) {
        ++data[i].votes;
    }

    int getCandidateCount() {
        return data.length;
    }

}
