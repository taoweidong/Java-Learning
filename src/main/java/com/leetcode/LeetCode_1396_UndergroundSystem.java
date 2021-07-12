package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LeetCode_1396_UndergroundSystem {
    public static void main(String[] args) {
        System.out.println(Objects.hash("HelloWorld"));
    }
}

class UndergroundSystem {

    class Start {
        /**
         * 站点信息
         */
        String station;
        /**
         * 进站时间
         */
        int time;

        public Start(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class EndStation {
        /**
         * 开始站点
         */
        private String start;
        /**
         * 结束站点
         */
        private String end;

        public EndStation(String start, String end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            EndStation that = (EndStation)o;
            return Objects.equals(start, that.start) && Objects.equals(end, that.end);
        }

        @Override
        public int hashCode() {
            return Objects.hash(start + end);
        }
    }

    class SumAmount {
        /**
         * 花费的总时长
         */
        int sum;
        /**
         * 已经出站的总人数
         */
        int amount;

        public SumAmount(int sum, int amount) {
            this.sum = sum;
            this.amount = amount;
        }
    }

    /**
     * 存储进站的信息
     */
    private Map<Integer, Start> inStation;

    private Map<EndStation, SumAmount> table;

    public UndergroundSystem() {
        inStation = new HashMap<>();
        table = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        this.inStation.put(id, new Start(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        // 编号为id的进站信息
        Start start = inStation.get(id);

        // 从站点信息中获取数据
        EndStation endStation = new EndStation(start.station, stationName);
        SumAmount sumAmount = table.getOrDefault(endStation, new SumAmount(0, 0));
        sumAmount.sum += t - start.time;
        sumAmount.amount++;
        // 更新结果值
        table.put(endStation, sumAmount);

    }

    public double getAverageTime(String startStation, String endStation) {
        EndStation station = new EndStation(startStation, endStation);
        SumAmount sumAmount = table.get(station);
        return sumAmount.sum / sumAmount.amount;
    }
}
