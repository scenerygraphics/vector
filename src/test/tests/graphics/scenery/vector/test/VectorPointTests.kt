package graphics.scenery.vector.test

import graphics.scenery.vector.VectorPoint3f
import graphics.scenery.vector.VectorPoint4f
import net.imglib2.img.array.ArrayImgs
import net.imglib2.interpolation.randomaccess.NLinearInterpolatorFactory
import net.imglib2.type.numeric.integer.UnsignedByteType
import net.imglib2.view.Views
import org.junit.Test
import kotlin.random.Random
import kotlin.test.assertEquals

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
        assertEquals(0.5f,vdiv.x(),"div test")
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
        assertEquals(0.5f,vdiv.x(),"div test")
    }

    @Test
    fun testImgLib() {
        println("Testing VectorPoint3f methods")
        val v = VectorPoint3f(1.0f, 0.0f, 0.0f)

        val rng = Random(17)

        val dim = 10L
        val img = ArrayImgs.unsignedBytes(dim, dim, dim)
        val cur = img.cursor()
        while( cur.hasNext() ) {
            cur.fwd()
            cur.get().set(rng.nextInt(255))
        }

        val realImg = Views.interpolate(img, NLinearInterpolatorFactory<UnsignedByteType>())
        val realImgAccess = realImg.realRandomAccess()

        realImgAccess.setPosition(v)

        assertEquals(123, realImgAccess.get().get(), "RealLocalizable access")
    }
}
