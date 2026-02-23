package org.example;

import java.io.File;

public class FileProcessor {

    private static final long MAX = 10 * 1024 * 1024;
    private final FileDAO fileDAO = new FileDAO();

    public void processFiles(String path) {
        File file = new File(path);

        if (!file.exists()) {
            System.out.println("Путь не существует");
            return;
        }

        process(file);
    }

    private void process(File file) {
        if (file.isFile()) {
            saveIfValid(file);
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    process(f); // рекурсия
                }
            }
        }
    }

    private void saveIfValid(File file) {
        if (file.length() <= MAX) {
            try {
                fileDAO.saveFile(file);
                System.out.println("Сохранён: " + file.getName());
            } catch (Exception e) {
                System.out.println("Ошибка при сохранении: " + file.getName());
            }
        } else {
            System.out.println("Пропущен (больше 10 MB): " + file.getName());
        }
    }
}
