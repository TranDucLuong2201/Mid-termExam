package com.android.mid_termexam.todo

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.mid_termexam.todo.screen.CakeMenuScreen
import com.android.mid_termexam.todo.screen.OrderCakeScreen

/**
 * Đề bài thường sẽ yêu cầu triển khai một ứng dụng có chức năng chuyển trang này sang trang khác, và ngược lại.
 *
 * Vì vậy, Setup MainNavigation để thực hiện phân trang
 *
 * Phía dưới đã được set up sẵn, sau đây là hướng dẫn để tạo thêm trang mới nếu cần.
 *
 * B1: Tạo một hàm Composable đại diện cho trang mới, ví dụ FourthScreen, các parameter tương tự, không dùng cũng không sao
 *
 * B2: Tạo viewmodel FourthViewModel nếu cần quản lý dữ liệu. Sau đó quay lại đây để setup navigation
 *
 * B3: Thêm đoạn code sau vào NavHost, sửa tên hàm và tên định danh trang cho phù hợp
 *
 * ```
 * val fourth_screen = "fourth_screen" // Tên định danh của trang
 * composable("fourth_screen") {
 *    FourthScreen(
 *      modifier = Modifier.padding(paddingValues),
 *      onClick = {},
 *      onBackClick = {}
 *    )
 * }
 * ```
 * @param fourth_screen: Tên định danh của trang, dùng để chuyển trang. Không rành thì nên đặt theo thứ tự first_screen, second_screen, ...
 * @param com.android.mid_termexam.todo.screen.AuthenticationScreen: Mỗi trang sẽ có 1 Composable riêng, tự tạo file và hàm Composable cho từng trang.
 * Phía dưới sẽ setup sẵn 3 trang, bạn chỉ cần chỉnh sửa tên hàm và thêm bớt trang cho phù hợp với đề bài. theo thứ tự 1 -> 2 -> 3, và 3 -> 2 -> 1.
 *
 * Để chỉnh sửa, tìm file có tên tương ứng rồi sửa, hoặc ấn Ctrl + Click vào tên hàm để điều hướng đến file đó.
 *
 */

@Composable
fun MainNavigation(paddingValues: PaddingValues) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "menu") {

        composable("menu") {
            CakeMenuScreen(
                onNext = {
                    navController.navigate("order") {
                    }
                }
            )
        }
        composable("order") {
            OrderCakeScreen(
                onBack = { navController.navigateUp() }
            )
        }
    }
}