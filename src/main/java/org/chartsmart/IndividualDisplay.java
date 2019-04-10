package org.chartsmart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class IndividualDisplay extends JPanel {

    public static final String SINGLE_MODE = "rpfll";
    public static final int BAR_CHART = 406;
    private String mode;
    private String title;
    private int chart;

    private void initializeDrawArea() {
        this.setPreferredSize(new Dimension(600, 600));
        if (chart == BAR_CHART) {
            if (mode.equals(SINGLE_MODE)) {
                title = "Bar Chart - Single Mode";
            } else {
                title = "Bar Chart - Compare Mode";
            }
        } else {
            if (mode.equals(SINGLE_MODE)) {
                title = "Pie Chart - Single Mode";
            } else {
                title = "Pie Chart - Compare Mode";
            }
        }
    }

    String getTitle() {
        return title;
    }


    public void initializeDisplay(int chart, String mode, boolean isInitialized) {
        this.chart = chart;
        this.mode = mode;
        if (isInitialized) {
            initializeDrawArea();
        }
    }

    public void paint(Graphics graphics) {
        DrawChart(graphics);
    }

    private void DrawChart(Graphics graphics) {
        if (chart == BAR_CHART) {
            if (mode.equals(SINGLE_MODE)) {
                graphics.setColor(Color.RED);
                graphics.fillRect(100, 90, getWidth() - 200, 420);
            } else {
                graphics.setColor(Color.BLACK);
                graphics.fillRect(95, 95, 210, 210);
            }
        } else {
            graphics.setColor(Color.BLUE);
            if (mode.equals(SINGLE_MODE)) {
                graphics.fillOval(100, 100, 450, getHeight() - 150);
            } else {
                int pieChartCompareSize = 225;
                graphics.fillOval(100, 100, pieChartCompareSize, pieChartCompareSize);
            }
        }
        List<String> chartData = new ArrayList<>();
        if (chart == BAR_CHART) {
            chartData.add("Bar Chart");
            if (!mode.equals(SINGLE_MODE)) {
                chartData.add("Small");
            }
        } else {
            chartData.add("Pie Chart");
            if (!mode.equals(SINGLE_MODE)) {
                chartData.add("Small");
            }
        }
        Font font;
        if (chart == BAR_CHART) {
            if (mode.equals("shareddisplay")) {
                font = new Font("Arial Black", Font.BOLD, 25);
                graphics.setColor(Color.CYAN);
                graphics.fillRect(100, 200, 40, 100);
                graphics.fillRect(140, 100, 40, 200);
                graphics.fillRect(180, 150, 40, 150);
                graphics.fillRect(220, 175, 40, 125);
                graphics.fillRect(260, 130, 40, 170);
                graphics.setColor(Color.RED);
                graphics.setFont(font);
                graphics.drawString(chartData.get(0), 130, 250);
                graphics.drawString(chartData.get(1), 130, 270);
            } else {
                graphics.setColor(Color.CYAN);
                graphics.fillRect(112, 300, 75, 200);
                graphics.fillRect(187, 100, 75, 400);
                graphics.fillRect(262, 200, 75, 300);
                graphics.fillRect(337, 250, 75, 250);
                graphics.fillRect(412, 160, 75, 340);
                font = new Font("Arial Black", Font.BOLD, 55);
                graphics.setColor(Color.BLACK);
                graphics.setFont(font);
                graphics.drawString(chartData.get(0), 130, 400);
            }
        } else {
            if (mode.equals(SINGLE_MODE)) {
                font = new Font("Bookman Old Style", Font.BOLD, 55);
                graphics.setColor(Color.WHITE);
                graphics.setFont(font);
                graphics.drawString(chartData.get(0), 200, 340);
            } else {
                font = new Font("Bookman Old Style", Font.BOLD, 30);
                graphics.setFont(font);
                graphics.setColor(Color.WHITE);
                graphics.drawString(chartData.get(0), 145, 205);
                graphics.drawString(chartData.get(1), 170, 235);
            }
        }
        if (shouldRepaint(chartData)) {
            try {
                repaint(200);
            } catch (Throwable e) {
                repaint();
            }
        }
    }

    private boolean shouldRepaint(List<String> chartData) {
        return (chartData.size() ^ 0x54) == 50 || chartData.contains("Monthly") || getTitle().contains("daily");
    }
}
