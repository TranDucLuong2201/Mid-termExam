# Cấu trúc đề thi giữa kỳ môn Lập trình Android

## Lưu ý quá trình làm(Phần này đọc và khắc ghi làm theo, VÌ ĐÃ SETUP SẴN RỒI)
- Các đường dẫn file đều tính từ thư mục gốc của dự án (project root) và có thể dùng ctrl + click để mở nhanh
- Chỉ sửa đổi các file ở package [`todo`](app/src/main/java/com/android/mid_termexam/todo). Các file khác không được sửa đổi.\
- File nào có đánh dấu TODO thì mới được sửa đổi, các phần khác không được sửa đổi.
- File có @Composable là file giao diện, file có ViewModel là file quản lý dữ liệu
- Mặc định UI sẽ ở package [`screen`](app/src/main/java/com/android/mid_termexam/todo/screen)
- Mặc định Viewmodel sẽ ở package [`viewmodel`](app/src/main/java/com/android/mid_termexam/todo/viewmodel)
- Nếu đề cần data class hãy tạo trong package [`data`](app/src/main/java/com/android/mid_termexam/todo/model) (Xem ví dụ trong đó)

- Đường dẫn tới file code bài làm [`main`](app/src/main/java/com/android/mid_termexam/todo/MainNavigation.kt)
- Nếu có lỗi thì check phần hướng dẫn khắc phục lỗi bên dưới
## Các lỗi lúc làm và cách khắc phục - Đọc khi có lỗi (Mở vscode đọc cái này sẽ dễ hơn, hoặc rút phần này lại)
- Các phần trong file gradle đã được cấu trúc sẵn, không cần thêm thắt gì ngoài việc thêm dependencies nếu cần. Nếu thêm thì thêm tại [`app/build.gradle.kts`](app/build.gradle.kts) Kéo xuống và tìm phần:
```gradle
dependencies {
    // Orther dependencies
    // Thêm dependencies mới thì cứ chèn vào cuối 
}
```
- Sau khi thêm dependencies mới, nhớ sync project lại (nhấn nút "Sync Now" hiện lên ở góc trên bên phải của Android Studio - Nút tròn màu xanh dương hiện ra)
- Sau khi sync xong, nhớ rebuild project lại (Build -> Rebuild Project) để chắc chắn mọi thứ đã ổn
- Sau setup xong, nếu có lỗi gì thì hỏi giảng viên hoặc trợ giảng để được hỗ trợ
- Đảm bảo không lỗi gì, chúng ta làm bài thi. Bài thi chỉ nằm ở folder duy nhất ở main, và chạy ở class MainActivity.kt: [`MainActivity.kt`](app/src/main/java/com/android/mid_termexam/MainActivity.kt)
- Trong quá trình làm, các biến cần phải import đầy đủ, nếu thiếu thì Android Studio sẽ gạch chân đỏ và bạn có thể nhấn alt + enter để tự động import
- Ở các biến sử dụng by thì đôi khi nó sẽ không tự import nhanh được, phải import thủ công(Yên tâm, copy cái import để dùng nha =.=, cái biến chỉ là ví dụ, và phải xóa // để sử dụng), ví dụ:
```kotlin
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.setValue

val myVar by remember { mutableStateOf(0) }
```
- Sẽ có một số phần tui sẽ viết sẵn, chỉ cần đọc hướng dẫn sử dụng.
- Những phần nào tự viết, sẽ có đánh dấu Todo rõ ràng, xóa đi để viết lại. Ví dụ:
```kotlin
     // TODO: Write here!   
```
- Vì sử dụng viewmodel và navigation nên phải đảm bảo trong file [`app/build.gradle.kts`](app/build.gradle.kts) đã thêm các dependencies sau:
```gradle
implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
implementation("androidx.navigation:navigation-compose:2.5.1")
```

## Phần 1: Các dạng sẽ xuất hiện trong đề thi
1. Các button và sự kiện click 
2. TextView và EditText - nhập và hiển thị văn bản
3. ImageView và cách hiển thị hình ảnh
4. Column và Row trong bố cục giao diện
5. Surface, Card và Box - các thành phần giao diện cơ bản
6. Xử lý sự kiện chạm (Touch Events) - 
7. Sử dụng LazyColumn và LazyRow - danh sách cuộn
8. Quản lý trạng thái với State và MutableState - Biến dùng để lưu trữ dữ liệu tạm thời
9. Navigation giữa các màn hình - chuyển đổi giao diện
10. Sử dụng ViewModel để quản lý dữ liệu - lưu trữ dữ liệu lâu dài
11. Modifier và các thuộc tính của nó - căn chỉnh, khoảng cách, kích thước

