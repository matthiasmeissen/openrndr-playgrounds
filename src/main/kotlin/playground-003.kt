import org.openrndr.KEY_ARROW_LEFT
import org.openrndr.KEY_ARROW_RIGHT
import org.openrndr.application
import org.openrndr.color.ColorHSLa
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadFont
import org.openrndr.draw.loadImage
import org.openrndr.draw.tint
import org.openrndr.math.Vector2
import org.openrndr.shape.Circle
import org.openrndr.shape.Rectangle
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

fun main() = application {
    configure {
        width = 768
        height = 576
        windowResizable = true
        title = "Playground 3"
    }

    var strokeNum = 20

    program {

        extend {
            drawer.clear(ColorRGBa.PINK)

            for (i in 0..strokeNum) {
                val start = Vector2(width / strokeNum * 1.0 * i, 0.0)
                val end = Vector2(mouse.position.x, mouse.position.y)
                drawer.lineSegment(start, end)
            }

            for (i in 0..strokeNum) {
                val start = Vector2(width / strokeNum * 1.0 * i, height * 1.0)
                val end = Vector2(mouse.position.x, height - mouse.position.y)
                drawer.lineSegment(start, end)
            }

            drawer.fill = null

            for (i in 1..strokeNum) {
                drawer.circle(Vector2(width * 0.5, height * 0.5), (i * width / strokeNum) * mouse.position.x / width)
            }
        }

        keyboard.keyDown.listen {
            if (it.key == KEY_ARROW_LEFT) {
                if (strokeNum > 2) {
                    strokeNum -= 1
                }
            }
            if (it.key == KEY_ARROW_RIGHT) {
                if (strokeNum < 200) {
                    strokeNum += 1
                }
            }
        }
    }
}
