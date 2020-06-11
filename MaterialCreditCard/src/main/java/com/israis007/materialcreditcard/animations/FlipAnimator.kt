package com.israis007.materialcreditcard.animations

import android.content.Context
import android.graphics.Camera
import android.util.AttributeSet
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.Transformation
import kotlin.math.sin

const val DIRECTION_X = 1
const val DIRECTION_Y = 2
const val DIRECTION_Z = 3
private const val DURATION = 500L
private const val DEGREES = 180.0
private const val ZERO_FLOAT = 0.0F
private const val DEGREES_150 = 150.0

class FlipAnimator(context: Context?, attrs: AttributeSet?) : Animation(context, attrs) {
    private lateinit var camera: Camera
    private lateinit var fromView: View
    private lateinit var toView: View
    private var centerX = 0
    private var centerY = 0
    private var forward = true
    private var visibilitySwapped = false
    var rotationDirection = DIRECTION_X
    var translateDirection = DIRECTION_Z

    /**
     * Creates a 3D flip animation between two views. If forward is true, its
     * assumed that view1 is "visible" and view2 is "gone" before the animation
     * starts. At the end of the animation, view1 will be "gone" and view2 will
     * be "visible". If forward is false, the reverse is assumed.
     *
     * @param fromView First view in the transition.
     * @param toView Second view in the transition.
     * @param centerX The center of the views in the x-axis.
     * @param centerY The center of the views in the y-axis.
     */
    constructor(context: Context?, attrs: AttributeSet?, fromView: View, toView: View, centerX: Int, centerY: Int): this(context, attrs){
        this.fromView = fromView
        this.toView = toView
        this.centerX = centerX
        this.centerY = centerY

        duration = DURATION
        fillAfter = true
        interpolator = AccelerateDecelerateInterpolator()
    }

    fun reverse() {
        forward = false
        val temp = toView
        toView = fromView
        fromView = temp
    }

    override fun initialize(width: Int, height: Int, parentWidth: Int, parentHeight: Int) {
        super.initialize(width, height, parentWidth, parentHeight)
        camera = Camera()
    }

    override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
        // Angle around the y-axis of the rotation at the given time. It is
        // calculated both in radians and in the equivalent degrees.
        val radians = Math.PI * interpolatedTime
        var degrees = (DEGREES * radians / Math.PI).toFloat()

        // Once we reach the midpoint in the animation, we need to hide the
        // source view and show the destination view. We also need to change
        // the angle by 180 degrees so that the destination does not come in
        // flipped around. This is the main problem with SDK sample, it does not
        // do this.
        if (interpolatedTime >= 0.5f){
            degrees -= DEGREES.toFloat()

            if (!visibilitySwapped) {
                fromView.visibility = View.GONE
                toView.visibility = View.VISIBLE

                visibilitySwapped = true
            }
        }

        if (forward)
            degrees = -degrees

        val matrix = t?.matrix!!

        camera.save()

        when (translateDirection) {
            DIRECTION_Z -> camera.translate(ZERO_FLOAT, ZERO_FLOAT, (DEGREES_150 * sin(radians)).toFloat())
            DIRECTION_Y -> camera.translate(ZERO_FLOAT, (DEGREES_150 * sin(radians)).toFloat(), ZERO_FLOAT)
            DIRECTION_X -> camera.translate((DEGREES_150 * sin(radians)).toFloat(), ZERO_FLOAT, ZERO_FLOAT)
        }

        when (rotationDirection) {
            DIRECTION_Z -> camera.rotateZ(degrees)
            DIRECTION_Y -> camera.rotateY(degrees)
            DIRECTION_X -> camera.rotateX(degrees)
        }

        camera.getMatrix(matrix)
        camera.restore()

        matrix.preTranslate(-centerX.toFloat(), -centerY.toFloat())
        matrix.postTranslate(centerX.toFloat(), centerY.toFloat())
    }
}