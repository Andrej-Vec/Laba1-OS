package com;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        // Отримуємо поточну директорію
        String currentDirectory = System.getProperty("user.dir");

        // Створюємо об'єкт File для поточної директорії
        File currentDir = new File(currentDirectory);

        printDirectoryTree(currentDir, 0);
    }

    public static void printDirectoryTree(File dir, int indent) {
        // Виводимо ім'я поточної директорії з відповідним відступом
        System.out.println(getIndentString(indent) + "+--" + dir.getName());

        // Отримуємо список файлів та папок у поточній директорії
        File[] files = dir.listFiles();

        // Якщо список файлів не порожній, то викликаємо функцію printDirectoryTree для кожного елемента
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printDirectoryTree(file, indent + 1);
                } else {
                    System.out.println(getIndentString(indent + 1) + "+--" + file.getName());
                }
            }
        }
    }

    // Функція, яка повертає рядок з необхідною кількістю відступів
    public static String getIndentString(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("|  ");
        }
        return sb.toString();
    }
}
