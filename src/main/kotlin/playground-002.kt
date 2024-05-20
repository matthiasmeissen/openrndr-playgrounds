import org.openrndr.application
import org.openrndr.color.ColorHSLa
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadFont
import org.openrndr.draw.loadImage
import org.openrndr.draw.tint
import org.openrndr.math.Vector2
import org.openrndr.shape.Circle
import org.openrndr.shape.Rectangle
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

fun main() = application {
    configure {
        width = 768
        height = 576
        windowResizable = true
        title = "Playground 2"
    }

    program {
        fun randomPointInArea(area: org.openrndr.shape.Rectangle): Vector2 {
            val x = area.x + Random.nextDouble() * area.width
            val y = area.y + Random.nextDouble() * area.height
            return Vector2(x, y)
        }

        var area = drawer.bounds.offsetEdges(-100.0)
        var positions = List(500) {
            randomPointInArea(area)
        }

        var count = 0

        extend {
            drawer.clear(ColorRGBa.PINK)

            drawer.fill = ColorRGBa.WHITE
            drawer.stroke = ColorRGBa.BLACK
            drawer.strokeWeight = 1.0

            count += 1

            drawer.circles(positions, 20.0)
        }

        window.sized.listen {
            area = drawer.bounds.offsetEdges(-100.0)
            positions = List(500) {
                randomPointInArea(area)
            }
        }
    }
}
