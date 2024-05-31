import org.openrndr.Program
import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extra.noise.uniform
import org.openrndr.math.Vector2
import org.openrndr.math.clamp
import org.openrndr.math.mod
import org.openrndr.shape.*
import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.min
import kotlin.math.sin

fun main() = application {
    configure {
        width = 768
        height = 576
        windowResizable = true
        title = "Playground 8"
    }

    program {
        extend {
            drawer.clear(ColorRGBa.BLACK)

            drawRects()
        }

        window.sized.listen { drawRects() }
    }
}

fun Program.drawRects() {
    drawer.fill = null
    drawer.stroke = ColorRGBa.WHITE

    val num = ceil(clamp(mouse.position.x / width, 0.0, 1.0) * 10.0)
    val gap = ceil(clamp(mouse.position.y / height, 0.0, 1.0) * 40.0)

    for (i in 0..num.toInt()) {
        drawer.rectangle(Vector2((width - gap) / num * i + gap, gap), (width - gap * (num + 1)) / num, height - gap * 2.0)
    }
}

