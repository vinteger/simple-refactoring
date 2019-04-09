package org.chartsmart.tests;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.DelayedClipboardReporter;
import org.approvaltests.reporters.UseReporter;
import org.chartsmart.IndividualDisplay;
import org.chartsmart.MainWindow;
import org.junit.Test;

@UseReporter(DelayedClipboardReporter.class)
public class ChartSmartTest {
    @Test
    public void testRun() {
        MainWindow chartSmart = new MainWindow();
        Approvals.verify(chartSmart);
    }

    @Test
    public void testBarChart() {
        IndividualDisplay cw = new IndividualDisplay();
        cw.initializeDisplay(406, "rpfll", true);
        Approvals.verify(cw);
    }

    @Test
    public void testBarChartCompare() {
        IndividualDisplay cw = new IndividualDisplay();
        cw.initializeDisplay(406, "shareddisplay", true);
        Approvals.verify(cw);
    }

    @Test
    public void testPieChart() {
        IndividualDisplay cw = new IndividualDisplay();
        cw.initializeDisplay(323, "rpfll", true);
        Approvals.verify(cw);
    }

    @Test
    public void testPieChartCompare() {
        IndividualDisplay cw = new IndividualDisplay();
        cw.initializeDisplay(323, "shareddisplay", true);
        Approvals.verify(cw);
    }
}
