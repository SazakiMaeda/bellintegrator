# **Пятое задание для Bellintegrator** 
![Java](https://img.shields.io/badge/Java-17-red)  ![Spring](https://img.shields.io/badge/Spring_Boot-3.1.5-brightgreen)  ![Hibernate](https://img.shields.io/badge/Hibernate-6.2-blue)  ![Docker](https://img.shields.io/badge/Docker-24.0-lightblue)  

&nbsp;&nbsp;&nbsp;&nbsp;Пятое вступительное задание для компании Bellintegrator. Суть задиния заключается в том, чтобы написать корзину для интернет магазина по заданному интерфейсу `Basket`.
В своей работе я подошёл чуть более творческим путём и реализовал Rest API интернет корзины. Для реализации задуманного мне пришлось чуть-чуть изменить интерфейс, который был дан в задание, при этом логика осталась та же самая, которая и была заложена в этот.

## **Особенности:**  
- Полный CRUD для товаров  
- Валидация данных
- Чистая архитектура
- Готовый Docker-образ  

## **Схема работы:**
1. Запустить Docker и запустить контейнер, который прописан в `docker-compose.yml`, который находится в проекте.
2. Запустить проект.

## **REST API Endpoints: Basket Service:**
| Метод   | Эндпоинт                     | Описание                          | Параметры                     | Тело запроса                     | Пример ответа                     |
|---------|------------------------------|-----------------------------------|-------------------------------|----------------------------------|----------------------------------|
| `GET`   | `/api/v1/basket`             | Получить все товары в корзине     | -                             | -                                | `[{"id":1,"product":"Ноутбук","quantity":1,"price":99900}]` |
| `GET`   | `/api/v1/basket/{product}`   | Получить количество товара        | `product` (строка)            | -                                | `{"quantity": 2}`               |
| `POST`  | `/api/v1/basket/add`         | Добавить новый товар              | -                             | `{"product":"","quantity":1,"price":1}` | `{"id":2,"product":"Телефон","quantity":1,"price":49900}` |
| `PUT`   | `/api/v1/basket/{id}`        | Изменить количество товара        | `id` (число)                  | `{"quantity": 1}`               | `{"id":1,"product":"Ноутбук","quantity":3,"price":99900}` |
| `DELETE`| `/api/v1/basket/{id}`        | Удалить товар                     | `id` (число)                  | -                                | `{"id":2,"product":"Телефон","quantity":1,"price":49900}` |
| `DELETE`| `/api/v1/basket/clear`       | Очистить всю корзину              | -                             | -                                | HTTP 200 (без тела)             |


## **Автор:** Коновалов Антон  
[![Email](https://img.shields.io/badge/Email-sazakimaedaa%40gmail.com-blue?style=flat&logo=gmail)](mailto:sazakimaedaa@gmail.com)  
[![Telegram](https://img.shields.io/badge/Telegram-%40SazakiMaeda-blue?style=flat&logo=telegram)](https://t.me/sazakimaeda)  
