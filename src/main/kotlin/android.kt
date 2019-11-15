import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime

fun main(args: Array<String>) {
    val orders = File("${System.getProperty("user.dir")}/src/main/resources/orders.json").readText(Charsets.UTF_8);
    println(orders)
    val listType = object : TypeToken<Array<OrdersAnalyzer.Order>>() {}.type
    val orderJsonParsed :Array<OrdersAnalyzer.Order> = Gson().fromJson(orders, listType)
    println(OrdersAnalyzer().totalDailySales(orderJsonParsed.toList()))
}