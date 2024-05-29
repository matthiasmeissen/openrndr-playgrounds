import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extra.noise.uniform
import org.openrndr.math.Vector2
import org.openrndr.math.mod
import org.openrndr.shape.*
import kotlin.math.abs
import kotlin.math.min
import kotlin.math.sin

fun main() = application {
    configure {
        width = 768
        height = 576
        windowResizable = true
        title = "Playground 7"
    }

    program {
        extend {
            drawer.clear(ColorRGBa.BLACK)

            drawer.fill = null
            drawer.stroke = ColorRGBa.WHITE

            val sd = compound {
                difference {
                        shape(Circle(width * 0.5, height * 0.5, min(width * 0.4, height * 0.4)).shape)
                        shape(Rectangle((seconds * 80.0) % width, 0.0, width * 0.2, height * 1.0).shape)
                }
            }

            val sd1 = compound {
                difference {
                    shape(Circle(width * 0.5, height * 0.5, min(width * 0.4, height * 0.4)).shape)
                    shape(Rectangle(0.0, (seconds * 80.0) % height, width * 1.0, height * 0.2).shape)
                }
            }
            var s = (abs(sin(seconds * 0.4)) + 0.2) * min(width * 0.4, height * 0.4)

            val sd2 = compound {
                difference {
                    difference {
                        shape(Circle(width * 0.5, height * 0.5, s).shape)
                        shape(Rectangle((seconds * 80.0) % width, 0.0, width * 0.2, height * 1.0).shape)
                    }
                    shape(Rectangle(0.0, (seconds * 80.0) % height, width * 1.0, height * 0.2).shape)
                }
            }

            drawer.shapes(sd2)
        }
    }
}
