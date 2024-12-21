package JFramePackge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JFrameMainWindow
{
    public static void main(String[] args)
    {
        final int[] method = {1};
        final String[] methodOneArrayOfParameters = {"", "", ""};
        final String[] methodTwoArrayOfParameters = {"", ""};
        JFrame frame = new JFrame("Приложение для вычисления значения выражения");

        //настройки окна
        frame.setSize(400, 260);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        //панель первого метода
        Panel panelMethodOne = new Panel(new BorderLayout());
        JLabel xLabelMethodOne = new JLabel("Переменная X");
        JLabel yLabelMethodOne = new JLabel("Переменная Y");
        JLabel nLabelMethodOne = new JLabel("Переменная n");
        JTextField xTextFieldMethodOne = new JTextField(10);
        JTextField yTextFieldMethodOne = new JTextField(10);
        JTextField nTextFieldMethodOne = new JTextField(10);
        Panel panelXMethodOne = new Panel(new FlowLayout());
        Panel panelYMethodOne = new Panel(new FlowLayout());
        Panel panelNMethodOne = new Panel(new FlowLayout());
        panelXMethodOne.add(xLabelMethodOne);
        panelXMethodOne.add(xTextFieldMethodOne);
        panelMethodOne.add(panelXMethodOne, BorderLayout.NORTH);
        panelYMethodOne.add(yLabelMethodOne);
        panelYMethodOne.add(yTextFieldMethodOne);
        panelMethodOne.add(panelYMethodOne, BorderLayout.CENTER);
        panelNMethodOne.add(nLabelMethodOne);
        panelNMethodOne.add(nTextFieldMethodOne);
        panelMethodOne.add(panelNMethodOne, BorderLayout.SOUTH);

        //панель второго метода
        Panel panelMethodTwo = new Panel(new BorderLayout());
        JLabel rLabelMethodTwo = new JLabel("Переменная R");
        JLabel nLabelMethodTwo = new JLabel("Переменная N");
        JTextField rTextFieldMethodTwo = new JTextField(10);
        JTextField nTextFieldMethodTwo = new JTextField(10);
        Panel panelRMethodTwo = new Panel(new FlowLayout());
        Panel panelNMethodTwo = new Panel(new FlowLayout());
        panelRMethodTwo.add(rLabelMethodTwo);
        panelRMethodTwo.add(rTextFieldMethodTwo);
        panelMethodTwo.add(panelRMethodTwo, BorderLayout.NORTH);
        panelNMethodTwo.add(nLabelMethodTwo);
        panelNMethodTwo.add(nTextFieldMethodTwo);
        panelMethodTwo.add(panelNMethodTwo, BorderLayout.CENTER);

        //настройка кнопки Вычислить Z
        Panel panelCalculate = new Panel(new FlowLayout());
        JButton buttonCalculate = new JButton("Вычислить Z");
        buttonCalculate.setPreferredSize(new Dimension(390, 60));
        panelCalculate.add(buttonCalculate);

        //настройка панели на Юге (метод 1, метод 2)
        Panel panelMethods = new Panel(new FlowLayout());
        JButton buttonMethodOne = new JButton("Метод 1");
        JButton buttonMethodTwo = new JButton("Метод 2");
        buttonMethodOne.setPreferredSize(new Dimension(190, 30));
        buttonMethodTwo.setPreferredSize(new Dimension(190, 30));
        panelMethods.add(buttonMethodOne);
        panelMethods.add(buttonMethodTwo);

        buttonMethodOne.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.remove(panelMethodTwo);
                frame.add(panelMethodOne, BorderLayout.CENTER);
                frame.revalidate();
                frame.repaint();
                method[0] = 1;
            }
        });
        buttonMethodTwo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.remove(panelMethodOne);
                frame.add(panelMethodTwo, BorderLayout.CENTER);
                frame.revalidate();
                frame.repaint();
                method[0] = 2;
            }
        });
        buttonCalculate.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JDialogInfo information;
                if (method[0] == 1)
                {
                    try
                    {
                        methodOneArrayOfParameters[0] = xTextFieldMethodOne.getText();
                        methodOneArrayOfParameters[1] = yTextFieldMethodOne.getText();
                        methodOneArrayOfParameters[2] = nTextFieldMethodOne.getText();
                        if (!methodOneArrayOfParameters[0].matches("\\d+") && !methodOneArrayOfParameters[1].matches("\\d+") && !methodOneArrayOfParameters[2].matches("\\d+"))
                            information = new JDialogInfo(null, "Ошибка", true, "Введите числовые значения!");
                        else
                            calculate(Integer.parseInt(methodOneArrayOfParameters[0]), Integer.parseInt(methodOneArrayOfParameters[1]), Integer.parseInt(methodOneArrayOfParameters[2]));
                    }
                    catch (NumberFormatException ignored){information = new JDialogInfo(null, "Ошибка", true, "Введите числовые значения!");}
                }
                else if (method[0] == 2)
                {
                    try
                    {
                        methodTwoArrayOfParameters[0] = rTextFieldMethodTwo.getText();
                        methodTwoArrayOfParameters[1] = nTextFieldMethodTwo.getText();
                        if(!methodTwoArrayOfParameters[0].matches("\\d+") && methodTwoArrayOfParameters[1].matches("\\d+"))
                            information = new JDialogInfo(null, "Ошибка", true, "Введите числовые значения!");
                        else
                            calculate(Integer.parseInt(methodTwoArrayOfParameters[0]), Integer.parseInt(methodTwoArrayOfParameters[1]));
                    }
                    catch (NumberFormatException ignored) {information = new JDialogInfo(null, "Ошибка", true, "Введите числовые значения!");}
                }
            }
        });

        frame.add(panelMethods, BorderLayout.NORTH);
        frame.add(panelMethodOne, BorderLayout.CENTER);
        frame.add(panelCalculate, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private static void calculate(int r, int n)
    {
        JDialogInfo information;
        if (r < 1 || n < 1)
            information = new JDialogInfo(null, "Ошибка", true, "Переменные R и N должны быть больше нуля!");
        else
        {
            double result = 0;
            for (int i = 1; i <= n; i++)
            {
                for (int j = 1; j <= r; j++)
                {
                    result += (double) (3 + j) / i;
                }
            }
            information = new JDialogInfo(null, "Ответ", true, result);
        }
    }
    private static void calculate(int x, int y, int n)
    {
        JDialogInfo information;
        if (n < 1)
            information = new JDialogInfo(null, "Ошибка", true, "Переменная n должена быть больше нуля!");
        else
        {
            double result = 0;
            if(n != 1)
            {

                int factorial = 1;
                boolean plusMinus = false;
                for (int i = 1; i <= n; i++)
                {
                    if (!plusMinus)
                    {
                        for (int j = 1; j <= i + 1; j++)
                            factorial *= j;
                        result -= Math.pow(x, i) / factorial;
                        factorial = 1;
                        plusMinus = true;
                    } else
                    {
                        for (int j = 1; j <= i + 1; j++)
                            factorial *= j;
                        result += Math.pow(y, i) / factorial;
                        factorial = 1;
                        plusMinus = false;
                    }
                }
                result += 1;
            }
            else if (x < 0)
                result = 2;
            else
                result = 0;
            information = new JDialogInfo(null, "Ответ", true, result);
        }
    }
}
