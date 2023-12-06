package org.example;

import com.google.gson.Gson;
import org.example.Entity.ChelEntity;
import org.example.Entity.DelEntity;
import org.example.Entity.KartEntity;
import org.example.Entity.ListKarts;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
//`
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ListKarts karts =new ListKarts();
        File file = new File("Q:\\МДК 05.02\\Itog.txt");
        if (file.createNewFile()) {
            System.out.println("Файл создан");
        }else {
            System.out.println("Файл уже существует");
        }
        try(FileReader fileReader = new FileReader(file)) {
            Scanner fileScanner = new Scanner(fileReader);
            if (fileScanner.hasNextLine()) {
                String str2 = fileScanner.nextLine();
                Gson gson = new Gson();
                karts = gson.fromJson(str2,ListKarts.class);
            }
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int menu = 0;
        do{
            try{
                System.out.println("1 - добавить человека");
                System.out.println("2 - вывести");
                System.out.println("3 - поиск по интерполу");
                System.out.println("5 - записать данные в файл");
                System.out.println("6 - завершить работу программы");
                menu = scanner.nextInt();
                switch (menu){
                    case 1:

                        ChelEntity chel = new  ChelEntity();
                        System.out.println("Введите фамилию");
                        chel.setSurname(scanner.next());
                        scanner.nextLine();
                        System.out.println("Введите имя");
                        chel.setName(scanner.nextLine());
                        System.out.println("Введите кличку");
                        chel.setKlichka(scanner.nextLine());
                        DelEntity del = new DelEntity();
                        System.out.println("Введите рост");
                        del.setRost(scanner.nextLine());
                        System.out.println("Введите цвет волос и глаз");
                        del.setChvet(scanner.nextLine());
                        System.out.println("Введите особые приметы");
                        del.setPrimet(scanner.nextLine());
                        System.out.println("Введите гражданство");
                        del.setGrachd(scanner.nextLine());
                        System.out.println("Введите место и дату рождения");
                        del.setDatar(scanner.nextLine());
                        System.out.println("Введите преступную профессию");
                        del.setProf(scanner.nextLine());
                        System.out.println("Введите последнее дело");
                        del.setDelo(scanner.nextLine());
                        KartEntity kart = new KartEntity();
                        kart.setChel(chel);
                        kart.setDel(del);
                        System.out.println("Введите номер дела");
                        kart.setNum(scanner.nextLine());
                        if (karts.getData() == null) {
                            List temp = new ArrayList<>();
                            temp.add(kart);
                            karts.setData(temp);
                        }else {
                            karts.getData().add(kart);
                        }break;
                    case 2: karts.getData().forEach(System.out::println);break;
                    case 3:
                        /*System.out.println("Введите фамилию преступника, которого хотите найти:");
                        scanner.nextLine();
                        String textSearch = scanner.nextLine();
                        List <ChelEntity> searchResult = new ArrayList<>();
                        for (ChelEntity b: karts.getData()) {
                            if (b.getSurname().equals(textSearch)) {
                                searchResult.add(b);
                            }
                            if (searchResult.isEmpty()) {
                                System.out.println("Преступник не найден");
                            }else {
                                searchResult.forEach(System.out::println);
                            }
                        }*/break;
                    case 4:
                       /* System.out.println("Введите фамилию преступника, которого хотите удалить");
                        scanner.nextLine();
                        String deleteChel = scanner.nextLine();
                        List deleteResult = new ArrayList<>();
                        for (ChelEntity b : karts.getData()) {
                            if (b.getSurname().equalsIgnoreCase(deleteChel)) {
                                deleteResult.add(b);
                            }
                        }
                        if (deleteResult.isEmpty()) {
                            System.out.println("Преступник не найден");
                        }else {
                            for (Object b : deleteResult) {
                                System.out.println("Удалить преступника?" + "Да" + "Нет\n" + b);
                                String d = scanner.nextLine();
                                if (d.equalsIgnoreCase("Да")) {
                                    karts.getData().remove(b);
                                    System.out.println("Удалено");
                                }else {
                                    System.out.println("Отмена удаления");
                                }
                            }
                        }*/break;
                    case 5: Gson gson = new Gson();
                    String str = gson.toJson(karts);
                    try(FileWriter fileWriter = new FileWriter(file)) {
                        fileWriter.write(str);
                        System.out.println("Данные записаны в файл");
                    }catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }catch (IOException e) {
                        throw new RuntimeException(e);
                    }break;
                    case 6:
                        System.out.println("(◕‿◕) Досвидания");break;
                }
            }catch (InputMismatchException e){
                System.out.println("Ошибка! Вы ввели символ");
            }
            scanner.nextLine();
        }while(menu != 6);

    }
}