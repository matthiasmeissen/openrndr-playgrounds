import org.openrndr.application
import org.openrndr.color.ColorHSLa
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadFont
import org.openrndr.draw.loadImage
import org.openrndr.draw.tint
import kotlin.math.cos
import kotlin.math.sin

fun main() = application {
    configure {
        width = 768
        height = 576
    }

    program {
        val image = loadImage("data/images/pm5544.png")
        val font = loadFont("data/fonts/default.otf", 64.0)

        extend {
            drawer.drawStyle.colorMatrix = tint(ColorRGBa.WHITE.shade(0.2))
            drawer.image(image)

            drawer.clear(ColorHSLa((seconds * 20.0) % 360.0, 1.0, 0.5, 1.0).toRGBa())

            drawer.fill = ColorHSLa((seconds * 20.0) + 180.0 % 360.0, 1.0, 0.5, 1.0).toRGBa()
            drawer.strokeWeight = 0.0
            drawer.circle(cos(seconds) * width / 2.0 + width / 2.0, sin(0.5 * seconds) * height / 2.0 + height / 2.0, 140.0)

            drawer.fill = ColorHSLa((seconds * 20.0) + 90.0 % 360.0, 1.0, 0.5, 1.0).toRGBa()
            drawer.circle(cos(seconds * 2.0) * width / 4.0 + width / 2.0, sin(0.5 * seconds) * width / 2.0 + width / 2.0, 120.0)

            drawer.fontMap = font
            drawer.fill = ColorRGBa.WHITE
            drawer.text(seconds.toString(), width / 2.0, height / 2.0)
        }
    }
}
