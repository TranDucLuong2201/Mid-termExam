package com.android.mid_termexam.todo.model

/**
 * HƯỚNG DẪN TẠO DATA CLASS(MODEL)
 *
 * Để tạo data class ta tạo như bên dưới
 *
 * Lưu ý các property trong data class nên có giá trị mặc định
 * Sử dụng dấu ngoặc tròn () để bao quanh các property
 * Mỗi property cách nhau bởi dấu phẩy ,
 * Tên property theo kiểu camelCase
 * Kiểu dữ liệu của property viết hoa chữ cái đầu (Int, String, Boolean, Float, Double, Long, ...)
 * Ví dụ:
 * ```
 * data class Name(
 *   val property1: Type1 = defaultValue1,
 *   val property2: Type2 = defaultValue2,
 * )
 */
data class ExampleUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val isSuccess: Boolean = false,
)
