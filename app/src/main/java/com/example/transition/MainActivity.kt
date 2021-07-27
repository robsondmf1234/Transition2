package com.example.transition

import android.os.Bundle
import android.os.Handler
import android.transition.Scene
import android.transition.Transition
import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.button1
import kotlinx.android.synthetic.main.activity_main.rootContainer

class MainActivity : AppCompatActivity() {
    lateinit var scene1: Scene
    lateinit var scene2: Scene
    lateinit var scene3: Scene
    lateinit var scene4: Scene
    lateinit var scene5: Scene
    lateinit var scene6: Scene
    var cont = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        prepareTransition()

        button1.setOnClickListener(View.OnClickListener {
            transitionScene(cont)
            cont++
        })
    }

    private fun prepareTransition() {

        scene1 = Scene.getSceneForLayout(rootContainer, R.layout.scene1, this)
        scene2 = Scene.getSceneForLayout(rootContainer, R.layout.scene2, this)
        scene3 = Scene.getSceneForLayout(rootContainer, R.layout.scene3, this)
        scene4 = Scene.getSceneForLayout(rootContainer, R.layout.scene4, this)
        scene5 = Scene.getSceneForLayout(rootContainer, R.layout.scene5, this)
        scene6 = Scene.getSceneForLayout(rootContainer, R.layout.scene6, this)

        scene1.enter()
    }

    private fun transitionScene(cont: Int) {
        when (cont) {
            1 -> {
                /*var fadeTransition: Transition =
                    TransitionInflater.from(this)
                        .inflateTransition(R.transition.fade_transition)*/

/*
                TransitionManager.go(scene2,fadeTransitionfadeTransition)
*/

                Toast.makeText(this, "Scene2 Cont ${cont}", Toast.LENGTH_SHORT).show()
                TransitionManager.go(scene2)
                startHandler()
            }
            2 -> {
                Toast.makeText(this, "Scene3 Cont ${cont}", Toast.LENGTH_SHORT).show()
                TransitionManager.go(scene3)
            }
            3 -> {
                Toast.makeText(this, "Scene4 Cont ${cont}", Toast.LENGTH_SHORT).show()
                TransitionManager.go(scene4)
            }
            4 -> {
                Toast.makeText(this, "Scene5 Cont ${cont}", Toast.LENGTH_SHORT).show()
                TransitionManager.go(scene5)
            }
            5 -> {
                Toast.makeText(this, "Scene6 Cont ${cont}", Toast.LENGTH_SHORT).show()
                TransitionManager.go(scene6)
            }
            6 -> {
                Toast.makeText(this, "Scene1 Cont ${cont}", Toast.LENGTH_SHORT).show()
                TransitionManager.go(scene1)
                this.cont = 1
            }
        }
    }

    private fun startHandler() {
        val handler = Handler()
        val r = Runnable {
            //what ever you do here will be done after 3 seconds delay.
        }
        handler.postDelayed(r, 1000)
    }
}


