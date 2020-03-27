package graphics.scenery.vector.test

import graphics.scenery.vector.VectorPoint3f
import graphics.scenery.vector.VectorPoint4f
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Tests for [VectorPoint3f] and [VectorPoint4f] classes.
 *
 * @author Kyle Harrington <scenery@kyleharrington.com>
 */

class VectorPointTests {

    @Test
    fun testVectorPoint3f() {
        println("Testing VectorPoint3f methods")
        val v = VectorPoint3f(1.0f, 0.0f, 0.0f)
        val v2 = VectorPoint3f(2.0f, 1.0f, 1.0f)

        val vadd = v + v2
        assertEquals(3f,vadd.x(),"add test")

        val vsub = v2 - v
        assertEquals(1f,vsub.x(),"sub test")

        val vmul = v2 * v
        assertEquals(2f,vmul.x(),"mul test")

        val vdiv = v / v2
        assertEquals(0.5f,vdiv.x(),"mul test")
    }


    @Test
    fun testVectorPoint4f() {
        println("Testing VectorPoint3f methods")
        val v = VectorPoint4f(1.0f, 0.0f, 0.0f, 0.0f)
        val v2 = VectorPoint4f(2.0f, 1.0f, 1.0f, 1.0f)

        val vadd = v + v2
        assertEquals(3f,vadd.x(),"add test")

        val vsub = v2 - v
        assertEquals(1f,vsub.x(),"sub test")

        val vmul = v2 * v
        assertEquals(2f,vmul.x(),"mul test")

        val vdiv = v / v2
        assertEquals(0.5f,vdiv.x(),"mul test")
    }
}
