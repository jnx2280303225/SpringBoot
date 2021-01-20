package com.jnx.springboot.util.io;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;

/**
 * 监听到文件变更后的处理器
 *
 * @author 蒋楠鑫
 * @since 2021/1/15
 */
public class MyFileAlterationListenerAdaptor extends FileAlterationListenerAdaptor {

    /**
     * 开始监听文件
     *
     * @param observer 文件观察者
     */
    @Override
    public void onStart(final FileAlterationObserver observer) {
        System.out.println("开始监听文件，文件路径为：" + observer.getDirectory().getPath());
    }

    /**
     * 文件创建
     *
     * @param file 文件对象
     */
    @Override
    public void onFileCreate(final File file) {
        System.out.println("监测到文件创建，文件名：" + file.getName());
    }

    /**
     * 文件被删除
     *
     * @param file 文件对象
     */
    @Override
    public void onFileDelete(final File file) {
        System.out.println("监测到文件删除，文件名：" + file.getName());
    }

    /**
     * 文件被修改
     *
     * @param file 文件对象
     */
    @Override
    public void onFileChange(final File file) {
        System.out.println("监测到文件修改，文件名" + file.getName());
    }
}
