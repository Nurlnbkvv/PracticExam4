package Task_1;

        /*1.Нужно создать схему взаимодействия (Таблицы,  связи):

        Имеются маршруты (важен номер маршрута (например, 204 или 102-А и т.п.), конечная и начальные точки).
        Имеются Автобусы (важен номер автомобиля) . Каждый автобус ходит по определенному маршруту.
        Есть водители (важно ФИО), которые могут водить разные автобусы.
        Данные о вождении какого-либо автобуса каким-то из водителей хранятся в Журнале (водитель, автобус, время).

        Создать таблицы и связи между ними (не забывать о PK, FK, Unique, Not Null).

        Заполнить таблицы хотя бы 3-4 записями

        В ответе  нужны SQL скрипты создания и заполнения таблиц.
         */

public class SQL {
    public static void main(String[] args) {
        System.out.println("CREATE table \"ExamPractic\".ex.route (           /*Маршрут*/\n" +
                "        end_point varchar (50) not null,\n" +
                "        starting_point varchar (50) not null,\n" +
                "        name_route varchar (50) not null,\n" +
                "        id_route int not null primary key,\n" +
                "        foreign key (id_route) references driver(id_driver));\n" +
                "\n" +
                "insert into \"ExamPractic\".ex.route\n" +
                "values ('Аламедин-1 (конечная)', 'ж/м Ак-Орго (ул. Алыкулова)', 'road route 216');\n" +
                "insert into \"ExamPractic\".ex.route\n" +
                "values ('222-я', 'Шоро', 'road route 169');\n" +
                "insert into \"ExamPractic\".ex.route\n" +
                "values ('12-й микрорайон', 'ж/м Ак-Ордо', 'road route 106');\n" +
                "insert into \"ExamPractic\".ex.route\n" +
                "values ('микрорайон Асанбай', 'ж/м Ак-Ордо', 'road route 204');\n" +
                "\n" +
                "CREATE table \"ExamPractic\".ex.bus (\n" +
                "        number_bus int not null,\n" +
                "        name_bus varchar (50) not null ,\n" +
                "        id_bus int not null primary key ,\n" +
                "        foreign key (id_bus) references route(id_route));\n" +
                "\n" +
                "insert into \"ExamPractic\".ex.bus\n" +
                "values (216, 216);\n" +
                "insert into \"ExamPractic\".ex.bus\n" +
                "values (169, 169);\n" +
                "insert into \"ExamPractic\".ex.bus\n" +
                "values (106, 106);\n" +
                "insert into \"ExamPractic\".ex.bus\n" +
                "values (204, 204);\n" +
                "\n" +
                "CREATE table \"ExamPractic\".ex.driver (\n" +
                "        fio_driver varchar (20) not null,\n" +
                "        id_driver int not null primary key,\n" +
                "        foreign key (id_driver) references bus(id_bus));\n" +
                "\n" +
                "insert into \"ExamPractic\".ex.driver\n" +
                "values ('Актамов Бектур', 72100);\n" +
                "insert into \"ExamPractic\".ex.driver\n" +
                "values ('Русланов Мирлан', 72250);\n" +
                "insert into \"ExamPractic\".ex.driver\n" +
                "values ('Орозбаев Руслан', 72350);\n" +
                "insert into \"ExamPractic\".ex.driver\n" +
                "values ('Акылбеков Дастан', 72450);\n" +
                "\n" +
                "create table \"ExamPractic\".ex.journal (\n" +
                "        driver varchar (50) not null,\n" +
                "        bus int not null ,\n" +
                "        time timestamp,\n" +
                "        id_journal int not null primary key ,\n" +
                "        foreign key (id_journal) references driver(id_driver));\n" +
                "\n" +
                "insert into \"ExamPractic\".ex.journal\n" +
                "values ('Актамов Бектур', 216, '2022-08-11 14:10:11');\n" +
                "insert into \"ExamPractic\".ex.journal\n" +
                "values ('Русланов Мирлан', 169, '2022-08-12 15:10:11');\n" +
                "insert into \"ExamPractic\".ex.journal\n" +
                "values ('Орозбаев Руслан', 106, '2022-08-13 16:10:11');\n" +
                "insert into \"ExamPractic\".ex.journal\n" +
                "values ('Акылбеков Дастан', 204, '2022-08-14 17:10:11');");
    }
}
