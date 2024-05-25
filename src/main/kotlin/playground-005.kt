import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.shadeStyle
import org.openrndr.math.Vector2

fun main() = application {
    configure {
        width = 768
        height = 576
        windowResizable = true
        title = "Playground 5"
    }

    program {
        extend {
            drawer.clear(ColorRGBa.BLACK)

            drawer.shadeStyle = shadeStyle {
                fragmentTransform = """
                    vec2 p = vec2(va_position.x, va_position.y) - 0.5;
                    p = p * p;
                    float c = fract(distance((sin(p.x) + p_time), p.y));
                    vec3 color = vec3(c, c, c);
                    x_fill.rgb = color;
                """.trimMargin()
                parameter("time", seconds)
            }

            drawer.stroke = null
            drawer.rectangle(width * 0.5 - width * 0.2, height * 0.5 - height * 0.2, width * 0.4, height * 0.4)

            val s1 = Vector2(width * 0.4, height * 0.4)

            for (i in 1..5) {
                var s2 = Vector2(s1.x - 20.0 * i, s1.y - 20.0 * i)
                drawer.rectangle(mouse.position.x - s2.x * 0.5, mouse.position.y - s2.y * 0.5, s2.x, s2.y)
            }
        }
    }
}
