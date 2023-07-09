INSERT INTO categories (name, imageName)
('Mobile phones', 'mobile.jpg'),
('Laptops', 'laptop.jpg'),
('GPS Navigators', 'jps_nav.jpg'),
('Fridges', 'fridge.jpg'),
('Cars', 'car.jpg'),
('Cameras', 'camera.jpg');

INSERT INTO users (name, surname, email, password)
VALUES ('Vadim', 'Vadimovich', 'vadim@mail.ru', '123123'),
       ('Max', 'Ivanov', 'max@bk.ru', 'admin123'),
       ('Anton', 'Antonov','anton@list.ru', '11111111');

INSERT INTO products (id, name, description, price, image_path, category_id)
VALUES (1, 'Iphone 14', 'Apple iOS, экран 6.1\" OLED (1170x2532) 60 Гц, Apple A15 Bionic, ОЗУ 6 ГБ, память 128 ГБ, камера 12 Мп, 1 SIM (nano-SIM/eSIM), влагозащита IP68', 1300, 'iphone14.png', 1),
(2, 'Samsung Galaxy M53 5G', 'Android 12, Super AMOLED Plus 120 Гц, 6,7 дюйма, 1080 х 2408, 20:9, MediaTek MT6877 Dimensity 900, ОЗУ 8 ГБ, память 128 ГБ, камера 12 Мп, 1 SIM (nano-SIM/eSIM), влагозащита IP68', 1100, 'galaxym53.jpg', 1),
(3, 'Macbook Air 13','Операционная система: MacOS, разрешение экрана: 2560x1600, IPS, соотношение: 16:10, 60 гц, процессор: M1, кол-во ядер: 8, частота процессора: 3200 МГц, графический адаптер: Apple M1 GPU, оперативная память: 8 гб,ёмкость SSD: 256 гб',1100, 'macbook.jpeg', 2),
(4, 'ASUS FX503','Операционная система: Windows, разрешение экрана: 1920x1080, IPS, соотношение: 16:9, 60 гц, процессор: intel core i5 6500, кол-во ядер: 4, частота: 3500 МГц, графический адаптер: GTX 1050, оперативная память: 16 гб,ёмкость SSD: 512 гб', 1100, 'asus.jpeg', 2),
(5, 'NAVITEL E777 Truck', 'Операционная система: Linux, процессор: MStar MSB2531, оперативная память: 128 мб,размер экрана:7 дюймов,разрешение экрана: 800 х 480,встроенная память: 8 гб', 1100, 'navitel.jpeg', 3),
(6, 'GEOFOX MID 743', 'Операционная система: Android 7.0 Nougat, процессор: MediaTek МТК8321, частота процессора: 1300 МГц, кол-во ядер: 4, оперативная память: 2 гб,размер экрана: 7 дюймов,разрешение экрана: 1024 х 600, технология экрана: IPS, встроенная память: 32 гб', 1100, 'geofox.jpeg', 3),
(7, 'LG DoorCooling','Исполнение: отдельностоящий,система охлаждения: No Frost,количество компрессоров: 1,количество полок: 4, количество отделений морозильной камеры: 3,общий объём: 419л, полезный объем: 384л, уровень шума: 35 дБ', 1100, 'lg.jpeg', 4),
(8, 'Indesit ITR', 'Исполнение: отдельностоящий,система охлаждения: No Frost,количество компрессоров: 1,количество полок: 3, количество отделений морозильной камеры: 3, полезный объем: 257л, уровень шума: 43 дБ', 1100,'indesit.jpeg', 4),
(9, 'Tesla model S', 'Мощность: 1020 л.с., привод: полный, коробка: автомат, разнос: 2.0 секунды, тип двигателя: электро, запас хода 840 км, максимальная скорость: 322 км/ч', 1100, 'models.jpg', 5),
(10, 'Tesla model X', 'Мощность: 580 л.с., привод: полный, коробка: автомат, разнос: 5.0 секунд, тип двигателя: электро, запас хода 489 км, максимальная скорость: 250 км/ч', 1100, 'modelx.png', 5),
(11, 'GoPro HERO10', 'Разрешение видеосъёмки: 5.3K, размер экрана: 2.27, количество точек матрицы: 23 Мп, электронная стабилизация: HyperSmooth 4.0, количество кадров в секунду: 240 кадров/с, емкость аккумулятора: 1720 мАч', 1100, 'gopro.jpeg', 6),
(12, 'Panasonic HC-V770', 'Разрешение видеосъёмки: Full HD, матрица: BSI MOS, электронная стабилизация: оптическая, количество пикселей при фотосъемке: 24 Мп, разрешение фотоснимка:6528x3672, емкость аккумулятора: 1940 мАч', 1100,'panasonic.jpg', 6);