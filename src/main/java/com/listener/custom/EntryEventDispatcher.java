package com.listener.custom;

import java.util.concurrent.CopyOnWriteArrayList;

public class EntryEventDispatcher {

    private static EntryEventDispatcher instance = new EntryEventDispatcher();
    private CopyOnWriteArrayList<EntryListener> listeners = new CopyOnWriteArrayList<EntryListener>();

    public static EntryEventDispatcher getInstance() {
        return instance;
    }

    private EntryEventDispatcher() {

        // String[] observers = PropertyMgr.getProperty("observers").split(",");
        String str =
                "com.listener.custom.IndexManager,com.listener.custom.ScoreManager,com.listener.custom.EmailManager";
        String[] observers = str.split(",");
        for (String s : observers) {
            try {
                // 实例化监听执行事件的对象
                EntryListener listener = (EntryListener) (Class.forName(s).newInstance());
                // 讲事件对象添加到监听器列表中
                listeners.add(listener);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    public void removeListener(EntryListener listener) {
        listeners.remove(listener);
    }

    public void dispatchEvent(EntryEvent event) {
        int eventType = event.getEventType();
        for (int i = 0; i < listeners.size(); i++) {
            try {
                EntryListener listener = listeners.get(i);
                // String name = listener.getClass().getName();
                // name = name.substring(name.lastIndexOf('.') + 1);

                switch (eventType) {
                    case EntryEvent.ENTRY_ADDED: // 创建博客文章
                        listener.entryAdded(event);
                        break;

                    case EntryEvent.ENTRY_DELETED: // 删除博客文章
                        listener.entryDeleted(event);
                        break;

                    case EntryEvent.ENTRY_MODIFIED: // 修改 博客文章
                        listener.entryModified(event);
                        break;

                }

            } catch (Exception e) {
                // logger.error(e);
            }

        }

        // Profiler.end("msgDispatchEvent");
    }
}
