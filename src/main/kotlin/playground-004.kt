import org.openrndr.KEY_ARROW_LEFT
import org.openrndr.KEY_ARROW_RIGHT
import org.openrndr.application
import org.openrndr.color.ColorHSLa
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadFont
import org.openrndr.draw.loadImage
import org.openrndr.draw.tint
import org.openrndr.math.Vector2
import org.openrndr.math.clamp
import org.openrndr.math.mix
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
        title = "Playground 4"
    }

    program {

        extend {
            drawer.clear(ColorRGBa.BLACK)

            var countMax = 20.0
            var count = clamp((1.0 - mouse.position.x / width) * countMax, 1.0, countMax)

            var colorHue = clamp(mouse.position.y / height * 360.0, 0.0, 360.0)

            drawer.stroke = null
            var color1 = ColorHSLa(colorHue, 1.0, 0.5)
            var baseColor = color1.toRGBa()

            val color2 = ColorHSLa(colorHue, 1.0, 0.5).toRGBa()
            val color3 = ColorHSLa(360.0 - colorHue, 1.0, 0.5).toRGBa()


            for (i in 1..count.toInt()) {
                drawer.fill = baseColor.shade(i / count)
                drawer.rectangle(width / count * i, 0.0, width / count, height * 1.0 )

                drawer.fill = baseColor.shade(1.0 + i / count)
                drawer.rectangle(width / count * i, height * 0.33, width / count, height * 1.0 )

                drawer.fill = org.openrndr.color.mix(color2, color3, i / count)
                drawer.rectangle(width / count * i, height * 0.66, width / count, height * 1.0 )
            }
        }
    }
}
