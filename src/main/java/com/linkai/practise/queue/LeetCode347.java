package com.linkai.practise.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 * ● 输入: nums = [1,1,1,2,2,3], k = 2
 * ● 输出: [1,2]
 *
 * 示例 2:
 * ● 输入: nums = [1], k = 1
 * ● 输出: [1]
 *
 * 提示：
 * ● 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * ● 你的算法的时间复杂度必须优于 $O(n \log n)$ , n 是数组的大小。
 * ● 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * ● 你可以按任意顺序返回答案。
 */
public class LeetCode347 {

    public static void main(String[] args) {
        example1();
        example2();
    }

    public static void example1() {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] expected = {1,2};
        int[] actual = new LeetCode347().topKFrequent(nums, k);
        System.out.println("示例1，输出结果：" + (Arrays.equals(expected, actual) ? "成功" : "失败"));
    }

    public static void example2() {
        int[] nums = {1};
        int k = 1;
        int[] expected = {1};
        int[] actual = new LeetCode347().topKFrequent(nums, k);
        System.out.println("示例1，输出结果：" + (Arrays.equals(expected, actual) ? "成功" : "失败"));
    }

    static class Element implements Comparable<Element> {
        Integer num;
        Integer count;

        @Override
        public int compareTo(Element o) {
            if (count.equals(o.count)) {
                return 0;
            }
            if (count > o.count) {
                return 1;
            }
            return -1;
        }
    }

    interface MaxHeapOperation {
        //获取堆的大小
        int size();

        //判断堆是否为空
        boolean isEmpty();

        //往堆中添加元素
        void add(Element element);

        //取出堆顶元素
        Element extractMax();

        //取出k个堆顶元素
        List<Element> batchExtractMax(int k);
    }

    static class MaxHeap implements MaxHeapOperation {

        ArrayList<Element> data;

        public MaxHeap() {
            data = new ArrayList<>();
            //数组中第0个元素位置留空， 不使用
            data.add(new Element());
        }

        public MaxHeap(List<Element> elements) {
            data = new ArrayList<>();
            data.add(new Element());
            for (Element element : elements) {
                add(element);
            }
        }

        @Override
        public int size() {
            return data.size() - 1;
        }

        @Override
        public boolean isEmpty() {
            return data.size() == 1;
        }

        @Override
        public void add(Element element) {
            data.add(element);
            //将添加到末尾的最后一个元素上浮
            shiftUp(data.size() - 1);
        }

        private void shiftUp(int idx) {
            while (idx > 1) {
                int parentIndex = parentIndex(idx);
                Element currentElement = data.get(idx);
                Element parentElement = data.get(parentIndex);
                //跟父元素进行比较，如果小于等于则直接返回，如果大于就进行元素交互
                if (currentElement.compareTo(parentElement) <= 0) {
                    return;
                }
                if (currentElement.compareTo(parentElement) > 0) {
                    Collections.swap(data, idx, parentIndex);
                }
                idx = parentIndex;
            }
        }

        @Override
        public Element extractMax() {
            Element element = getMax();
            //将堆顶元素与堆位元素进行交换
            Collections.swap(data, 1, data.size() - 1);
            //删除堆位元素
            data.remove(data.size() - 1);
            //下沉堆顶元素
            shiftDown(1);
            return element;
        }

        @Override
        public List<Element> batchExtractMax(int k) {
            List<Element> result = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                result.add(extractMax());
            }
            return result;
        }

        private int parentIndex(int idx) {
            if (idx <= 1) {
                throw new RuntimeException("该节点不存在父节点");
            }
            return idx / 2;
        }

        private int leftChildIndex(int idx) {
            return idx * 2;
        }

        private int rightChildIndex(int idx) {
            return idx * 2 + 1;
        }

        private Element getMax() {
            if (data.size() <= 1) {
                throw new RuntimeException("堆中不存在元素");
            }
            return data.get(1);
        }

        private void shiftDown(int idx) {
            //如果左子节点超过了堆的大小，则停止搜素
            while (leftChildIndex(idx) <= data.size() - 1) {
                //需要交换的index，默认从左子树开始
                int swapIndex = leftChildIndex(idx);
                int rightChildIndex = rightChildIndex(idx);


                //如果右子节点存在值，并且右子节点的值是大于swapIndex的，这swapIndex选择右子节点
                if (rightChildIndex < data.size() && data.get(rightChildIndex).compareTo(data.get(swapIndex)) > 0) {
                    swapIndex = rightChildIndex;
                }

                //如果当前节点大于需要交换的节点，则直接返回
                if (data.get(idx).compareTo(data.get(swapIndex)) >= 0) {
                    break;
                }
                //交换节点
                Collections.swap(data, idx, swapIndex);
                idx = swapIndex;
            }
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            numMap.computeIfPresent(num, (key, value) -> value + 1);
            numMap.putIfAbsent(num, 1);
        }
        List<Element> elements = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            Element element = new Element();
            element.num = entry.getKey();
            element.count = entry.getValue();
            elements.add(element);
        }
        MaxHeap maxHeap = new MaxHeap(elements);
        List<Element> topKElements = maxHeap.batchExtractMax(k);
        return topKElements.stream().mapToInt(element -> element.num).toArray();
    }
}
