package com.android.mid_termexam.todo.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.mid_termexam.R

/**
 * Mới tìm ra quy tắc để làm bài thi giữa kỳ môn lập trình di động Android nè
 *
 * Kiên nhẫn đọc file này rồi làm, tức là tui sẽ làm sẵn, các bạn dùng cái nào thì copy paste vô project của mình, kiểu kéo thả, nhét vào chỗ phù hợp
 *
 * Sau khi set up trang mới tạo như hướng dẫn ở file MainNavigation.kt thì quay lại đây để triển khai giao diện và logic cho trang mới tạo
 *
 * Với bất kì file nào chỉ cần tưởng tượng ra, đây là một khoảng trống, như trò chơi xếp gạch
 *
 * Nếu một màn hình chỉ có hàm Composable thì nó sẽ không có viền, để xác định vị trí, cần một cái khung để biết được kích thước màn hình
 *
 * Bước 1: Tạo một hàm Composable với các parameter cơ bản như sau
 * ```
 * // Một file mới tạo thì nên làm theo như này
 * @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
 * @Composable
 * fun Example(
 *  onClick: () -> Unit = { },
 *  onBackClick: () -> Unit = { },
 *  modifier: Modifier,
 *  viewModel: ExampleViewModel = viewModel() // Cần tạo một file viewmodel khi tạo một màn hình mới
 * ) {
 *      Scaffold(
 *          modifier = modifier.fillMaxSize(),
 *          topBar = {
 *          }
 *          ) {
 *          Column(
 *              modifier = Modifier.fillMaxSize(),
 *              verticalArrangement = Arrangement.Center, // Sắp xếp theo chiều dọc, từ trên xuống dưới
 *              horizontalAlignment = Alignment.CenterHorizontally // Căn giữa theo chiều ngang
 *          ){
 *          // Các thành phần sẽ được xếp từ trên xuống dưới, giữa theo chiều ngang
 * }
 *      }
 * }
 * ```
 *
 * Khi này màn hình đã có một cái khung bao phủ, chỉ cần nhét đồ vào bên trong Surface là được, nhét vào trong dấu ngoặc nhọn
 *
 * Nhưng vấn đề gặp phải là mặc định khi nhét một thành phần mà không cung cấp vị trí hay cách nhét như nào thì nó mặc định sẽ nằm ở góc trên bên trái
 *
 * Nên ta phải dùng 1 trong 2 cách để sắp xếp thành phần: Column(), Row()
 *
 * Bước 2: Chọn kiểu sắp xếp, nên dùng column, vì nó sẽ theo kiểu xếp từ trên xuống dưới, kiểu như nhét các thành phần vào thì nó sẽ xếp từ trên xuống dưới, và nằm ở chính giữa
 *
 * ```
 * Column(
 *  modifier = Modifier.fillMaxSize(),
 *  verticalArrangement = Arrangement.Center, // Sắp xếp theo chiều dọc, từ trên xuống dưới
 *  horizontalAlignment = Alignment.CenterHorizontally // Căn giữa theo chiều ngang
 *  ){
 *   // Các thành phần sẽ được xếp từ trên xuống dưới, giữa theo chiều ngang
 * }
 * ```
 * Hoặc
 * ```
 * Row(
 *  modifier = Modifier.fillMaxSize(),
 *  verticalAlignment = Alignment.CenterVertically, // Căn giữa theo chiều dọc
 *  horizontalArrangement = Arrangement.Center // Sắp xếp theo chiều ngang, từ trái sang phải
 *  ) {
 *  // Các thành phần sẽ được xếp từ trái sang phải, giữa theo chiều dọc
 *  }
 * ```
 *
 * Như tui khuyến khích thì dùng column, nhưng gặp 1 số trường hợp thấy các nút ngang hàng nhau, tưởng tượng ở màn hình đăng nhập có các nút đăng nhập bằng Google, Facebook, Twitter nằm ngang hàng thì trong colum
 * ta sẽ nhét một row vào trong column để các nút nằm ngang hàng với nhau, trường hợp này thì ta chép đoạn này vào Column, rồi nhét các nút vào trong Row
 * ```
 * Row(
 *  modifier= Modifier.fillMaxWidth(),
 *  verticalAlignment = Alignment.CenterVertically,
 *  horizontalArrangement = Arrangement.Center// Hoặc Arrangement.spacedBy(8.dp) để cách đều nhau, tránh nó tập trung ở giữa
 * ) {
 *  // Ta bắt đầu chèn nút vào khối này, nếu đủ rồi thì đóng khối Row lại, ra ngoài và nhét các thành phần khác
 * }
 * ```
 * Bước 3: Nhét các thành phần giao diện vào trong Column hoặc Row
 * Và ta có các thành phần:
 *
 * ```
 * Text(text = "Hello World") // Hiển thị chữ Hello World, thì khi muốn thay đổi nội dung thì thay đổi trong dấu nháy đôi
 * ```
 *```
 * Button(onClick = { /* Xử lý khi bấm nút */ }) {
 *  Text(text = "Click Me") // Nút bấm có chữ Click Me
 * }
 * ```
 * ```
 * TextField(
 *  value = textFieldValue, // Biến lưu giá trị nhập vào
 *  onValueChange = { newValue -> textFieldValue = newValue },// Cập nhật giá trị khi người dùng nhập
 *  label = { Text("Enter text") } // Nhãn hiển thị bên trong,
 *  modifier = Modifier.fillMaxWidth().padding(16.dp) // Chiếm hết chiều ngang và có khoảng cách 16dp so với các thành phần khác
 *  )
 *  ```
 */
@Composable
fun Example() {

}

/**
 * ═══════════════════════════════════════════════════════════════════════════
 * CÁCH SỬ DỤNG COOKBOOK NÀY:
 * ═══════════════════════════════════════════════════════════════════════════
 * Bật Nút preview, render tất cả thành phần, trong đó chứa cả index của phần đó, thấy giống thì Ctrl + F để tìm đến đó
 *
 * Tìm thành phần cần dùng (Column, Button, TextField...)
 *
 * - Copy code ví dụ
 *
 * - Paste vào project
 *
 * - Sửa text, biến, logic theo yêu cầu
 *
 * - Xem Preview để kiểm tra
 *
 * MẸO: Dùng Ctrl+F để tìm nhanh (vd: "LazyColumn", "Dialog")
 *
 * Preview giúp xem trước không cần chạy app
 *
 * Kết hợp các thành phần để tạo UI phức tạp
 *
 * State (remember) để lưu dữ liệu thay đổi
 * ═══════════════════════════════════════════════════════════════════════════
 */
/**
 * ═══════════════════════════════════════════════════════════════════════════
 *  📋 MỤC LỤC - JETPACK COMPOSE COOKBOOK
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * [1]  Column – Xếp dọc
 * [2]  Row – Xếp ngang
 * [3]  Box – Chồng lớp
 * [4]  Text – Hiển thị chữ
 * [5]  Button – Các loại nút bấm
 * [6]  TextField – Ô nhập liệu
 * [7]  Image & Icon
 * [8]  LazyColumn – Danh sách dọc (cuộn)
 * [9]  LazyRow – Danh sách ngang
 * [10] LazyGrid – Lưới (Grid)
 * [11] Card – Thẻ hiển thị nội dung
 * [12] Spacer & Divider – Khoảng trống & đường kẻ
 * [13] Checkbox / Switch / RadioButton – Lựa chọn
 * [14] Scaffold – Khung chính app (TopBar / BottomBar / FAB)
 * [15] Dialog – Hộp thoại
 * [16] State – Quản lý trạng thái (remember / mutableStateOf)
 * [17] Modifier – Tùy chỉnh giao diện
 * [18] Mẫu màn hình hoàn chỉnh (Login, Todo List)
 *
 * ═══════════════════════════════════════════════════════════════════════════
 */


/**
 * ═══════════════════════════════════════════════════════════════════════════
 * [1] COLUMN - XẾP DỌC (Trên → Dưới)
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * 📌 DÙNG KHI NÀO:
 * - Xếp các thành phần từ trên xuống dưới
 * - Form đăng nhập/đăng ký (TextField xếp dọc)
 * - Màn hình chi tiết (Title, Description, Button xếp dọc)
 *
 * 📌 CÁC OPTION:
 * verticalArrangement:
 *   - Arrangement.Top: Dồn lên trên
 *   - Arrangement.Center: Giữa màn hình
 *   - Arrangement.Bottom: Dồn xuống dưới
 *   - Arrangement.SpaceBetween: Cách đều, item đầu/cuối sát mép
 *   - Arrangement.SpaceAround: Cách đều, có khoảng trống 2 đầu
 *   - Arrangement.SpaceEvenly: Cách đều hoàn toàn
 *   - Arrangement.spacedBy(8.dp): Cách nhau 8dp
 *
 * horizontalAlignment:
 *   - Alignment.Start: Sát trái
 *   - Alignment.CenterHorizontally: Giữa
 *   - Alignment.End: Sát phải
 */
@Composable
fun ColumnExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Item 1")
        Text("Item 2")
        Text("Item 3")
    }
}

@Preview(showBackground = true, name = "[1] Column")
@Composable
fun Preview1_Column() { ColumnExample() }
/**
 * ═══════════════════════════════════════════════════════════════════════════
 * [2] ROW - XẾP NGANG (Trái → Phải)
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * 📌 DÙNG KHI NÀO:
 * - Xếp các nút ngang hàng (Login with Google, Facebook, Twitter)
 * - Icon + Text cạnh nhau
 * - Các button hành động (Cancel, OK)
 *
 * 📌 CÁC OPTION:
 * horizontalArrangement:
 *   - Arrangement.Start: Dồn sang trái
 *   - Arrangement.Center: Giữa
 *   - Arrangement.End: Dồn sang phải
 *   - Arrangement.SpaceBetween, SpaceAround, SpaceEvenly (tương tự Column)
 *   - Arrangement.spacedBy(8.dp): Cách nhau 8dp
 *
 * verticalAlignment:
 *   - Alignment.Top: Dồn lên trên
 *   - Alignment.CenterVertically: Giữa
 *   - Alignment.Bottom: Dồn xuống dưới
 */
@Composable
fun RowExample() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Default.Home, contentDescription = null)
        Text("Home")
    }
}

@Preview(showBackground = true, name = "[2] Row")
@Composable
fun Preview2_Row() { RowExample() }

/**
 * ═══════════════════════════════════════════════════════════════════════════
 * [3] BOX - CHỒNG LÊN NHAU
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * 📌 DÙNG KHI NÀO:
 * - Chồng ảnh với text lên trên
 * - Badge (số thông báo) trên icon
 * - Loading overlay lên màn hình
 * - Watermark trên ảnh
 *
 * 📌 CÁC OPTION:
 * contentAlignment:
 *   - Alignment.TopStart, TopCenter, TopEnd
 *   - Alignment.CenterStart, Center, CenterEnd
 *   - Alignment.BottomStart, BottomCenter, BottomEnd
 */
@Composable
fun BoxExample() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        // Lớp dưới cùng
        Card(modifier = Modifier.fillMaxSize()) {}

        // Lớp giữa
        Text("Ở giữa")

        // Lớp trên cùng - có thể dùng align() để đặt vị trí riêng
        Text(
            "Top End",
            modifier = Modifier.align(Alignment.TopEnd)
        )
    }
}

@Preview(showBackground = true, name = "[3] Box")
@Composable
fun Preview3_Box() { BoxExample() }

/**
 * ═══════════════════════════════════════════════════════════════════════════
 * [4] TEXT - HIỂN THỊ CHỮ
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * 📌 DÙNG KHI NÀO:
 * - Hiển thị tiêu đề, nội dung, mô tả
 * - Label cho các thành phần
 *
 * 📌 CÁC OPTION:
 * - fontSize: Kích thước chữ (sp)
 * - fontWeight: FontWeight.Bold, Normal, Light, Medium, SemiBold
 * - color: Màu chữ
 * - textAlign: TextAlign.Start, Center, End, Justify
 * - maxLines: Giới hạn số dòng
 * - overflow: TextOverflow.Ellipsis (hiện ...), Clip, Visible
 */
@Composable
fun TextExamples() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Text cơ bản
        Text(text = "Hello World")

        // Text có style
        Text(
            text = "Tiêu đề lớn",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )

        // Text giới hạn dòng
        Text(
            text = "Văn bản dài dòng này sẽ chỉ hiển thị tối đa 2 dòng và nếu vượt quá sẽ có dấu ba chấm ở cuối",
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showBackground = true, name = "[4] Text")
@Composable
fun Preview4_Text() { TextExamples() }


/**
 * ═══════════════════════════════════════════════════════════════════════════
 * [5] BUTTON - NÚT BẤM
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * 📌 CÁC LOẠI BUTTON:
 * - Button: Nút cơ bản, có nền màu
 * - OutlinedButton: Nút viền, không nền
 * - TextButton: Nút chỉ có chữ, không viền không nền
 * - IconButton: Nút chỉ có icon
 * - FloatingActionButton: Nút tròn nổi (dùng trong Scaffold)
 *
 * 📌 DÙNG KHI NÀO:
 * - Button: Hành động chính (Submit, Login, Save)
 * - OutlinedButton: Hành động phụ (Cancel, Skip)
 * - TextButton: Hành động nhỏ (Forgot Password, Learn More)
 * - IconButton: Navigation, hành động icon (Delete, Edit)
 * - FAB: Hành động nổi bật (Add, Create)
 */
@Composable
fun ButtonExamples() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Button cơ bản
        Button(onClick = { /* Code xử lý */ }) {
            Text("Button")
        }

        // Button full width
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Full Width Button")
        }

        // Outlined Button
        OutlinedButton(onClick = { }) {
            Text("Outlined Button")
        }

        // Text Button
        TextButton(onClick = { }) {
            Text("Text Button")
        }

        // Icon Button
        IconButton(onClick = { }) {
            Icon(Icons.Default.Delete, contentDescription = "Delete")
        }

        // Button với icon
        Button(onClick = { }) {
            Icon(
                Icons.Default.Add,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Add Item")
        }
    }
}

@Preview(showBackground = true, name = "[5] Button")
@Composable
fun Preview5_Button() { ButtonExamples() }
/**
 * ═══════════════════════════════════════════════════════════════════════════
 * [6] TEXTFIELD - Ô NHẬP LIỆU
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * 📌 CÁC LOẠI:
 * - TextField: Ô nhập cơ bản
 * - OutlinedTextField: Ô nhập có viền (đẹp hơn, dùng nhiều hơn)
 *
 * 📌 DÙNG KHI NÀO:
 * - Form đăng nhập/đăng ký
 * - Tìm kiếm
 * - Nhập dữ liệu (tên, email, số điện thoại)
 *
 * 📌 LƯU Ý:
 * - Phải có biến state để lưu giá trị
 * - var text by remember { mutableStateOf("") }
 */
@Composable
fun TextFieldExamples() {
    var text by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var search by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // TextField cơ bản
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Tên") }
        )

        // OutlinedTextField (khuyên dùng)
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            placeholder = { Text("example@gmail.com") },
            modifier = Modifier.fillMaxWidth()
        )

        // Password field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Mật khẩu") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        // Search field với icon
        OutlinedTextField(
            value = search,
            onValueChange = { search = it },
            label = { Text("Tìm kiếm") },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = null)
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true, name = "[6] TextField")
@Composable
fun Preview6_TextField() { TextFieldExamples() }


/**
 * ═══════════════════════════════════════════════════════════════════════════
 * [7] IMAGE & ICON
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * 📌 ICON:
 * - Dùng Icons.Default.TenIcon (Material Icons)
 * - Danh sách icon: https://fonts.google.com/icons
 *
 * 📌 IMAGE:
 * - Từ resource: painterResource(R.drawable.ten_hinh)
 * - Từ URL: cần thêm library Coil
 *
 * 📌 DÙNG KHI NÀO:
 * - Icon: Nút, navigation, decoration
 * - Image: Avatar, product image, banner
 */
@Composable
fun ImageIconExamples() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Icon cơ bản
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "Home",
            tint = Color.Blue,
            modifier = Modifier.size(48.dp)
        )

        // Icon trong Row
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Person, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Profile")
        }

//         Image vuông (uncomment khi có ảnh trong drawable)
         Image(
             painter = painterResource(id = R.drawable.ic_launcher_foreground),
             contentDescription = "Mô tả",
             modifier = Modifier.size(100.dp)
         )

//         Image tròn (Avatar)
         Image(
             painter = painterResource(id = R.drawable.ic_launcher_foreground),
             contentDescription = null,
             modifier = Modifier
                 .size(80.dp)
                 .clip(CircleShape)
         )

        // Icon thay thế avatar
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
    }
}

@Preview(showBackground = true, name = "[7] Image & Icon")
@Composable
fun Preview7_ImageIcon() { ImageIconExamples() }


/**
 * ═══════════════════════════════════════════════════════════════════════════
 * [8] LAZY COLUMN - DANH SÁCH DỌC (Cuộn được)
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * 📌 DÙNG KHI NÀO:
 * - Danh sách có nhiều item (Todo list, Chat list, Product list)
 * - Cần cuộn dọc
 * - Tiết kiệm hiệu năng (chỉ render item nhìn thấy)
 *
 * 📌 CÁC CÁCH DÙNG:
 * 1. items(số lượng): Dùng với list đơn giản
 * 2. items(list): Dùng với data class
 * 3. itemsIndexed(list): Có cả index
 *
 * 📌 LƯU Ý:
 * - Không dùng Modifier.fillMaxSize() trực tiếp trong LazyColumn
 * - Dùng contentPadding cho padding tổng thể
 * - Dùng verticalArrangement.spacedBy() cho khoảng cách giữa items
 */

// Cách 1: List đơn giản
@Composable
fun LazyColumnSimple() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(20) { index ->
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Item số $index",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}
@Preview(showBackground = true, name = "[8] LazyColumn – Simple")
@Composable
fun Preview8_LazyColumnSimple() { LazyColumnSimple() }

// Cách 2: Với Data Class (Todo List)
@Composable
fun LazyColumnWithData() {
    data class Todo(val id: Int, val title: String, val done: Boolean)

    val todos = remember {
        listOf(
            Todo(1, "Làm bài tập Android", false),
            Todo(2, "Đi mua đồ ăn", true),
            Todo(3, "Học Jetpack Compose", false),
            Todo(4, "Làm đồ án", false)
        )
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(todos) { todo ->
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = todo.done,
                        onCheckedChange = { }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(todo.title)
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "[8] LazyColumn – With Data")
@Composable
fun Preview8_LazyColumnData() { LazyColumnWithData() }

// Cách 3: Với các loại item khác nhau
@Composable
fun LazyColumnMixed() {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Header
        item {
            Text(
                text = "Danh sách",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Subheader
        item {
            Text("Có 5 items", color = Color.Gray)
        }

        // List items
        items(5) { index ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Text(
                    "Item $index",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        // Footer
        item {
            Text(
                "Hết rồi",
                modifier = Modifier.fillMaxWidth(),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                color = Color.Gray
            )
        }
    }
}


@Preview(showBackground = true, name = "[8] LazyColumn – Mixed")
@Composable
fun Preview8_LazyColumnMixed() { LazyColumnMixed() }

/**
 * ═══════════════════════════════════════════════════════════════════════════
 * [9]LAZY ROW - DANH SÁCH NGANG (Cuộn ngang)
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * 📌 DÙNG KHI NÀO:
 * - Danh sách category (Tags, Filters)
 * - Stories (như Instagram, Facebook)
 * - Banner quảng cáo
 * - Product carousel
 *
 * 📌 GIỐNG LAZY COLUMN NHƯNG:
 * - horizontalArrangement thay vì verticalArrangement
 * - Item nên có width cố định
 */
@Composable
fun LazyRowExample() {
    Column {
        Text(
            "Categories",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(10) { index ->
                Card(
                    modifier = Modifier
                        .width(120.dp)
                        .height(80.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text("Category $index")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "[9] LazyRow")
@Composable
fun Preview9_LazyRow() { LazyRowExample() }

// LazyRow với Data (Stories)
@Composable
fun LazyRowStories() {
    data class Story(val id: Int, val username: String)

    val stories = remember {
        listOf(
            Story(1, "user1"),
            Story(2, "user2"),
            Story(3, "user3"),
            Story(4, "user4"),
            Story(5, "user5")
        )
    }

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(stories) { story ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Avatar (dùng Icon thay Image)
                Box(
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = null,
                        modifier = Modifier.size(50.dp)
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    story.username,
                    fontSize = 12.sp,
                    maxLines = 1
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "[9] LazyRow – Stories")
@Composable
fun Preview9_LazyRowStories() { LazyRowStories() }
/**
 * ═══════════════════════════════════════════════════════════════════════════
 * [10] LAZY GRID - LƯỚI (Dạng Grid/Lưới)
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * 📌 DÙNG KHI NÀO:
 * - Gallery ảnh
 * - Product grid (shop)
 * - App grid (như màn hình home Android)
 * - Icon picker
 *
 * 📌 CÁC LOẠI:
 * - LazyVerticalGrid: Grid cuộn dọc
 * - LazyHorizontalGrid: Grid cuộn ngang
 *
 * 📌 COLUMNS:
 * - GridCells.Fixed(2): 2 cột cố định
 * - GridCells.Adaptive(minSize = 100.dp): Tự động tính số cột dựa vào kích thước
 */

// Grid 2 cột
@Composable
fun LazyGridExample() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(20) { index ->
            Card(
                modifier = Modifier.aspectRatio(1f) // Ô vuông
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text("Item $index")
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "[10] LazyGrid")
@Composable
fun Preview10_LazyGrid() { LazyGridExample() }
// Grid Gallery (3 cột)
@Composable
fun LazyGridGallery() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(30) { index ->
            Card(
                modifier = Modifier.aspectRatio(1f)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Icon(
                        Icons.Default.Image,
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "[10] LazyGrid – Gallery")
@Composable
fun Preview10_LazyGridGallery() { LazyGridGallery() }

/**
 * ═══════════════════════════════════════════════════════════════════════════
 * [11] CARD - THẺ
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * 📌 DÙNG KHI NÀO:
 * - Bọc nội dung thành khối
 * - Item trong list
 * - Product card
 * - Profile card
 *
 * 📌 LƯU Ý:
 * - Card tự động có elevation (bóng đổ)
 * - Có thể onClick
 */
@Composable
fun CardExamples() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Card cơ bản
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Tiêu đề", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Nội dung card ở đây")
            }
        }

        // Card có click
        Card(
            onClick = { /* Xử lý click */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.Notifications, contentDescription = null)
                Spacer(modifier = Modifier.width(16.dp))
                Text("Card có thể bấm được")
            }
        }

        // Product Card
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                // Image placeholder
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        Icons.Default.ShoppingCart,
                        contentDescription = null,
                        modifier = Modifier.size(60.dp)
                    )
                }

                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Tên sản phẩm", fontWeight = FontWeight.Bold)
                    Text("299.000đ", color = Color.Red)
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = { },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Mua ngay")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "[11] Card")
@Composable
fun Preview11_Card() { CardExamples() }

/**
 *═══════════════════════════════════════════════════════════════════════════
 * [12]SPACER & DIVIDER - KHOẢNG TRỐNG & ĐƯỜNG KẺ
 * ══════════════════════════════════════════════════════════════════════════
 *
 * SPACER: Tạo khoảng trống giữa các thành phần
 *
 * height() cho Column, width() cho Row
 *
 * ```
 * Spacer(modifier = Modifier.height(16.dp)) // Khoảng trống dọc 16dp
 * ```
 *
 * DIVIDER: Đường kẻ phân cách
 * ```
 * HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp)) // Kẻ ngang với padding dọc 16dp
 * ```
 * ```
 * VerticalDivider(modifier = Modifier.padding(horizontal = 16.dp)) // Kẻ dọc với padding ngang 16dp
 * ```
 */
@Composable
fun SpacerDividerExamples() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Text 1")
// Spacer - khoảng trống
        Spacer(modifier = Modifier.height(16.dp))
        Text("Text 2")
// Divider - đường kẻ
        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
        Text("Text 3")
        Spacer(modifier = Modifier.height(16.dp))
// Row với Spacer width
        Row {
            Text("Left")
            Spacer(modifier = Modifier.width(16.dp))
            Text("Right")
        }
    }
}


@Preview(showBackground = true, name = "[12] Spacer & Divider")
@Composable
fun Preview12_SpacerDivider() { SpacerDividerExamples() }


/**
 * ═══════════════════════════════════════════════════════════════════════════
 * [13]CHECKBOX, SWITCH, RADIOBUTTON - LỰA CHỌN
 * ═══════════════════════════════════════════════════════════════════════════
 * CHECKBOX: Chọn nhiều option (Accept terms, Subscribe newsletter)
 * ```
 * var checked by remember { mutableStateOf(false) }
 * Checkbox(
 *  checked = checked,
 *  onCheckedChange = { checked = it }
 * )
 * ```
 *
 * SWITCH: Bật/tắt tính năng (Notifications, Dark mode)
 * ```
 * var enabled by remember { mutableStateOf(false) }
 * Switch(
 *  checked = enabled,
 *  onCheckedChange = { enabled = it }
 * )
 * ```
 *
 * RADIOBUTTON: Chọn 1 trong nhiều option (Gender, Payment method)
 * ```
 * var selectedOption by remember { mutableStateOf("") }
 * RadioButton(
 *  selected = selectedOption == "Option1",
 *  onClick = { selectedOption = "Option1" }
 * )
 * ```
 */
@Composable
fun SelectionExamples() {
    var checked1 by remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(true) }
    var switchEnabled by remember { mutableStateOf(false) }
    var selectedGender by remember { mutableStateOf("Nam") }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
// Checkbox
        Text("Checkbox:", fontWeight = FontWeight.Bold)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checked1,
                onCheckedChange = { checked1 = it }
            )
            Text("Đồng ý điều khoản")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checked2,
                onCheckedChange = { checked2 = it }
            )
            Text("Nhận thông báo")
        }

        HorizontalDivider()

        // Switch
        Text("Switch:", fontWeight = FontWeight.Bold)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Bật thông báo")
            Switch(
                checked = switchEnabled,
                onCheckedChange = { switchEnabled = it }
            )
        }

        HorizontalDivider()

        // RadioButton
        Text("RadioButton:", fontWeight = FontWeight.Bold)
        Column {
            listOf("Nam", "Nữ", "Khác").forEach { gender ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedGender == gender,
                        onClick = { selectedGender = gender }
                    )
                    Text(gender)
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "[13] Selection (Checkbox / Switch / RadioButton)")
@Composable
fun Preview13_Selection() { SelectionExamples() }

/**
 * ═══════════════════════════════════════════════════════════════════════════
 * [14]SCAFFOLD - KHUNG CHÍNH APP
 * ═══════════════════════════════════════════════════════════════════════════
 * DÙNG KHI NÀO:
 *
 * - Màn hình có TopBar (Header)
 *
 * - Màn hình có BottomBar (Navigation)
 *
 * - Màn hình có FloatingActionButton
 *
 * CẤU TRÚC:
 *
 * topBar: Thanh trên (Title, Back button)
 *
 * bottomBar: Thanh dưới (Navigation)
 *
 * floatingActionButton: Nút tròn nổi
 *
 * content: Nội dung chính (nhớ padding)
 *
 * LƯU Ý:
 * Content phải dùng Modifier.padding(paddingValues)
 *
 * @OptIn(ExperimentalMaterial3Api::class) cho TopAppBar
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
// Top Bar
        topBar = {
            TopAppBar(
                title = { Text("Tên App") },
                navigationIcon = {
                    IconButton(onClick = { /* Back / }) {
Icon(Icons.Default.ArrowBack, contentDescription = "Back")
}
},
actions = {
IconButton(onClick = { / More */
                    }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "More")
                    }
                }
            )
        },
        // Bottom Navigation Bar
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
                    label = { Text("Home") }
                )
                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    icon = { Icon(Icons.Default.Search, contentDescription = null) },
                    label = { Text("Search") }
                )
                NavigationBarItem(
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                    icon = { Icon(Icons.Default.Person, contentDescription = null) },
                    label = { Text("Profile") }
                )
            }
        },

        // Floating Action Button
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { paddingValues ->
// Content - NHỚ PADDING
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text("Nội dung màn hình ở đây")
            Text("Selected tab: $selectedTab")
        }
    }
}

@Preview(showBackground = true, name = "[14] Scaffold")
@Composable
fun Preview14_Scaffold() { ScaffoldExample() }

/**
 * ═══════════════════════════════════════════════════════════════════════════
 * [15] DIALOG - HỘP THOẠI
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * DÙNG KHI NÀO:
 *
 * Xác nhận hành động (Delete, Logout)
 *
 * Thông báo lỗi/thành công
 *
 * Input dialog (nhập tên, note)
 *
 * CẤU TRÚC:
 * ```
 * var showDialog by remember { mutableStateOf(false) }
 * if (showDialog) { AlertDialog(...) }
 *
 * ```
 */
@Composable
fun DialogExamples() {
    var showDialog1 by remember { mutableStateOf(false) }
    var showDialog2 by remember { mutableStateOf(false) }
    var showDialog3 by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
// Dialog xác nhận
        Button(onClick = { showDialog1 = true }) {
            Text("Dialog xác nhận xóa")
        }
        // Dialog thông báo
        Button(onClick = { showDialog2 = true }) {
            Text("Dialog thông báo")
        }

        // Dialog nhập liệu
        Button(onClick = { showDialog3 = true }) {
            Text("Dialog nhập tên")
        }
    }
// Dialog 1: Xác nhận xóa
    if (showDialog1) {
        AlertDialog(
            onDismissRequest = { showDialog1 = false },
            title = { Text("Xác nhận xóa") },
            text = { Text("Bạn có chắc muốn xóa item này không?") },
            confirmButton = {
                TextButton(onClick = {
// Xử lý xóa
                    showDialog1 = false
                }) {
                    Text("Xóa")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog1 = false }) {
                    Text("Hủy")
                }
            }
        )
    }
// Dialog 2: Thông báo
    if (showDialog2) {
        AlertDialog(
            onDismissRequest = { showDialog2 = false },
            title = { Text("Thành công") },
            text = { Text("Đã lưu thành công!") },
            confirmButton = {
                TextButton(onClick = { showDialog2 = false }) {
                    Text("OK")
                }
            }
        )
    }
// Dialog 3: Nhập liệu
    if (showDialog3) {
        var name by remember { mutableStateOf("") }
        AlertDialog(
            onDismissRequest = { showDialog3 = false },
            title = { Text("Nhập tên") },
            text = {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Tên") },
                    singleLine = true
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    // Xử lý với name
                    showDialog3 = false
                }) {
                    Text("Lưu")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog3 = false }) {
                    Text("Hủy")
                }
            }
        )
    }
}

@Preview(showBackground = true, name = "[15] Dialog")
@Composable
fun Preview15_Dialog() { DialogExamples() }

/**
 * ═══════════════════════════════════════════════════════════════════════════
 * [16] STATE - QUẢN LÝ TRẠNG THÁI
 * ═══════════════════════════════════════════════════════════════════════════
 * DÙNG KHI NÀO:
 *
 * Cần lưu giá trị biến đổi (count, text, selected)
 *
 * UI cần cập nhật theo dữ liệu
 *
 * CÚ PHÁP:
 * ```
 * var tenBien by remember { mutableStateOf(giaTri) }
 *
 * // Thay đổi: tenBien = giaTriMoi
 * // CÁC LOẠI:
 *
 * //String
 * var text by remember { mutableStateOf("") }
 * //Int
 * var count by remember { mutableStateOf(0) }
 * //Boolean
 * var checked by remember { mutableStateOf(false) }
 * //List
 * var items by remember { mutableStateOf(listOf()) }
 * ```
 */
@Composable
fun StateExamples() {
// State cơ bản
    var count by remember { mutableStateOf(0) }
    var text by remember { mutableStateOf("") }
    var items by remember { mutableStateOf(listOf("A", "B", "C")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
// Counter
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Count: $count", fontSize = 24.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(onClick = { count-- }) {
                        Text("-")
                    }
                    Button(onClick = { count++ }) {
                        Text("+")
                    }
                }
            }
        }
        // TextField với state
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Nhập text") },
            modifier = Modifier.fillMaxWidth()
        )
        Text("Bạn đã nhập: $text")

        // List với state
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Items: ${items.size}", fontWeight = FontWeight.Bold)
                items.forEach { item ->
                    Text("• $item")
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = {
                    items = items + "Item ${items.size + 1}"
                }) {
                    Text("Thêm item")
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "[16] State")
@Composable
fun Preview16_State() { StateExamples() }


/**
 * ═══════════════════════════════════════════════════════════════════════════
 * [17] MODIFIER - CHỈNH SỬA GIAO DIỆN
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * CÁC MODIFIER HAY DÙNG:
 *
 * KÍCH THƯỚC:
 * ```
 * .fillMaxWidth() //Chiếm hết chiều ngang
 *
 * .fillMaxHeight() //Chiếm hết chiều cao
 *
 * .fillMaxSize() // Chiếm hết cả width và height
 *
 * .width(200.dp) // Rộng cố định
 *
 * .height(100.dp) // Cao cố định
 *
 * .size(100.dp) // Vuông 100x100
 *
 * .aspectRatio(1f) // Tỷ lệ 1:1 (vuông), 16f/9f (chữ nhật)
 *
 * // KHOẢNG CÁCH:
 *
 * .padding(16.dp) // Padding tất cả 4 cạnh
 *
 * .padding(horizontal = 16.dp, vertical = 8.dp) // Padding riêng
 *
 * .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
 *
 * // MÀU SẮC & HÌNH DẠNG:
 *
 * .background(Color.Blue) // Màu nền
 *
 * .clip(RoundedCornerShape(8.dp)) // Bo góc
 *
 * .clip(CircleShape) // Hình tròn
 *
 * .border(2.dp, Color.Red) // Viền
 *
 * .border(2.dp, Color.Red, RoundedCornerShape(8.dp)) // Viền + bo góc
 *
 * // HIỆU ỨNG:
 *
 * .clickable { } - Bắt sự kiện click
 *
 * // WEIGHT (dùng trong Column/Row):
 *
 * .weight(1f) // Chiếm phần còn lại
 */
@Composable
fun ModifierExamples() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
// Kích thước
        Text(
            "Full Width",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(16.dp)
        )
        Text(
            "Fixed Size",
            modifier = Modifier
                .size(100.dp)
                .background(Color.LightGray)
        )
// Bo góc
        Text(
            "Bo góc 8dp",
            modifier = Modifier
                .background(Color.Blue, RoundedCornerShape(8.dp))
                .padding(16.dp),
            color = Color.White
        )
// Hình tròn
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Red, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text("Tròn", color = Color.White)
        }
// Viền
        Text(
            "Có viền",
            modifier = Modifier
                .border(2.dp, Color.Red, RoundedCornerShape(8.dp))
                .padding(16.dp)
        )
// Clickable
        Text(
            "Bấm vào tôi",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green, RoundedCornerShape(8.dp))
                .clickable { /* Handle click */ }
                .padding(16.dp),
            color = Color.White
        )
// Weight trong Column
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red)
            )
            Box(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight()
                    .background(Color.Blue)
            )
        }
    }
}


@Preview(showBackground = true, name = "[17] Modifier")
@Composable
fun Preview17_Modifier() { ModifierExamples() }


/**
 * ═══════════════════════════════════════════════════════════════════════════
 * [18]MẪU MÀN HÌNH HOÀN CHỈNH
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * MÀN HÌNH LOGIN
 */
@Composable
fun LoginScreenExample() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
// Logo/Title
            Text(
                "Đăng Nhập",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(48.dp))

            // Email
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Mật khẩu") },
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Login Button
            Button(
                onClick = { /* Handle login */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("Đăng nhập", fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Forgot Password
            TextButton(onClick = { }) {
                Text("Quên mật khẩu?")
            }
        }
    }
}

@Preview(showBackground = true, name = "[18] Login Screen")
@Composable
fun Preview18_Login() { LoginScreenExample() }


/**
 * MÀN HÌNH TODO LIST
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoListScreenExample() {
    data class Todo(val id: Int, val title: String, var done: Boolean)

    var todos by remember {
        mutableStateOf(
            listOf(
                Todo(1, "Học Jetpack Compose", false),
                Todo(2, "Làm bài tập", true),
                Todo(3, "Đi chợ", false)
            )
        )
    }
    var showDialog by remember { mutableStateOf(false) }
    var newTodoText by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Todo List") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { showDialog = true }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(todos) { todo ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = todo.done,
                            onCheckedChange = {
                                todos = todos.map {
                                    if (it.id == todo.id) it.copy(done = it.done)
                                    else it
                                }
                            }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            todo.title,
                            modifier = Modifier.weight(1f)
                        )
                        IconButton(onClick = {
                            todos = todos.filter { it.id != todo.id }
                        }) {
                            Icon(Icons.Default.Delete, contentDescription = "Delete")
                        }
                    }
                }
            }
        }
    }
// Add Dialog
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Thêm Todo") },
            text = {
                OutlinedTextField(
                    value = newTodoText,
                    onValueChange = { newTodoText = it },
                    label = { Text("Nội dung") }
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    if (newTodoText.isNotBlank()) {
                        val newId = (todos.maxOfOrNull { it.id } ?: 0) + 1
                        todos = todos + Todo(newId, newTodoText, false)
                        newTodoText = ""
                        showDialog = false
                    }
                }) {
                    Text("Thêm")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Hủy")
                }
            }
        )
    }
}

@Preview(showBackground = true, name = "[18] Todo List Screen")
@Composable
fun Preview18_TodoList() { TodoListScreenExample() }

