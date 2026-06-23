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
    │   ├── BasePage.java       # Chứa các hàm wrapper (Waits, Alerts, Frames, Shadow DOM)
    │   └── TestListener.java   # Bộ lắng nghe sự kiện, tự động chụp ảnh màn hình khi Fail
    └── pages
        ├── FileDownload.java   # Xử lý IO, quản lý tệp và loại trừ file tạm (.crdownload)
        ├── SortableDataTables.java # Dò tìm dữ liệu bảng động qua XPath Axes
        └── ShadowDOM.java      # Bẻ khóa cây cấu trúc ẩn thông qua SearchContext
src/test/java
└── com.thutrang.automation
    ├── base
    │   └── BaseTest.java       # Khởi tạo WebDriver, cấu hình ChromeOptions nâng cao
    └── tests
        ├── FileDownloadTest.java
        ├── SortableDataTablesTest.java
        └── ShadowDOMTest.java
testng.xml                      # Quản lý luồng thực thi và đăng ký Hệ thống Báo cáo (Listeners)
pom.xml                         # Quản lý các dependencies và cấu hình build hệ thống
🛠️ Công Nghệ & Công Cụ Sử Dụng (Tech Stack)Ngôn ngữ chính: JavaThư viện lõi: Selenium WebDriver (v4.x)Kiểm thử cốt lõi: TestNG (Quản lý Test Cases, Assertions, DataProvider)Quản lý dự án & Build: Apache MavenQuản lý Trình duyệt: WebDriverManager (Tự động hóa quản lý driver nhị phân)Hệ thống Báo cáo: Extent Reports (Tự động chụp ảnh giao diện khi lỗi, kết xuất đồ thị trực quan)🔥 Các Tính Năng Nổi Bật Đã Triển Khai (Highlights)Hệ thống được thiết kế không chỉ để chạy kịch bản tuyến tính mà còn tập trung giải quyết các bài toán "sống còn" tại doanh nghiệp:Khu vực tính năngGiải pháp kỹ thuật nâng cao đã áp dụngÝ nghĩa thực tếData & FilesCấu hình ChromeOptions (prefs) ép tải file vào thư mục nội bộ tương đối; Viết hàm lặp while quét tệp theo đuôi loại trừ file tạm .crdownload.Giúp script chạy đa nền tảng (Windows/macOS), không sợ "chết đường dẫn", không lo file rỗng do tải chưa xong.Dynamic TablesỨng dụng Dynamic XPath kết hợp các trục quan hệ (following-sibling, ancestor) và kỹ thuật Java Stream để đối chiếu danh sách dữ liệu.Tối ưu hiệu năng, script không bị lỗi lệch cột hay lệch hàng khi dữ liệu hệ thống cập nhật hoặc thay đổi phân trang.Edge CasesSử dụng cơ chế bẻ khóa getShadowRoot() tiếp cận các node biệt lập nằm sâu bên dưới cấu trúc bảo mật.Giải quyết các bài toán tự động hóa với các form nhập liệu bảo mật hoặc các Web Components hiện đại.Advanced ActionsTích hợp Actions Class (Kéo thả, hover), xử lý chuyển tab đa cửa sổ động (getWindowHandles), quản lý luồng nhảy iFrames.Phủ kín các tương tác phức tạp của người dùng thật.Smart ReportsTriển khai TestNG ITestListener độc lập lắng nghe sự kiện, kích hoạt hàm TakesScreenshot tự động ghim ảnh lỗi vào file HTML.Giảm thời gian debug lỗi cho đội ngũ, cung cấp báo cáo trực quan cho Quản lý dự án.📊 Giao diện Báo cáo Tự động (Extent Reports Dashboard)Dưới đây là minh họa biểu đồ trực quan kết quả thực thi kiểm thử tự động của hệ thống:⚙️ Hướng Dẫn Cài Đặt & Chạy Dự Án (Getting Started)Yêu cầu hệ thốngĐã cài đặt Java JDK 11 hoặc 17Đã cài đặt Apache MavenTrình duyệt Google ChromeCác bước thực thiClone dự án về máy cục bộ:
git clone <đường-dẫn-repository-của-bạn>
    ```
2.  **Chạy toàn bộ Suite kiểm thử qua Terminal (Maven CLI):**
```bash
    mvn clean test
    ```
3.  **Xem báo cáo kiểm thử:**
* Sau khi quá trình thực thi kết thúc, truy cập thư mục: `target/ExtentReport.html`.
* Mở file trên bằng trình duyệt để xem biểu đồ và hình ảnh minh họa trạng thái.

---

## 👩‍💻 Thông Tin Tác Giả (Author)

* **Họ và tên:** Huỳnh Thị Thu Trang
* **Vị trí hướng tới:** Automation Testing Engineer / Quality Control Professional
* **Kỹ năng bổ trợ:** Kiểm thử thủ công (Web/Mobile/SDK), Quản lý vòng đời lỗi (Jira/Azure DevOps), Phân tích yêu cầu nghiệp vụ.
* **Liên hệ:** [Điền Email của bạn] | [Điền Link LinkedIn của bạn]

---

## 💡 Bí Quyết Để Tăng Điểm Cộng Trong Mắt Nhà Tuyển Dụng (QC Insights)

1. **Báo cáo trực quan (Extent Report):** Hệ thống tự động chụp màn hình khi xảy ra lỗi (`FAILED`) giúp các bạn Manual Tester và PM xem trực tiếp trạng thái UI ngay trong file báo cáo HTML mà không cần mở code debug.
2. **Tư duy thiết kế tối ưu:** Code sử dụng Dynamic XPath thay vì vòng lặp `for` thủ công, giúp kiểm thử chính xác kể cả khi dữ liệu bảng thay đổi hoặc phân trang nhiều dòng.
