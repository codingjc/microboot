package cn.codingjc.test;

import cn.codingjc.lombok.SaleTicket;

/**
 * @author shenjicheng
 * @create 2021/8/22 9:46 上午
 */
public class SaleTicketTest {

    public static void main(String[] args) {

        SaleTicket saleTicket = new SaleTicket(20);

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                saleTicket.sale();
            }, "售票员" + i).start();
        }
    }
}
