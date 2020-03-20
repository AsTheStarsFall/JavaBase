package com.tianhy.javabase.multithread;

/**
 * {@link}
 *
 * @Desc: 定期保存工作内容
 * @Author: thy
 * @CreateTime: 2020/3/4 0:57
 **/
public class AutoSave extends Thread {
    protected FileSaver model;
    //休眠时间
    public static final int MINUTES = 5;

    private static final int SECONDS = 60 * MINUTES;


    public AutoSave(FileSaver fileSaver) {
        super("AutoSaver thread");
        setDaemon(true);
        model = fileSaver;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(SECONDS * 1000);
            } catch (InterruptedException e) {
            }
            if (model.wantAutoSave() && model.hasUnsavedChanges()) {
                model.saveFile("");
            }
        }
    }

    interface FileSaver {
        public void loadFile(String fn);

        public boolean wantAutoSave();

        public boolean hasUnsavedChanges();

        public void saveFile(String fn);

    }
}
