# 🚀 Selenium Java Automation Testing Framework

[![Java Version](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Selenium Version](https://img.shields.io/badge/Selenium-4.x-green.svg)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-7.x-blue.svg)](https://testng.org/)
[![Build](https://img.shields.io/badge/Build-Maven-red.svg)](https://maven.apache.org/)

Một dự án thiết kế Framework kiểm thử tự động toàn diện được xây dựng từ cơ bản đến nâng cao. Dự án mô phỏng cách giải quyết các bài toán kịch bản thực tế (Web UI, Data-Driven, Dynamic Elements, Advanced Interactions) trên nền tảng thực hành **The Internet Herokuapp**, tuân thủ nghiêm ngặt các tiêu chuẩn kiến trúc công nghiệp.

---

## 🏗️ Kiến Trúc Dự Án (Architecture & Design Pattern)

Dự án áp dụng mô hình thiết kế mẫu **Page Object Model (POM)** kết hợp với cấu trúc **Data-Driven Testing**, giúp tách biệt hoàn toàn giữa tầng xử lý Logic Giao diện và tầng Kịch bản Kiểm thử.

### Cấu trúc thư mục (Project Structure)
```text
src/main/java
└── com.thutrang.automation
    ├── base
    │   ├── BasePage.java       # Chứa các hàm wrapper (Smart Waits, Alerts, Frames, Shadow DOM)
    │   └── TestListener.java   # Bộ thu thập trạng thái test, tự động chụp ảnh màn hình khi Fail
    └── pages
        ├── FileDownload.java   # Xử lý IO, quản lý tệp tin tải về và tệp tạm (.crdownload)
        ├── SortableDataTables.java # Dò tìm dữ liệu động qua XPath Axes (following-sibling)
        └── ShadowDOM.java      # Bẻ khóa cây cấu trúc ẩn thông qua SearchContext
src/test/java
└── com.thutrang.automation
    ├── base
    │   └── BaseTest.java       # Khởi tạo WebDriver, quản lý cấu hình nâng cao ChromeOptions
    └── tests
        ├── FileDownloadTest.java
        ├── SortableDataTablesTest.java
        └── ShadowDOMTest.java
testng.xml                      # Quản lý luồng thực thi và đăng ký Hệ thống Báo cáo (Listeners)
pom.xml                         # Quản lý các dependencies và cấu hình build hệ thống
