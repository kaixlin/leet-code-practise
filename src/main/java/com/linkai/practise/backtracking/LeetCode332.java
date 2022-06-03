package com.linkai.practise.backtracking;

import java.util.*;

/**
 * 给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
 *
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
 *
 * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
 *
 * 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
 *
 * 示例 1：
 *
 * 输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
 * 输出：["JFK","MUC","LHR","SFO","SJC"]
 *
 * 示例 2：
 *
 * 输入：tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"] ，但是它字典排序更大更靠后。
 */
public class LeetCode332 {
    public static void main(String[] args)  {
        example1();
        example2();
    }

    public static void example1() {
        List<List<String>> tickets = Arrays.asList(
                Arrays.asList("MUC", "LHR"),
                Arrays.asList("JFK", "MUC"),
                Arrays.asList("SFO", "SJC"),
                Arrays.asList("LHR", "SFO")
        );

        List<String> expected = Arrays.asList("JFK","MUC","LHR","SFO","SJC");
        List<String> actual = new LeetCode332().findItinerary(tickets);
        System.out.println("示例1，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public static void example2() {
        List<List<String>> tickets = Arrays.asList(
                Arrays.asList("JFK","SFO"),
                Arrays.asList("JFK","ATL"),
                Arrays.asList("SFO","ATL"),
                Arrays.asList("ATL","JFK"),
                Arrays.asList("ATL","SFO")
        );

        List<String> expected = Arrays.asList("JFK","ATL","JFK","SFO","ATL","SFO");
        List<String> actual = new LeetCode332().findItinerary(tickets);
        System.out.println("示例2，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        //初始化targets
        Map<String, Map<String, Integer>> targets = new HashMap<>();
        for (List<String> ticket : tickets) {
            Map<String, Integer> target = targets.get(ticket.get(0));
            if (target == null) {
                target = new TreeMap<>();
                target.put(ticket.get(1), 1);
                targets.put(ticket.get(0), target);
            } else {
                if (target.containsKey(ticket.get(1))) {
                    int num = target.get(ticket.get(1));
                    target.put(ticket.get(1), num + 1);
                } else {
                    target.put(ticket.get(1), 1);
                }
            }
        }

        List<String> path = new ArrayList<>();
        path.add("JFK");
        backtracking(targets, tickets.size(), path);
        return path;
    }

    public boolean backtracking(Map<String, Map<String, Integer>> targets, int ticketNum, List<String> path) {
        if (path.size() == ticketNum + 1) {
            return true;
        }
        String last = path.get(path.size() - 1);

        if (targets.containsKey(last)) {
            for (Map.Entry<String, Integer> target : targets.get(last).entrySet()) {
                int count = target.getValue();
                if (count <= 0) {
                    continue;
                }
                path.add(target.getKey());
                target.setValue(target.getValue() - 1);
                if (backtracking(targets, ticketNum, path)) {
                    return true;
                }
                target.setValue(target.getValue() + 1);
                path.remove(path.size() - 1);
            }
        }
        return false;
    }
}
