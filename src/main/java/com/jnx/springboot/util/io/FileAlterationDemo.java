package com.jnx.springboot.util.io;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

/**
 * 监听文件修改的案例
 *
 * @author 蒋楠鑫
 * @since 2021/1/15
 */
public class FileAlterationDemo {

    public static void main(String[] args) {
        FileAlterationMonitor monitor = new FileAlterationMonitor();
        // 文件观察者
        FileAlterationObserver observer = new FileAlterationObserver(
                "/Users/jiangnanxin/Desktop",
                FileFilterUtils.suffixFileFilter(".txt"));
        // 监听到文件变动后的处理器
        MyFileAlterationListenerAdaptor listener = new MyFileAlterationListenerAdaptor();
        observer.addListener(listener);
        monitor.addObserver(observer);
        try {
            monitor.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
