package com.policy.app.ui.main

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.github.mikephil.charting.charts.BarChart
import com.policy.app.R
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import java.util.*
import com.github.mikephil.charting.components.XAxis.XAxisPosition
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setBarChart()
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    private fun setBarChart() {
        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(13f, 0))
        entries.add(BarEntry(8f, 1))
        entries.add(BarEntry(-6f, 2))
        entries.add(BarEntry(16f, 3))
        entries.add(BarEntry(18f, 4))

        val barDataSet = BarDataSet(entries, "Cells")

        val labels = ArrayList<String>()
        labels.add("02/18")
        labels.add("02/19")
        labels.add("02/20")
        labels.add("02/21")
        labels.add("02/22")
        val data = BarData(labels, barDataSet)
        barChart.data = data // set the data and list of lables into chart
        barChart.setBackgroundColor(Color.WHITE);
        barChart.setExtraTopOffset(-10f);
        barChart.setExtraBottomOffset(10f);
        barChart.setExtraLeftOffset(10f);
        barChart.setExtraRightOffset(10f);

        barChart.setDrawBarShadow(false);
        barChart.setDrawGridBackground(false);

        barChart.setDescription("")

        val xAxis = barChart.getXAxis()
        xAxis.setPosition(XAxisPosition.BOTTOM)
        xAxis.setDrawGridLines(false)
        xAxis.setDrawAxisLine(true)
        //xAxis.setTextColor(Color.LTGRA
        // Y)
        xAxis.setTextSize(13f)


        val left = barChart.getAxisLeft()
        left.setDrawLabels(false)
        left.setSpaceTop(25f)
        left.setSpaceBottom(25f)
        left.setDrawAxisLine(false)
        left.setDrawGridLines(false)
        left.setDrawZeroLine(true) // draw a zero line
        left.setZeroLineColor(Color.GRAY)
        left.setZeroLineWidth(0.7f)
        barChart.getAxisRight().setEnabled(false)
        barChart.getLegend().setEnabled(false)

        barChart.data.setValueTextSize(15f)
        //barDataSet.setColors(ColorTemplate.COLORFUL_COLORS)
        // barDataSet.color = resources.getColor(R.color.colorAccent)

        val colors = intArrayOf(Color.BLUE, Color.BLUE, Color.RED, Color.BLUE, Color.BLUE)
        barDataSet.setColors(colors)

        //barChart.animateY(5000)
    }
}