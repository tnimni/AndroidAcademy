import com.google.gson.annotations.SerializedName
import java.io.File
import java.math.BigDecimal
import java.time.DayOfWeek
import java.time.LocalDateTime

class OrdersAnalyzer {

    data class Order(val orderId: Int, val creationDate: String, val orderLines: List<OrderLine>)

    data class OrderLine(val productId: Int, val name: String, val quantity: Int, val unitPrice: BigDecimal)

    fun totalDailySales(orders: List<Order>): Map<DayOfWeek, Int> {
        val result = mutableMapOf<DayOfWeek, Int>()
        for (order in orders) {
            val day = LocalDateTime.parse(order.creationDate).dayOfWeek
            if (!result.containsKey(day))
                result[day] = 0
            result[day] = result[day]!!.plus(order.orderLines.sumBy { it.quantity })
        }
        return result
    }

}
