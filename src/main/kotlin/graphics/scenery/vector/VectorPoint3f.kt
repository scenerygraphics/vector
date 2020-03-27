package graphics.scenery.vector

import net.imglib2.Localizable
import net.imglib2.RealLocalizable
import net.imglib2.RealPositionable
import org.joml.Vector3f
import org.joml.Vector3fc

class VectorPoint3f() : Vector3f(), RealLocalizable, RealPositionable {
    constructor(x: Float, y: Float, z: Float) : this() {
        this.x = x
        this.y = y
        this.z = z
    }

    constructor(v: Vector3fc) : this() {
        this.x = v.x()
        this.y = v.y()
        this.z = v.z()
    }


    // Extra convenience methods
    val length: Double
        get() = Math.sqrt(getDoublePosition(0) * getDoublePosition(0) + getDoublePosition(1) * getDoublePosition(1) + getDoublePosition(2) * getDoublePosition(2))

    // -- RealLocalizable methods --

    override fun localize(position: FloatArray) {
        position[0] = x()
        position[1] = y()
        position[2] = z()
    }

    override fun localize(position: DoubleArray) {
        position[0] = x().toDouble()
        position[1] = y().toDouble()
        position[2] = z().toDouble()
    }

    override fun getFloatPosition(d: Int): Float {
        if (d == 0) return x()
        if (d == 1) return y()
        if (d == 2) return z()
        throw IndexOutOfBoundsException("" + d)
    }

    override fun getDoublePosition(d: Int): Double {
        if (d == 0) return x().toDouble()
        if (d == 1) return y().toDouble()
        if (d == 2) return z().toDouble()
        throw IndexOutOfBoundsException("" + d)
    }

    // -- RealPositionable methods --

    override fun move(distance: Float, d: Int) {
        move(distance.toDouble(), d)
    }

    override fun move(distance: Double, d: Int) {
        if (d == 0)
            this.x += distance.toFloat()
        else if (d == 1)
            this.y += distance.toFloat()
        else if (d == 2)
            this.z += distance.toFloat()
        else
            throw IndexOutOfBoundsException("" + d)
    }

    override fun move(distance: RealLocalizable) {
        for (d in 0 until numDimensions()) {
            move(distance.getDoublePosition(d), d)
        }
    }

    override fun move(distance: FloatArray) {
        for (d in 0 until numDimensions()) {
            move(distance[d], d)
        }
    }

    override fun move(distance: DoubleArray) {
        for (d in 0 until numDimensions()) {
            move(distance[d], d)
        }
    }

    override fun setPosition(localizable: RealLocalizable) {
        for (d in 0 until numDimensions())
            setPosition(localizable.getDoublePosition(d), d)
    }

    override fun setPosition(position: FloatArray) {
        for (d in 0 until numDimensions())
            setPosition(position[d], d)
    }

    override fun setPosition(position: DoubleArray) {
        for (d in 0 until numDimensions())
            setPosition(position[d], d)
    }

    override fun setPosition(position: Float, d: Int) {
        if (d == 0)
            this.x = position
        else if (d == 1)
            this.y = position
        else if (d == 2)
            this.z = position
        else
            throw IndexOutOfBoundsException("" + d)
    }

    override fun setPosition(position: Double, d: Int) {
        setPosition(position.toFloat(), d)
    }

    // -- Positionable methods --

    override fun fwd(d: Int) {
        move(1, d)
    }

    override fun bck(d: Int) {
        move(1, d)
    }

    override fun move(distance: Int, d: Int) {
        move(distance.toDouble(), d)
    }

    override fun move(distance: Long, d: Int) {
        move(distance.toDouble(), d)
    }

    override fun move(distance: Localizable) {
        for (d in 0 until numDimensions())
            move(distance.getDoublePosition(d), d)
    }

    override fun move(distance: IntArray) {
        for (d in 0 until numDimensions())
            move(distance[d], d)
    }

    override fun move(distance: LongArray) {
        for (d in 0 until numDimensions())
            move(distance[d], d)
    }

    override fun setPosition(localizable: Localizable) {
        for (d in 0 until numDimensions())
            setPosition(localizable.getDoublePosition(d), d)
    }

    override fun setPosition(position: IntArray) {
        for (d in 0 until numDimensions())
            setPosition(position[d], d)
    }

    override fun setPosition(position: LongArray) {
        for (d in 0 until numDimensions())
            setPosition(position[d], d)
    }

    override fun setPosition(position: Int, d: Int) {
        setPosition(position.toDouble(), d)
    }

    override fun setPosition(position: Long, d: Int) {
        setPosition(position.toDouble(), d)
    }

    // -- EuclideanSpace methods --

    override fun numDimensions(): Int {
        return 3
    }

    fun add(p2: VectorPoint3f): VectorPoint3f {
        val result = this.copy()
        for( d in 0 until numDimensions())
            result.move(p2.getDoublePosition(d), d)
        return result
    }

    operator fun minus(p2: VectorPoint3f): VectorPoint3f {
        val result = this.copy()
        for( d in 0 until numDimensions())
            result.move(-p2.getDoublePosition(d), d)
        return result
    }

    fun multiply(s: Float): VectorPoint3f {
        val result = this.copy()
        result.setPosition(result.getDoublePosition(0) * s, 0)
        result.setPosition(result.getDoublePosition(1) * s, 1)
        result.setPosition(result.getDoublePosition(2) * s, 2)
        return result
    }

    fun asFloatArray(): FloatArray {
        val a = FloatArray(3)
        a[0] = x()
        a[1] = y()
        a[2] = z()
        return a
    }

    fun asDoubleArray(): DoubleArray {
        val a = DoubleArray(3)
        a[0] = x().toDouble()
        a[1] = y().toDouble()
        a[2] = z().toDouble()
        return a
    }

    fun cross(v2: VectorPoint3f): VectorPoint3f {
        return this.cross(v2)
    }

    fun elmul(v2: VectorPoint3f): VectorPoint3f {
        val r = this.copy()
        r.setPosition(r.x() * v2.x(), 0)
        r.setPosition(r.y() * v2.y(), 1)
        r.setPosition(r.z() * v2.z(), 2)
        return r
    }

    fun dot(v2: VectorPoint3f): Float {
        return this.x() * v2.x() + this.y() * v2.y() + this.z() * v2.z()
    }

    override fun normalize(): VectorPoint3f {
        val r = this.copy()
        val f = 1 / this.length
        r.setPosition(r.x() * f, 0)
        r.setPosition(r.y() * f, 1)
        r.setPosition(r.z() * f, 2)
        return r
    }

    fun copy(): VectorPoint3f {
        return VectorPoint3f(x(), y(), z())
    }

    operator fun plus(v2: VectorPoint3f): VectorPoint3f {
        return this.add(v2)
    }

    operator fun times(v2: VectorPoint3f): VectorPoint3f {
        return this.mul(v2, VectorPoint3f()) as VectorPoint3f
    }

    operator fun div(v2: VectorPoint3f): VectorPoint3f {
        return this.div(v2, VectorPoint3f()) as VectorPoint3f
    }

    companion object {
        fun test() {
            val v = VectorPoint3f(1.0f, 0.0f, 0.0f)
            val v2 = v + v
            println(v2)
        }
    }
}