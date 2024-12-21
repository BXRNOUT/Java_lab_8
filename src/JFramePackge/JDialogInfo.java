package JFramePackge;

import java.awt.*;
import javax.swing.*;

public class JDialogInfo extends JDialog
{
    public JDialogInfo(Dialog parent, String title, boolean isModal, double result)
    {
        super(parent, title, isModal);
        setSettings(200, 100);
        add(new JLabel(String.format("%.4f", result)), BorderLayout.CENTER);
        setVisible(true);
    }
    public JDialogInfo(Dialog parent, String title, boolean isModal, String errorParameter)
    {
        super(parent, title, isModal);
        setSettings(310, 60);
        add(new JLabel(errorParameter), BorderLayout.CENTER);
        setVisible(true);
    }
    private void setSettings(int width, int height)
    {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
    }
}
