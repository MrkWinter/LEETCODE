package day4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author MrkWinter
 * @version 1.0
 * 901. 股票价格跨度
 * 中等
 * 385
 * 相关企业
 * <p>
 * 设计一个算法收集某些股票的每日报价，并返回该股票当日价格的 跨度 。
 * <p>
 * 当日股票价格的 跨度 被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * <p>
 * 例如，如果未来 7 天股票的价格是 [100,80,60,70,60,75,85]，那么股票跨度将是 [1,1,1,2,1,4,6] 。
 * <p>
 * 实现 StockSpanner 类：
 * <p>
 * StockSpanner() 初始化类对象。
 * int next(int price) 给出今天的股价 price ，返回该股票当日价格的 跨度 。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
 * [[], [100], [80], [60], [70], [60], [75], [85]]
 * 输出：
 * [null, 1, 1, 1, 2, 1, 4, 6]
 * <p>
 * 解释：
 * StockSpanner stockSpanner = new StockSpanner();
 * stockSpanner.next(100); // 返回 1
 * stockSpanner.next(80);  // 返回 1
 * stockSpanner.next(60);  // 返回 1
 * stockSpanner.next(70);  // 返回 2
 * stockSpanner.next(60);  // 返回 1
 * stockSpanner.next(75);  // 返回 4 ，因为截至今天的最后 4 个股价 (包括今天的股价 75) 都小于或等于今天的股价。
 * stockSpanner.next(85);  // 返回 6
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= price <= 105
 * 最多调用 next 方法 104 次
 */
/*
思路:
用一个ArrayList维护一个数组 表示进几天的股票价格
用另一个ArrayList维护一个数组 表示当天的跨度 该数组用于较快 计算靠后的当天跨度
 */
public class StockSpanner {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }

    //用于维护股票价格
    private ArrayList<Integer> stock;
    private ArrayList<Integer> stockSp;

    public StockSpanner() {
        stock = new ArrayList<>();
        stockSp = new ArrayList<>();
    }

    //暴力计算 时间复杂度较高
    public int next1(int price) {
        stock.add(price); //添加当天股票
        int sp = 0;
        int n = stock.size() - 1; //从当前天往前数找跨度
        while (n >= 0 && stock.get(n--) <= price) {
            sp += 1;
        }
        return sp;
    }

    //数组记录 采用动态规划思路
    public int next(int price) {
        stock.add(price); //添加当天股票
        int sp = 1;
        int n = stock.size() - 2; //从当前天往前数找跨度
        while (n >= 0 && stock.get(n) <= price) {
            sp += stockSp.get(n);
            n -= stockSp.get(n);
        }
        stockSp.add(sp);
        return sp;
    }
}
