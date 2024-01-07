import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FHE_Edit {
    private JFrame frame;
    private JPanel contentPanel;
    private JLabel titleLabel;

    public FHE_Edit() {
        frame = new JFrame("FHE Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setOpaque(false);

        showWelcomeScreen();

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(contentPanel, BorderLayout.CENTER);

        frame.pack();
        //frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FHE_Edit();
            }
        });
    }

    private void showWelcomeScreen() {
        contentPanel.removeAll();

        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\hriti\\Desktop\\Hritika\\Final year final sem\\capstone\\FHEGUI\\FHE\\Images\\3303533 (1).jpg");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(new GridBagLayout());

        JLabel titleLabel = new JLabel(" WELCOME!!");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel introLabel = new JLabel("Fully Homomorphic Encryption in Nuclear Power Plants");
        introLabel.setForeground(Color.WHITE);
        introLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        introLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton beginButton = new JButton("Let's begin");
        beginButton.setForeground(Color.WHITE);
        beginButton.setFont(new Font("Arial", Font.BOLD, 20));
        beginButton.setOpaque(false);
        beginButton.setContentAreaFilled(false);
        beginButton.setBorderPainted(false);
        beginButton.setFocusPainted(false);
        beginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showChoiceScreen();
            }
        });

        JPanel scenePanel = new JPanel(new BorderLayout());
        scenePanel.setOpaque(false);
        scenePanel.add(titleLabel, BorderLayout.NORTH);
        scenePanel.add(introLabel, BorderLayout.CENTER);
        scenePanel.add(beginButton, BorderLayout.SOUTH);

        backgroundLabel.add(scenePanel);

        contentPanel.add(backgroundLabel, new GridBagConstraints());

        frame.revalidate();
    }

    private void showChoiceScreen() {
        contentPanel.removeAll();

        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\hriti\\Desktop\\Hritika\\Final year final sem\\capstone\\FHEGUI\\FHE\\Images\\3303533 (1).jpg");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(new GridBagLayout());

        titleLabel = new JLabel("Choice Screen");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel buttonsPanel = new JPanel(new GridBagLayout());
        buttonsPanel.setOpaque(false);

        JButton button1 = createButton("Integration", "C:\\Users\\hriti\\Desktop\\Hritika\\Final year final sem\\capstone\\FHEGUI\\FHE\\Images\\2.png");
        JButton button2 = createButton("Sin Function", "C:\\Users\\hriti\\Desktop\\Hritika\\Final year final sem\\capstone\\FHEGUI\\FHE\\Images\\3.png");
        JButton button3 = createButton("Polynomial Function", "C:\\Users\\hriti\\Desktop\\Hritika\\Final year final sem\\capstone\\FHEGUI\\FHE\\Images\\4.png");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        buttonsPanel.add(button1, gbc);

        gbc.gridx = 1;
        buttonsPanel.add(button2, gbc);

        gbc.gridx = 2;
        buttonsPanel.add(button3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(30, 10, 10, 10);
        JButton endButton = new JButton("End");
        endButton.setForeground(Color.WHITE);
        endButton.setFont(new Font("Arial", Font.BOLD, 16));
        endButton.setOpaque(false);
        endButton.setContentAreaFilled(false);
        endButton.setBorderPainted(false);
        endButton.setFocusPainted(false);
        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonsPanel.add(endButton, gbc);

        JPanel scenePanel = new JPanel(new BorderLayout());
        scenePanel.setOpaque(false);
        scenePanel.add(titleLabel, BorderLayout.NORTH);
        scenePanel.add(buttonsPanel, BorderLayout.CENTER);

        backgroundLabel.add(scenePanel);

        contentPanel.add(backgroundLabel, new GridBagConstraints());

        frame.revalidate();
    }

    private JButton createButton(String text, String iconPath) {
        JButton button = new JButton(text);
        button.setIcon(new ImageIcon(iconPath));
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (text.equals("Integration")) {
                    showScene3();
                } else if (text.equals("Sin Function")) {
                    showScene4();
                } else if (text.equals("Polynomial Function")) {
                    showScene5();
                }
            }
        });
        return button;
    }


    private JButton createOptionButton(String text, String iconPath) {
        JButton button = new JButton(text);
        button.setIcon(new ImageIcon(iconPath));
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (text.equals("Integration")) {
                    showScene3();
                } else if (text.equals("Sin Function")) {
                    showScene4();
                } else if (text.equals("Polynomial Function")) {
                    showScene5();
                }
            }
        });
        return button;
    }

    private void showScene3() {
        contentPanel.removeAll();

        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\hriti\\Desktop\\Hritika\\Final year final sem\\capstone\\FHEGUI\\FHE\\Images\\Integration (1).png");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(new GridBagLayout());

        titleLabel = new JLabel("Integration");
        titleLabel.setForeground(Color.CYAN);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel inputLabel1 = new JLabel("No. Of Iterations");
        JTextField inputField1 = new JTextField(10);


        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input1 = inputField1.getText();
                int input2=Integer.parseInt(input1);

                Client s = new Client();

                String output = s.input(1, input2);
                //String output8=Double.toString(output);

                showScene6("Option X", output);
            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showChoiceScreen();
            }
        });

        JPanel inputsPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputsPanel.setOpaque(false);
        inputsPanel.add(inputLabel1);
        inputsPanel.add(inputField1);


        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(calculateButton);
        buttonsPanel.add(backButton);

        JPanel scenePanel = new JPanel(new BorderLayout());
        scenePanel.setOpaque(false);
        scenePanel.add(titleLabel, BorderLayout.NORTH);
        scenePanel.add(inputsPanel, BorderLayout.CENTER);
        scenePanel.add(buttonsPanel, BorderLayout.SOUTH);

        backgroundLabel.add(scenePanel);

        contentPanel.add(backgroundLabel, new GridBagConstraints());

        frame.revalidate();
    }

    private void showScene4() {
        contentPanel.removeAll();

        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\hriti\\Desktop\\Hritika\\Final year final sem\\capstone\\FHEGUI\\FHE\\Images\\Sin (1).png");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(new GridBagLayout());

        titleLabel = new JLabel("Sin Function");
        titleLabel.setForeground(Color.DARK_GRAY);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel inputLabel1 = new JLabel("No of Iterations");
        JTextField inputField1 = new JTextField(10);


        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input1 = inputField1.getText();

                String output = "Output "+ input1;
                showScene6("Sin Function", output);
            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showChoiceScreen();
            }
        });

        JPanel inputsPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputsPanel.setOpaque(false);
        inputsPanel.add(inputLabel1);
        inputsPanel.add(inputField1);


        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(calculateButton);
        buttonsPanel.add(backButton);

        JPanel scenePanel = new JPanel(new BorderLayout());
        scenePanel.setOpaque(false);
        scenePanel.add(titleLabel, BorderLayout.NORTH);
        scenePanel.add(inputsPanel, BorderLayout.CENTER);
        scenePanel.add(buttonsPanel, BorderLayout.SOUTH);

        backgroundLabel.add(scenePanel);

        contentPanel.add(backgroundLabel, new GridBagConstraints());

        frame.revalidate();
    }

    private void showScene5() {
        contentPanel.removeAll();

        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\hriti\\Desktop\\Hritika\\Final year final sem\\capstone\\FHEGUI\\FHE\\Images\\Polynomial (1).png");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(new GridBagLayout());

        titleLabel = new JLabel("Polynomial Function");
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel inputLabel1 = new JLabel("No. Of Iterations");
        JTextField inputField1 = new JTextField(10);


        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input1 = inputField1.getText();

                String output = "Output " + input1 ;
                showScene6("Polynomial Function", output);
            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showChoiceScreen();
            }
        });

        JPanel inputsPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputsPanel.setOpaque(false);
        inputsPanel.add(inputLabel1);
        inputsPanel.add(inputField1);


        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(calculateButton);
        buttonsPanel.add(backButton);

        JPanel scenePanel = new JPanel(new BorderLayout());
        scenePanel.setOpaque(false);
        scenePanel.add(titleLabel, BorderLayout.NORTH);
        scenePanel.add(inputsPanel, BorderLayout.CENTER);
        scenePanel.add(buttonsPanel, BorderLayout.SOUTH);

        backgroundLabel.add(scenePanel);

        contentPanel.add(backgroundLabel, new GridBagConstraints());

        frame.revalidate();
    }

    private void showScene6(String option, String output) {
        contentPanel.removeAll();

        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\hriti\\Desktop\\Hritika\\Final year final sem\\capstone\\FHEGUI\\FHE\\Images\\NPP (1).jpg");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(new GridBagLayout());

        System.out.println("This is the output: "+output);

        titleLabel = new JLabel("Output for " + option);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JTextArea outputArea = new JTextArea(output);
        outputArea.setEditable(false);
        outputArea.setOpaque(false);
        outputArea.setForeground(Color.WHITE);
        outputArea.setFont(new Font("Arial", Font.PLAIN, 16));

        ImageIcon graphIcon = new ImageIcon(getGraphImagePath(option));
        JLabel graphLabel = new JLabel(graphIcon);

        JButton homeButton = new JButton("Home");

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showChoiceScreen();
            }
        });

        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.setOpaque(false);
        outputPanel.add(outputArea, BorderLayout.CENTER);
        outputPanel.add(graphLabel, BorderLayout.SOUTH);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(homeButton);

        JPanel scenePanel = new JPanel(new BorderLayout());
        scenePanel.setOpaque(false);
        scenePanel.add(titleLabel, BorderLayout.NORTH);
        scenePanel.add(outputPanel, BorderLayout.CENTER);
        scenePanel.add(buttonsPanel, BorderLayout.SOUTH);

        backgroundLabel.add(scenePanel);

        contentPanel.add(backgroundLabel, new GridBagConstraints());

        frame.revalidate();
    }

    private String getGraphImagePath(String option) {
        if (option.equals("Integration")) {
            return "graph1.png";
        } else if (option.equals("Sin Function")) {
            return "graph2.png";
        } else if (option.equals("Polynomial Function")) {
            return "graph3.png";
        }
        return "";
    }
}
