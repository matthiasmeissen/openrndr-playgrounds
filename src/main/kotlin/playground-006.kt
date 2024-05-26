import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extra.noise.uniform
import org.openrndr.math.Vector2
import org.openrndr.shape.SegmentJoin
import org.openrndr.shape.ShapeContour
import org.openrndr.shape.offset

fun main() = application {
    configure {
        width = 768
        height = 576
        windowResizable = true
        title = "Playground 6"
    }

    program {
        var points1 = List(30) { drawer.bounds.uniform() * Vector2(0.5, 1.0) }
        var line1 = ShapeContour.fromPoints(points1, closed = false)

        var points2 = List(30) { drawer.bounds.uniform() * Vector2(0.5, 1.0) + Vector2(width * 0.5, 0.0) }
        var line2 = ShapeContour.fromPoints(points2, closed = false)

        extend {
            drawer.clear(ColorRGBa.BLACK)
            drawer.fill = null

            for (i in 1..5) {
                val offset1 = line1.offset(seconds % 2.0 * i * 4.0, SegmentJoin.BEVEL)
                drawer.stroke = ColorRGBa.WHITE.shade(i / 5.0)
                drawer.contour(offset1)
            }

            for (i in 1..5) {
                val offset1 = line2.offset(seconds % 2.0 * i * 4.0, SegmentJoin.BEVEL)
                drawer.stroke = ColorRGBa.WHITE.shade(i / 5.0)
                drawer.contour(offset1)
            }
        }

        window.sized.listen {
            points1 = List(30) { drawer.bounds.uniform() * Vector2(0.5, 1.0) }
            line1 = ShapeContour.fromPoints(points1, closed = false)

            points2 = List(30) { drawer.bounds.uniform() * Vector2(0.5, 1.0) + Vector2(width * 0.5, 0.0) }
            line2 = ShapeContour.fromPoints(points2, closed = false)
        }
    }
}
