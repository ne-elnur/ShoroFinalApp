package com.company;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;

class ShoroApp {
    static class SaleDelivery {

        public static void main(String args[]) throws IOException {
            System.out.println("Пожалуйста, авторизуйтесь");
            chooseUsers();
        }

        // Выбор Аккаунта
        public static String chooseUsers() throws IOException {
            Scanner sc = new Scanner(System.in);

            System.out.println("Выберите вашу специальность :");
            System.out.println("(1) Продавец");
            System.out.println("(2) Поставщик");
            System.out.println("(3) Доставщик");
            do {
                System.out.print("Ваш выбор: ");
                String choose = sc.nextLine();
                switch (choose) {
                    case "salesman":
                    case "Salesman":
                    case "1":
                        System.out.println("Добро пожаловать Продавец");
                        System.out.println("Введите логин и пароль");
                        salesmanInputLgPw();
                        break;
                    case "provider":
                    case "Provider":
                    case "2":
                        System.out.println("Добро пожаловать Поставщик");
                        System.out.println("Введите логин и пароль");
                        providerInputLgPw();
                        break;
                    case "deliveryman":
                    case "Deliveryman":
                    case "3":
                        System.out.println("Добро пожаловать Доставщик");
                        System.out.println("Введите логин и пароль");
                        deliverymanInputLgPw();
                        break;
                    default:
                        System.out.println("Кто вы?");
                        System.out.print("Желаете выйти[1] или повторить[0]? ");
                        int ex = sc.nextInt();
                        if (ex == 0) {
                            chooseUsers();
                        } else if (ex == 1) {
                            System.exit(0);
                        }
                }
                break;
            } while (true);
            return "";
        }

        // Авторизация директора
        public static void salesmanInputLgPw() throws FileNotFoundException, IOException {
            Scanner sc = new Scanner(System.in);

            ArrayList<String> loginArrayList = new ArrayList<String>();
            ArrayList<String> passwordArrayList = new ArrayList<String>();
            loginArrayList.add("Salesman");
            loginArrayList.add("Provider");
            loginArrayList.add("Del");
            passwordArrayList.add("Salesman1");
            passwordArrayList.add("Provider1");
            passwordArrayList.add("Del1");
            loginArrayList.add("s");
            passwordArrayList.add("s1");

            do {
                System.out.print("Введите логин: ");
                String input_lg = sc.next();
                sc.nextLine();
                System.out.print("Введите пароль: ");
                String input_pw = sc.next();
                sc.nextLine();
                int indexArray = 0;
                boolean haveInArray = false;
                while (indexArray < loginArrayList.size()) {
                    if (input_lg.equals(loginArrayList.get(indexArray)) &&
                            input_pw.equals(passwordArrayList.get(indexArray))) {
                        haveInArray = true;
                        break;
                    } else {
                        haveInArray = false;
                    }
                    indexArray++;
                }
                ;
                if (haveInArray == true) {
                    System.out.println("Продавец, вы успешно вошли!");
                    salesmanActions();
                    break;
                } else {
                    System.out.println("Попытайтесь снова");
                }
            } while (true);
        }

        // Авторизация работника
        public static void providerInputLgPw() throws IOException {
            Scanner sc = new Scanner(System.in);

            ArrayList<String> loginArrayList = new ArrayList<String>();
            ArrayList<String> passwordArrayList = new ArrayList<String>();
            loginArrayList.add("p");
            passwordArrayList.add("p1");

            do {
                System.out.print("Введите логин: ");
                String input_lg = sc.next();
                sc.nextLine();
                System.out.print("Введите пароль: ");
                String input_pw = sc.next();
                sc.nextLine();
                int indexArray = 0;
                boolean haveInArray = false;
                while (indexArray < loginArrayList.size()) {
                    if (input_lg.equals(loginArrayList.get(indexArray)) &&
                            input_pw.equals(passwordArrayList.get(indexArray))) {
                        haveInArray = true;
                        break;
                    } else {
                        haveInArray = false;
                    }
                    indexArray++;
                }
                ;
                if (haveInArray == true) {
                    System.out.println("Поставщик, вы успешно вошли!");
                    Menu();
                    break;
                } else {
                    System.out.println("Попытайтесь снова");
                }
            } while (true);
        }

        // Авторизация курьера
        public static void deliverymanInputLgPw() throws IOException {
            Scanner sc = new Scanner(System.in);

            ArrayList<String> loginArrayList = new ArrayList<String>();
            ArrayList<String> passwordArrayList = new ArrayList<String>();
            loginArrayList.add("Del");
            passwordArrayList.add("Del1");

            do {
                System.out.print("Введите логин: ");
                String input_lg = sc.next();
                sc.nextLine();
                System.out.print("Введите пароль: ");
                String input_pw = sc.next();
                sc.nextLine();
                int indexArray = 0;
                boolean haveInArray = false;
                while (indexArray < loginArrayList.size()) {
                    if (input_lg.equals(loginArrayList.get(indexArray)) &&
                            input_pw.equals(passwordArrayList.get(indexArray))) {
                        haveInArray = true;
                        break;
                    } else {
                        haveInArray = false;
                    }
                    indexArray++;
                }
                ;
                if (haveInArray == true) {
                    System.out.println("Доставщик, вы успешно вошли!");
                    deliverymanActions();
                    break;
                } else {
                    System.out.println("Попытайтесь снова.");
                }
            } while (true);
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Действия директора
        public static void salesmanActions() throws FileNotFoundException, IOException {
            Scanner sc = new Scanner(System.in);

            System.out.println("Меню:");
            System.out.println("(1)Показать список всей бытовой техники");
            System.out.println("(2)Искать товар");
            System.out.println("(3)Показать отчет по продаже"); //Было -- Максимальное количество бытовой техники
            System.out.println("(4)Сделать заказ отсутствующего товара"); //Было -- Минимальное количество бытовой техники
            System.out.println("(5)Удалить заказ"); //Было -- Отчет по закупкам бытовой техники
            System.out.println("(0)Выход");
            do {
                System.out.print("Ваш выбор: ");
                String chooseAction = sc.nextLine();
                switch (chooseAction) {
                    case "action1":
                    case "Action1":
                    case "1":
                        System.out.println("Действие 1");
                        action1();
                        salesmanActions();
                        break;
                    case "action2":
                    case "Action2":
                    case "2":
                        System.out.println("Действие 2");
                        action2();
                        salesmanActions();
                        break;
                    case "action3":
                    case "Action3":
                    case "3":
                        System.out.println("Действие 3");
                        action3();
                        salesmanActions();
                        break;
                    case "action4":
                    case "Action4":
                    case "4":
                        System.out.println("Действие 4");
                        action4();
                        salesmanActions();
                        break;
                    case "action5":
                    case "Action5":
                    case "5":
                        System.out.println("Действие 5");
                        action5();
                        salesmanActions();
                        break;
                    default:
                        System.out.println("Такого действия нет в программе!");
                        salesmanActions();
                        break;
                    case "n":
                        try {
                            chooseUsers();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    case "action0":
                    case "Action0":
                    case "0":
                        System.out.println("Выход");
                        break;
                }
                break;
            } while (true);
        }

        public static void action1() {
            try {
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\IdeaProjects\\ShoroFinalApp\\sale.txt"));
                while (br.ready()) {
                    System.out.print(br.readLine() + " " + "\n");
                }
                System.out.println();
                br.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        private static void action2() throws FileNotFoundException, IOException {
            Scanner input = new Scanner(System.in);
            FileInputStream file = new FileInputStream(new File("C:\\Users\\User\\IdeaProjects\\ShoroFinalApp\\ПродукцияШоро.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            System.out.print("Введите название или код продукта-->");
            String search = input.nextLine();
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                var name = row.getCell(0);
                var sernum = row.getCell(1);
                if (name.getStringCellValue().trim().equals(search) || sernum.getStringCellValue().trim().equals(search)) {
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_NUMERIC:
                                System.out.printf("%.0f", cell.getNumericCellValue());
                                System.out.print("\t\t");
                                break;
                            case Cell.CELL_TYPE_STRING:
                                System.out.print(cell.getStringCellValue() + "\t\t");
                                break;
                        }
                    }
                    System.out.println();
                }

            }
            file.close();
        }

        private static void action3() throws FileNotFoundException, IOException {
            FileInputStream file = new FileInputStream(new File("C:\\Users\\User\\IdeaProjects\\ShoroFinalApp\\Отчёт по продажам.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue() + " - ");
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.printf("%.0f", cell.getNumericCellValue());
                            System.out.print("\t\t");
                            break;

                    }
                }
                System.out.println();
            }
            file.close();
        }

        private static void action4() {
            String path = "C:\\Users\\User\\IdeaProjects\\ShoroFinalApp\\order.txt";
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
                Scanner input = new Scanner(System.in);

                do {
                    System.out.print("Введите продукт и требуемое количество\n(Нажмите Enter, если закончили): ");
                    String thing = input.nextLine();
                    if (thing == null || StringUtils.isEmpty(thing.trim())) {
                        break;
                    } else {
                        writer.newLine();
                        writer.write(thing);
                    }

                } while (true);
                writer.close();
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                System.out.println("Заказ оформлен.");
            }
        }

        private static void action5() {
            String path = "C:\\Users\\User\\IdeaProjects\\ShoroFinalApp\\order.txt";
            try {
                BufferedReader reader = new BufferedReader(new FileReader(path));
                int count = 0;
                String letter = "";
                Scanner input = new Scanner(System.in);
                System.out.print("Введите-->");
                String delThing = input.next();
                Scanner scanner = new Scanner(new File("C:\\Users\\User\\IdeaProjects\\ShoroFinalApp\\order.txt"));
                boolean haveIt = false;
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    count++;
                    if (line.contains(delThing)) {
                        haveIt = true;
                        break;
                    }
                }
                if (haveIt == false) {
                    System.out.println("Тако  го продукта  нет в файле.");
                    System.out.print("Желаете выйти[0] или повторить[1]?-->");
                    int ask = input.nextInt();
                    if (ask == 1) {
                        action5();
                    } else if (ask == 0) {
                        salesmanActions();
                    }
                }
                var skipIndex = 0;
                while (reader.ready()) {
                    skipIndex++;
                    if (skipIndex != count) {
                        letter += reader.readLine() + "\n";
                    } else {
                        reader.readLine();
                    }
                }
                System.out.println(letter);
                reader.close();
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                System.out.println("Был показан обновленный список заказанной техники на данный момент.");
            }
        }

//        public static void action2() {
//            try {
//                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\dos.txt"));
//                int count = 0;
//                while (br.ready()) {
//                    br.readLine();
//                    count++;
//                }
//                BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\zak.txt"));
//                int count1 = 0;
//                while (br1.ready()) {
//                    br1.readLine();
//                    count1++;
//                }
//                System.out.println("Всего товаров = " + (int) (count + count1));
//                br1.close();
//                br.close();
//            } catch (IOException e) {
//                System.out.println(e);
//            }
//        }


        //Отчет по закупкам бытовой техники
//        public static void action5() {
//            try {
//                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\dos.txt"));
//                System.out.print("Доставленная бытовая техника ");
//                int countLine = 0;
//                while (br.ready()) {
//                    System.out.print(br.readLine() + ", ");
//                    countLine++;
//                }
//                System.out.println("Количество = " + countLine);
//                BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\zak.txt"));
//                System.out.print("Заказанная бытовая техника ");
//                int countline = 0;
//                while (br1.ready()) {
//                    System.out.print(br1.readLine() + ", ");
//                    countline++;
//                }
//                System.out.println("Количество = " + countline);
//                br1.close();
//                br.close();
//            } catch (FileNotFoundException e) {
//                System.out.println(e);
//            } catch (IOException e) {
//                System.out.println(e);
//            }
//        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//----------------------------------------------------------------------------------------------------------------------
//         Действия работника
        public static void Menu() throws IOException {
            System.out.println("1. Показать список товаров для поставки"); //Показать весь список бытовой техники в магазине
            System.out.println("2. Показать количество поставляемого товара"); //Искать бытовую технику
            System.out.println("3. Показать товар с самым большим количеством заказов для доставки"); //Показать отчет по бытовой технике
            System.out.println("4. Показать товар с самым меньшим количеством заказов для доставки"); //Выполнить заказ бытовой техники
//            System.out.println("5. "); //Посмотреть список заказаной бытовой тенхники
//            System.out.println("6. "); //Показать отсутствующие на складе бытовые техники
//            System.out.println("7. "); //Показать все бытовые техники, на которых действует скидка
//            System.out.println("8. "); //Удалить заказ
            System.out.println("0. Выход");
            Scanner input = new Scanner(System.in);
            while (true) {
                System.out.print("(Чтобы увидеть меню снова, нажмите [0]) Введите-->");
                var action = input.nextLine();
                switch (action) {
                    case "1":
                        ShowSuppliesList();
                        Menu();
                        break;
                    case "2":
                        Search();
                        Menu();
                        break;
                    case "3":
                        MaxVal(); //ShowReport();
                        Menu();
                        break;
                    case "4":
                        MinVal(); //Order();
                        Menu();
                        break;
                    case "n":
                        try {
                            chooseUsers();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    case "0":
                        System.out.println("Выход");
                        break;
                    default:
                        System.out.print("Пожалуйста, введите номера из меню.");
                }
            }
        }

        private static void ShowSuppliesList() throws FileNotFoundException, IOException {
            try {
                FileInputStream file = new FileInputStream(new File("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\БытоваяТехника.xlsx"));
                XSSFWorkbook workbook = new XSSFWorkbook(file);
                XSSFSheet sheet = workbook.getSheetAt(0);
                Iterator<Row> rowIterator = sheet.iterator();

                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    for (var colIndex = 0; colIndex < 3; colIndex += 2) {
                        Cell cell = row.getCell(colIndex);
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_NUMERIC:
                                System.out.printf("%.0f", cell.getNumericCellValue());
                                break;
                            case Cell.CELL_TYPE_STRING:
                                System.out.print(cell.getStringCellValue() + "\t\t");
                                break;
                        }
                    }
                    System.out.println();
                }
                file.close();
            } catch (Exception e) {
                System.out.println("Smth is wrong!");
            }
        }

        private static void Search() throws FileNotFoundException, IOException {
            Scanner input = new Scanner(System.in);
            FileInputStream file = new FileInputStream(new File("C:\\Users\\User\\IdeaProjects\\ShoroFinalApp\\ПродукцияШоро.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            System.out.print("Введите название техники или серийный номер-->");
            String search = input.nextLine();
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                var name = row.getCell(0);
                var sernum = row.getCell(1);
                if (name.getStringCellValue().trim().equals(search) || sernum.getStringCellValue().trim().equals(search)) {
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_NUMERIC:
                                System.out.printf("%.0f", cell.getNumericCellValue());
                                System.out.print("\t\t");
                                break;
                            case Cell.CELL_TYPE_STRING:
                                System.out.print(cell.getStringCellValue() + "\t\t");
                                break;
                        }
                    }
                    System.out.println();
                }

            }
            file.close();
        }

        //Максимальное количество бытовой техники
        public static void MaxVal() {
            try {
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\IdeaProjects\\ShoroFinalApp\\order.txt"));
                HashMap<String, Integer> d = new HashMap<>();
                while (br.ready()) {
                    String line = br.readLine();
                    if (d.containsKey(line)) {
                        d.put(line, (int) (d.get(line) + 1));
                    } else {
                        d.put(line, 1);
                    }
                }

                System.out.println(d);
                String s = "dsd";
                int m = 0;
                for (String i : d.keySet()) {
                    if (d.get(i) > m) {
                        m = d.get(i);
                        s = i;
                    }
                }
                System.out.println("Tовар с самым большим количеством заказов для доставки:" + s);
                br.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }


        //Минимальное количество бытовой техники
        public static void MinVal() {
            try {
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\IdeaProjects\\ShoroFinalApp\\order.txt"));
                HashMap<String, Integer> d = new HashMap<>();
                while (br.ready()) {
                    String line = br.readLine();
                    if (d.containsKey(line)) {
                        d.put(line, (int) (d.get(line) + 1));
                    } else {
                        d.put(line, 1);
                    }
                }
                System.out.println(d);
                String s = "dsd";
                int m = 100;
                for (String i : d.keySet()) {
                    if (d.get(i) < m) {
                        m = d.get(i);
                        s = i;
                    }
                }
                System.out.println("Tовар с самым меньшим количеством заказов для доставки:" + s);
                br.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }

//        private static void ShowReport() {
//            try {
//                FileInputStream file = new FileInputStream(new File("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\БытоваяТехника.xlsx"));
//                XSSFWorkbook workbook = new XSSFWorkbook(file);
//                XSSFSheet sheet = workbook.getSheetAt(0);
//                Iterator<Row> rowIterator = sheet.iterator();
//
//                while (rowIterator.hasNext()) {
//                    Row row = rowIterator.next();
//                    for (var colIndex = 0; colIndex < 5; colIndex += 2) {
//                        Cell cell = row.getCell(colIndex);
//                        switch (cell.getCellType()) {
//                            case Cell.CELL_TYPE_NUMERIC:
//                                System.out.printf("%.0f", cell.getNumericCellValue());
//                                System.out.print("\t\t");
//                                break;
//                            case Cell.CELL_TYPE_STRING:
//                                System.out.print(cell.getStringCellValue() + "\t\t");
//                                break;
//                        }
//                    }
//                    System.out.println();
//                }
//                file.close();
//            } catch (Exception e) {
//                System.out.println("Smth is wrong!");
//            }
//        }

//        private static void Order() {
//            String path = "C:\\Users\\User\\IdeaProjects\\ShoroFinalApp\\sale.txt";
//            try {
//                BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
//                Scanner input = new Scanner(System.in);
//
//                do {
//                    System.out.print("Введите название техники, которую вы бы хотели заказать-->");
//                    String thing = input.nextLine();
//                    if (thing == null || StringUtils.isEmpty(thing.trim())) {
//                        break;
//                    } else {
//                        writer.newLine();
//                        writer.write(thing);
//                    }
//
//                } while (true);
//                writer.close();
//            } catch (IOException e) {
//                System.out.println(e);
//            } finally {
//                System.out.println("Заказ сделан.");
//            }
//        }

        private static void OrderList() {
            String path = "C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\zak.txt";
            try {
                BufferedReader reader = new BufferedReader(new FileReader(path));
                while (reader.ready()) {
                    System.out.println(reader.readLine());
                }
                reader.close();
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                System.out.println("Был показан список заказанной техники на данный момент.");
            }
        }

        private static void Lack() throws FileNotFoundException, IOException {
            FileInputStream file = new FileInputStream(new File("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\БытоваяТехника.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                var amount = row.getCell(2);
                amount.setCellType(Cell.CELL_TYPE_STRING);
                if (amount.getStringCellValue().equals("0")) {
                    for (var colIndex = 0; colIndex < 3; colIndex += 2) {
                        Cell cell = row.getCell(colIndex);
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_NUMERIC:
                                System.out.printf("%.0f", cell.getNumericCellValue());
                                System.out.print("\t\t");
                                break;
                            case Cell.CELL_TYPE_STRING:
                                System.out.print(cell.getStringCellValue() + "\t\t");
                                break;
                        }
                    }
                    System.out.println();
                }
            }
            file.close();
        }

        private static void Discount() throws FileNotFoundException, IOException {
            FileInputStream file = new FileInputStream(new File("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\БытоваяТехника.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                var amount = row.getCell(3);
                amount.setCellType(Cell.CELL_TYPE_STRING);
                if (amount.getStringCellValue().equals("0%")) {
                    continue;
                } else {
                    for (var colIndex = 0; colIndex < 4; colIndex++) {
                        if (colIndex == 1) {
                            continue;
                        }
                        Cell cell = row.getCell(colIndex);
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_NUMERIC:
                                System.out.printf("%.0f", cell.getNumericCellValue());
                                System.out.print("\t\t");
                                break;
                            case Cell.CELL_TYPE_STRING:
                                System.out.print(cell.getStringCellValue() + "\t\t");
                                break;
                        }
                    }
                    System.out.println();
                }
            }
            file.close();
        }

        private static void Delete() {
            String path = "C:\\Users\\User\\IdeaProjects\\ShoroFinalApp\\order.txt";
            try {
                BufferedReader reader = new BufferedReader(new FileReader(path));
                int count = 0;
                String letter = "";
                Scanner input = new Scanner(System.in);
                System.out.print("Введите-->");
                String delThing = input.next();
                Scanner scanner = new Scanner(new File("C:\\Users\\User\\IdeaProjects\\ShoroFinalApp\\order.txt"));
                boolean haveIt = false;
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    count++;
                    if (line.contains(delThing)) {
                        haveIt = true;
                        break;
                    }
                }
                if (haveIt == false) {
                    System.out.println("Такой техники нет в файле.");
                    System.out.print("Желаете выйти[0] или повторить[1]?-->");
                    int ask = input.nextInt();
                    if (ask == 1) {
                        Delete();
                    } else if (ask == 0) {
                        Menu();
                    }
                }
                var skipIndex = 0;
                while (reader.ready()) {
                    skipIndex++;
                    if (skipIndex != count) {
                        letter += reader.readLine() + "\n";
                    } else {
                        reader.readLine();
                    }
                }
                System.out.println(letter);
                reader.close();
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                System.out.println("Был показан обновленный список заказанной техники на данный момент.");
            }
        }

//----------------------------------------------------------------------------------------------------------------------

        // Действия курьера
        public static void deliverymanActions() throws IOException {
            Scanner sc = new Scanner(System.in);
            System.out.println("Меню:");
            System.out.println("(1)Показать список товаров для доставки"); //Список бытовой техники для доставки.
            System.out.println("(2)Показать доставленные заказы"); //Доставленная бытовая техника.
            System.out.println("(3)Доставить заказ"); //Доставить бытовую технику.
            System.out.println("(4)Показать количество доставленных товаров"); //Количество доставленной бытовой.
            System.out.println("(5)Показать количество заказанных товаров"); //Количество заказанной бытовой техники.
            System.out.println("(6)Показать мой заработок"); //Мой заработок.
            System.out.println("(0)Выход");
            do {
                System.out.print("Ваш выбор: ");
                String chooseAction = sc.nextLine();
                switch (chooseAction) {
                    case "n":
                        try {
                            SaleDelivery.chooseUsers();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    case "action1":
                    case "Action1":
                    case "1":
                        //СПИСОК ЗАКАЗАННОЙ ТЕХНИКИ.
                        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\zak.txt"))) {
                            String line = null;
                            while ((line = br.readLine()) != null) {
                                System.out.println(line);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        deliverymanActions();
                        break;

                    case "action2":
                    case "Action2":
                    case "2":
                        //СПИСОК ДОСТАВЛЕННОЙ ТЕХНИКИ.
                        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\dos.txt"))) {
                            String line = null;
                            while ((line = br.readLine()) != null) {
                                System.out.println(line);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        deliverymanActions();
                        break;

                    case "action3":
                    case "Action3":
                    case "3":
                        System.out.println("Действие 3");
                        //--ДОСТАВИТЬ ЗАКАЗ--
                        ArrayList<String> appliances = new ArrayList<String>(); // Для доставки
                        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\zak.txt"))) {
                            String line = null;
                            while ((line = br.readLine()) != null) {
                                appliances.add(line);
                            }
                            System.out.println(appliances);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\zak.txt", true))) {
                            String i = "";
                            bw.write(i);
                            if (i.equals(i)) {
                                bw.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\dos.txt", true))) {
                            int i = 0;
                            while (i <= appliances.size()) {
                                if (i == appliances.size()) {
                                    bw.close();
                                    System.out.println("Доставлено!");
                                    break;
                                } else {
                                    bw.newLine();
                                    bw.write(appliances.get(i));
                                    i++;
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        deliverymanActions();
                        break;

                    case "action4":
                    case "Action4":
                    case "4":
                        //--КОЛ-ВО ДОСТАВЛЕННОЙ БЫТ.ТЕХНИКИ--
                        try {

                            File myFile = new File("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\dos.txt");
                            FileReader fileReader = new FileReader(myFile);
                            LineNumberReader lineNumberReader = new LineNumberReader(fileReader);

                            int lineNumber = 0;

                            while (lineNumberReader.readLine() != null) {
                                lineNumber++;
                            }

                            System.out.println(lineNumber);

                            lineNumberReader.close();

                            String lineNumber1 = String.valueOf(lineNumber);
                            File newFile = new File("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\kol.txt");
                            FileWriter fileWriter = new FileWriter(newFile);
                            fileWriter.write(lineNumber1 + " Строк в файле: " + "C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\dos.txt");
                            fileWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        deliverymanActions();
                        break;


                    case "action5":
                    case "Action5":
                    case "5":
                        //--КОЛ-ВО ЗАКАЗАННОЙ БЫТ.ТЕХНИКИ--
                        try {

                            File myFile = new File("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\zak.txt");
                            FileReader fileReader = new FileReader(myFile);
                            LineNumberReader lineNumberReader = new LineNumberReader(fileReader);

                            int lineNumber = 0;

                            while (lineNumberReader.readLine() != null) {
                                lineNumber++;
                            }

                            System.out.println(lineNumber);

                            lineNumberReader.close();

                            String lineNumber1 = String.valueOf(lineNumber);
                            File newFile = new File("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\kol.txt");
                            FileWriter fileWriter = new FileWriter(newFile);
                            fileWriter.write(lineNumber1 + " Строк в файле: " + "C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\zak.txt");
                            fileWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        deliverymanActions();
                        break;

                    case "action6":
                    case "Action6":
                    case "6":
                        int count = 0;

                        try {
                            // create a new file object
                            File file = new File("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\dos.txt");

                            // create an object of Scanner
                            // associated with the file
                            Scanner mn = new Scanner(file);

                            // read each line and
                            // count number of lines
                            while (mn.hasNextLine()) {
                                mn.nextLine();
                                count++;
                            }
                            System.out.println("Total Number of Delivered techniques: " + count);
                            System.out.println("Your Earnings: " + count * 2000);
                            // close scanner
                            mn.close();
                        } catch (Exception e) {
                            e.getStackTrace();
                        }

                        deliverymanActions();
                        break;

                    default:
                        System.out.println("Такого действия нет в программе!");
                        deliverymanActions();
                        break;

                    case "action0":
                    case "Action0":
                    case "0":
                        System.out.println("Выход");
                        break;

                }
                break;
            } while (true);
        }
    }
}