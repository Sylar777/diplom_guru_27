# Проект автоматизации тестирования [Kinopoisk](https://www.kinopoisk.ru/)

## Описание ресурса Kinopoisk
Kinopoisk - это крупнейший российский интернет-сервис, посвященный кино и телевидению. Платформа предоставляет пользователям обширную базу данных фильмов, сериалов, актеров и режиссеров, а также позволяет оставлять отзывы, рейтинги и участвовать в обсуждениях. Kinopoisk является ключевым ресурсом для киноманов, предлагая последние новости киноиндустрии и подробную информацию о предстоящих релизах.

![Kinopoisk Logo](images/logo/Kinopoisk_colored_logo_max.png)

## Содержание
- [Описание](#описание)
- [Технологии и инструменты](#технологии-и-инструменты)
- [Реализованные проверки](#реализованные-проверки)
- [Локальный запуск тестов](#локальный-запуск-тестов)
- [Сборка тестов в Jenkins](#сборка-тестов-в-jenkins)
- [Интеграция с Allure Report](#интеграция-с-allure-report)
- [Интеграция с Allure TestOps](#интеграция-с-allure-testops)
- [Интеграция с Jira](#интеграция-с-jira)
- [Видео примера запуска тестов в Selenoid](#Видео-примера-запуска-тестов-в-Selenoid)
- [Видео примера запуска тестов в BrowserStack](#Видео-примера-запуска-тестов-в-BrowserStack)

## Описание
Проект по автоматизации тестирования Kinopoisk нацелен на демонстрацию возможностей автоматизации одного сервиса с различных сторон, включая UI, API и Mobile. 
Цель проекта - предоставить комплексный подход к автоматизации, охватывая все основные аспекты и обеспечивая высокое качество тестирования. 

Проект включает в себя тесты на:
- Автоматизацию пользовательского интерфейса (UI)
- Автоматизацию тестирования API
- Автоматизацию тестирования мобильного приложений

А также всключает в себя всю сопутствующая инфраструктуру:
- Jenkins
- Allure
- Selenoid
- TestOps
- Jira 
 
## Технологии и инструменты

<div align="center" dir="auto">
<a href="https://www.jetbrains.com/idea/" rel="nofollow"><img alt="InteliJ IDEA" height="50" src="images/logo/Idea.svg" width="50" style="max-width: 100%;"></a>
<a href="https://github.com/"><img alt="GitHub" height="50" src="images/logo/GitHub.svg" width="50" style="max-width: 100%;"></a>  
<a href="https://www.java.com/" rel="nofollow"><img alt="Java" height="50" src="images/logo/Java.svg" width="50" style="max-width: 100%;"></a>
<a href="https://gradle.org/" rel="nofollow"><img alt="Gradle" height="50" src="images/logo/Gradle.svg" width="50" style="max-width: 100%;"></a>  
<a href="https://junit.org/junit5/" rel="nofollow"><img alt="JUnit 5" height="50" src="images/logo/Junit5.svg" width="50" style="max-width: 100%;"></a>
<a href="https://selenide.org/" rel="nofollow"><img alt="Selenide" height="50" src="images/logo/Selenide.svg" width="50" style="max-width: 100%;"></a>
<a href="https://aerokube.com/selenoid/" rel="nofollow"><img alt="Selenoid" height="50" src="images/logo/Selenoid.svg" width="50" style="max-width: 100%;"></a>
<a href="https://rest-assured.io/" rel="nofollow"><img alt="RestAssured" height="50" src="images/logo/RestAssured.svg" width="50" style="max-width: 100%;"></a>
<a href="https://www.browserstack.com/" rel="nofollow"><img alt="Browserstack" height="50" src="images/logo/Browserstack.svg" width="50" style="max-width: 100%;"></a>
<a href="https://appium.io/" rel="nofollow"><img alt="Appium" height="50" src="images/logo/Appium.svg" width="50" style="max-width: 100%;"></a>
<a href="https://developer.android.com/studio" rel="nofollow"><img alt="Android Studio" height="50" src="images/logo/Android_Studio.svg" width="50" style="max-width: 100%;"></a>
<a href="https://www.jenkins.io/" rel="nofollow"><img alt="Jenkins" height="50" src="images/logo/Jenkins.svg" width="50" style="max-width: 100%;"></a>
<a href="https://github.com/allure-framework/"><img alt="Allure Report" height="50" src="images/logo/Allure.svg" width="50" style="max-width: 100%;"></a>
<a href="https://qameta.io/" rel="nofollow"><img alt="Allure TestOps" height="50" src="images/logo/Allure_TO.svg" width="50" style="max-width: 100%;"></a>
<a href="https://www.atlassian.com/software/jira" rel="nofollow"><img alt="Jira" height="50" src="images/logo/Jira.svg" width="50" style="max-width: 100%;"></a>  
<a href="https://telegram.org/" rel="nofollow"><img alt="Telegram" height="50" src="images/logo/Telegram.svg" width="50" style="max-width: 100%;"></a>
</div>

## Реализованные проверки
**UI**
- Проверка отображения полного списка лучших сериало на странице
- Проверка на не пустой пиклист Страна на странице Топ Сериалов
- Проверка применения фильтра Страна на список отображаемых на странице фильмов
- Проверка валидации на пиклист Бюджет
- Параметризованный тест на независимость поиска на русском и английском языках

**API**
- Проверка ответа на непустой список наград
- Проверка текста ошибки при запросе списка наград
- Проверка непустого ответа при запросе рандомного фильма
- Проверка применения фильтра при запросе рандомного фильма с указанием его типа
- Параметризованный тест на независимость поиска на русском и английском языках

**Mobile**
- Проверка отображения фильмов в карусели "В кино"
- Проверка отображения фильмов в карусели "Премьера"
- Параметризованный тест на независимость поиска на русском и английском языках

## Локальный запуск тестов
Для запуска следует открыть IntelliJ IDEA и выполнить в терминале:


Для запуска API тестов

``` bash
gradle clean api_tests
```

Для запуска UI тестов

``` bash
gradle clean ui_tests
```

Для запуска Mobile тестов

``` bash
gradle clean mobile_tests
```

Для запуска всех тестов

``` bash
gradle clean all_tests
```

## Сборка тестов в [Jenkins](https://jenkins.autotests.cloud/job/27-Sylar777-Diplom-Kinopoisk/)
Для запуска сборки необходимо перейти в раздел Build with Parameters и нажать кнопку Build. Сборка с параметрами позволяет перед запуском задать нужные параметры для сборки:

**Параметры запуска:**
```
clean
${TAG}
-Denv=${PLATFORM}
-Dwdhost=${URL}
-Dbrowser=${BROWSER}
-DBrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DbaseUrl=${BASE_URL}
-DbaseAPIUrl=${BASE_API_URL}
-Dapikey=${X_API_KEY}
```

Для запуска сборки необходимо перейти в раздел Собрать с параметрами, задать параметры и нажать кнопку Собрать.

<p dir="auto">
  <a href="images/screenshots/Jenkins.png">
    <img src="images/screenshots/Jenkins.png" style="max-width: 100%;">
  </a>
</p>

После выполнения сборки, в блоке История сборок напротив номера сборки появятся значек Allure Report, при клике на который откроется страница со сформированным html-отчетом и тестовой документацией соответственно, а так же появятся значек Allure TestOps при клике на который откроется страница проекта в Allure TestOps.

## Интеграция с [Allure Report](https://jenkins.autotests.cloud/job/27-Sylar777-Diplom-Kinopoisk/30/allure/)
**Диаграммы прохождения тестов**
ALLURE REPORT - отображает дату и время теста, общее количество запущенных тестов, а также диаграмму с процентом и количеством успешных и провалившихся тестов
TREND - отображает тенденцию выполнения тестов
SUITES - отображает распределение тестов по сьютам
CATEGORIES - отображает распределение неудачных тестов по типам дефектов

<p dir="auto">
  <a href="images/screenshots/AllureReport.png">
    <img src="images/screenshots/AllureReport.png" style="max-width: 100%;">
  </a>
</p>

**Развернутый результат прохождения тестов:**

<p dir="auto">
  <a href="images/screenshots/AllureResult.png">
    <img src="images/screenshots/AllureResult.png" style="max-width: 100%;">
  </a>
</p>

## Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/4350/dashboards)
**Диаграммы прохождения тестов**

<p dir="auto">
  <a href="images/screenshots/TestOpsDashbord.png">
    <img src="images/screenshots/TestOpsDashbord.png" style="max-width: 100%;">
  </a>
</p>

**Тест кейсы**

<p dir="auto">
  <a href="images/screenshots/TestOpsTests.png">
    <img src="images/screenshots/TestOpsTests.png" style="max-width: 100%;">
  </a>
</p>

## Интеграция с [Jira](https://jira.autotests.cloud/)
**Создана задача в Jira**

<p dir="auto">
  <a href="images/screenshots/Jira.png">
    <img src="images/screenshots/Jira.png" style="max-width: 100%;">
  </a>
</p>

## Видео примера запуска тестов в Selenoid
<p dir="auto">
  <a href="images/screenshots/Jira.png">
    <img src="images/video/Selenoid.gif" style="max-width: 100%;">
  </a>
</p>

## Видео примера запуска тестов в BrowserStack
<p dir="auto">
  <a href="images/screenshots/Jira.png">
    <img src="images/video/mobile.gif" style="max-width: 100%;">
  </a>
</p>
