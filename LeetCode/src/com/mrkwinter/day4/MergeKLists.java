package com.mrkwinter.day4;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author MrkWinter
 * @version 1.0
 * <p>
 * 23. 合并 K 个升序链表
 * 困难
 * 2.6K
 * 相关企业
 * <p>
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * <p>
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * <p>
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 */


public class MergeKLists {
    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[3];
        ListNode a1 = new ListNode(1);
        a1.next = new ListNode(4);
        a1.next.next = new ListNode(5);
        ListNode a2 = new ListNode(1);
        a2.next = new ListNode(3);
        a2.next.next = new ListNode(4);
        ListNode a3 = new ListNode(2);
        a3.next = new ListNode(6);
        listNodes[0] = a1;
        listNodes[1] = a2;
        listNodes[2] = a3;
        ListNode listNode = new MergeKLists().mergeKLists(listNodes);

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode root = null;
        ListNode curNode = null;
        ListNode min = null;
        int minIndex = 0;
        ArrayList<ListNode> listNodes = new ArrayList<>();
        //保存每一个指针
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                listNodes.add(lists[i]);
        }
        //选取最小的一个值连接到root上
        while (listNodes.size() != 0) {
            //找到最小结点
            min = Collections.min(listNodes, (o1, o2) -> o1.val - o2.val);
            minIndex = listNodes.indexOf(min);
            if (curNode == null) {
                curNode = min;
                root = curNode;

            } else {
                curNode.next = min;
                curNode = curNode.next;
            }
            listNodes.set(minIndex, min.next);
            if (listNodes.get(minIndex) == null) {
                listNodes.remove(minIndex);
            }
        }
        return root;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}