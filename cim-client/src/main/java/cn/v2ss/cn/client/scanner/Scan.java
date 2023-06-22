package cn.v2ss.cn.client.scanner;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * @Author: YeFei
 * @Description:
 * @Date: 2022-10-02 17:07
 **/
@Slf4j
public class Scan implements Runnable {
    public Scan() {
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String msg = sc.nextLine();

        }
    }
}
