package work.beltran.conductortalkdemo

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.changehandler.AnimatorChangeHandler

/**
 * This AnimatorChangeHandler will make a view grow from 0 to 100% its size on push
 *
 * There's no action on pop
 */
class CustomChangeHandler : AnimatorChangeHandler() {
    override fun resetFromView(from: View) {

    }

    /**
     * Should be overridden to return the Animator to use while replacing Views.
     *
     * @param container The container these Views are hosted in.
     * @param from The previous View in the container or {@code null} if there was no Controller before this transition
     * @param to The next View that should be put in the container or {@code null} if no Controller is being transitioned to
     * @param isPush True if this is a push transaction, false if it's a pop.
     * @param toAddedToContainer True if the "to" view was added to the container as a part of this ChangeHandler. False if it was already in the hierarchy.
     */
    override fun getAnimator(
            container: ViewGroup,
            from: View?,
            to: View?,
            isPush: Boolean,
            toAddedToContainer: Boolean): Animator {
        val animator = AnimatorSet()

        to?.let {
            animator.play(ObjectAnimator.ofFloat(to, View.SCALE_X, 0f, 1f))
            animator.play(ObjectAnimator.ofFloat(to, View.SCALE_Y, 0f, 1f))
        }

        return animator
    }
}