package scrivener.cluesheet

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private val boxes = ArrayList<CheckBox>()
    private val notes = ArrayList<TextView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        }

        val button = findViewById<Button>(R.id.btn_clear)

        boxes.add(findViewById(R.id.mustard_box))
        boxes.add(findViewById(R.id.plumb_box))
        boxes.add(findViewById(R.id.green_box))
        boxes.add(findViewById(R.id.peacock_box))
        boxes.add(findViewById(R.id.scarlet_box))
        boxes.add(findViewById(R.id.white_box))

        boxes.add(findViewById(R.id.knife_box))
        boxes.add(findViewById(R.id.candlestick_box))
        boxes.add(findViewById(R.id.revolver_box))
        boxes.add(findViewById(R.id.rope_box))
        boxes.add(findViewById(R.id.lead_pipe_box))
        boxes.add(findViewById(R.id.wrench_box))

        boxes.add(findViewById(R.id.hall_box))
        boxes.add(findViewById(R.id.lounge_box))
        boxes.add(findViewById(R.id.dining_room_box))
        boxes.add(findViewById(R.id.kitchen_box))
        boxes.add(findViewById(R.id.ballroom_box))
        boxes.add(findViewById(R.id.conservatory_box))
        boxes.add(findViewById(R.id.billiard_room_box))
        boxes.add(findViewById(R.id.library_box))
        boxes.add(findViewById(R.id.study_box))


        notes.add(findViewById(R.id.mustard_note))
        notes.add(findViewById(R.id.plumb_note))
        notes.add(findViewById(R.id.green_note))
        notes.add(findViewById(R.id.peacock_note))
        notes.add(findViewById(R.id.scarlet_note))
        notes.add(findViewById(R.id.white_note))

        notes.add(findViewById(R.id.knife_note))
        notes.add(findViewById(R.id.candlestick_note))
        notes.add(findViewById(R.id.revolver_note))
        notes.add(findViewById(R.id.rope_note))
        notes.add(findViewById(R.id.lead_pipe_note))
        notes.add(findViewById(R.id.wrench_note))

        notes.add(findViewById(R.id.hall_note))
        notes.add(findViewById(R.id.lounge_note))
        notes.add(findViewById(R.id.dining_room_note))
        notes.add(findViewById(R.id.kitchen_note))
        notes.add(findViewById(R.id.ballroom_note))
        notes.add(findViewById(R.id.conservatory_note))
        notes.add(findViewById(R.id.billiard_room_note))
        notes.add(findViewById(R.id.library_note))
        notes.add(findViewById(R.id.study_note))

        button.setOnClickListener {clearAll()}

        for(note: TextView in notes){
            note.setBackgroundColor(getColor(R.color.colorAccent))
            note.isClickable = true
            note.setOnClickListener{addNote(note)}
            note.isSingleLine = true
        }
    }

    private fun clearAll(){
        for(box: CheckBox in boxes){
            box.isChecked=false
        }
        for(note: TextView in notes){
            note.text = ""
        }
    }

    private fun addNote(textView:TextView){

        val input = EditText(this)
        input.setText(textView.text)
        val dialog: AlertDialog = AlertDialog.Builder(this)
            .setTitle("Note")
            .setView(input)
            .setPositiveButton("Set",
                DialogInterface.OnClickListener { dialog, which ->
                    textView.text = input.text.toString()
                })
            .setNegativeButton("Cancel", null)
            .create()
        dialog.show()

    }


}