package com.intelligent.ratingdialog


import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.DialogFragment


class Dialog: DialogFragment() {

    var om = OptionManager()
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // setup dialog
        val dialog = super.onCreateDialog(savedInstanceState)
        // "no title" feature, turning off the title at the top of the screen
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        // transparent background is for better dialogs
        dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        // whether this dialog is cancelable with the BACK key
        dialog.setCancelable(true)
        // end of lifecycle step
        return dialog
    }
    lateinit var rateButton: AppCompatButton
    lateinit var rateLater: AppCompatTextView
    lateinit var rateNever: AppCompatTextView
    lateinit var dialogTitle: AppCompatTextView
    lateinit var dialogDesc: AppCompatTextView
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // add new view
        val view = inflater.inflate(R.layout.dialog_layout,container)
        // "no title" feature, turning off the title at the top of the screen
        dialog!!.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        // setup dialog title
        dialogTitle = view.findViewById(R.id.dialogTitle)
        dialogTitle.text = om.getTitle(requireContext())
        // setup desc title
        dialogDesc = view.findViewById(R.id.dialogDescription)
        dialogDesc.text = om.getDescription(requireContext())
        // setup never title
        rateNever = view.findViewById(R.id.rateNever)
        rateNever.text = om.getNeverTitle(requireContext())
        rateNever.setOnClickListener {
            om.setNeverAskAgain(requireContext(),true)
            dismiss()
        }
        // setup later title
        rateLater = view.findViewById(R.id.rateLater)
        rateLater.text = om.getLaterTitle(requireContext())
        rateLater.setOnClickListener {
            dismiss()
        }
        // setup onclick rate us button
        rateButton = view.findViewById(R.id.rateButton)
        rateButton.setOnClickListener {
            rateButtonOnClick()
        }
        rateButton.text = om.getRateTitle(requireContext())
        reset()
        // end of lifecycle step
        return view
    }
    private fun rateButtonOnClick(){
        // remember option already rated
        var op = OptionManager()
        op.setNeverAskAgain(requireContext(),true)

        // get package name of app
        val packageName = requireActivity().packageName
        // setup intent
        var intent: Intent
        try {
            intent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName"))
            startActivity(intent)
        } catch (safe: ActivityNotFoundException) {
            intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
            )
            startActivity(intent)
        }
        // close dialog
        dismiss()


    }


    private fun reset(){
        om.setTitle(requireContext(),resources.getString(R.string.dialog_title))
        om.setDescription(requireContext(),resources.getString(R.string.dialog_description).toString())
        om.setRateTitle(requireContext(),resources.getString(R.string.rate_title).toString())
        om.setNeverTitle(requireContext(),resources.getString(R.string.never_title).toString())
        om.setLaterTitle(requireContext(),resources.getString(R.string.later_title).toString())
        om.setThresholdLimit(requireContext(),0)
    }
}

