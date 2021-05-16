import javax.swing.*;

    public class Button {
        private JButton btn = new JButton();
        private int flag=0;
        private int state = 0;

        public Button(){}
        public JButton getBtn() {
            return btn;
        }
        public int getFlag() {
            return flag;
        }
        public int getState() {
            return state;
        }
        public void setState(int i) {
            this.state = i;
        }
        public void setFlag(int flag) {
            this.flag = flag;
        }
    }

