import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("game");
        JPanel pt = new JPanel(new GridLayout(1, 2));
        JPanel pm = new JPanel(new GridLayout(8, 8));
        JPanel pb = new JPanel(new FlowLayout());
        JLabel label = new JLabel();
        LinkedList<Button> board = new java.util.LinkedList<Button>();
        Button[][] buttons = new Button[10][10];

        frame.setLayout(new BorderLayout());
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // put buttons
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                buttons[i][j] = new Button();
            }
        }
        for (int i = 0; i < 64; i++) {
            board.add(new Button());
        }

        // shuffle
        for (int i = 0; i < 12; i++) {
            board.get(i).setState(-1);
        }
        Collections.shuffle(board);
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                buttons[i][j] = board.pop();
            }
        }

        int count;
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                count = 0;
                if (buttons[i][j].getState() != -1) {
                    for (int k = i - 1; k < i + 2; k++) {
                        for (int l = j - 1; l < j + 2; l++) {
                            if (buttons[k][l].getState() == -1) {
                                count++;
                            }
                        }
                    }

                    buttons[i][j].setState(count);

                }

            }
        }
        int sum = 0;
        for (int i = 1; i <= 8; i++)
            for (int j = 1; j <= 8; j++) {
                int I = i;
                int J = j;
                
                pm.add(buttons[i][j].getBtn());
                
                buttons[i][j].getBtn().addActionListener(new ActionListener() {
                    // @Override

                   
                    int SUM = sum;
                    public void actionPerformed(ActionEvent e) {
                        if (buttons[I][J].getState() == -1) {
                            for (int k = 1; k <= 8; k++) {
                                for (int l = 1; l <= 8; l++) {
                                    if (buttons[k][l].getState() == -1) {
                                        buttons[k][l].getBtn().setText("B");
                                    }
                                }
                            }
                            JOptionPane.showMessageDialog(frame, "You Lost");
                            System.exit(0);
                            pb.add(label);
                        } else if (buttons[I][J].getState() == 0) {
                            for (int k = I - 1; k <= I + 1; k++) {
                                for (int l = J - 1; l <= J + 1; l++) {
                                    SUM++;
                                    buttons[k][l].getBtn().setBackground(Color.GRAY);
                                    if (buttons[k][l].getState() != 0)
                                        buttons[k][l].getBtn().setText(String.valueOf(buttons[k][l].getState()));
                                    else
                                        buttons[k][l].getBtn().setText(String.valueOf(""));
                                }
                            } 
                        } else {
                            SUM++;
                            buttons[I][J].getBtn().setBackground(Color.GRAY);
                            if (buttons[I][J].getState() != 0)
                                buttons[I][J].getBtn().setText(String.valueOf(buttons[I][J].getState()));
                            else
                                buttons[I][J].getBtn().setText(String.valueOf(""));
                        }

                        if(SUM + 12 == 64)
                        {
                            JOptionPane.showMessageDialog(frame, "You Win");
                        }
                    }
                    
                });

                frame.add(pt, BorderLayout.NORTH);
                frame.add(pm, BorderLayout.CENTER);
                frame.add(pb, BorderLayout.SOUTH);

                frame.setVisible(true);
            }
    }
}
